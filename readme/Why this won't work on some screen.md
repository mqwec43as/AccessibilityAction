# Why

The reason why this project won't work on certain view is because of the view is flagged with `accessibilityDataSensitive` . This prevents any app that is not accessibility tool from reading the screen.


This line in [AccessibilityInteractionController.java](https://android.googlesource.com/platform/frameworks/base/+/refs/heads/main/core/java/android/view/AccessibilityInteractionController.java?autodive=0%2F%2F%2F%2F%2F%2F%2F%2F#:~:text=isVisibleToAccessibilityService(foundView)) will determine if the service can read the view or not.
```java
    private boolean isVisibleToAccessibilityService(View view) {
        return view != null && (mA11yManager.isRequestFromAccessibilityTool()
                || !view.isAccessibilityDataSensitive());
    }
```

&nbsp;

Several views and apps that are flagged as such:
1. Bitwarden
2. Several section in App Info, like Permissions.


&nbsp;
# How to solve

Tasker direct purchase version has to be declared as Accessibility Tool `isAccessibilityTool=true` in the manifest.

As seen the snippet above, the view is only visible if the service is Accessibility Tool or the view is not flagged with `accessibilityDataSensitive`.

>[!NOTE]
>One of the other benefit is that Tasker's accessibility service will also work when [Android Advanced Protection Mode](https://developer.android.com/privacy-and-security/advanced-protection-mode) is turned on on Android 17.

&nbsp;
# Why direct purchase?

According to [Use of the AccessibilityService API](https://support.google.com/googleplay/android-developer/answer/10964491?hl=en), Tasker is not eligible as accessibility tool and can't be published as such in the store.

Tasker's main purpose is not to assist people with dissabilities. It's also explicitly stated that automation apps are not accessibility tools. 

>Other examples of apps that are not accessibility tools are: antivirus software, automation tools, assistants, monitoring apps, cleaners, password managers, and launchers.

