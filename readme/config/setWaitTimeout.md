# [setWaitTimeout](/code/config/setWaitTimeout.bsh)

Set the timeout used while waiting for nodes.

&nbsp;
# Dependencies
1. [Config](/readme/config/Config.md)

&nbsp;
# How it works
`setWaitTimeout` updates the maximum time the project will wait while searching for a node before continuing or failing.

&nbsp;
# How to use

```java
setWaitTimeout(15000);
```

&nbsp;
## Return Value
Returns the timeout value that was set.
