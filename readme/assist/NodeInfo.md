# [NodeInfo](/code/assist/NodeInfo.bsh)

Inspect Android accessibility node flags, grouping names, and node metadata exposed through a Java-like scripted object.

&nbsp;
# Dependencies
None

&nbsp;
# How it works
`NodeInfo(AccessibilityNodeInfo node)` creates a metadata helper that reads Android node boolean properties, matches them against a constant table, and exposes grouped aliases such as `Clickable`, `Focusable`, `Scrollable`, `Editable`, and `LongClickable`. It also exposes `getConstantNames()`, `getConstant(name)`, `getGroupList(groupName)`, `getGroupNames()`, `getProperties(node)`, and `hasAllProperties(...)` for assist overlays and filter logic.

&nbsp;
# How to use

```java
node = getNode("Login");
info = NodeInfo(node);
flags = info.getConstantNames();
selected = info.getConstant("Clickable");
```

```java
group = info.getGroupList("Action");
```

&nbsp;
## Return Value
Returns a scripted `NodeInfo` object with metadata helpers and property-checking methods for the current accessibility node.
