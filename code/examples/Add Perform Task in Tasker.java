
a11Y.set();

taskName = "UI Actions With Java";
long startTime = System.currentTimeMillis();
addTask(String taskName) {
	click("id", "net.dinglisch.android.taskerm:id/button_add_action");
	setText("text", "Filter", taskName);
	click("Perform Task");
	click("id", "net.dinglisch.android.taskerm:id/checkbox", 1, "Reset");
	click("id", "net.dinglisch.android.taskerm:id/checkbox", 1, "Allow Overwrite");
	click("id", "net.dinglisch.android.taskerm:id/checkbox", 1, "Local Variable Passthrough");
	click("id", "net.dinglisch.android.taskerm:id/continue_on_error_checkbox");
	setText("id", "net.dinglisch.android.taskerm:id/edittext", "Put your script here", 2, "%par1");
	setText("text", "Optional", "Put your script here 2", 2, "text", "%par2");
}

addTask(taskName);

end = System.currentTimeMillis() - startTime;
tasker.showToast(end.toString() + " ms");