# [canDisplayA11yOverlay](/code/lib/canDisplayA11yOverlay.bsh)

Check whether the active accessibility service can create an accessibility overlay window.

&nbsp;
# Dependencies
1. `tasker.getAccessibilityService()`
2. Android `AccessibilityService` and `WindowManager`
3. RxJava `CompletableSubject` for main-thread synchronization

&nbsp;
# How it works
`canDisplayA11yOverlay()` obtains Tasker's accessibility service, creates a 1-by-1 `TYPE_ACCESSIBILITY_OVERLAY` view, and removes it immediately. It returns false when the service is unavailable or the window operation fails. The probe is used during a11Y initialization before assist overlays are created.

&nbsp;
# How to use
```java
if (!canDisplayA11yOverlay()) {
	tasker.showToast("Accessibility overlay is unavailable");
	return;
}
```

&nbsp;
## Return Value
Returns `true` when a temporary accessibility overlay can be added and removed; otherwise returns `false`.
