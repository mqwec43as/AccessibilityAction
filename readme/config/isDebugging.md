# [isDebugging](/code/config/isDebugging.bsh)

Check whether debug mode is enabled in the active accessibility configuration.

&nbsp;
# Dependencies
1. [A11yConfig](/readme/config/A11yConfig.md)

&nbsp;
# How it works
`isDebugging()` reads and returns `A11yConfig.debugMe`. It does not change the setting and reflects the current runtime configuration used by debug helpers.

&nbsp;
# How to use
```java
if (isDebugging()) {
	log("Debug mode is enabled");
}
```

&nbsp;
## Return Value
Returns `true` when `A11yConfig.debugMe` is enabled; otherwise returns `false`.
