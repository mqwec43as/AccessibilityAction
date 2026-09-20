# [excludeSplitScreenDividerWindow](/code/window/excludeSplitScreenDividerWindow.bsh)

Exclude split-screen divider windows from the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [removeWindowFilter](/readme/window/removeWindowFilter.md)

&nbsp;
# How it works
`excludeSplitScreenDividerWindow` removes the split-screen divider flag from the active filter set.

&nbsp;
# How to use

```java
excludeSplitScreenDividerWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
