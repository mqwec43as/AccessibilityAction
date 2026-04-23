import bsh.This;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;



a11Y() {
	// 1. Retrieve the previous instance from Tasker's memory
	This old = tasker.getJavaVariable("a11Y");
	if (old != null) {
		try {
			if (old.executor != void && old.executor != null) {
				if (!old.executor.isShutdown()) {
					old.executor.shutdownNow();
				}
			}
		} catch (Exception e) {}
	}

	boolean debugSteps = false;
	boolean debugMe = false;
	boolean debugInfo = true;
	long findDelay = 100;
	long debugDelay = 1000;
	List assistOverlays = new ArrayList();
	String ENV;
	This assistButton;
	This updateManager;
	boolean useOffset = true;
	boolean useA11yOffset = true;
	boolean waitNodes = true;
	boolean useA11yStructure = false;
	boolean includeAllMethods = false;
	boolean quickAddMode = true;
	This TOP;
	String scriptEditor = "";
	This inspector;

	ThreadFactory customThreadFactory = new ThreadFactory() {
		private AtomicInteger count = new AtomicInteger(0);
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r, "a11Y_" + count.incrementAndGet());
			thread.setPriority(Thread.MAX_PRIORITY);
			return thread;
		}
	};

	ThreadPoolExecutor executor = new ThreadPoolExecutor(
		1, // Core size
		1, // Max size
		30, // Idle timeout
		TimeUnit.SECONDS, // Timeout unit
		new ArrayBlockingQueue(1), // Task wait-list
		customThreadFactory, // Thread factory
		new ThreadPoolExecutor.DiscardOldestPolicy()
	);

	debug() {
		debugMe = true;
	}

	set(This THIS) {
		THIS.namespace.setVariable("debugMe", debugMe, false);
		THIS.namespace.setVariable("debugSteps", debugSteps, false);
		THIS.namespace.setVariable("debugInfo", debugInfo, false);
		THIS.namespace.setVariable("findDelay", findDelay, false);
		THIS.namespace.setVariable("debugDelay", debugDelay, false);
		THIS.namespace.setVariable("useOffset", useOffset, false);
		THIS.namespace.setVariable("useA11yOffset", useA11yOffset, false);
		THIS.namespace.setVariable("waitNodes", waitNodes, false);
		THIS.namespace.setVariable("useA11yStructure", useA11yStructure, false);
		THIS.namespace.setVariable("includeAllMethods", includeAllMethods, false);
		THIS.namespace.setVariable("quickAddMode", quickAddMode, false);
		if (ENV == null) {
			String superImport = tasker.getVariable("ImportJava");
			try {
				this.interpreter.source(superImport);
				THIS.invokeMethod("IMPORT", new Object[] { "AccessibilityAction" });
				if (THIS.namespace.getVariable("MAIN_DIRECTORY") != null) ENV = THIS.namespace.getVariable("MAIN_DIRECTORY");
				THIS.namespace.setVariable("a11Y", THIS, false);
			} catch (e) {
				tasker.showToast("Please set the folder with a11Y.setEnv(\"Directory path\")");
				return;
			}
		} else {
			this.interpreter.source(ENV + "/import.java");
		}
		return THIS;
	}

	set() {
		set(this.caller);
	}

	setEnv(String path) {
		ENV = path;
	}

	resetEnv() {
		ENV = null;
	}

	reset() {
		debugSteps = false;
		debugMe = false;
		debugInfo = true;
		findDelay = 100;
		debugDelay = 1000;
		useOffset = true;
		useA11yOffset = true;
		waitNodes = true;
		useA11yStructure = false;
	}


	addOverlay(This overlay) {
		assistOverlays.add(overlay);
	};

	removeOverlay(This overlay) {
		assistOverlays.remove(overlay);
	}

	clean() {
		if (assistOverlays.isEmpty()) return;
		for (This overlay: assistOverlays) {
			try { overlay.remove(); } catch (e) {}
		}
		assistOverlays.clear();
	}

	addEvent(String eventId, This eventListener) {
		This a11E = tasker.getJavaVariable("a11E");
		if (a11E != null) a11E.add(eventId, eventListener);
	}

	removeEvent(String eventId) {
		This a11E = tasker.getJavaVariable("a11E");
		if (a11E != null) a11E.remove(eventId);
	}

	removeEvents() {
		This a11E = tasker.getJavaVariable("a11E");
		if (a11E != null) a11E.removeEvents();
	}

	getEvents() {
		This a11E = tasker.getJavaVariable("a11E");
		if (a11E != null) {
			Set keyset = a11E.listeners.keySet();
			return new ArrayList(keyset);
		}
	}

	if (old != null) {
		if (old.scriptEditor != void) scriptEditor = old.scriptEditor;
	}

	showAssist() {
		if (!assistButton.isShown) assistButton.show();
	}

	removeAssist() {
		if (assistButton.isShown) assistButton.remove();
	}

	update() {
		if (updateManager != null) updateManager.update();
	}

	muteEvents() {
		This a11E = tasker.getJavaVariable("a11E");
		a11E.mute();
	}
	
	unmuteEvents() {
		This a11E = tasker.getJavaVariable("a11E");
		a11E.unmute();
	}

	return this;

};

String ENV = new File(getSourceFileInfo()).getParentFile().getAbsolutePath();
This a11Y = a11Y();
a11Y.setEnv(ENV);
a11Y.set();
This inspector = MethodInspector(this);
inspector.read();
a11Y.inspector = inspector;
tasker.setJavaVariable("a11Y", a11Y);

This a11E = a11E();
tasker.setJavaVariable("a11E", a11E);

This assistButton = AssistButton(0.8, 0.8);
a11Y.namespace.setVariable("assistButton", assistButton, false);

This updateManager = UpdateManager();
updateManager.namespace.setVariable("directoryPath", ENV, false);
a11Y.namespace.setVariable("updateManager", updateManager, false);

tasker.sendCommand("a11Y=:=start");