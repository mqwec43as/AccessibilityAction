String ENV_PATH = new File(getSourceFileInfo()).getParentFile().getAbsolutePath();
LOG_FILE = ENV_PATH + "/log.txt";

addClassPath(ENV_PATH);
importCommands("main");
importCommands("window");
importCommands("gestures");
importCommands("actions");
importCommands("others");
importCommands("assist");
importCommands("helper");
importCommands("lib");
importCommands("lib.file");
importCommands("assist.helper");
importCommands("assist.dialog");
importCommands("event");
importCommands("global");
importCommands("config");

import bsh.This;
import bsh.NameSpace;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import com.joaomgcd.taskerm.action.java.JavaCodeException;

This ENV = Environment();

a11Y() {
	// Retrieve the previous instance from Tasker's memory
	This old = getA11yInstance();
	if (old != null) {
		try {
			boolean hasRemoveBoolean = old.namespace.getMethod("remove", new Class[] { Boolean.class }) != null;
			if (hasRemoveBoolean) old.remove(false);
			else {
				throw new JavaCodeException("Could not find remove(boolean) method");
			}
		} catch (Exception e) {
			log(e.getMessage(), "ERROR");
			String appName = context.getApplicationContext().getApplicationInfo().loadLabel(context.getPackageManager());
			String packageName = context.getPackageName();
			tasker.showToast("Unable to clear existing a11Y instance:\n in package " + packageName + "\n" + e.getMessage(), "Please Restart " + appName);
			throw e;
			return;
		}
	}

	final This TOP = this;
	final String[] constants = new String[] {
		"AssistInfo",
		"WindowInfo",
		"NodeInfo",
		"ENV",
	};

	// Variables
	List assistOverlays = new ArrayList();
	This ENV;
	String ENV_PATH;
	String LOG_FILE;
	long lastActionPickerReminder = 0;
	long screenshotDelay = 500;
	This assistBar;
	This updateManager;
	This materialColorFallback;
	This displayInfos;
	String scriptEditor = "";
	This inspector;
	This NodeInfo;
	This WindowInfo;
	This config;
	Handler mainHandler = new Handler(Looper.getMainLooper());

	ThreadFactory customThreadFactory = new ThreadFactory() {
		private AtomicInteger count = new AtomicInteger(0);
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r, "a11Y_" + count.incrementAndGet());
			thread.setPriority(Thread.MAX_PRIORITY);
			return thread;
		}
	};

	ThreadPoolExecutor a11yExecutor = new ThreadPoolExecutor(
		1, // Core size
		1, // Max size
		30, // Idle timeout
		TimeUnit.SECONDS, // Timeout unit
		new ArrayBlockingQueue(1), // Task wait-list
		customThreadFactory, // Thread factory
		new ThreadPoolExecutor.DiscardOldestPolicy()
	);

	ThreadPoolExecutor executor = new ThreadPoolExecutor(
		1, /* Core size */
		3, /* Max size */
		30, /* Idle timeout */
		TimeUnit.SECONDS, /* Timeout unit */
		new LinkedBlockingQueue(), /* Unbounded queue guarantees no tasks are dropped */
		Executors.defaultThreadFactory() /* Thread factory */
	);

	void reload() {
		Runnable reloadTask = new Runnable() {
			run() {
				try {
					if (ENV_PATH != null) source(ENV_PATH + "/a11Y.java");
				} catch (e) {
					log(e.getMessage(), "ERROR");
				}
			}
		};
		execute(reloadTask);
	}

	void debug() {
		debugMe = true;
	}

	void setConfigTo(This THIS) {
		config.setTo(TOP, THIS);
	}

	This set(This THIS) {
		if (ENV_PATH == null) {
			throw new JavaCodeException("ENV_PATH is null");
		}
		config.setTo(TOP, THIS);
		setConstant(THIS);
		this.interpreter.source(ENV_PATH + "/import.java");
		return THIS;
	}

	void set() {
		set(this.caller);
	}
	
	void setConstant(This THIS) {
		NameSpace callerNamespace = THIS.namespace;
		for (String constant: constants) {
			if (callerNamespace.getVariable(constant) == void) {
				Object value = TOP.namespace.getVariable(constant);
				callerNamespace.setTypedVariable(constant, value.getClass(), value, true);
			}
		};
	}

	void setEnvPath(String path) {
		ENV_PATH = path;
		LOG_FILE = path + "/log.txt";
	}

	void setEnv(This env) {
		ENV = env;
	}

	void resetEnv() {
		ENV_PATH = null;
	}

	void reset() {
		config.setTo(TOP);
	}

	void addOverlay(This overlay) {
		assistOverlays.add(overlay);
	};

	void removeOverlay(This overlay) {
		assistOverlays.remove(overlay);
	}

	void clean() {
		if (assistOverlays.isEmpty()) return;
		for (This overlay: assistOverlays) {
			try { overlay.remove(); } catch (e) {}
		}
		assistOverlays.clear();
	}

	void addEvent(String eventId, This eventListener) {
		if (a11E != null) a11E.add(eventId, eventListener);
	}

	void removeEvent(String eventId) {
		if (a11E != null) a11E.remove(eventId);
	}

	void removeEvents() {
		if (a11E != null) a11E.removeEvents();
	}

	List getEvents() {
		if (a11E != null) {
			Set keyset = a11E.listeners.keySet();
			return new ArrayList(keyset);
		}
		
		return new ArrayList();
	}

	if (old != null) {
		if (old.scriptEditor != void) scriptEditor = old.scriptEditor;
	}

	void showAssist() {
		if (!assistBar.isShowing()) assistBar.show();
	}

	void removeAssist() {
		if (assistBar.isShowing()) assistBar.remove();
	}

	void update() {
		if (updateManager != null) {
			if (updatePreRelease) {
				updateManager.updatePreRelease();
			}
			else {
				updateManager.update();
			}
		}

		reload();

	}

	void updatePreRelease() {
		if (updateManager != null) {
			updateManager.updatePreRelease();
			reload();
		}
	}

	void muteEvents() {
		a11E.mute();
	}

	void unmuteEvents() {
		a11E.unmute();
	}

	void execute(Runnable postRun) {
		executor.submit(postRun);
	}

	void executeA11y(Runnable postRun) {
		a11yExecutor.submit(postRun);
	}

	FutureTask submit(Runnable postRun) {
		return executor.submit(postRun);
	}

	FutureTask submitA11y(Runnable postRun) {
		return a11yExecutor.submit(postRun);
	}

	void run(String fileName) {
		Runnable runMe = new Runnable() {
			run() {
				try {
					String scriptDirName = "/scripts";
					String fullPath = ENV_PATH + scriptDirName;
					File target = new File(fullPath, fileName);
					if (!target.exists()) {
						File directory = new File(fullPath);
						File[] files = directory.listFiles();
						if (files != null) {
							for (File file: files) {
								if (file.isFile()) {
									if (file.getName().equals(fileName)) {
										target = file;
										break;
									}
								}
							}
						}
					}
					if (target.exists()) {
						this.interpreter.source(target.getAbsolutePath());
					} else {
						log("File not found: " + fileName + " in " + scriptDirName, "ERROR");
					}
				} catch (Exception e) {
					log(e.getMessage(), "ERROR");
				}
			}
		};
		execute(runMe);
	}

	void testDisplay() {
		if (displayInfos == null) {
			set();
			displayInfos = DisplayInfos();
		}
		displayInfos.show(6000);
	}

	void post(Runnable postRun) {
		mainHandler.post(postRun);
	}

	void postDelayed(Runnable postRun, long delay) {
		mainHandler.postDelayed(postRun, delay);
	}

	void remove(boolean clearGlobalVariable) {
		log("Removing a11Y", TOP);
		clean();
		removeAssist();
		removeEvents();
		executor.shutdownNow();
		a11yExecutor.shutdownNow();
		tasker.setJavaVariable("a11E", null);
		if (clearGlobalVariable) tasker.setJavaVariable("a11Y", null);
	}

	void remove() {
		remove(true);
	}

	boolean checkService() {
		return tasker.getAccessibilityService() != null;
	}

	void enableService() {
		if (a11yController == null) a11yController = A11yController();
		String packageName = context.getPackageName();
		a11yController.enableService(packageName);
	}

	void disableService() {
		if (a11yController == null) a11yController = A11yController();
		String packageName = context.getPackageName();
		a11yController.disableService(packageName);
	}

	long startTime = System.currentTimeMillis();
	
	return this;

};

