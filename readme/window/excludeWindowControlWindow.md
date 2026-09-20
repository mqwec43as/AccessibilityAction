# [excludeWindowControlWindow](/code/window/excludeWindowControlWindow.bsh)

Exclude window-control windows from the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [removeWindowFilter](/readme/window/removeWindowFilter.md)

&nbsp;
# How it works
`excludeWindowControlWindow` removes the window-control window type from the active filter.

&nbsp;
# How to use

```java
excludeWindowControlWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
