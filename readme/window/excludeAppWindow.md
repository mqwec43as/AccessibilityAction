# [excludeAppWindow](/code/window/excludeAppWindow.bsh)

Exclude application windows from the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [removeWindowFilter](/readme/window/removeWindowFilter.md)

&nbsp;
# How it works
`excludeAppWindow` removes the application window flag from the filter so app windows are not included in results.

&nbsp;
# How to use

```java
excludeAppWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
