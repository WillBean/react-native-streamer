package com.reactnativestreamer;

import android.app.Activity;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReactNativeStreamerPackage implements ReactPackage {

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new KSYStreamerViewManager()
        );
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        modules.add(new KSYStreamerModule(reactContext));
        modules.add(new ImgTexFilterModule(reactContext));
        modules.add(new KSYStreamerConstantsModule(reactContext));
        modules.add(new KSYAudioFilterConstantsModule(reactContext));

        return modules;
    }
}