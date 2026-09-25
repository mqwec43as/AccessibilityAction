# [log](/code/lib/log.bsh)

Write messages to the configured Tasker log with severity, caller, node, or tag metadata.

&nbsp;
# Dependencies
1. Tasker `tasker.log(...)`
2. `LOG_FILE` from the active a11Y environment
3. [A11yConfig](/readme/config/A11yConfig.md) for optional node logging

&nbsp;
# How it works
The overloads support an INFO message, an explicit level, an `AccessibilityNodeInfo`, a scripted caller object, or a string tag. Node text is appended only when `A11yConfig.logIncludeNode` is enabled. Log entries include the calling namespace and BeanShell invocation line unless a tag is supplied.

# How to use

```java
log("Loaded", "INFO");
```

```java
log("Error", "ERROR", "MyTag");
```

## Return Value
Returns `void` after forwarding the message to Tasker's logger.
