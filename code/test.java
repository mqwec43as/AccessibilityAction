
/* Get the parent directory of the current script file in a single line. */
MAIN_DIRECTORY = new File(getSourceFileInfo()).getParentFile().getAbsolutePath();
source(MAIN_DIRECTORY + "/import.java");
// a11Y.set();
root = getRoot();

return findNodes(root, "regex", """map[\s\S]+net.ding""");
