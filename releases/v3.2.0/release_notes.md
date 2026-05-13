# **New**

1. Added `tapShizuku` and `gestureShizuku`.
2. Added a new method `waitUntilGone` to wait until specific UI nodes have disappeared.
3. Introduced `PackageManager` object to handle app operations.
4. Added `getClipboard` to retrieve clipboard content.
5. Added `shareText` to share text to target app.
6. Added `muteEvents` and `unmuteEvents` methods in `a11Y` to control events.
7. Added `showAssist` and `removeAssist` methods in `a11Y` to control AssistButton.
8. Send command `a11Y=:=start` when `a11Y.java` is executed.
9. Added duration parameter to `scrollTo`, increased default value to 200ms.

&nbsp;
# **Fixes**

1. Fixed `AssistButton` errors when a11Y is not yet initialized.
2. Fixed visibility issues where the setting and editor would occasionally show up unexpectedly.
3. Fixed filtering logic in `ListDialog`.
