# [tapShizuku](/code/gestures/tapShizuku.bsh)

Inject a touch tap through Shizuku by sending `ACTION_DOWN` and `ACTION_UP` motion events directly to the input manager.

&nbsp;
# Dependencies
1. [getContext](/readme/main/getContext.md)
2. [getDisplayMetrics](/readme/main/getDisplayMetrics.md)
3. [tasker.getShizukuService](https://tasker.joaoapps.com/android/reference/)

&nbsp;
# How it works
`tapShizuku(double x, double y, long duration)` normalizes the input coordinates to the current display size, converts normalized values like `0.5` into pixel coordinates, and then injects a low-level touch sequence by reflecting `IInputManager` through Shizuku. It performs a quick `ACTION_DOWN` followed by `ACTION_UP`, optionally waiting for the given hold duration before releasing. The overloads accept either normalized coordinates or absolute pixel positions.

&nbsp;
# How to use

**Tap the center of the screen:**
```java
tapShizuku(0.5, 0.5);
```

**Tap at an exact pixel coordinate with a hold:**
```java
tapShizuku(540, 1200, 200L);
```

**Use the default short tap duration:**
```java
tapShizuku(0.3, 0.7);
```

&nbsp;
## Return Value
Returns `true` when the Shizuku tap injection succeeds, or `false` if the input event fails or an exception is raised.