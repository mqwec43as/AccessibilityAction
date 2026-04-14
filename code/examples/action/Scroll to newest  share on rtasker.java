a11Y.waitNodes = false;
a11Y.set();

browseUrl("www.reddit.com/r/tasker", "com.reddit.frontpage");
nodes = waitNodes("text", "r/tasker", 2000);
if (!hasNode(nodes)) return;
node = scrollTo("text", "share]", 20);
click(node);
a11Y.reset();