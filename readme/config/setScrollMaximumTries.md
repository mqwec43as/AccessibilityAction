# [setScrollMaximumTries](/code/config/setScrollMaximumTries.bsh)

Set the maximum number of scroll attempts used by scrolling helpers.

&nbsp;
# Dependencies
1. [A11yConfig](/readme/config/A11yConfig.md)
2. Scrolling helpers such as [scrollTo](/readme/actions/scrollTo.md)

&nbsp;
# How it works
`setScrollMaximumTries(int maximumTries)` assigns the supplied count to `A11yConfig.scrollMaximumTries`. Scrolling logic can use this value to stop retrying after the configured number of attempts.

&nbsp;
# How to use
```java
setScrollMaximumTries(5);
```

&nbsp;
## Return Value
Returns the configured maximum attempt count as an `int`.
