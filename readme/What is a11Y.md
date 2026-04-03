
# a11Y

a11Y is global java variable set by [a11Y.java](/code/a11Y.java) and avaiable accross any Java Code action once it's initiated at first.

It has variables and methods that is needed for running the codes easily.

## 1. Usage Comparison
### without a11Y
```java
// use import.java
source("full import path");
click("Add");

// or include everything inside import.java

addClassPath("/storage/emulated/0/Folder");
importCommands("main"); // Must
importCommands("actions");
click("Add");

// or include every codes and its dependencies / other codes it uses

getRoot() {}
findNodes(String text) {
    //
}
openApp(String appName) {
    //
}
click(String key, String value) {
    //
}

click("text", "Add");

```

Must be done on every Java Code action in case we want to reuse them.


### with a11Y

```java
a11Y.set();
click("Add");
```


&nbsp;

## 2. Variables


### 2.1 Enviroment

| Variable | Type | Description | Default Value |
| :--- | :--- | :--- | :--- |
| `assistOverlays` | `List` | Store recently displayed views from `StructureOverlay`, `NodeBox`, `InfoToast`, and `InfoDialog`. | `new ArrayList()` |
| `importPath` | `String` | The full path location of `import.java`. (e.g., `"/storage/emulated/0/Folder/import.java"`) | `null` |
| `ENV` | `String` | The full path location of AccessibilityAction. (e.g., `"/storage/emulated/0/Folder"`) | `null` |

### 2.2 Debugging

| Variable | Type | Description | Default Value |
| :--- | :--- | :--- | :--- |
| `debugMe` | `boolean` | Control debug mode. | `false` |
| `debugSteps` | `boolean` | Activate debug steps mode. (Not yet implemented in V3). | `false` |
| `debugInfo` | `boolean` | Show information toast about interacted node. | `true` |
| `findDelay` | `long` | Duration for how long found nodes are highlighted. | `100` |
| `debugDelay` | `long` | Duration for how long generic actions are highlighted. | `1000` |
| `assistButton` | `bsh.This` | Assist button instances if any are shown. | `null` |
| `useOffset` | `boolean` | Use status bar offset to show structure overlay for `TYPE_APPLICATION_OVERLAY`. | `true` |
| `useA11yOffset` | `boolean` | Use status bar offset to show structure overlay for `TYPE_ACCESSIBILITY_OVERLAY`. | `true` |

   
## 3. Methods / Functions

1. `set()`
    Set all the variables above and run [import.java](/code/import.java).

    if `ENV` is null, it will try to use the super import file called **mainImport.java** stored in Tasker Global Variable %ImportJava

    *mainImport.java is only included in the taskernet project.*

    Otherwise ENV need to be set with [setENV](#func-setEnv)
2. `setEnv(String path)`
   <a name="func-setEnv"></a>
   
   Set enviroment file path. Must be set after `a11Y` is available and set with [a11Y.java](/code/a11Y.java)
3. `resetEnv()`

    Set enviroment to null and will fallback to use %ImportJava variable and super import file.
4. `reset()`

    Will set the following debugging variables to default value.
    ```
    debugSteps = false;
	debugMe = false;
	debugInfo = true;
	findDelay = 100;
	debugDelay = 1000;
    ```
5. `addOverlay(This overlay)`
    <a name="func-addOverlay"></a>

    Add [StructureOverlay](/code/assist/StructureOverlay.bsh), [NodeBox](/code/assist/NodeBox.bsh), [InfoToast](/code/assist/InfoToast.bsh), [InfoDialog](/code/assist/InfoDialog.bsh) to existing overlays.

6. `removeOverlay(This overlay)`

   Remove any stored overalys added with [addOverlay()](#func-addOverlay). Those 4 classes before will try to automatically run this if removed.
    
7. `clean()`

    Clean up any displayed overlays.

&nbsp;
   
# 4. Dependency & Dependant

a11Y has dependency on [import.java](/code/import.java) to set up all methods.

 [StructureOverlay](/code/assist/StructureOverlay.bsh), [NodeBox](/code/assist/NodeBox.bsh), [InfoToast](/code/assist/InfoToast.bsh), [InfoDialog](/code/assist/InfoDialog.bsh) is dependant on a11Y.

 The dependants are mostly for debugging purpose.
 
 Any methods stored in [/actions](/code/actions/), [/main](/code/main/), [/others](/code/others/), and [/gestures](/code/gestures/) are not.
    