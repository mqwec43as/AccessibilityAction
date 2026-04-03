/*─────────────────────────────────────────────────────────────── 
This code was primarily generated using AI with minimal human editing.
───────────────────────────────────────────────────────────────*/

import android.accessibilityservice.AccessibilityService;

/*───────────────────────────────────────────────────────────────
  SINGLE GLOBAL ACTION FUNCTIONS
  Each function directly performs the corresponding global action.
───────────────────────────────────────────────────────────────*/

back() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
}

home() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME);
}

recents() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS);
}

tasks() {
	// Alias for recents()
	return recents();
}

notifications() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS);
}

notif() {
	// Alias for notifications()
	return notifications();
}

qs() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_QUICK_SETTINGS);
}

quicksettings() {
	// Alias for qs()
	return qs();
}

power() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_POWER_DIALOG);
}

powerdialog() {
	// Alias for power()
	return power();
}

splitscreen() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN);
}

split() {
	// Alias for splitscreen()
	return splitscreen();
}

lock() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_LOCK_SCREEN);
}

lockscreen() {
	// Alias for lock()
	return lock();
}

screenshot() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_TAKE_SCREENSHOT);
}

ss() {
	// Alias for screenshot()
	return screenshot();
}

dismiss() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_DISMISS_NOTIFICATION_SHADE);
}

closepanel() {
	// Alias for dismiss()
	return dismiss();
}

a11ybutton() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_ACCESSIBILITY_BUTTON);
}

accessibilitybutton() {
	// Alias for a11ybutton()
	return a11ybutton();
}

shortcut() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_ACCESSIBILITY_SHORTCUT);
}

a11yshortcut() {
	// Alias for shortcut()
	return shortcut();
}

allapps() {
	svc = getService();
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_ACCESSIBILITY_ALL_APPS);
}

drawer() {
	// Alias for allapps()
	return allapps();
}

lastapp() {
	svc = getService();
	// Press Recents twice to switch to the last app
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS);
	wait(50);
	svc.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS);
}