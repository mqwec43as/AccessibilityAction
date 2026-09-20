# [showDebugToast](/code/config/showDebugToast.bsh)

Enable or disable the debug toast output.

&nbsp;
# Dependencies
1. [Config](/readme/config/Config.md)

&nbsp;
# How it works
`showDebugToast` toggles the `debugInfo` setting, which controls whether generic action messages are shown as toasts while debugging.

&nbsp;
# How to use

```java
showDebugToast(true);
```

&nbsp;
## Return Value
Returns the boolean state that was set.
