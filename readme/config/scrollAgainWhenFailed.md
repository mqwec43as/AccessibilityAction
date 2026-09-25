# [scrollAgainWhenFailed](/code/config/scrollAgainWhenFailed.bsh)

Configure whether scrolling should be attempted again after a failed scroll operation.

&nbsp;
# Dependencies
1. [A11yConfig](/readme/config/A11yConfig.md)

&nbsp;
# How it works
`scrollAgainWhenFailed(boolean state)` stores the supplied value in `A11yConfig.scrollAgainWhenFailed`. The no-argument overload is an enable shortcut and calls `scrollAgainWhenFailed(true)`.

&nbsp;
# How to use
```java
scrollAgainWhenFailed(true);
```

```java
scrollAgainWhenFailed(false);
```

&nbsp;
## Return Value
Returns the boolean value stored in `A11yConfig.scrollAgainWhenFailed`.
