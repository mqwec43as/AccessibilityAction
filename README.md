
<div align="center">
<h4><b>The codes in this repo were mainly generated with the assistance of AI tools.</b></h4>


&nbsp;
# Accessibility Action
Accessibility related actions and events for android automation app called [Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm&hl=id)

[![Downloads](https://img.shields.io/github/downloads/mqwec43as/AccessibilityAction/total?label=downloads&labelColor=27303D&color=0D1117&logo=github&logoColor=FFFFFF&style=flat)](https://github.com/mqwec43as/AccessibilityAction/releases/latest/download/AccessibilityAction.zip)
[![Latest](https://img.shields.io/github/release/mqwec43as/AccessibilityAction.svg?maxAge=3600&label=latest&labelColor=06599d&color=043b69)](https://github.com/mqwec43as/AccessibilityAction/releases/latest)

_Requires Java Code action available on v6.6_

</div>


&nbsp;
<div align="center">

# Features

</div>

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

<video height ="560" src="https://github.com/user-attachments/assets/d87dbd79-3aab-4c42-a4eb-f2b5e4397771" controls="controls" muted="muted" playsinline="playsinline"></video>


&nbsp;
### 3. Script builder

Create and test UI automation script by choosing through dialogs.

<video height ="560" src="https://github.com/user-attachments/assets/37fbec1e-f809-4241-a570-e2dee39b005a" controls="controls" muted="muted" playsinline="playsinline"></video>

&nbsp;
<div align="center">

# DOCUMENTATION
[Available Methods & Variables](/readme/Documentation.md) | [Examples](/code/examples/)
</div>
&nbsp;
<div align="center">

# FAQ
</div>

1. [What is a11Y?](/readme/What%20is%20a11Y.md)
2. [Why this won't work on some screen?](/readme/Why%20this%20won't%20work%20on%20some%20screen.md)
3. [How to use this wihtout taskernet project?](/readme/Use%20without%20taskernet%20project.md)
