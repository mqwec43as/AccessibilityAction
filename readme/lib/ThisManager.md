# [ThisManager](/code/lib/ThisManager.bsh)

Inspect BeanShell `This` objects and expose metadata about variables and methods.

&nbsp;
# Dependencies
1. BeanShell `This`, `NameSpace`, and `BshMethod`
2. Java collection and regex utilities

&nbsp;
# How it works
`ThisManager(This THIS)` inspects the supplied scripted object and its namespace hierarchy. It exposes namespace metadata, top invocation information, method maps, declarations, variable names, method names, and conversion helpers for making BeanShell arrays easier to consume from Tasker UI code.

# How to use

```java
manager = ThisManager(myObject);
hierarchy = manager.getHierarchy();
methods = manager.getMethodsMap();
```

```java
manager.toArray(objs);
```

## Return Value
Returns a scripted `ThisManager` object. Query methods return lists, maps, strings, or namespace metadata depending on the method.
