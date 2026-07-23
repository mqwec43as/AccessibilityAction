
<div align="center">
<h4><b>The codes in this repo were mainly generated with the assistance of AI tools.</b></h4>


&nbsp;
# Accessibility Action
Text based UI automation for android automation apps **[Tasker](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm)** and **[Macrodroid](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid)**

[![Downloads](https://img.shields.io/github/downloads/mqwec43as/AccessibilityAction/total?label=downloads&labelColor=27303D&color=0D1117&logo=github&logoColor=FFFFFF&&style=for-the-badge)](https://github.com/mqwec43as/AccessibilityAction/releases/latest/download/AccessibilityAction.zip)
[![Stable](https://img.shields.io/github/v/release/mqwec43as/AccessibilityAction?sort=date&display_name=tag&style=for-the-badge&label=stable
)](https://github.com/mqwec43as/AccessibilityAction/releases/latest)
[![Beta](https://img.shields.io/github/v/release/mqwec43as/AccessibilityAction?include_prereleases&sort=semver&display_name=tag&style=for-the-badge&label=beta
)](https://github.com/mqwec43as/AccessibilityAction/releases)
</div>


&nbsp;
<div align="center">

# Features

</div>

### Summary

| No | Features | Tasker | Macrodroid |
| --- | --- | --- | --- |
| 1 | [Text based UI automation](#1-text-based-ui-automation) | :heavy_check_mark: `v6.6` | :heavy_check_mark: `v5.65.2` |
| 2 | [Debug highlighter](#2-debug-highlighter) | :heavy_check_mark: `v6.6`  | :heavy_check_mark: `v5.65.2` |
| 3 | [Script builder](#3-script-builder) | :heavy_check_mark: `v6.7` | :x:  |

&nbsp;

### 1. Text based UI automation
[![Tasker](https://img.shields.io/badge/Tasker-v6.6-ffdbcc?style=for-the-badge&labelColor=e65100)](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm) [![Macrodroid](https://img.shields.io/badge/Macrodroid-v5.65.2-d6e3ff?style=for-the-badge&labelColor=003066)](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid)

Use text to build our automation, like AutoHotkey or AutoInput Action V2

**Open Youtube today feed**
```java
openApp("Youtube");
click("Subscription");
click("Today");
```

**Open reddit on secondary display and scroll to r/tasker**
```java
setDisplay(21); // or setDisplay("scrcpy");
openApp("Reddit");
node = scrollTo("r/tasker");
click(node);
```

&nbsp;
>[!IMPORTANT] 
> Limited to Tasker. Macrodroid v5.65.2 doesn't suppport intercepting events in Java code.

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

### 2. Debug highlighter
[![Tasker](https://img.shields.io/badge/Tasker-v6.6-ffdbcc?style=for-the-badge&labelColor=e65100)](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm) [![Macrodroid](https://img.shields.io/badge/Macrodroid-v5.65.2-d6e3ff?style=for-the-badge&labelColor=003066)](https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid)

Highlight actions and display brief information toast.

<video height ="480" src="https://github.com/user-attachments/assets/d87dbd79-3aab-4c42-a4eb-f2b5e4397771" controls="controls" muted="muted" playsinline="playsinline"></video>


&nbsp;
### 3. Script builder
[![Tasker](https://img.shields.io/badge/Tasker-v6.7-ffdbcc?style=for-the-badge&labelColor=e65100)](https://play.google.com/store/apps/details?id=net.dinglisch.android.taskerm)

Create and test UI automation script by choosing through dialogs.

<video height ="480" src="https://github.com/user-attachments/assets/37fbec1e-f809-4241-a570-e2dee39b005a" controls="controls" muted="muted" playsinline="playsinline"></video>


> [!IMPORTANT] 
> This feature use material library available only on Tasker v6.7

> [!NOTE] 
> Macrodroid can't use material library due to missing compatible theme Theme.Material3

&nbsp;
<div align="center">

# [DOCUMENTATION](/readme/Documentation.md)
[Read here](/readme/Documentation.md) | [Examples](/code/examples/)
</div>
&nbsp;
<div align="center">

# FAQ
</div>

1. [What is a11Y?](/readme/What%20is%20a11Y.md)
2. [Why this won't work on some screen?](/readme/Why%20this%20won't%20work%20on%20some%20screen.md)
3. [How to use this wihtout taskernet project?](/readme/Use%20without%20taskernet%20project.md)
