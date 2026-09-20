# [setWindowFilter](/code/window/setWindowFilter.bsh)

Set the entire window filter to a specific value.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)

&nbsp;
# How it works
`setWindowFilter` replaces the current filter bitmask with a new window-type mask, enabling full control over which types are considered.

&nbsp;
# How to use

```java
setWindowFilter(WindowInfo.TYPE_APPLICATION);
```

&nbsp;
## Return Value
Returns the new filter bitmask.
