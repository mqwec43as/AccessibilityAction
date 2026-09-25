# [getPixelColor](/code/main/getPixelColor.bsh)

Read the pixel color at screen coordinates or at the center coordinates of an accessibility node.

&nbsp;
# Dependencies
1. [takeScreenshot](/readme/others/takeScreenshot.md)
2. [getCoordinates](/readme/main/getCoordinates.md)
3. `ScreenshotHelper.getPixelColor(...)`

&nbsp;
# How it works
`getPixelColor(int x, int y)` captures the current display with `takeScreenshot(-1, 0, null)`, reads the requested pixel from the screenshot helper, recycles the capture, and returns the color integer. `getPixelColor(AccessibilityNodeInfo node)` obtains the node coordinates first and reads the pixel at that point before recycling the capture.

&nbsp;
# How to use
```java
color = getPixelColor(100, 200);
```

```java
color = getPixelColor(getNode("Play"));
```

&nbsp;
## Return Value
Returns an Android color packed as an `int` in the format produced by the screenshot helper.
