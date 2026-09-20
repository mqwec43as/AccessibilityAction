# [setLimitParentLevel](/code/config/setLimitParentLevel.bsh)

Limit the parent traversal depth used by click and long-click fallback logic.

&nbsp;
# Dependencies
1. [Config](/readme/config/Config.md)

&nbsp;
# How it works
`setLimitParentLevel` changes the maximum number of parent levels the fallback search can traverse before giving up.

&nbsp;
# How to use

```java
setLimitParentLevel(3);
```

&nbsp;
## Return Value
Returns the parent limit that was set.
