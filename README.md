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

#### IOS Installation

1. Install `react-native-streamer` latest stable version.
```
yarn add react-native-streamer
```

2. In Xcode, in Project Navigator (left pane), right-click on the `Libraries` > `Add files to [project name]`. Add `./node_modules/react-native-navigation/ios/ReactNativeNavigation.xcodeproj`

3. In Xcode, in Project Navigator (left pane), click on your project (top), then click on your target row (on the "project and targets list", which is on the left column of the right pane) and select the `Build Phases` tab (right pane). In the `Link Binary With Libraries` section add `libReactNativeStreamer.a`

4. In Xcode, in Project Navigator (left pane), click on your project (top), then click on your project row (on the "project and targets list") and select the `Build Settings` tab (right pane). In the `Header Search Paths` section add `$(SRCROOT)/../node_modules/react-native-streamer/ios`. Make sure on the right to mark this new path `recursive`

5. Download [KSYSDK](https://github.com/WillBean/react-native-streamer/releases/download/0.1/KSYSDK.zip) in `release`

6. In Xcode, in Project Navigator (left pane), click on `ReactNativeNavigation.xcodeproj`, then click on your project row (on the "project and targets list") and select the `Build Phases` tab (right pane). In the `Link Binary With Libraries` section add `GPUImage.framework` and `libksygpulive.framework`

7. In Xcode, in Project Navigator (left pane), click on your project (top), then click on your target row (on the "project and targets list", which is on the left column of the right pane) and select the `Build Phases` tab (right pane). In the `Embed Frameworks` section add `GPUImage.framework` and `libksygpulive.framework`

8. Run you project
