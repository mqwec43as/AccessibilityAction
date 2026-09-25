# [gesture](/code/gestures/gesture.bsh)

Dispatch a complex multi-step gesture using accessibility gestures and optional visual trail overlays.

&nbsp;
# Dependencies
1. [gestureShizuku](/readme/gestures/gestureShizuku.md)
2. [getContext](/readme/main/getContext.md)
3. [getDisplayMetrics](/readme/main/getDisplayMetrics.md)
4. [getRoot](/readme/main/getRoot.md)
5. [getService](/readme/main/getService.md)
6. [setDisplay](/readme/main/setDisplay.md)

&nbsp;
# How it works
`gesture` accepts a multidimensional points array and converts normalized screen coordinates into actual display pixels. It builds one or more `StrokeDescription` objects, supports action types for down/move/up, and can optionally render the gesture path with a `Paint` overlay. If the standard accessibility service root is unavailable, it falls back to `gestureShizuku`.

&nbsp;
# How to use

**Simple gesture sequence:**
A quick down-move-up gesture in the middle of the screen.
```java
Object[][] points = new Object[][] {
  {0.5, 0.5, 0, 1L},
  {0.5, 0.8, 1, 200L},
  {0.5, 0.8, 2, 50L}
};
gesture(points);
```

&nbsp;
**Gesture with visual overlay:**
```java
Paint paint = createPaint(0xFF00FFFF, 6, 18);
Object[][] points = new Object[][] {
  {0.2, 0.2, 0, 1L},
  {0.8, 0.2, 3, 300, 0.5, 0.0},
  {0.8, 0.8, 2, 50L}
};
gesture(points, paint);
```

&nbsp;
**Full control over gesture points:**
Each item is `[x, y, actionType, duration, (optional controlX, controlY)]`.
```
{0.5, 0.5, 0, 1L} // down
{0.7, 0.3, 3, 200L, 0.7, 0.1} // curve move
{0.7, 0.3, 2, 50L} // up
```

&nbsp;
## Return Value
Returns `true` if the gesture dispatch completes successfully, or `false` on failure.