
# Clipboard

### getClipboard returns null when phone is locked.
It's the limitation for both Shizuku or overlay method. 

The API uses to get clipboard `Clipboard.getPrimaryClip` checks whether the phone is locked or not.

Link:

1. https://github.com/termux/termux-api/issues/452#issuecomment-2004955852
2. https://cs.android.com/android/_/android/platform/frameworks/base/+/93d77b07c34077b6c403c459b7bb75933446a502


&nbsp;
# Overlay

### The background color is transparent.

It's a security feature since Android 12. https://developer.android.com/about/versions/12/behavior-changes-all#untrusted-touch-events-exceptions

To work around it run the following adb command.

```bash
adb shell settings put global maximum_obscuring_opacity_for_touch 1
```

&nbsp;

# Update

### Is it safe to upgrade from another version?

Generally yes. 

However just to be safe, please re-import and choose a different folder.

If it breaks something, change the task variable **`accessibility_path`** in **`📦 Initiate a11Y Variable`** task to previous folder.

Make sure to restart Tasker after downloading the files.

&nbsp;

