# [excludeInputWindow](/code/window/excludeInputWindow.bsh)

Exclude input method windows from the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [removeWindowFilter](/readme/window/removeWindowFilter.md)

&nbsp;
# How it works
`excludeInputWindow` removes the keyboard and input-method window type from all future window filtering.

&nbsp;
# How to use

```java
excludeInputWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
