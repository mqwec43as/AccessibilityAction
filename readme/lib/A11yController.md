# [A11yController](/code/lib/A11yController.bsh)

Inspect and enable or disable installed Android accessibility services by package, component, or label.

&nbsp;
# Dependencies
1. Android `AccessibilityManager`, `AccessibilityServiceInfo`, `Settings.Secure`, and `PackageManager`
2. [a11Y.java](/code/a11Y.java) for the runtime instance

&nbsp;
# How it works
`A11yController()` creates a scripted object that lists installed services, reads enabled service component names, resolves a query to matching `package/class` components, and updates `Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES`. It exposes `getService`, `getAllServices`, `getEnabledServices`, `enableService`, and `disableService`.

&nbsp;
# How to use
```java
controller = A11yController();
services = controller.getAllServices();
controller.enableService("com.example.accessibility");
controller.disableService("com.example.accessibility/MyService");
```

&nbsp;
## Return Value
Returns a scripted `A11yController` object. Service-list methods return `ArrayList` or `AccessibilityServiceInfo`; enable and disable methods perform updates without returning a value.
