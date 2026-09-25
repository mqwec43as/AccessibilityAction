# [setDisplayPowerOn](/code/others/setDisplayPowerOn.bsh)

Restore the display to Android's normal power state.

&nbsp;
# Dependencies
1. [setDisplayPower](/readme/others/setDisplayPower.md)
2. [setDisplayPowerViaShell](/readme/others/setDisplayPowerViaShell.md)

&nbsp;
# How it works
`setDisplayPowerOn(boolean useShell)` passes mode `2` to the shell helper when requested, or calls `setDisplayPower(2)` for direct display control. The no-argument overload defaults to the shell path.

&nbsp;
# How to use
```java
setDisplayPowerOn();
setDisplayPowerOn(false); // use direct display control
```

&nbsp;
## Return Value
Returns the boolean result from the selected display power helper.
