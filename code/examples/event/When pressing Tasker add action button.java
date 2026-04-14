a11Y.set();
myEvent() {
	String PackageName = "tasker";


	Source() {
		String ViewIdResourceName = "net.dinglisch.android.taskerm:id/button_add_action";
		return this;
	}

	onViewClicked(Object event) {
		click("Filter");
	}

	onViewLongClicked(Object event) {
		tasker.showToast("Quick Actions");
	}


	regex = "PackageName";
	return this;
}

myEvent = myEvent();
a11Y.removeEvent("myEvent");
a11Y.addEvent("myEvent", myEvent);