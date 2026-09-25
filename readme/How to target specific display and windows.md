

# Targeting Display

Call `a11Y.set()` before using the accessibility helpers. A script can select a
display, restrict the window types that are searched, and then use the normal
node helpers on that display.

&nbsp;

### By display ID

Display ID `0` is normally the default display. `setDisplay` returns the ID it
selected.

```java
a11Y.set();

setDisplay(12);
click("Continue");
```

&nbsp;

### By display name

Display names are matched case-insensitively and partially. For example, this
matches a display named `scrcpy`.

```java
a11Y.set();
setDisplay("scrcpy");
scrollTo("Settings");
```

&nbsp;

### By an app or window id

These helpers search active accessibility windows across all displays and then
update the selected display.

```java
a11Y.set();
/* Select the display containing the app's TYPE_APPLICATION window. */
setDisplayByPackageName("com.android.settings");

/* Or select the display containing a specific accessibility window. */
setDisplayByWindowId(1234);
```

`setDisplayByPackageName` returns the selected display ID, or `0` when the
package is not found. `setDisplayByWindowId` does not return a value; it leaves
the current display unchanged when the window is not found.

&nbsp;

### Switch displays during a script

The selected display can be changed at any time. The next node or window query
uses the new display.

```java
a11Y.set();
setDisplay("scrcpy");
click("Hey");

setDisplay(0);
scrollTo("Home");
```
&nbsp;

# Targeting Windows

>[!NOTE]
> Without any window filter, the default root node will be used.

&nbsp;

## Filter windows with `WindowInfo`

`WindowInfo` provides the constants used by the window filter helpers. The
constants are bit flags, so combine them with `|` when more than one window
type is needed.

1. [addWindowFilter](/readme/window/addWindowFilter.md) will add new flags.
2. [removeWindowFilter](/readme/window/removeWindowFilter.md) will remove the flags.
3. [setWindowFilfter](/readme/window/setWindowAppFilter.md) will overide the current flags.
4. [resetWindowFilfter](/readme/window/resetWindowFilfter.md) will reset the current filter to default.


&nbsp;


```java
a11Y.set();
/* Search system and input windows only. */
addWindowFilter(WindowInfo.TYPE_SYSTEM | WindowInfo.TYPE_INPUT_METHOD);

click("Home");
```

>[!WARNING]
> Adding window filter will not include the default root node. Which is usually TYPE_APPLICATION window.

&nbsp;

```java
/* Search application and input-method windows. */
setWindowFilter(WindowInfo.TYPE_APPLICATION | WindowInfo.TYPE_INPUT_METHOD);
windows = getWindows();
```

Useful constants include:

- `WindowInfo.TYPE_APPLICATION`
- `WindowInfo.TYPE_INPUT_METHOD`
- `WindowInfo.TYPE_SYSTEM`
- `WindowInfo.TYPE_ACCESSIBILITY_OVERLAY`
- `WindowInfo.TYPE_SPLIT_SCREEN_DIVIDER`
- `WindowInfo.TYPE_MAGNIFICATION_OVERLAY`
- `WindowInfo.TYPE_WINDOW_CONTROL`
- `WindowInfo.TYPE_ALL_WINDOWS`

&nbsp;

Use `addWindowFilter` and `removeWindowFilter` when changing one type without
replacing the rest of the filter.


```java
setWindowFilter(WindowInfo.TYPE_APPLICATION | WindowInfo.TYPE_ACCESSIBILITY_OVERLAY);
addWindowFilter(WindowInfo.TYPE_SYSTEM);
removeWindowFilter(WindowInfo.TYPE_SYSTEM);
```
&nbsp;

## Filter window by application package

[`setWindowAppFilter`](/readme/window/setWindowAppFilter.md) adds a regular-expression filter to the owner of the windows.

```java
a11Y.set();
setWindowAppFilter("^com\\.android\\.settings$");
```
&nbsp;

## Use window utility methods

The `window` folder also provides readable `include*Window` and
`exclude*Window` helpers. These methods add or remove one `WindowInfo` type
from the active filter without requiring the bitmask to be written directly.

&nbsp;

### Include selected window types

Use these methods to add a window type to the current filter:

```java
includeAppWindow();
includeInputWindow();
includeSystemWindow();
includeAccessibilityWindow();
includeSplitScreenDividerWindow();
includeMagnificationWindow();
includeWindowControlWindow();
```
&nbsp;

For example, the system windows:

```java
resetWindowFilter();
includeSystemWindow();
```

>[!WARNING]
> Using window util methods will not include the default root node. Which is usually TYPE_APPLICATION window.

&nbsp;

`includeAllWindows()` is a shortcut for enabling every supported window type:

```java
includeAllWindows();
```

&nbsp;

### Exclude selected window types

Use these methods to remove one type while keeping the other active filter
flags:

```java
excludeAppWindow();
excludeInputWindow();
excludeSystemWindow();
excludeAccessibilityWindow();
excludeSplitScreenDividerWindow();
excludeMagnificationWindow();
excludeWindowControlWindow();
```

&nbsp;

For example, this includes everything except input-method windows:

```java
includeAllWindows();
excludeInputWindow();

windows = getWindows();
```

&nbsp;

Use `resetWindowFilter()` to clear the type filter.

For the individual filter and display helpers, see the [window methods](/readme/window/),
[setDisplay](/readme/main/setDisplay.md), [setDisplayByPackageName](/readme/main/setDisplayByPackageName.md),
and [setDisplayByWindowId](/readme/main/setDisplayByWindowId.md) documentation.
