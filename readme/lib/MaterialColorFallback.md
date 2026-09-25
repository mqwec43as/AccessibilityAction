# [MaterialColorFallback](/code/lib/MaterialColorFallback.bsh)

Provide fallback Material color values when the platform theme does not expose the required dynamic colors.

&nbsp;
# Dependencies
1. Android `Resources`
2. `Environment` material-color capability flags
3. [ThemeManager](/readme/assist/ThemeManager.md) consumers

&nbsp;
# How it works
`MaterialColorFallback()` creates a scripted color provider with default Material 3 color values and a mapping from names such as `colorPrimary` to Android system accent resources. Its `load()` method attempts to replace mapped values with resources resolved from the current context; fallback values remain available when a resource cannot be resolved.

# How to use

```java
fallback = MaterialColorFallback();
fallback.load();
primary = fallback.color("colorPrimary");
```

## Return Value
Returns a scripted `MaterialColorFallback` object. Color lookup returns an integer color value, while `load()` updates the object and does not return data.
