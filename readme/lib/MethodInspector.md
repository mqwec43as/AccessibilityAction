# [MethodInspector](/code/lib/MethodInspector.bsh)

Inspect imported methods, parameter declarations, and action metadata for the current BeanShell runtime.

&nbsp;
# Dependencies
1. [ThisManager](/readme/lib/ThisManager.md)
2. BeanShell `This`, `NameSpace`, and `BshMethod`
3. The loaded command folders under `/code`

&nbsp;
# How it works
`MethodInspector(This THIS)` builds metadata maps for discovered methods and their overloads. It groups methods by source directory, records parameter names and declarations, tracks necessary, nearby, and advanced parameters, and exposes filtering helpers such as `removeIgnore()`, `ignoreDefault()`, and available-method queries. The a11Y runtime stores an instance in `a11Y.inspector` after initialization.

# How to use

```java
inspector = MethodInspector(this);
inspector.read();
inspector.removeIgnore();
```

## Return Value
Returns a scripted `MethodInspector` object containing the discovered method and parameter metadata.
