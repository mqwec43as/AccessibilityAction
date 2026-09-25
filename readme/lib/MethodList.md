# [MethodList](/code/lib/MethodList.bsh)

Manage and format a list of method names, including capitalized display labels for UI selection.

&nbsp;
# Dependencies
None

&nbsp;
# How it works
`MethodList(List array)` copies the supplied strings into internal state. `getCapitalized()` returns display labels such as `longClick` -> `Long Click`, while `getOriginal()` returns a copy of the original values. `convertToCapital()` and `convertToOriginal()` mutate the internal list, and `get(int index)` returns one item or `null` for an invalid index.

# How to use

```java
ml = MethodList(methods);
```

```java
caps = ml.getCapitalized();
```

## Return Value
Returns a scripted `MethodList` object. List getters return new lists; conversion methods return `void`.
