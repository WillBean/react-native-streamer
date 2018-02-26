package com.reactnativestreamer;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.io.IOException;

public class KSYPlayerViewManager extends SimpleViewManager<KSYPlayerView> {
    private static final String REACT_CLASS = "KSYPlayer";

    @Override
    public String getName(){
        return REACT_CLASS;
    }

    @Override
    public KSYPlayerView createViewInstance(ThemedReactContext context){
        KSYPlayerView view = new KSYPlayerView(context);
        KSYPlayerModule.getInstance().setPlayer(view.getPlayerInstance());
        return view;
    }

    /**
     * 必须在 prepareAsync 之前调用
     * 播放SDK提供自动开播的功能，即在调用接口prepareAsync之后会自动开始播放音视频
     * 该功能是默认开启
     * TODO: 如何保证在 prepareAsync 之前调用
     * */
    @ReactProp(name = "shouldAutoPlay")
    public void setShouldAutoPlay(KSYPlayerView view, Boolean state) {
        view.getPlayerInstance().shouldAutoPlay(state);
    }

    /**
     * 设置推流url
     * */
    @ReactProp(name = "url")
    public void setUrl(KSYPlayerView view, String url) {
        try {
            view.getPlayerInstance().setDataSource(url);
            view.getPlayerInstance().prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
