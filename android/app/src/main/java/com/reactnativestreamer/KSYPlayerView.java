package com.reactnativestreamer;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.support.annotation.Nullable;
import android.view.SurfaceHolder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.ksyun.media.player.IMediaPlayer;
import com.ksyun.media.player.KSYMediaPlayer;

public class KSYPlayerView extends GLSurfaceView {
    private Context ctx = null;
    private KSYMediaPlayer ksyMediaPlayer;

    public KSYPlayerView(Context context) {
        super(context);
        ctx = context;
        init();
    }

    private void init() {
        // 创建KSYStreamer实例
        ksyMediaPlayer = new KSYMediaPlayer.Builder(ctx).build();
        ksyMediaPlayer.setOnCompletionListener(mOnCompletionListener);
        ksyMediaPlayer.setOnPreparedListener(mOnPreparedListener);
        ksyMediaPlayer.setOnInfoListener(mOnInfoListener);
        ksyMediaPlayer.setOnVideoSizeChangedListener(mOnVideoSizeChangeListener);
        ksyMediaPlayer.setOnErrorListener(mOnErrorListener);
        ksyMediaPlayer.setOnSeekCompleteListener(mOnSeekCompletedListener);

        SurfaceHolder mSurfaceHolder = this.getHolder();
        SurfaceHolder.Callback mSurfaceCallback = new SurfaceHolder.Callback() {
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ksyMediaPlayer != null) {
                    ksyMediaPlayer.setDisplay(holder);
                    ksyMediaPlayer.setScreenOnWhilePlaying(true);
                }
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // 此处非常重要，必须调用!!!
                if (ksyMediaPlayer != null) {
                    ksyMediaPlayer.setDisplay(null);
                    ksyMediaPlayer.release();
                    ksyMediaPlayer = null;
                }
            }
        };
        mSurfaceHolder.addCallback(mSurfaceCallback);
    }

    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new IMediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(IMediaPlayer mp) {
            if(ksyMediaPlayer != null) {
                WritableMap params = Arguments.createMap();
                params.putString("type", "Initialized");
                sendEvent("onAndroidPlayerInfo", params);
            }
        }
    };

    // 其功能是监听在播放器发出的消息通知onInfo回调
    private IMediaPlayer.OnInfoListener mOnInfoListener = new IMediaPlayer.OnInfoListener() {
        @Override
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
            if(ksyMediaPlayer != null) {
                WritableMap params = Arguments.createMap();
                params.putString("type", "Info");
                params.putInt("what", i);
                params.putInt("msg", i1);
                sendEvent("onAndroidPlayerInfo", params);
            }
            return false;
        }
    };

    // 其功能是监听在播放器播放完成时发出的onCompletion回调
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new IMediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            if(ksyMediaPlayer != null) {
                WritableMap params = Arguments.createMap();
                params.putString("type", "Finished");
                sendEvent("onAndroidPlayerInfo", params);
            }
        }
    };

    // 视频宽高发生变化时会有此回调，并告知最新的视频宽高
    // 该回调主要在以下情况会出现：
    //
    // 视频开播
    // 播放过程中视频宽高发生变化
    private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangeListener = new IMediaPlayer.OnVideoSizeChangedListener() {
        @Override
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {
            if(ksyMediaPlayer != null) {
                WritableMap params = Arguments.createMap();
                params.putString("type", "SizeChanged");
                params.putInt("width", i);
                params.putInt("height", i1);
                params.putInt("sarNum", i2);
                params.putInt("sarDen", i3);
                sendEvent("onAndroidPlayerInfo", params);
            }
        }
    };

    private IMediaPlayer.OnErrorListener mOnErrorListener = new IMediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
            if(ksyMediaPlayer != null) {
                WritableMap params = Arguments.createMap();
                params.putString("type", "Error");
                params.putInt("what", i);
                params.putInt("msg", i1);
                sendEvent("onAndroidPlayerInfo", params);
            }
            return false;
        }
    };

    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompletedListener = new IMediaPlayer.OnSeekCompleteListener() {
        @Override
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            if(ksyMediaPlayer != null) {
                WritableMap params = Arguments.createMap();
                params.putString("type", "SeekCompleted");
                sendEvent("onAndroidPlayerInfo", params);
            }
        }
    };

    private void sendEvent(String eventName, @Nullable WritableMap params) {
        ((ReactContext)ctx).getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    public KSYMediaPlayer getPlayerInstance() {
        return ksyMediaPlayer;
    }
}
