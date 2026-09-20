# [includeInputWindow](/code/window/includeInputWindow.bsh)

Include input method windows in the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [addWindowFilter](/readme/window/addWindowFilter.md)

&nbsp;
# How it works
`includeInputWindow` adds the input-method window type to the configuration so keyboard and suggestion windows can be included.

&nbsp;
# How to use

```java
includeInputWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
