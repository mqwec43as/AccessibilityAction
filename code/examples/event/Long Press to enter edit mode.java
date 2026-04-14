a11Y.set();
myEvent() {
	String PackageName = "reddit";


	Source() {
		String ViewIdResourceName = "(com.laurencedawson.reddit_sync:id/root|com.laurencedawson.reddit_sync:id/comment_row_base)";
		String regex = "ViewIdResourceName";
		return this;
	}

	onViewLongClicked(Object event) {
		List text = event.getText();
		if (!text.isEmpty()) {
			String combined = String.join("\n", text );
			textDialog(combined);
		}
	}


	regex = "PackageName";
	return this;
}

myEvent = myEvent();
a11Y.removeEvent("longToCopy");
a11Y.addEvent("longToCopy", myEvent);