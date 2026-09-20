# [addWindowFilter](/code/window/addWindowFilter.bsh)

Add a window type to the active window filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)

&nbsp;
# How it works
`addWindowFilter` ORs the provided window type into `A11yConfig.filterWindowType`, allowing that category to be included in future window queries.

&nbsp;
# How to use

```java
addWindowFilter(WindowInfo.TYPE_APPLICATION);
```

&nbsp;
## Return Value
Returns the updated filter bitmask.
