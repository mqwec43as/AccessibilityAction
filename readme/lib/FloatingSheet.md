# [FloatingSheet](/code/lib/FloatingSheet.bsh)

Create a draggable accessibility overlay sheet that hosts custom content panels and a drag handle.

&nbsp;
# Dependencies
1. [Environment](/readme/main/Environment.md)
2. [ThemeManager](/readme/assist/ThemeManager.md)
3. [getContext](/readme/main/getContext.md)
4. [getService](/readme/main/getService.md)

&nbsp;
# How it works
`FloatingSheet(This config)` builds a bottom-sheet style overlay using a `WindowManager`, `FrameLayout`, `ScrollView`, and `MaterialToolbar`. It validates the config object for either `getView(...)` or `getViewList(...)`, applies a theme, sets a max-height limit, and attaches drag handlers so the sheet can be moved vertically and horizontally. The sheet also calls `onAttach()` and `onDetach()` hooks if they are defined on the config object.

&nbsp;
# How to use

```java
sheetConfig = This();
sheetConfig.title = "Debug";
sheetConfig.maxHeight = 0.75f;
sheetConfig.getViewList = function(Context ctx) {
    // return a List of Views here
};

sheet = FloatingSheet(sheetConfig);
sheet.show();
```

```java
sheet.remove();
```

&nbsp;
## Return Value
Returns a scripted `FloatingSheet` object with methods such as `show()`, `remove()`, `toggle()`, and `addSpacer(...)`.
