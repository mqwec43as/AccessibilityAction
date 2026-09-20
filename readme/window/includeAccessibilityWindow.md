# [includeAccessibilityWindow](/code/window/includeAccessibilityWindow.bsh)

Include accessibility overlay windows in the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [addWindowFilter](/readme/window/addWindowFilter.md)

&nbsp;
# How it works
`includeAccessibilityWindow` adds the accessibility overlay flag to the configuration so those windows can be included in queries.

&nbsp;
# How to use

```java
includeAccessibilityWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
