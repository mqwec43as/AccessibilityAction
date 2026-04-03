

# 1. Using a11Y

By default the project runs [a11Y.java](/code/a11Y.java) on each Tasker's monitor start. So as long as this script is executed, the rest of the methods can be used.

Separate the profile and the task that initates a11Y variables and delete the project. That's all we need to use the codes.

&nbsp;

# 2. Evaluating import.java

a11Y.set() executes [import.java](/code/import.java), so we can always execute it ourselves. 

The most easiest one is using [`source(String path)`](https://beanshell.org/manual/bshmanual.html#source()), it's a built-in function from the interpreter Tasker uses that evaluates a script file. It's also what a11Y.set() uses.

```
source(folder + "/import.java");
```

&nbsp;

# 3. Copying & disecting the code

You need to take of the variables and dependencies which requires you  to inspect the codes yourself.

IIRC, the only methods that doesn't have dependency are.
1. [/others/openApp.bsh](/code/others/openApp.bsh)
2. [/others/browseUrl](/code/others/browseUrl.bsh)
3. [/gestures/gesture](/code/gestures/gesture.bsh)


All methods in [/actions](/code/actions/), has dependency on methods in [/main](/code/main/). [/main](/code/main/) methods are used to find the right key pattern for those actions. 

1. [getNode](/code/main/getNode.bsh) has dependency on [waitNodes](/code/main/waitNodes.bsh) on [findNodes](/code/main/findNodes.bsh);
2. They also have dependency on other methods like [foundNearby](/code/main/findNodesNearby.bsh) etc to determine if nodes are nearby etc.
3. The debugging objects are also heavily reliant on each other as well a11Y.java.

Unfornutately, not much I can help further.

The codes are written & generated this way so I can re-use them easily myself with a11Y.set();

I made it available here so everyone can read them easily without importing my project.


