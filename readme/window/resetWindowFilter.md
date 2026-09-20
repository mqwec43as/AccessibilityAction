# [resetWindowFilter](/code/window/resetWindowFilter.bsh)

Clear the active window filter entirely.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)

&nbsp;
# How it works
`resetWindowFilter` resets the `A11yConfig.filterWindowType` value to zero, clearing all window-type inclusions and exclusions.

&nbsp;
# How to use

```java
resetWindowFilter();
```

&nbsp;
## Return Value
Returns `0`.
