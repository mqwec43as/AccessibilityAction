# [runMe](/code/lib/runMe.bsh)

Run a `Runnable` asynchronously on an RxJava computation thread.

&nbsp;
# Dependencies
1. RxJava `Completable`
2. RxJava `Schedulers.computation()`
3. [log](/readme/lib/log.md) for errors raised by surrounding runtime code

&nbsp;
# How it works
`runMe(Runnable bgAction)` wraps the runnable in `Completable.fromRunnable(...)`, schedules it on `Schedulers.computation()`, and subscribes immediately. It is fire-and-forget and does not block the calling BeanShell script.

# How to use

```java
runMe(new Runnable() {
	run() {
		result = httpGet(url);
	}
});
```

## Return Value
Returns `void`; the runnable executes asynchronously.
