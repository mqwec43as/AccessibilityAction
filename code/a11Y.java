import bsh.This;

a11Y() {
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
	This TOP;
	set(This THIS) {
		THIS.namespace.setVariable("debugMe", debugMe, false);
		THIS.namespace.setVariable("debugSteps", debugSteps, false);
		THIS.namespace.setVariable("debugInfo", debugInfo, false);
		THIS.namespace.setVariable("findDelay", findDelay, false);
		THIS.namespace.setVariable("debugDelay", debugDelay, false);
		THIS.namespace.setVariable("useOffset", useOffset, false);
		THIS.namespace.setVariable("useA11yOffset", useA11yOffset, false);
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

	return this;
};

This a11Y = a11Y();
tasker.setJavaVariable("a11Y", a11Y);