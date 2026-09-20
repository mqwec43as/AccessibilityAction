# [setLogIncludeNode](/code/config/setLogIncludeNode.bsh)

Include node metadata in logs while debugging.

&nbsp;
# Dependencies
1. [Config](/readme/config/Config.md)

&nbsp;
# How it works
`setLogIncludeNode` toggles the `logIncludeNode` option so log entries can include the matched node information for debugging.

&nbsp;
# How to use

```java
setLogIncludeNode(true);
```

&nbsp;
## Return Value
Returns the boolean state that was set.
