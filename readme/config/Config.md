# [Config](/code/config/Config.bsh)

Load, save, and synchronize configuration presets and runtime settings from a file.

&nbsp;
# Dependencies
None

&nbsp;
# How it works
`Config` loads a BeanShell config file, keeps a preset list of managed keys, and can copy values between namespaces. It is used to persist runtime options such as debug delay, wait timeouts, and assist behavior.

# How to use

```java
config = Config("/sdcard/a11y/config.bsh");
config.load();
```

```java
config.save();
```

```java
config.setTo(a11Y);
```

## Return Value
Returns the configured `Config` object.
