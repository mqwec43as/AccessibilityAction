# [stepDelay](/code/actions/stepDelay.bsh)

Wait for the configured delay between debug or accessibility action steps.

&nbsp;
# Dependencies
1. [A11yConfig](/readme/config/A11yConfig.md)
2. [wait](/readme/main/wait.md)

&nbsp;
# How it works
`stepDelay()` reads `A11yConfig.stepDelay`. When the value is greater than zero, it calls `wait(...)` with that value in milliseconds. A zero or negative value skips the wait.

&nbsp;
# How to use
```java
setStepDelay(100);
click("Continue");
stepDelay();
```

&nbsp;
## Return Value
Returns `void`.
