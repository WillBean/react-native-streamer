package com.reactnativestreamer;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.support.annotation.Nullable;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.ksyun.media.streamer.filter.imgtex.ImgFilterBase;
import com.ksyun.media.streamer.kit.KSYStreamer;

class KSYStreamerView extends GLSurfaceView {
    private Context ctx = null;
    private KSYStreamer mStreamer = null;
    private ImgFilterBase filter = null;

    public KSYStreamerView(Context context) {
        super(context);
        ctx = context;
        init();
    }

    private void init() {
        // 创建KSYStreamer实例
        mStreamer = new KSYStreamer(ctx);
        mStreamer.setDisplayPreview(this);

        mStreamer.setOnInfoListener(new KSYStreamer.OnInfoListener() {
            @Override
            public void onInfo(int what, int msg1, int msg2) {
                WritableMap params = Arguments.createMap();
                params.putInt("what", what);
                params.putInt("msg1", msg1);
                params.putInt("msg2", msg2);
                sendEvent("onStreamerInfoListener", params);
            }
        });

        mStreamer.setOnErrorListener(new KSYStreamer.OnErrorListener() {
            @Override
            public void onError(int what, int msg1, int msg2) {
                WritableMap params = Arguments.createMap();
                params.putInt("what", what);
                params.putInt("msg1", msg1);
                params.putInt("msg2", msg2);
                sendEvent("onStreamerErrorListener", params);
            }
        });
    }

    private void sendEvent(String eventName, @Nullable WritableMap params) {
        ((ReactContext)ctx).getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    public KSYStreamer getStreamerInstance() {
        return mStreamer;
    }

}
