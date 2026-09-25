# [ViewControl](/code/lib/ViewControl.bsh)

Manage overlay views for the assist system, including add/remove and visibility checks.

&nbsp;
# Dependencies
1. [Environment](/readme/main/Environment.md) layout type constants
2. [getA11yInstance](/readme/main/getA11yInstance.md)
3. Scripted view objects exposing `show()`, `hide()`, `remove()`, `isShowing()`, `isHidden()`, and `isRemoved()`

&nbsp;
# How it works
`ViewControl()` stores scripted views by their `WINDOW_TYPE` bit flag. `show(targetViewsBit)` applies the configured exclusivity rules, hiding or removing conflicting overlays before showing the requested views. `hide(...)` and `remove(...)` operate on bit masks, while `isVisible`, `isHidden`, `isRemoved`, and `isAnyVisible` query state.

# How to use

```java
vc = ViewControl();
vc.addView(overlay);
vc.show(ENV.Layout.TYPE_STRUCTURE_OVERLAY);
```

```java
vc.addView(viewObject);
```

## Return Value
Returns a scripted `ViewControl` manager object. Registration and state-changing methods do not return data; lookup methods return scripted views or booleans.
