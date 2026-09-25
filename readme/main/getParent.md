# [getParent](/code/main/getParent.bsh)

Find the first ancestor of an accessibility node that matches a selector.

&nbsp;
# Dependencies
1. [isMatch](/readme/main/isMatch.md)

&nbsp;
# How it works
`getParent(AccessibilityNodeInfo node, String key, Object value)` starts at `node.getParent()` and walks upward until `isMatch(...)` accepts an ancestor. There are convenience overloads for matching text and for matching a scripted `multiKeys` object. The starting node itself is not tested.

&nbsp;
# How to use
```java
parent = getParent(button, "text", "Settings");
```

```java
container = getParent(button, "Settings");
```

&nbsp;
## Return Value
Returns the first matching parent `AccessibilityNodeInfo`, or `null` if no ancestor matches.
