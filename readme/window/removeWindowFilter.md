# [removeWindowFilter](/code/window/removeWindowFilter.bsh)

Remove one window type from the active filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)

&nbsp;
# How it works
`removeWindowFilter` clears a specific bit from `A11yConfig.filterWindowType` without resetting the other flags.

&nbsp;
# How to use

```java
removeWindowFilter(WindowInfo.TYPE_APPLICATION);
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
