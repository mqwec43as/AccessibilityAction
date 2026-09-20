# [hasWindowFilter](/code/window/hasWindowFilter.bsh)

Check whether a specific window type is included in the filter.

&nbsp;
# Dependencies
1. [WindowInfo](/readme/window/WindowInfo.md)

&nbsp;
# How it works
`hasWindowFilter` checks if a target bit is currently enabled in `A11yConfig.filterWindowType`.

&nbsp;
# How to use

```java
if (hasWindowFilter(WindowInfo.TYPE_APPLICATION)) {
    // app windows are allowed
}
```

&nbsp;
## Return Value
Returns `true` if the flag is enabled, otherwise `false`.
