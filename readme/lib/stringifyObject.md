# [stringifyObject](/code/lib/stringifyObject.bsh)

Format a two-dimensional object array as a readable bracketed string.

&nbsp;
# Dependencies
None

&nbsp;
# How it works
`stringifyObject(Object[][] matrix)` iterates through each row, writes values separated by commas, represents `null` values as the text `null`, and joins rows with ` , `. A `null` matrix becomes `[]`.

&nbsp;
# How to use
```java
matrix = new Object[][] {
	{"text", "Save"},
	{"id", "button_save"}
};
formatted = stringifyObject(matrix);
```

&nbsp;
## Return Value
Returns a `String`, for example `[ text, Save ] , [ id, button_save ]`.
