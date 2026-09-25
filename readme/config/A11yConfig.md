# [A11yConfig](/code/config/A11yConfig.bsh)

Create the per-script accessibility configuration object used by node searching, scrolling, and window filtering.

&nbsp;
# Dependencies
1. [getA11yInstance](/readme/main/getA11yInstance.md)
2. [Config](/readme/config/Config.md)
3. [WindowInfo](/readme/window/WindowInfo.md)
4. Android `AccessibilityWindowInfo` and `Pattern`

&nbsp;
# How it works
`A11yConfig()` obtains the active `a11Y` instance and copies the shared configuration into a scripted object. It maintains runtime fields including `filterWindowType`, `displayId`, `filterPackageName`, `scrollMaximumTries`, `scrollDelay`, and `scrollAgainWhenFailed`. Its methods are `refresh()`, `hasWindowFilter()`, `setPackageNamePattern(String)`, `hasPackageNamePattern()`, and `IsWindowMatchFilter(AccessibilityWindowInfo)`. Package filters use regular-expression matching against the window root package name; window filters use `WindowInfo.hasFlag(...)`.

The current implementation expects a non-null pattern in `setPackageNamePattern(...)`; passing `null` attempts to call `isEmpty()` on `null`, while an empty string compiles as an empty regular expression rather than clearing `filterPackageName`.

&nbsp;
# How to use
```java
config = A11yConfig();
config.displayId = 1;
config.scrollDelay = 250;
config.setPackageNamePattern("^com\\.example\\..*");
```

```java
if (config.IsWindowMatchFilter(window)) {
	nodes = findNodes(window.getRoot(), "text", "Continue");
}
```

&nbsp;
## Return Value
Returns a scripted `A11yConfig` object containing the active display, scroll, and window-filter state.
