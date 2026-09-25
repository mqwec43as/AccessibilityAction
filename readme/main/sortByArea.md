# [sortByArea](/code/main/sortByArea.bsh)

Sort accessibility nodes by their screen bounds, from largest area to smallest.

&nbsp;
# Dependencies
Android `AccessibilityNodeInfo` and `Rect`

&nbsp;
# How it works
`sortByArea(List nodes)` reads each node's bounds with `getBoundsInScreen(...)`, calculates `width * height`, and sorts the supplied list in descending area order. The list is sorted in place and then returned.

&nbsp;
# How to use
```java
ordered = sortByArea(findNodes("flags", NodeInfo.SCROLLABLE.toString()));
```

&nbsp;
## Return Value
Returns the same `List` instance after it has been sorted from largest screen area to smallest.
