# [setDisplayPower](/code/others/setDisplayPower.bsh)

Set the power state of a specific Android display.

&nbsp;
# Dependencies
1. Android `IDisplayManager` and `Display`
2. [setDisplayPowerViaShell](/readme/others/setDisplayPowerViaShell.md)
3. Tasker Shizuku and shell helpers

&nbsp;
# How it works
`setDisplayPower(int displayId, int mode)` first tries Shizuku's `IDisplayManager.requestDisplayPower(...)`, mapping mode `0` to `Display.STATE_OFF` and every other mode to `Display.STATE_ON`. If that call fails, it falls back to `setDisplayPowerViaShell(mode)`. The one-argument overload uses the current context display ID.

&nbsp;
# How to use
```java
setDisplayPower(0, 0); // display 0 off
setDisplayPower(2);    // current display on
```

&nbsp;
## Return Value
Returns `true` when the direct display request or shell fallback succeeds, otherwise `false`.
