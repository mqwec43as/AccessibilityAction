# [includeSplitScreenDividerWindow](/code/window/includeSplitScreenDividerWindow.bsh)

Include split-screen divider windows in the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [addWindowFilter](/readme/window/addWindowFilter.md)

&nbsp;
# How it works
`includeSplitScreenDividerWindow` adds the split-screen divider window flag so divider windows are eligible in queries.

&nbsp;
# How to use

```java
includeSplitScreenDividerWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
