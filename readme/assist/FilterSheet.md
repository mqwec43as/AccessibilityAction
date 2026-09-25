# [FilterSheet](/code/assist/FilterSheet.bsh)

Create a material-chip filter sheet that lets the assist UI build dynamic node flag selections.

&nbsp;
# Dependencies
1. [FloatingSheet](/readme/lib/FloatingSheet.md)
2. [NodeInfo](/readme/assist/NodeInfo.md)
3. [ThemeManager](/readme/assist/ThemeManager.md)

&nbsp;
# How it works
`FilterSheet(This assistBar, This structure)` builds a scripted UI object that reads all node flag groups from `NodeInfo.getGroupNames()`, creates chip groups for each category, and updates the selected filter mask through `addFlag()` and `removeFlag()`. It then wraps the generated filter panel inside a `FloatingSheet`, so the user can toggle node highlighting and filter settings from a draggable assist panel.

&nbsp;
# How to use

```java
sheet = FilterSheet(assistBar, structure);
```

```java
sheet.show();
```

Or use the generated floating sheet directly:

```java
filterSheet = FilterSheet(a11Y.assistBar, a11Y.structureOverlay);
filterSheet.config();
```

&nbsp;
## Return Value
Returns a scripted `FilterSheet` object whose methods include `addFlag`, `removeFlag`, `config`, and the inherited floating-sheet behaviors.
