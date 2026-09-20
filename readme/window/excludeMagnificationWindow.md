# [excludeMagnificationWindow](/code/window/excludeMagnificationWindow.bsh)

Exclude magnification overlay windows from the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [removeWindowFilter](/readme/window/removeWindowFilter.md)

&nbsp;
# How it works
`excludeMagnificationWindow` removes the magnification overlay type from the active filter so it will not match magnifier windows.

&nbsp;
# How to use

```java
excludeMagnificationWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
