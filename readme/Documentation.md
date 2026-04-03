 

> [!NOTE] 
> *This code was primarily generated using AI with minimal human editing.*

> [!IMPORTANT]
> This doc doesn't cover the whole functionalities and can be wrong. Please check the functions yourself by reading the function files inside the folder.

# 📚 Contents

- [📚 Contents](#-contents)
- [⚙️ Configuration Variables](#️-configuration-variables)
- [⚙️ Key identifier](#️-key-identifier)
  - [🛠️ Utility Functions](#️-utility-functions)
      - [Suspend execution](#suspend-execution)
      - [Access screen root](#access-screen-root)
- [🔎Node Finding and Waiting](#node-finding-and-waiting)
      - [Wait for specific nodes](#wait-for-specific-nodes)
      - [Search from a root node](#search-from-a-root-node)
      - [Multi-step proximity search](#multi-step-proximity-search)
      - [Bulk search with ID mapping](#bulk-search-with-id-mapping)
      - [Search for Spanned text](#search-for-spanned-text)
      - [Get a single node with retry](#get-a-single-node-with-retry)
      - [Get a single node (Default timeout)](#get-a-single-node-default-timeout)
      - [Retrieve all window nodes](#retrieve-all-window-nodes)
- [✨ Node Detail and State](#-node-detail-and-state)
      - [Get center coordinates](#get-center-coordinates)
      - [Check expandable state](#check-expandable-state)
      - [Locate scrollable parent/child](#locate-scrollable-parentchild)
      - [Locate expandable child](#locate-expandable-child)
  - [📍 Nearby and Validation](#-nearby-and-validation)
      - [Near proximity](#near-proximity)
      - [Verify absence](#verify-absence)
      - [Check Presence in List or Map](#check-presence-in-list-or-map)
      - [Check for specific keys](#check-for-specific-keys)
  - [🕸️ Node Extraction](#️-node-extraction)
      - [Get node from List](#get-node-from-list)
      - [Get node from Map](#get-node-from-map)
  - [📄 Get Node Text](#-get-node-text)
      - [Smart extraction (Automatic)](#smart-extraction-automatic)
      - [Targeted extraction](#targeted-extraction)
      - [Extract from collections](#extract-from-collections)
      - [Seekbar value extraction](#seekbar-value-extraction)
  - [📐 Node Geometry and Distance](#-node-geometry-and-distance)
      - [Get center coordinates](#get-center-coordinates-1)
      - [Calculate distance between nodes](#calculate-distance-between-nodes)
- [👆 User Action Functions](#-user-action-functions)
  - [🖱️ Click / Long Click / Focus / Context Click / Paste / Cut / Copy / Select](#️-click--long-click--focus--context-click--paste--cut--copy--select)
      - [Perform directly on the given node](#perform-directly-on-the-given-node)
      - [Perform on the first key / array child](#perform-on-the-first-key--array-child)
      - [Target a specific button](#target-a-specific-button)
      - [Long click the first matching element](#long-click-the-first-matching-element)
      - [Near another element](#near-another-element)
  - [🖍️ Set Selection](#️-set-selection)
      - [Perform directly on the given node](#perform-directly-on-the-given-node-1)
      - [Target by selector](#target-by-selector)
      - [Target the focused node](#target-the-focused-node)
      - [Select all in focused node](#select-all-in-focused-node)
  - [↕️ Scroll In Direction](#️-scroll-in-direction)
      - [Perform directly on the given node](#perform-directly-on-the-given-node-2)
      - [Target by selector](#target-by-selector-1)
  - [🔄 Scroll Backward / Scroll Forward](#-scroll-backward--scroll-forward)
      - [Scroll the first container found](#scroll-the-first-container-found)
      - [Target a specific scrollable element](#target-a-specific-scrollable-element)
  - [🤏 Collapse](#-collapse)
      - [Collapse with hierarchy search](#collapse-with-hierarchy-search)
  - [👆 Gesture](#-gesture)
      - [Custom Paint](#custom-paint)
      - [Invisible](#invisible)
  - [🔘 Tap](#-tap)
      - [Custom duration](#custom-duration)
      - [Quick tap](#quick-tap)
  - [↔️ Swipe](#️-swipe)
      - [Standard swipe](#standard-swipe)
      - [Swipe without flick](#swipe-without-flick)
- [⏱️ Misc](#️-misc)
  - [Open App](#open-app)
      - [Launch app](#launch-app)
      - [Launch specific activity](#launch-specific-activity)
- [🌎 Global Actions \& System Navigation](#-global-actions--system-navigation)
      - [Back navigation](#back-navigation)
      - [Home navigation](#home-navigation)
      - [Overview / Recent apps](#overview--recent-apps)
      - [Notification shade](#notification-shade)
      - [Quick settings](#quick-settings)
      - [Power menu](#power-menu)
      - [Lock device](#lock-device)
      - [Capture screenshot](#capture-screenshot)
      - [Dismiss panels](#dismiss-panels)
      - [Switch to last app](#switch-to-last-app)
      - [App drawer](#app-drawer)
      - [Accessibility button](#accessibility-button)
      - [Accessibility shortcut](#accessibility-shortcut)
- [🧩 Assist Overlay](#-assist-overlay)
      - [Create \& Remove](#create--remove)
      - [Controls](#controls)
        - [Handle (Camera Icon)](#handle-camera-icon)
        - [Accessibility Icon](#accessibility-icon)
      - [Structure Overlay](#structure-overlay)
        - [Interaction](#interaction)
        - [Highlights](#highlights)
      - [Offset Config](#offset-config)
- [🐞Debug Mode](#debug-mode)
      - [Debug Colors](#debug-colors)

---
# ⚙️ Configuration Variables

**Description:** These variables control the behavior of the node-finding functions, specifically how long they wait and the delay between retry attempts.

| **Variable**       | **Default Value** | **Description**                                                                              |
| ------------------ | ----------------- | -------------------------------------------------------------------------------------------- |
| `nearbyDistance`   | `500`             | Nearby distance between each nodes.                                                          |
| `stepDelay`        | `100`             | The delay in milliseconds between each retry attempt when searching for a node.              |
| `waitNodesTimeout` | `5000`            | The maximum time in milliseconds the script will wait for a node to appear before giving up. |
| `findFirst`        | `false`           | Return immediately after a first match for traversing (text, id, regex)                      |


**Example (Modifying configuration):**

```java
// If using Tasker project
a11Y.set();

// Increase the wait timeout to 10 seconds for slow screens
waitNodesTimeout = 10000;

// Set a short delay between checks
stepDelay = 50;

**Call functions here**
```

---
# ⚙️ Key identifier

Key are used to find node by querying their attributes.

| **Key (`queryKey`)** | **Queried Attributes**                   | **Traverse Root** | **Description**                                |
| -------------------- | ---------------------------------------- | ----------------- | ---------------------------------------------- |
| `id`                 | `ViewIdResourceName`                     | Fallback          | Uses `findAccessibilityNodeInfosByViewId`      |
| `text`               | `Text`, `ContentDescription`, `TextSpan` | Fallback          | Uses `findAccessibilityNodeInfosByText`        |
| `class`              | `ClassName` (e.g. `ImageView`)           | Yes               | Matches node class type                        |
| `regex`              | `Text, ContentDesciption`                | Yes               | Applies regex matching instead of exact match  |
| `*Span`              | Span objects (e.g. `URLSpan`, etc.)      | Yes               | Matches specific text spans that contains text |

*Traverse as fallback when not a single text if found.*

## 🛠️ Utility Functions

General helper methods to manage execution flow and access the top-level UI structure.

#### Suspend execution
`wait(long ms)`

```java
// Suspends execution for a specified duration in milliseconds
wait(500); // Wait for half a second
```

#### Access screen root
`getRoot()`

```java
// Gets a snapshot of the current active screen's root UI node
AccessibilityNodeInfo root = getRoot();
```

---
# 🔎Node Finding and Waiting

Methods for locating UI elements within the accessibility tree, either through immediate search, recursive fallback, or by waiting for specific screen events.

#### Wait for specific nodes
`waitNodes(String key, String value, long timeoutMs)`

```java
// Waits until a node matching the selector is found or timeout occurs
ArrayList nodes = waitNodes("text", "Login", 15000);

// Wait for a specific view ID
ArrayList nodes = waitNodes("id", "com.app:id/submit_button", 10000);
```

#### Search from a root node
`findNodes(AccessibilityNodeInfo root, String key, String value)`

```java
// Finds all nodes matching selector ("id", "text", "regex", "focus")
ArrayList buttons = findNodes(getRoot(), "text", "Save");

// Regex search (case-insensitive) across text and content descriptions
ArrayList items = findNodes(getRoot(), "regex", "Item \\d+");
```

#### Multi-step proximity search
`findNodes(AccessibilityNodeInfo root, String key, String value, Object[][] argsConfigs)`

```java
Object[][] args = new Object[][] { { 2, "text", "Status" } };
ArrayList results = findNodes(getRoot(), "id", "my_btn", args);
```

#### Bulk search with ID mapping
`findNodes(AccessibilityNodeInfo root, Object[][] argsConfigs, boolean allFound)`

```java
Object[][] configs = {
    {"loginField", "id", "user_input"},
    {"submitBtn", "text", "Login"}
};
HashMap map = findNodes(getRoot(), configs, true);
```

#### Search for Spanned text
`findSpannedNodes(AccessibilityNodeInfo root, String classname, String pattern)`

```java
ArrayList nodes = findSpannedNodes(getRoot(), "URLSpan", "google.com");
```

#### Get a single node with retry
`getNode(String key, String value, int index, int timeout)`

```java
AccessibilityNodeInfo node = getNode("id", "profile_icon", 0, 10000);
```

#### Get a single node (Default timeout)
`getNode(String key, String value, int index)`

```java
// Find the second item labeled "Message" (index 1) using default wait timeout
AccessibilityNodeInfo node = getNode("text", "Message", 1);
```

#### Retrieve all window nodes
`getAllNodes()`

```java
// Recursively retrieves every accessibility node in the active window
nodes = getAllNodes();
```

---

# ✨ Node Detail and State

Methods for extracting information or checking the functional capabilities of specific UI nodes.

#### Get center coordinates
`getCoordinates(AccessibilityNodeInfo node)`

```java
// Calculates the exact center pixel coordinates of a node
Map center = getCoordinates(node);
tasker.log("Center X: " + center.x + ", Y: " + center.y);
```

#### Check expandable state
`isExpandable(AccessibilityNodeInfo node)`

```java
// Checks if a UI node can be expanded or collapsed
if (isExpandable(settingsGroup)) {
    tasker.log("Group can be expanded.");
}
```

#### Locate scrollable parent/child
`findScrollableNode(AccessibilityNodeInfo node)`

```java
// Searches downwards from the starting node to find the first scrollable container
AccessibilityNodeInfo list = findScrollableNode(getRoot());
```

#### Locate expandable child
`findExpandableChild(AccessibilityNodeInfo node)`

```java
// Searches downwards for the first child node that is currently expandable/collapsible
AccessibilityNodeInfo hiddenDetails = findExpandableChild(sectionHeader);
```

---

## 📍 Nearby and Validation

Methods for verifying the presence of nodes within a specific range or inside data structures like Lists and Maps.

#### Near proximity
`isNearby(AccessibilityNodeInfo sourceNode, int parentLevel, String key, String value)`

```java
// Checks if a node matching the criteria exists within the specified range
if (isNearby(node, 0, "text", "Price")) {
    tasker.log("Price label found nearby.");
}
```

#### Verify absence
`isNotNearby(AccessibilityNodeInfo sourceNode, int parentLevel, String key, String value)`

```java
// Checks if a node matching the criteria does NOT exist within the range
if (isNotNearby(node, 0, "id", "error_icon")) {
    tasker.log("No error icon found nearby.");
}
```

#### Check Presence in List or Map
`hasNode(ArrayList nodes)` or `hasNode(HashMap nodes)`

```java
// Returns true if the collection contains at least one valid node
if (hasNode(resultsList)) {
    click(toNode(resultsList));
}
```

#### Check for specific keys
`hasNode(HashMap nodes, String key)` or `hasNode(HashMap nodes, Object[][] targets)`

```java
// Validates if specific keys exist and contain valid node objects
if (hasNode(dataMap, "submit_btn")) {
    focus(toNode(dataMap, "submit_btn"));
}
```

---

## 🕸️ Node Extraction
Safely retrieves and casts objects to `AccessibilityNodeInfo` from collections with built-in bounds safety.

#### Get node from List
`toNode(ArrayList nodes, int index)`

```java
// Retrieves node at index; supports -1 for the last element
AccessibilityNodeInfo lastNode = toNode(nodes, -1);
AccessibilityNodeInfo firstNode = toNode(nodes); // Defaults to index 0
```

#### Get node from Map
`toNode(HashMap nodes, String key)`

```java
// Retrieves a node by key or extracts the first available node in the map
AccessibilityNodeInfo node = toNode(nodes, "header_icon");
AccessibilityNodeInfo firstAvailable = toNode(nodes);

```

---
## 📄 Get Node Text
Extracts text or metadata from a node.  It prioritizes raw text, then content descriptions, and finally embedded span metadata (like URLs or locales).

#### Smart extraction (Automatic)
`getText(AccessibilityNodeInfo node)`

```java
// Automatically attempts to find the best text representation
// Order: Raw Text -> Content Description -> Text Spans -> Content Spans
String info = getText(node);

```

#### Targeted extraction
`getText(AccessibilityNodeInfo node, String type)`

```java
// Specifically target "text", "contentDescription", or a span type like "URLSpan"
String url = getText(node, "URLSpan");
String raw = getText(node, "text");

```

#### Extract from collections
`getText(ArrayList nodes, int index)` or `getText(HashMap nodes, String key)`

```java
// Extracts text from a node stored within a list or map
String textFromList = getText(nodes, 0);
String textFromMap = getText(nodes, "submit_button");

```

#### Seekbar value extraction
`getText(AccessibilityNodeInfo node)` (Internal logic)

```java
// If the node is a SeekBar, it automatically returns the current progress value
// as defined in the node's RangeInfo.
String progress = getText(seekBarNode);

```

---
## 📐 Node Geometry and Distance
Methods for calculating the spatial position of UI elements and the distance between them on the screen.

#### Get center coordinates
`getCoordinates(AccessibilityNodeInfo node)`

```java
// Calculates the exact center pixel coordinates (x, y) of a node
Map center = getCoordinates(node);
float x = center.x;
float y = center.y;

```

#### Calculate distance between nodes
`getDistance(AccessibilityNodeInfo node1, AccessibilityNodeInfo node2)`

```java
// Calculates the straight-line (Euclidean) distance between two nodes
double distance = getDistance(elementA, elementB);

if (distance < 100) {
    tasker.log("Elements are close to each other.");
}

```


---

# 👆 User Action Functions

## 🖱️ Click / Long Click / Focus / Context Click / Paste / Cut / Copy / Select 

These methods share the same input parameters for interacting with UI elements.
1. click()
2. longClick()
3. focus()
4. contextClick()
5. paste()
6. cut()
7. copy()
8. select()

#### Perform directly on the given node
`click(AccessibilityNodeInfo node)`

```java
AccessibilityNodeInfo node = getNode("text", "OK", 0);
focus(node);
```

#### Perform on the first key / array child
`click(HashMap map)` or `click(ArrayList nodes)`

```java
ArrayList nodes = findNodes("text", "OK");
cut(nodes);
```

#### Target a specific button
`click(String key, String value, int index)`

```java
click("id", "package:id/submit_btn", 2);
```

#### Long click the first matching element
`action(String key, Sring value)`

```java
longClick("text", "Login Button");
```

#### Near another element
`click(String key, String value, int parentLevel, String siblingKey, String siblingValue)`

```java
click("text", "Login Button", 2, "text", "OK");
```

---

## 🖍️ Set Selection

Sets the text selection range or highlights text within a target node or the currently focused input field.

#### Perform directly on the given node
`setSelection(AccessibilityNodeInfo target, int start, int end)`

```java
AccessibilityNodeInfo node = getNode("id", "my_text_field", 0);
setSelection(node, 0, 5); // Selects first 5 characters
```

#### Target by selector
`setSelection(String key, String value, int start, int end)`

```java
setSelection("id", "input_field", 6, 10);
```

#### Target the focused node
`setSelection(int start, int end)`

```java
setSelection(0, -1); // Selects all text in the focused field
```

#### Select all in focused node
`setSelection()`

```java
setSelection(); // Shorthand for (0, -1) on the focused element
```

---

## ↕️ Scroll In Direction

Finds a target node or uses a provided node to scroll its parent container in a specified direction (e.g., "up", "down", "forward", "backward").

#### Perform directly on the given node
`scrollInDirection(AccessibilityNodeInfo node, String direction)`

```java
AccessibilityNodeInfo listNode = getNode("id", "com.android.settings:id/container_list", 0);
scrollInDirection(listNode, "down");
```

#### Target by selector
`scrollInDirection(String key, String value, String direction)`

```java
scrollInDirection("text", "Item 5", "down");
```

---

## 🔄 Scroll Backward / Scroll Forward

Scrolls a scrollable container (like a list or grid) in a specific direction.

#### Scroll the first container found
`scrollBackward()` or `scrollForward()`

```java
// Scrolls the first scrollable element on the screen backward
scrollBackward();

// Scrolls the first scrollable element on the screen forward
scrollForward();
```

#### Target a specific scrollable element
`scrollBackward(String key, String value, int index)` or `scrollForward(String key, String value, int index)`


```java
// Scrolls the vertical list with the specified ID forward
scrollForward("id", "vertical_list", 0);
```

---

## 🤏 Collapse

Finds a specific node and collapses it, or searches its hierarchy for the nearest expandable parent or child to collapse.

#### Collapse with hierarchy search

`collapse(String key, String value, int index, boolean checkparent)`

```java
// Find "Details" and search its parents to find the expandable container to collapse
collapse("text", "Details", 0, true);

// Find the section header and search its children for an expandable element to collapse
collapse("id", "section_header", 0, false);
```

---

Would you like me to format any other expansion or UI state methods?

## 👆 Gesture

Performs complex taps and swipes with multiple strokes. Coordinates can be provided as pixels or screen percentages (0.0 to 1.0).


| Parameter  | Type         | Description                                           |
| ---------- | ------------ | ----------------------------------------------------- |
| `x`        | float/double | X coordinate (0.0–1.0 = %, >1 = pixels)               |
| `y`        | float/double | Y coordinate (0.0–1.0 = %, >1 = pixels)               |
| `action`   | int          | MotionEvent action (`0` = DOWN, `1` = MOVE, `2` = UP) |
| `duration` | long         | Duration in milliseconds for this step                |
*Supports only one stroke.*

#### Custom Paint
`gesture(Object[][] strokes, Paint paint)`

```java
// No animation, requires more points
paint = createPaint(Color.WHITE, 20, 20 );
Object[][] points = new Object[][] {
	{ 0.5, 0.5f, 0,100L } // for 100 ms
	, {700f,500f, 1,300L } // tto 700,500 in 300ms
	, {700f,900f, 2,300L } 
};
gesture(points, paint);
```

#### Invisible
`gesture(Object[][] strokes, Paint paint)`

```java
Object[][] points = new Object[][] {
	{ 0.5, 0.5f, 0,100L }
	, {700f,500f, 1,300L }
	, {700f,900f, 2,300L }
};
gesture(points);
```


---

## 🔘 Tap

Performs a tap or long-press gesture at specified coordinates using pixels or percentages.

#### Custom duration
`tap(float startx, float starty, long duration)`

```java
// Long-press center screen for 500ms and wait for completion
tap(0.5, 0.5, 500);
```

#### Quick tap
`tap(float startx, float starty)`

```java
// Performs a quick tap (50ms) at the coordinates and waits for completion
tap(0.5, 0.5);
```

---

## ↔️ Swipe

Performs a swipe gesture between two points with controlled duration.
#### Standard swipe
`swipe(double startx, double starty, double endx, double endy, long duration)`

```java
// Performs a swipe and waits for the gesture to complete
swipe(0.2, 0.5, 0.8, 0.5, 300);
```

#### Swipe without flick
`swipe(double startx, double starty, double endx, double endy, long duration, boolean stopFlick)`

```java
// Performs a swipe and waits for the gesture to complete
swipe(0.2, 0.5, 0.8, 0.5, 300, true);
```



---

# ⏱️ Misc

## Open App

Launches a specific activity inside an app using the package name and full activity class name. Useful for deep-linking into internal settings screens or hidden activities.

#### Launch app
`OpenApp(String pkg)`

```java
// Open Youtube by label
openApp("Youtube");

// Open Vivaldi by package name
openApp("com.vivaldi.browser");
```

#### Launch specific activity
`openApp(String pkg, String activity)`

```java
// Open Settings main activity
openApp("com.android.settings", "com.android.settings.Settings");

// Open Wi-Fi settings activity
openApp("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity");
```

---
# 🌎 Global Actions & System Navigation

Triggers Android's global accessibility actions. These functions operate at the system level and work across all applications.

#### Back navigation
`back()`

#### Home navigation
`home()`

#### Overview / Recent apps
`recents()` or `tasks()`

#### Notification shade
`notifications()` or `notif()`

#### Quick settings
`qs()` or `quicksettings()`

#### Power menu
`power()` or `powerdialog()`

#### Lock device
`lock()` or `lockscreen()`

#### Capture screenshot
`screenshot()` or `ss()`

#### Dismiss panels
`dismiss()` or `closepanel()`

#### Switch to last app
`lastapp()`

#### App drawer
`drawer()` or `allapps()`

#### Accessibility button
`a11ybutton()` or `accessibilitybutton()`

#### Accessibility shortcut
`shortcut()` or `a11yshortcut()`

---

> [!TIP]
> 
> Wait for Transition: After calling global actions like home() or recents(), it is recommended to add a wait(500) to ensure the system animations have finished before attempting to find nodes on the new screen.




# 🧩 Assist Overlay

Floating helper overlay for inspecting UI and controlling accessibility behavior.

---

#### Create & Remove

```java
a11Y.set();
assist = AssistButton(0.7, 0.2);
````

```java
assist.remove();
```

>[!TIP]
> Store `assist` globally to remove it anytime.

---

####  Controls

##### Handle (Camera Icon)
- **Tap** → Toggle structure overlay (blocks screen)
- **Long Press** → Remove all overlays
- **Double Tap** → Restore hidden boxes
    
##### Accessibility Icon
- **Tap** → Toggle:
    - Accessibility overlay (works over system UI / restricted apps)
    - Normal overlay
- **Long Press** → Toggle:
	- Toggle offset status bar for given overlay
    

---
#### Structure Overlay
Visualizes UI nodes.
#####  Interaction
- **Tap** → Show short info (`text`, `id`, count)  
    Format: `#index key (count)`
- **Long Press** → Detailed dialog (copy/select text)
- **Flick** → Remove overlay (interact behind)
    
##### Highlights

|Color|Meaning|
|---|---|
|PRIMARY_COLOR|Focused node|
|Cyan|Same `id`|
|Magenta|Same `text`|

---

#### Offset Config

Fix overlay misalignment (set after `a11Y.set()`):

```java
a11Y.useA11yOffset = true; // for Accessibility overlay
a11Y.useOffset = true; // for normal overlay
```

>[!WARNING]
>This must be configured manually

---

# 🐞Debug Mode

```java
a11Y.debugMe = true; // Debug mode
a11Y.debugDelay = 300; // Delay for each steps
a11Y.findDelay = 300; // Delay for finding nodes before proceed
a11Y.debugInfo = false; // Disable info toast for generic actions
a11Y.set();
```

#### Debug Colors

|Color|Usage|
|---|---|
|Yellow|find / wait nodes|
|Green|actions (click, long)|
|Red|setText|
_Shows extra toast with node info + invocation line_