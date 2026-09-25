# [getScrollableParent](/code/main/getScrollableParent.bsh)

Find the nearest scrollable ancestor of an accessibility node.

&nbsp;
# Dependencies
Android `AccessibilityNodeInfo`

&nbsp;
# How it works
The helper checks the supplied node and then repeatedly follows `getParent()`. It returns immediately when a node reports `isScrollable() == true`; otherwise it continues until the hierarchy ends.

&nbsp;
# How to use
```java
scrollContainer = getScrollableParent(currentNode);
```

&nbsp;
## Return Value
Returns the nearest scrollable `AccessibilityNodeInfo`, or `null` when the node and all of its ancestors are not scrollable.
