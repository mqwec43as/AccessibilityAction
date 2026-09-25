# [UpdateManager](/code/lib/UpdateManager.bsh)

Manage update download and unpack tasks, open URLs, and query remote endpoints from the active script environment.

&nbsp;
# Dependencies
None

&nbsp;
# How it works
`UpdateManager()` creates a scripted helper object that exposes update and download utilities such as `browseUrl(String url)`, `httpGet(String urlString)`, `downloadFile(String url, String destinationPath)`, `unzipFile(File zipFile, String targetFolderPath)`, and `clearDirectory(File dir)`. It is designed for fetching release artifacts and extracting them into the target environment while keeping the Android download flow and filesystem cleanup under one object.

&nbsp;
# How to use

```java
updater = UpdateManager();
updater.browseUrl("https://github.com/mqwec43as/AccessibilityAction/releases/latest");
```

```java
json = updater.httpGet("https://api.github.com/repos/mqwec43as/AccessibilityAction/releases/latest");
```

```java
zipPath = updater.downloadFile(downloadUrl, "/storage/emulated/0/Download/");
```

```java
extractDir = updater.unzipFile(new File(zipPath), "/sdcard/AccessibilityAction");
```

&nbsp;
## Return Value
Returns a scripted `UpdateManager` object. Individual methods return values corresponding to their action: `browseUrl()` and `downloadFile()` initiate work; `httpGet()` returns a string response; `unzipFile()` returns the extracted folder path; and `clearDirectory()` returns `void`.
