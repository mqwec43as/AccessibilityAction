# [setScrollDelay](/code/config/setScrollDelay.bsh)

Set the delay used by scrolling operations.

&nbsp;
# Dependencies
1. [A11yConfig](/readme/config/A11yConfig.md)
2. Scrolling helpers such as [scrollTo](/readme/actions/scrollTo.md)

&nbsp;
# How it works
`setScrollDelay(long scrollDelay)` assigns the supplied duration to `A11yConfig.scrollDelay`. The unit is milliseconds, and scrolling helpers use the stored value when waiting between scroll attempts.

&nbsp;
# How to use
```java
setScrollDelay(250);
```

&nbsp;
## Return Value
Returns the configured delay as a `long` value in milliseconds.
