
# [Click to see release notes](release_notes.md)

&nbsp;
# **TLDR**
This is a long post describing what's been added in the project recently. 
1. How to use Assist Overlay
2. How to configure offset to workaround bug
3. How to use debug mode.

&nbsp;
# **Assist Overlay**

### **Create overlay**
The overlay can be created like this.

```java
// If a11Y is set propler during Tasker start.
a11Y.set();
assist = AssistButton(0.7,0.2);
```

&nbsp;
### **Assist overlay**
The overlay will serve as a helper.

#### Handle (Camera Icon)
1. Tap
	1. Display UI structure overlay and block the entire screen.
	2. Tap it back to clear the structures.
2. Long Press
	1. Destroy every overlays.
3. Double Tap
	1. Restore hidden boxes.

&nbsp;
#### Accessibility Icon
1. Tap
	1. Switch between using accessibility or application overlay.
	2. Accessibility overlay will shows up over system components or certain apps that blocks normal overlay. 
2. Long Press
	1. Toggle status bar offset for given overlay type.

The overlay can be destroyed like this. 
```
assist = AssistButton(0.7,0.2);
assist.remove();
```

Store assist to global java variable, so it can be removed from anywhere.

&nbsp;
### **Structure overlay**

Structure overlay will be a visual representation for the UI.
1. Tap, Show info toast.
	1. Display a short information about the node. text, id, and similar nodes counts.
		1. The similar format is `#index key (similar counts)`
		2. It's only text and id.
	2. Highlight similar nodes.
		1. Cyan will highlight nodes with the same id.
		2. Magenta will highlight nodes containing the text.
2. Long Press, Information dialog.
	1. Display a dialog with more information. 
	2. We can copy the information and select the text if any.
3. Flick, Remove hints.
	1. Flick will remove the view so we can click on behind it.

There are three highlights for similar nodes.
1. PRIMARY_COLOR, for focus node. Recently tapped node.
2. CYAN, nodes which contain focused node's text.
3. MAGENTA, nodes with the same id as focused node.

&nbsp;
### Important Status bar offset

The same code behaves differently across many OS, causing the overlay to be off place. Tested on HyperOS3 (Android 16) and CRDroid (Android 15).

This needs to be configured manually.

After a11Y initiates, set both like this. Set it inside **Initiate a11Y Variable** task
```java
//Default value
a11Y.useA11yOffset = true; // for Accessibility overlay
a11Y.useOffset = true; // for normal overlay
```

&nbsp;
# **Debug Mode**

Debug mode is more of like step highlighter. It will slow down the execution based on the configuration then highlights what's the project sees and does.

There are three highlight color as of now.
1. Yellow, highlight nodes matching the pattern used.
2. Green, generic actions like click, long.
3. Red, for setting text with setText.

Supported functions.
1. findNodes.
2. click.
3. longClick.
4. setText.

&nbsp;
#### Configuration variables

```
a11Y.debugMe = false; // Debug mode
a11Y.debugInfo = true; // Show info toast for generic actions
a11Y.findDelay = 100; // Delay for finding nodes before proceed
a11Y.debugDelay = 1000; // Delay for each steps
a11Y.set();

// Script

a11Y.reset(); // reset those 4 configured variables to default
```

Additional toast will be shown as well for generic actions similar to structure overlays + invocation line.

&nbsp;
# **Creating gesture & trail**

```
a11Y.set();

import android.graphics.Color;
paint = createPaint(Color.GREEN, 20,20f);
Object[][] points = new Object[][] {
	{ 0.5, 0.5, 0,100L }, { 700, 500, 1,300L }, { 700, 900, 2,300L }
};
gesture(points, paint);

// Without trail
gesture(points);
```


**The visual trail is not the perfect representation of the actual gesture performed.**  It will match the amount of points that is passed to it and drawn after it's performed.

It will look snappy if there are only a few of them. 







