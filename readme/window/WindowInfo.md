# [WindowInfo](/code/window/WindowInfo.bsh)

Expose the window-type constants and helpers used by the window filter system.

&nbsp;
# Dependencies
None

&nbsp;
# How it works
`WindowInfo` defines constant bit flags for accessibility window types and provides helper methods to test flags and format them as readable strings.

&nbsp;
# How to use

```java
info = WindowInfo();
flags = info.getFlagStringList(WindowInfo.TYPE_ALL_WINDOWS);
```

```java
addWindowFilter(WindowInfo.TYPE_APPLICATION);
```

&nbsp;
## Return Value
Returns a scripted `WindowInfo` helper object.
