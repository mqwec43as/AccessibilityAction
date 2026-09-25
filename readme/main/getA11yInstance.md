# [getA11yInstance](/code/main/getA11yInstance.bsh)

Retrieve the current global `a11Y` scripted object.

&nbsp;
# Dependencies
1. [a11Y.java](/code/a11Y.java)
2. Tasker Java-variable storage through `tasker.getJavaVariable(...)`

&nbsp;
# How it works
The helper first checks the BeanShell `a11Y` variable and uses it when it exists and is not `null`. Otherwise it retrieves the Java variable named `a11Y` from Tasker. This allows initialization code to reuse an existing runtime instance instead of creating a second one.

&nbsp;
# How to use
```java
a11y = getA11yInstance();
if (a11y != null) {
	a11y.clean();
}
```

&nbsp;
## Return Value
Returns the current `a11Y` scripted object, or `null` when no global instance is available.
