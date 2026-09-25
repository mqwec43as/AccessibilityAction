# [runScript](/code/assist/runScript.bsh)

Run a BeanShell script in the active a11Y interpreter on the accessibility executor, with optional delay and temporary event muting.

&nbsp;
# Dependencies
1. [a11Y.java](/code/a11Y.java)
2. [What is a11Y?](/readme/What%20is%20a11Y.md)
3. [setDisplay](/readme/main/setDisplay.md)

&nbsp;
# How it works
`runScript(String script, long delayMs, int displayId, int windowFilter)` prepares a script header that rebinds the `a11Y` context, refreshes `A11yConfig`, sets a wait timeout, applies the target display and window filter, and then evaluates the user script via `this.interpreter.eval(...)`. Before execution it calls `a11Y.muteEvents()`, waits for the optional delay, and restores event processing in a `finally` block. The work is scheduled through `a11Y.executeA11y(...)` so it runs on the accessibility thread.

&nbsp;
# How to use

**Run a script after a short delay:**
```java
runScript("click('Add');", 200);
```

**Run on a specific display and window filter:**
```java
runScript("click('Filter');", 500, 1, 0);
```

**Run a script that changes the active display before executing:**
```java
runScript("setDisplay(1); click('Settings');", 300);
```

&nbsp;
## Return Value
Returns `void`. The script is executed asynchronously, and any runtime exception is logged through the project logger.
