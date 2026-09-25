# [textDialog](/code/lib/textDialog.bsh)

Open a bottom-aligned Material text editor inside a temporary Tasker activity.

&nbsp;
# Dependencies
1. Tasker `doWithActivity(...)`
2. [Environment](/readme/main/Environment.md) and [ThemeManager](/readme/assist/ThemeManager.md)
3. Material `TextInputLayout`, `TextInputEditText`, and `FloatingToolbarLayout`

&nbsp;
# How it works
`textDialog(String text)` checks the material library, creates a temporary activity through `tasker.doWithActivity(...)`, pre-fills a multiline text field, applies the current dark theme, and shows a bottom-aligned cancelable panel. The current implementation only wires a `CANCEL` button; it does not expose an accept callback or return the edited text.

# How to use

```java
textDialog("Text to edit");
```

## Return Value
Returns `void`; the dialog is shown asynchronously through the temporary activity.
