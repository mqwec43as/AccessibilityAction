# [setVisibilityListener](/code/lib/setVisibilityListener.bsh)

Attach a visibility listener to a view and execute callbacks when visibility changes.

&nbsp;
# Dependencies
1. Android `View` and `ViewTreeObserver`
2. A listener `This` object
3. The active `config` namespace used to detect callback methods

&nbsp;
# How it works
`setVisibilityListener(View myView, This listener)` stores the initial visibility and installs an `OnGlobalLayoutListener`. When the visibility changes, it calls any available `onVisible(View)`, `onGone(View)`, or `onInvisible(View)` method on the listener for the corresponding Android state.

# How to use

```java
listener.onVisible = function(View view) {
	log("View is visible");
};
listener.onGone = function(View view) {
	log("View is gone");
};
setVisibilityListener(myView, listener);
```

## Return Value
Returns `void`. The global-layout listener remains attached to the view and reacts to later visibility changes.
