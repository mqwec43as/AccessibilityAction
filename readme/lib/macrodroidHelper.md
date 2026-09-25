# [macrodroidHelper](/code/lib/macrodroidHelper.bsh)

Provide the Tasker-like runtime bridge used when the project runs inside MacroDroid.

&nbsp;
# Dependencies
1. MacroDroid `AppContext`, `ActivityHelper`, and accessibility helpers
2. MacroDroid `globals` storage
3. Android `Context`, `Activity`, `Uri`, and file APIs

&nbsp;
# How it works
`macrodroidHelper()` returns a scripted compatibility object. Its `set()` method injects `tasker` and `context` into the caller namespace. It also supplies MacroDroid-backed methods such as `getContext()`, `getAccessibilityService()`, Java-variable access, `doWithActivity(...)`, and `writeFile(...)`. Some Tasker-only operations are stubs in this compatibility layer.

&nbsp;
# How to use
```java
helper = macrodroidHelper();
helper.set();
context = helper.getContext();
success = helper.writeFile("ready", "/sdcard/a11y/status.log");
```

&nbsp;
## Return Value
Returns a scripted MacroDroid helper object. `getContext()` and storage methods return their corresponding objects or booleans; `writeFile()` returns `true` on success and `false` on failure.
