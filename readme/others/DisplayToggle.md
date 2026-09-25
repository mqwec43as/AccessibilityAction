# [DisplayToggle](/code/others/DisplayToggle.bsh)

Bundled privileged helper used to change an Android display's power mode.

&nbsp;
# Dependencies
1. [setDisplayPowerViaShell](/readme/others/setDisplayPowerViaShell.md)
2. Android `Display` power-mode constants
3. `code/others/DisplayToggle.dex`

&nbsp;
# How it works
`DisplayToggle` is a compiled DEX command-line helper, not a BeanShell function. `setDisplayPowerViaShell(int mode)` loads it with `app_process`, passes the requested mode, and runs it through the first available privileged shell backend. Supported modes are `0` off, `1` doze, `2` normal, and `3` doze suspend.

&nbsp;
# How to use
```java
setDisplayPowerViaShell(0); // off
setDisplayPowerViaShell(2); // normal/on
```

&nbsp;
## Return Value
The DEX helper is not called directly from BeanShell. Its command result is converted by `setDisplayPowerViaShell(...)` to `true` on success or `false` when no shell result or an error is returned.
