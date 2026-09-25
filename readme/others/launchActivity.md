# [launchActivity](/code/others/launchActivity.bsh)

Launch an Android activity by component name, using a privileged assistant fallback when needed.

&nbsp;
# Dependencies
1. Android `Intent`, `ComponentName`, and `SearchManager`
2. Tasker root, Shizuku, or ADB Wi-Fi shell helpers for the privileged fallback
3. `WRITE_SECURE_SETTINGS` when launching through the assistant-setting method

&nbsp;
# How it works
`launchActivity(String component)` defines helpers for standard and privileged launches, then invokes `launchActivityPrivileged(component)`. The privileged path temporarily sets Android's secure `assistant` component and launches the assistant; if that path is unavailable it falls back to `context.startActivity(...)`. The component string must be in flattened form such as `package.name/.MainActivity`.

&nbsp;
# How to use
```java
launchActivity("com.example.app/.MainActivity");
```

&nbsp;
## Return Value
Returns `void`. Launch failures are logged or ignored by the helper's fallback paths.
