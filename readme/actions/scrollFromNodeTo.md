# [scrollFromNodeTo](/code/actions/scrollFromNodeTo.bsh)

Scroll a specific scrollable node until another target node is found inside it.

&nbsp;
# Dependencies
1. [findNodes](/readme/main/findNodes.md)
2. [findScrollNodes](/readme/main/findScrollNodes.md)
3. [getNode](/readme/main/getNode.md)
4. [hasNode](/readme/main/hasNode.md)
5. [toNode](/readme/main/toNode.md)
6. [showOnScreen](/readme/actions/showOnScreen.md)
7. [wait](/readme/main/wait.md)
8. [stepDelay](/readme/actions/stepDelay.md)
9. [A11yConfig](/readme/config/A11yConfig.md)

&nbsp;
# How it works
`scrollFromNodeTo(scrollNode, toKey, toValue, scrollCount, scrollForward)` searches the target selector before each scroll and performs `ACTION_SCROLL_FORWARD` or `ACTION_SCROLL_BACKWARD` on the supplied scroll node. If the first scroll fails, it tries the opposite direction. When `A11yConfig.scrollAgainWhenFailed` is enabled, it retries failed scroll actions up to `A11yConfig.scrollMaximumTries`, waiting `A11yConfig.scrollDelay` between attempts. On success it refreshes the scroll node, brings the target on screen, and applies `stepDelay()`.

Overloads accept a text target, omit the count or direction, or locate the scroll node by a key/value selector. The default scroll count is `20` and the default direction is forward.

&nbsp;
# How to use
```java
target = scrollFromNodeTo(scrollView, "text", "Newest", 20, true);
```

```java
target = scrollFromNodeTo("text", "Posts", "text", "Newest", 10, true);
```

```java
target = scrollFromNodeTo(scrollView, "Newest");
```

&nbsp;
## Return Value
Returns the found `AccessibilityNodeInfo`, or `null` when the supplied scroll node is not scrollable, no scroll node can be resolved, or the target is not found within the attempts.
