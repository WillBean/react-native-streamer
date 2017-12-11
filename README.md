# react-native-streamer
#### A live framework for react native
Integrated with [KSYStreamer SDK](https://github.com/ksvc/),react-native-streamer is a live streaming framework supporting RTMP,Network Auto Adapt,Beauty Filter,Beauty Voice,Software/Hardware Encoder etc.

#### Android Installation

1. Install `react-native-streamer` latest stable version.
```
yarn add react-native-streamer
```

2. Add the following in `android/settings.gradle`.
```
include ':react-native-streamer'
project(':react-native-streamer').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-streamer/android/app/')
```

3. Update project dependencies in `android/app/build.gradle`.
```
dependencies {
     compile fileTree(dir: "libs", include: ["*.jar"])
     compile "com.android.support:appcompat-v7:23.0.1"
     compile "com.facebook.react:react-native:+"
	 
     compile project(':react-native-streamer')
 }

```

4. Add the package in `MainApplication.java`.
```
    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(), 
          new ReactNativeStreamerPackage() // add this line
      );
    }
```

5. Refresh Gradle project.