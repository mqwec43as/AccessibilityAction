# [setDisplayPowerOff](/code/others/setDisplayPowerOff.bsh)

Turn the display off using the direct or shell-backed display power helper.

&nbsp;
# Dependencies
1. [setDisplayPower](/readme/others/setDisplayPower.md)
2. [setDisplayPowerViaShell](/readme/others/setDisplayPowerViaShell.md)

&nbsp;
# How it works
`setDisplayPowerOff(boolean useShell)` selects the shell implementation when `useShell` is true; otherwise it calls `setDisplayPower(0)`. The no-argument overload defaults to the shell path.

&nbsp;
# How to use
```java
setDisplayPowerOff();
setDisplayPowerOff(false); // use direct display control
```

&nbsp;
## Return Value
Returns the boolean result from the selected display power helper.
