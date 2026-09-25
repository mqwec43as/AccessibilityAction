# [AssistInfo](/code/assist/AssistInfo.bsh)

Expose shared titles, button bit flags, and Material icon names used by the assist bar and structure overlay.

&nbsp;
# Dependencies
1. BeanShell `This`
2. Assist UI components such as [AssistBar](/readme/assist/AssistBar.md) and [StructureOverlay](/readme/assist/StructureOverlay.md)

&nbsp;
# How it works
`AssistInfo()` returns a scripted object containing the titles `ASSIST_BAR_TITLE` and `STRUCTURE_TITLE`, the button bit flags `HANDLE_BUTTON`, `ACTIONS_GROUP_BUTTON`, `SCRIPT_BUTTON`, `SETTING_BUTTON`, `FILTER_BUTTON`, `SEARCH_BUTTON`, `CLOSE_BUTTON`, and `INFO_BUTTON`, and the corresponding Material icon names such as `HANDLE_ICON`, `FILTER_ICON`, `SEARCH_ICON`, `CLOSE_ICON`, `DELETE_ICON`, and `INFO_ICON`. `HAS_NO_ID` is the zero-value identifier.

&nbsp;
# How to use
```java
assistInfo = AssistInfo();
title = assistInfo.ASSIST_BAR_TITLE;
filterMask = assistInfo.HANDLE_BUTTON | assistInfo.FILTER_BUTTON;
icon = assistInfo.FILTER_ICON;
```

&nbsp;
## Return Value
Returns a scripted `AssistInfo` object containing constants for assist UI construction and button-mask checks.