log("Initializing a11Y");
This a11Y = a11Y();
a11Y.setEnvPath(ENV_PATH);
a11Y.setEnv(ENV);

setVariable(String name, Object value) {
	if (name != null && value != null) {
		a11Y.namespace.setVariable(name, value, false);
		this.caller.namespace.setVariable(name, value, false);
	}
}

This viewControl = ViewControl();
setVariable("viewControl", viewControl);

This config = Config(ENV_PATH + "/config.java");
config.load();
config.setTo(a11Y);
setVariable("config", config);
setVariable("NodeInfo", NodeInfo());
setVariable("WindowInfo", WindowInfo());
setVariable("AssistInfo", AssistInfo());
setVariable("packageManager", PackageManager());

a11Y.set();

This inspector = MethodInspector(this);
inspector.read();
a11Y.inspector = inspector;
tasker.setJavaVariable("a11Y", a11Y);

setVariable("a11yController", A11yController());
This a11E = a11E();
tasker.setJavaVariable("a11E", a11E);


This updateManager = UpdateManager();
updateManager.namespace.setVariable("directoryPath", ENV_PATH, false);
setVariable("updateManager", updateManager);

// Limit following methods and scripted objects to Tasker app
if (!ENV.HAS_MATERIAL_LIB) return;

setVariable("assistBar", AssistBar(0.8, 0.8));

if (!ENV.HAS_MATERIAL_COLOR && ENV.HAS_MATERIAL_COLOR_FALLBACK) {
	This mcf = MaterialColorFallback();
	setVariable("materialColorFallback", mcf);
	mcf.load();
	log("Using fallback material color.");
	tasker.showToast("Can't find material color via ThemeManager.color(String). Will try to use a fallback that doesn't match the theme.\n\nAccessibility actions still can be used.", "Assist & Debug features may not work.");
}

log("a11Y initialized and send start command");
tasker.sendCommand("a11Y=:=start");