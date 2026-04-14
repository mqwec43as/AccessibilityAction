
# [Click to see release notes](release_notes.md)

&nbsp;
# **TLDR**
This is a long post describing what's been added in the project. 
1. How to use script editor.
2. How to create and manage events.

&nbsp;
# 1. Script Editor

## Building script with script editor

1. Take a snapshot of the tree with the snap icon.
2. Select the box we want to interact to see information first.
	1. Swipe to remove the box to access below nodes.
	2. Double tap on the overlay to restore removed nodes.
3. Long press the box.
4. Select which actions, pattern, and the method variants to use.
5. It will be appended to the script editor.

>[!TIP]
>Only actions methods are listed by default, Set to show all in the setting.

&nbsp;
## Testing the script

There are two ways to test the script after accessing the editor from the **<>** icon.

1. **Run all**
   
	This will execute the entire script. so make sure to go where it needs to be started first.
 2. **Run Lines**
   	
	This will execute the current focused line or selected lines. Useful to test a portion of the script.

&nbsp;
# 2. Events

##  How the event works

I was looking for a way to add an event shorter than what Joao demonstrated before. The logic is stripped from his project, the core concept is very similar.

1. Add an event to with an id.
2. Automatically add a monitor if there isn't any.
3. If match is found the monitor will filter the listener and validate the the entries.


>[!NOTE]
>The project automatically skips event that is not added and remove the montior if there isn't any listener attached.

&nbsp;
## Creating an event

### Example

First see this is example.

```java
a11Y.set();

myEvent() {
	// This will limit the event to certain package name. getPackageName(); net.dinglisch.android.taskerm
	String PackageName = "tasker";


	Source() { // Reference to the node returned by getSource();
		String ViewIdResourceName = "net.dinglisch.android.taskerm:id/button_add_action"; // Matching against
		contains = "ViewIdResourceName";
		return this; // A must 
	}

	onViewClicked(Object event) { // From TYPE_VIEW_CLICKED
		click("Filter");
	}

	onViewLongClicked(Object event) { // From TYPE_VIEW_LONG_CLICKED
		tasker.showToast("Quick Actions");
	}

	 // matching pattern for get and is methods. e.g getPackageName();
	contains = "PackageName";
	return this; // A must
}

myEvent = myEvent();

// Add an event will override existing one.
a11Y.addEvent("myEvent", myEvent); 

// Remove event.
a11Y.removeEvent("myEvent"); 

// Remove all events.
a11Y.removeEvents(); 

```

&nbsp;
### Watching events

We can watch the events by declaring it as functions. The events can be read here.

1. Create a function that return **this**. *It's called scripted object*
2. Use with the following name pattern.  **TYPE_EVENT_STRING** to **onEventString(Object event)**;

Say from **TYPE_VIEW_CLICKED** , it's an event that is reported when clicking a view. 
```
onViewClicked(Object event) { // From TYPE_VIEW_CLICKED
	click("Filter");
}
```

&nbsp;
### Conditions

Add condition by declaring the variable matching from get and is method in the `AccessibilityEvent`.

For example the event has `getPackageName()` and `getText()`. We can declare the condition like this.
```java
String PackageName = "tasker";
String Text = "add";

// Pattern to be used against each methods separated by comma. Optional.
regex = "PackageName";
contains = "Text";
insensitive = "Text,PackageName"

return this;
```

>[!WARNING]
>All variables that starts with uppercase and and "is" will be matched against.

Similar for **Source()**. This matches against the node (AccessibilityNodeInfo) we recently interact. reported by `getSource()`.

The rule are similar. 
