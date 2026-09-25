# [validate](/code/lib/validate.bsh)

Match a scripted criteria object against properties or getter methods on another object.

&nbsp;
# Dependencies
1. BeanShell `This` namespaces
2. Java reflection for getter and `is...` method lookup
3. Java regex `Pattern` for regex criteria

&nbsp;
# How it works
`validate(This criteria, Object object)` examines criteria variables whose names begin with an uppercase letter or use an `isX` form, then invokes the corresponding `getX()` or `isX()` method on `object`. Values are compared exactly by default. Names listed in `criteria.regex`, `criteria.contains`, or `criteria.insensitive` switch the matching behavior. An optional `condition(Object)` callback can apply an additional final test.

# How to use

```java
criteria.Text = "Settings";
criteria.insensitive = "Text";
criteria.condition = function(Object value) {
	return value != null;
};
matches = validate(criteria, accessibilityEvent);
```

## Return Value
Returns `true` when every configured criterion and optional condition matches; otherwise returns `false`.
