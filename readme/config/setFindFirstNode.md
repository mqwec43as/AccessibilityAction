# [setFindFirstNode](/code/config/setFindFirstNode.bsh)

Control whether recursive node searches stop after their first matching result.

&nbsp;
# Dependencies
1. [A11yConfig](/readme/config/A11yConfig.md)
2. [findNodes](/readme/main/findNodes.md)
3. [findScrollNodes](/readme/main/findScrollNodes.md)

&nbsp;
# How it works
`setFindFirstNode(boolean state)` writes the value to `A11yConfig.findFirstForRecursive`. Recursive search helpers consult this flag to stop early when a result has been found.

&nbsp;
# How to use
```java
setFindFirstNode(true);
```

```java
setFindFirstNode(false);
```

&nbsp;
## Return Value
Returns the boolean value stored in `A11yConfig.findFirstForRecursive`.
