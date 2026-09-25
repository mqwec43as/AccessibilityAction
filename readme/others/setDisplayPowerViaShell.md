# [setDisplayPowerViaShell](/code/others/setDisplayPowerViaShell.bsh)

Toggle a display power state by invoking the bundled `DisplayToggle` helper through a privileged shell backend.

&nbsp;
# Dependencies
1. [setDisplayPower](/readme/others/setDisplayPower.md)
2. [setDisplayPowerOff](/readme/others/setDisplayPowerOff.md)
3. [setDisplayPowerOn](/readme/others/setDisplayPowerOn.md)
4. [getContext](/readme/main/getContext.md)

&nbsp;
# How it works
`setDisplayPowerViaShell(int mode)` resolves the `others/DisplayToggle.dex` helper path and runs it via the first available privileged executor: `root`, `ADB Wi‑Fi`, or `Shizuku`. It accepts the same display power modes used by Android: `0` for off, `1` for doze, `2` for normal, and `3` for doze suspend. The function returns `true` only when the shell command finishes without an error.

&nbsp;
# How to use

**Turn the display off:**
```java
setDisplayPowerViaShell(0);
```

**Restore the display to the normal on state:**
```java
setDisplayPowerViaShell(2);
```

**Use the convenience wrappers instead:**
```java
setDisplayPowerOff();
setDisplayPowerOn();
```

&nbsp;
## Return Value
Returns `true` when the display power command succeeds, otherwise `false`.
