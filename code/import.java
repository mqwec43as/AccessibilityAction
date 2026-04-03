addClassPath(".");
MAIN_DIRECTORY = new File(getSourceFileInfo()).getParentFile().getAbsolutePath();
long stepDelay = 50; // ms between node retries
long waitNodesTimeout = 5000; // max wait for node existence
boolean waitNodes = true; // keep waiting until node appears
String LOG_FILE = MAIN_DIRECTORY + "/log.txt";
long LONG_CLICK_DURATION = 500;
cd(MAIN_DIRECTORY);
addClassPath(".");
importCommands("main");
importCommands("gestures");
importCommands("actions");
importCommands("others");
importCommands("assist");
source("others/globalAction.java");
String RUNNING_ENV = CHECK_ENV();
if (debugMe  == void) debugMe = false;
if (debugDelay  == void) debugDelay = 1000;
if (findDelay  == void) findDelay = 100;
if (debugSteps  == void) debugSteps = false;
if (debugInfo  == void) debugInfo = false;
if (useOffset  == void) useOffset = true;
if (useA11yOffset  == void) useA11yOffset = false;
