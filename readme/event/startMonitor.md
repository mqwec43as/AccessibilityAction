# [startMonitor](/code/event/startMonitor.bsh)

Start the RxJava accessibility-event monitor that dispatches registered `a11E` listeners.

&nbsp;
# Dependencies
1. [a11E](/readme/event/a11E.md)
2. [validate](/readme/lib/validate.md)
3. `tasker.getAccessibilityEvents()`
4. RxJava `Observable`, `Disposable`, and scheduler APIs
5. [getService](/readme/main/getService.md)

&nbsp;
# How it works
`startMonitor()` retrieves the global `a11E` object and exits if its monitor subscription is already active. It subscribes to Tasker’s accessibility-event stream, moves processing onto the manager executor, ignores muted or unregistered event types, filters listeners by package, validates listener fields and optional `Source()` criteria, and invokes matching `on<EventName>(AccessibilityEvent)` methods asynchronously.

The monitor keeps a bounded event history, recycles processed accessibility events, and stores the RxJava `Disposable` on `a11E` so the subscription can be stopped by the manager.

&nbsp;
# How to use

The normal initialization path starts the monitor through the event manager:

```java
a11Y.set();
a11Y.addEvent("taskerClick", listener);
```

To start the stream directly after `a11E` has been initialized:

```java
startMonitor();
```

Listeners must expose event methods such as `onViewClicked(Object event)` and can provide `PackageName`, `regex`, `contains`, `insensitive`, or `Source()` criteria.

&nbsp;
## Return Value
Returns `void`. The monitor runs asynchronously; if the event stream or global `a11E` object is unavailable, it logs the failure or raises the corresponding initialization error.
