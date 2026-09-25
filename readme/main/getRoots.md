# [getRoots](/code/main/getRoots.bsh)

Get the root accessibility node for every accessibility window on a display.

&nbsp;
# Dependencies
1. [getWindows](/readme/window/getWindows.md)
2. [A11yConfig](/readme/config/A11yConfig.md)

&nbsp;
# How it works
`getRoots(int displayId)` retrieves windows for the requested display, obtains each `AccessibilityWindowInfo` root, and returns the roots in window order. The no-argument overload uses `A11yConfig.displayId`, defaulting to display `0` when the configuration object is unavailable.

&nbsp;
# How to use
```java
roots = getRoots();
```

```java
secondaryRoots = getRoots(1);
```

&nbsp;
## Return Value
Returns a `List` of root `AccessibilityNodeInfo` objects, one for each window returned for the display.
