# [ListDialog](/code/lib/ListDialog.bsh)

Create a configurable list dialog with filtering, sorting, single or multiple selection, and lifecycle callbacks.

&nbsp;
# Dependencies
1. Material Components and `FloatingToolbarLayout`
2. `lib.ui` helpers and Android `Activity`/`WindowManager`
3. A config `This` object containing `itemList`

&nbsp;
# How it works
`ListDialog(This config)` reads options such as `title`, `itemList`, `showFilter`, `multiSelect`, `preSelect`, `sort`, `useOverlay`, `useAccessibility`, `displayId`, `timeout`, and size values. Items are maps with a `title` value. The object manages the dialog lifecycle and can call `onSuccess(HashMap)`, `onSuccess(ArrayList)`, `onCancel()`, `onTimeout()`, `onDismiss()`, `onAttach()`, and `onDetach()` callbacks when those methods exist on the config object.

# How to use

```java
config.itemList = new ArrayList();
config.itemList.add({"title": "Settings", "value": "settings"});
config.showFilter = true;
config.multiSelect = false;
config.onSuccess = function(HashMap selected) {
	log(selected.toString());
};
dialog = ListDialog(config);
```

```java
dialog.show();
```

## Return Value
Returns a scripted `ListDialog` object. Selection callbacks receive a `HashMap` for single selection or an `ArrayList` for multi-selection; lifecycle methods do not return data.
