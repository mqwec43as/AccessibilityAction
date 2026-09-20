# [includeAppWindow](/code/window/includeAppWindow.bsh)

Include application windows in the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [addWindowFilter](/readme/window/addWindowFilter.md)

&nbsp;
# How it works
`includeAppWindow` adds the application window flag so app windows are included in later scans.

&nbsp;
# How to use

```java
includeAppWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
