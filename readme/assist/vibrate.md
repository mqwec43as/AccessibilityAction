# [vibrate](/code/assist/vibrate.bsh)

Trigger a short Android haptic feedback pulse on a specific view.

&nbsp;
# Dependencies
None

&nbsp;
# How it works
`vibrate(View v)` checks whether the provided Android `View` is non-null and then calls `performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)`. This is used as a quick tactile feedback hint for UI touches and assist interactions.

&nbsp;
# How to use

```java
button = findViewById(...);
vibrate(button);
```

Or from a direct assist callback:

```java
vibrate(myButton);
```

&nbsp;
## Return Value
Returns `void` after triggering the haptic feedback if the view is valid.
