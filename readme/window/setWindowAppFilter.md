# [setWindowAppFilter](/code/window/setWindowAppFilter.bsh)

Set a package-name regex filter for the active window matching.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)

&nbsp;
# How it works
`setWindowAppFilter` stores a regex pattern used to match package names during window filtering, so only matching app windows are considered.

&nbsp;
# How to use

```java
setWindowAppFilter("net.dinglisch.android.taskerm");
```

&nbsp;
## Return Value
No explicit value is returned.
