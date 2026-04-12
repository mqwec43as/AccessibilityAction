import bsh.This;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



a11Y() {
	This old = tasker.getJavaVariable("a11Y");
	if (old != null) {
		try {
			if (old.executor != void) old.executor.shutdown();
			old.clean();
		} catch (e) {

		}
	}
	boolean debugSteps = false;
	boolean debugMe = false;
	boolean debugInfo = true;
	long findDelay = 100;
	long debugDelay = 1000;
	List assistOverlays = new ArrayList();
	String ENV;
	This assistButton;
	boolean useOffset = true;
	boolean useA11yOffset = true;
	boolean waitNodes = true;
	boolean useA11yStructure = false;
	boolean includeAllMethods = false;
	boolean quickAddMode = true;
	This TOP;
	String scriptEditor = "";
	ExecutorService executor = Executors.newFixedThreadPool(2);
	debug() {
		debugMe = true;
	}
	This inspector;
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
	
	if (old != null) {
		if (old.scriptEditor != void) scriptEditor = old.scriptEditor;
	}
	return this;
};
String ENV = new File(getSourceFileInfo()).getParentFile().getAbsolutePath();
This a11Y = a11Y();
a11Y.setEnv(ENV);
a11Y.set();
This inspector = MethodInspector(this);
inspector.read();
inspector.ignoreNearby();
a11Y.inspector = inspector;
tasker.setJavaVariable("a11Y", a11Y);