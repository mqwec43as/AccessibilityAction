# [includeWindowControlWindow](/code/window/includeWindowControlWindow.bsh)

Include window-control overlay windows in the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [addWindowFilter](/readme/window/addWindowFilter.md)

&nbsp;
# How it works
`includeWindowControlWindow` adds the window-control flag so those overlay windows can participate in the filter set.

&nbsp;
# How to use

```java
includeWindowControlWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
