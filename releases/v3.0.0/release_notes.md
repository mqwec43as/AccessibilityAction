# **New**
1. Assist Overlay, overlay to help inspecting the current UI. 
2. Continuous gesture, now gesture supports multiple points and trail as an option.
3. Global Java Variable, adds global java variable called **a11Y** to initiate the project easily.
4. Debug mode, highlight nodes and add delay each steps for limited functions. **BUGGY**.

# **Fix**
1. Fix not finding id that couldn't be found with **findAccessibilityNodeInfosByViewId** by traversing the entire root tree.

# **Bug**
1. Assist Overlay will crash on certain apps that blocks accessibility service, e.g Bitwarden.
2. UI Structure overlays not getting cleared. **WE MAY NOT BE ABLE TO TOUCH THE SCREEN.**
	1. Several safety measurement.
		1. Turn off the screen.
		2. Long press the Assist Overlay.
		3. Run a11Y.clean() via Java code. 
3. UI structure is misaligned due to status bar offset.
4. Debug mode not showing correct line due to various functions calling its overloads.
5. Many others.

&nbsp;
# **Demo**
[Catbox](https://files.catbox.moe/1akbc1.mp4)
[Github](releases/a11y.3.0.0/demo.mp4)


What's in the video.
1. Adding a perform task in debug mode.
2. Continuous gesture on Circle To Search, uses MICTS.
3. Showcase assist overlay on Tasker and Quick Tiles.
