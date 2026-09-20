# [excludeAccessibilityWindow](/code/window/excludeAccessibilityWindow.bsh)

Exclude accessibility overlay windows from the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [removeWindowFilter](/readme/window/removeWindowFilter.md)

&nbsp;
# How it works
`excludeAccessibilityWindow` removes the accessibility overlay bit from the active filter so those windows are ignored in future queries.

&nbsp;
# How to use

```java
excludeAccessibilityWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
