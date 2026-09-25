# [findScrollNodes](/code/main/findScrollNodes.bsh)

Find scrollable accessibility nodes from an existing node list or from the same selectors supported by `findNodes`.

&nbsp;
# Dependencies
1. [findNodes](/readme/main/findNodes.md)
2. [getScrollableParent](/readme/main/getScrollableParent.md)
3. [sortByArea](/readme/main/sortByArea.md)
4. [NodeInfo](/readme/assist/NodeInfo.md)

&nbsp;
# How it works
`findScrollNodes(List nodes)` keeps each node that is scrollable, or replaces it with its nearest scrollable ancestor. Duplicates are removed. If no scrollable node is found, the original matches are sorted by screen area and passed to `debugMe()`. Other overloads first call `findNodes(...)` and then apply the same scrollable-node selection. The no-argument overload searches for the `NodeInfo.SCROLLABLE` flag and sorts the result by area.

&nbsp;
# How to use
```java
scrollable = findScrollNodes("text", "Messages");
```

```java
scrollable = findScrollNodes(getRoot(), "class", "android.widget.ScrollView");
```

```java
scrollable = findScrollNodes();
```

&nbsp;
## Return Value
Returns a `List` of scrollable or likely scrollable nodes. Multi-query overloads return a map keyed by the configured query IDs.
