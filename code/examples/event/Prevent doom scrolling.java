a11Y.debug = false;
a11Y.set();

/*───────────────────────────────────────────────────────────────
  redditDoomScroll()
  **Simplified Session Monitor**
  
  Logic:
  - Tracks scrolls/clicks for the specific package.
  - After 'limit' actions, kicks to home and starts a 'cooldown'.
  - Blocks app usage until cooldown expires.
  ───────────────────────────────────────────────────────────────*/
redditDoomScroll() {
	String PackageName = "reddit";
	int scrollCount = 0;
	int limit = 50;
	
	/* Event Hooks */
	onViewScrolled(Object event) {
		process();
	}
	onViewClicked(Object event) {
		process();
	}
	onWindowStateChanged(Object event) {
		check();
	}
	
	/* COOLDOWN CONFIGURATION (In Seconds) */
	long cooldownSeconds = 60*60*1;
	long cooldownMs = cooldownSeconds * 1000;
	long lastBlockTime = 0;
	int attemptCount = 0;
	long lastToast = 0;

	check() {
		long currentTime = System.currentTimeMillis();
		/* 1. Check if currently in cooldown */
		if (currentTime < (lastBlockTime + cooldownMs)) {
			long remaining = (lastBlockTime + cooldownMs - currentTime) / 1000;
			if (!this.caller.namespace.getName().equals("process") && lastToast + 1000 < currentTime) {
				attemptCount++;
				tasker.showToast("Reddit is locked! " + remaining + "s left.", "Attemps: " + attemptCount);
				lastToast = currentTime;
			}
			home();
			return false;
		}

		return true;
	}

	/* Core logic for both Click and Scroll events */
	process() {
		if (!check()) return;
		/* 2. Increment action count */
		scrollCount++;

		/* 3. Check threshold */
		if (scrollCount >= limit) {
			tasker.showToast("Limit reached! Locked for " + cooldownSeconds + "s.");
			lastBlockTime = System.currentTimeMillis();
			home();
			scrollCount = 0;
			attemptCount = 0;
		}
	}

	regex = "PackageName";

	return this;
}


redditMonitor = redditDoomScroll();
a11Y.removeEvent("redditMonitor");
a11Y.addEvent("redditMonitor", redditMonitor);