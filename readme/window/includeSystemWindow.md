# [includeSystemWindow](/code/window/includeSystemWindow.bsh)

Include system windows in the current filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)
2. [addWindowFilter](/readme/window/addWindowFilter.md)

&nbsp;
# How it works
`includeSystemWindow` adds the system window flag so system UI windows can be handled or inspected.

&nbsp;
# How to use

```java
includeSystemWindow();
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
