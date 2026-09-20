# [includeAllWindows](/code/window/includeAllWindows.bsh)

Enable all supported window types in the filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [setWindowFilter](/readme/window/setWindowFilter.md)

&nbsp;
# How it works
`includeAllWindows` replaces the current filter mask with `WindowInfo.TYPE_ALL_WINDOWS`, allowing every supported window category.

&nbsp;
# How to use

```java
includeAllWindows();
```

&nbsp;
## Return Value
Returns the `TYPE_ALL_WINDOWS` bitmask.
