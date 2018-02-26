package com.reactnativestreamer;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.ksyun.media.player.KSYMediaPlayer;

import java.util.HashMap;
import java.util.Map;

public class KSYPlayerModule extends ReactContextBaseJavaModule {
    private static KSYPlayerModule single = null;
    private KSYMediaPlayer player = null;

    public KSYPlayerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        single = this;
    }

    public static KSYPlayerModule getInstance() {
        return single;
    }

    public void setPlayer(KSYMediaPlayer s) {
        player = s;
    }

    @Override
    public Map<String, Object> getConstants() {
        return new HashMap<>();
    }

    @Override
    public String getName() {
        return "KSYPlayerModule";
    }

    /**
     * 开始播放
     */
    @ReactMethod
    public void start() {
        if (player == null) {
            throw new NullPointerException("KSYPlayer尚未初始化");
        } else {
            player.start();
        }
    }

    /**
     * 停止播放
     */
    @ReactMethod
    public void stop() {
        if (player == null) {
            throw new NullPointerException("KSYPlayer尚未初始化");
        } else {
            player.stop();
        }
    }

    /**
     * 释放播放器
     */
    @ReactMethod
    public void release() {
        if (player == null) {
            throw new NullPointerException("KSYPlayer尚未初始化");
        } else {
            player.release();
        }
    }

    /**
     * 只能在播放过程中使用，如果finish或者主动stop后需要继续使用该实例，需要使用reset。
     * @param url 播放地址
     * @param flushBuffer 是否丢弃播放器中旧的数据
     */
    @ReactMethod
    public void reload(String url, Boolean flushBuffer) {
        if (player == null) {
            throw new NullPointerException("KSYPlayer尚未初始化");
        } else {
            player.reload(url, flushBuffer);
        }
    }
}
