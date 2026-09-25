# [gestureShizuku](/code/gestures/gestureShizuku.bsh)

Replay a complex touch motion sequence using Shizuku input injection.

&nbsp;
# Dependencies
1. [getContext](/readme/main/getContext.md)
2. [getDisplayMetrics](/readme/main/getDisplayMetrics.md)
3. [setDisplay](/readme/main/setDisplay.md)

&nbsp;
# How it works
`gestureShizuku` builds and injects `MotionEvent` events through Shizuku's input service. It accepts normalized or absolute coordinates, supports ACTION_DOWN, ACTION_MOVE, ACTION_UP, and bezier-style curve steps. When a `Paint` object is provided, it can also draw the gesture path overlay while injecting touch events.

&nbsp;
# How to use

**Simple Shizuku gesture:**
```java
Object[][] points = new Object[][] {
  {0.5, 0.5, 0, 1L},
  {0.5, 0.8, 1, 200L},
  {0.5, 0.8, 2, 50L}
};
gestureShizuku(points);
```

&nbsp;
**Gesture with curve control point:**
```java
Object[][] circlePoints = new Object[][] {
  {0.5, 0.3, 0, 100L},
  {0.7, 0.5, 3, 200L, 0.7, 0.3},
  {0.5, 0.7, 3, 200L, 0.7, 0.7},
  {0.3, 0.5, 3, 200L, 0.3, 0.7},
  {0.5, 0.3, 3, 200L, 0.3, 0.3},
  {0.5, 0.3, 1, 500L}
};
gestureShizuku(circlePoints);
```

&nbsp;
**Overlay-enabled gesture:**
```java
Paint paint = createPaint(0xFFFFFF00, 5, 12);
gestureShizuku(points, paint);
```

&nbsp;
## Return Value
Returns `true` when the Shizuku gesture is injected successfully, otherwise `false`.