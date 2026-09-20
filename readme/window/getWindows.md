# [getWindows](/code/window/getWindows.bsh)

Get the filtered accessibility windows for a display.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [getService](/readme/main/getService.md)

&nbsp;
# How it works
`getWindows` reads all windows from the accessibility service for a display, filters them using the current window configuration, and returns the matching entries.

&nbsp;
# How to use

```java
windows = getWindows();
```

```java
windows = getWindows(1);
```

&nbsp;
## Return Value
Returns a `List` of `AccessibilityWindowInfo` objects, or an empty list if none are available.
