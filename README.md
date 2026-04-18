### Accessibility Action Project for android automation app called [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=id)

The codes here need to be ran via Java Code action, which is available only on v6.6 upwards.

>[!WARNING]
>The codes in this repo were mainly generated with the assistance using AI tools.


# What does this project do?


### 1. Syntax based UI automation actions

Use text to build our automation, like AutoHotkey or AutoInput Action V2

**Open Youtube subscription**
```java
openApp("Youtube");
click("Subscription");
```

**React on click.**
```java
a11Y.set();
myEvent() {
	String PackageName = "net.dinglisch.android.taskerm";
	
	Source() {
		String ViewIdResourceName = "net.dinglisch.android.taskerm:id/button_add_action";
		return this;
	}

	onViewClicked(Object event) {
		click("Filter");
	}

	return this;
}

String myEvent = myEvent();
String eventName = "Tasker add action";
a11Y.addEvent(eventName, myEvent);
```

&nbsp;
### 2. Debug highlighter & UI inspector

Highlight certain actions and maps the entire UI.
<video width ="320" src="https://github.com/user-attachments/assets/d87dbd79-3aab-4c42-a4eb-f2b5e4397771" controls="controls" muted="muted" playsinline="playsinline"></video>


&nbsp;
### 3. Script builder
Create and test UI automation script by choosing through dialogs.

<video width ="320" src="https://github.com/user-attachments/assets/37fbec1e-f809-4241-a570-e2dee39b005a" controls="controls" muted="muted" playsinline="playsinline"></video>

