# [excludeSystemWindow](/code/window/excludeSystemWindow.bsh)

Exclude system windows from the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [removeWindowFilter](/readme/window/removeWindowFilter.md)

&nbsp;
# How it works
`excludeSystemWindow` removes the system window flag from `A11yConfig.filterWindowType` so system UI windows are skipped.

&nbsp;
# How to use

```java
excludeSystemWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
