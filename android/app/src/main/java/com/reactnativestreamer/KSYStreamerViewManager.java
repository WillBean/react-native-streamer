package com.reactnativestreamer;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.ksyun.media.streamer.capture.CameraCapture;
import com.ksyun.media.streamer.kit.StreamerConstants;

/**
 * Created by Will Bean on 2017/11/27.
 */
public class KSYStreamerViewManager extends SimpleViewManager<KSYStreamerView> {
    private static final String REACT_CLASS = "RCTKSLiveView";

    @Override
    public String getName(){
        return REACT_CLASS;
    }

    @Override
    public KSYStreamerView createViewInstance(ThemedReactContext context){
        KSYStreamerView view = new KSYStreamerView(context);
        KSYStreamerModule.getInstance().setStreamer(view.getStreamerInstance());
        return view;
    }

    /**
     * 设置推流url
     * */
    @ReactProp(name = "url")
    public void setUrl(KSYStreamerView view, String url) {
        view.getStreamerInstance().setUrl(url);
    }

    /**
     * 设置预览分辨率, 当一边为0时，SDK会根据另一边及实际预览View的尺寸进行计算
     */
    @ReactProp(name = "previewResolution")
    public void setPreviewResolution(KSYStreamerView view, ReadableArray array) {
        if (array.size() == 1) {
            view.getStreamerInstance().setPreviewResolution(array.getInt(0));
        } else if (array.size() == 2) {
            view.getStreamerInstance().setPreviewResolution(array.getInt(0), array.getInt(1));
        }
    }

    /**
     * 设置推流分辨率，可以不同于预览分辨率（不应大于预览分辨率，否则推流会有画质损失）
     */
    @ReactProp(name = "targetResolution")
    public void setTargetResolution(KSYStreamerView view, ReadableArray array) {
        if (array.size() == 1) {
            view.getStreamerInstance().setTargetResolution(array.getInt(0));
        } else if (array.size() == 2) {
            view.getStreamerInstance().setTargetResolution(array.getInt(0), array.getInt(1));
        }
    }

    /**
     * 设置预览帧率
     */
    @ReactProp(name = "previewFps", defaultFloat = 15f)
    public void setPreviewFps(KSYStreamerView view, float f) {
        view.getStreamerInstance().setPreviewFps(f);
    }

    /**
     * 设置推流帧率，当预览帧率大于推流帧率时，编码模块会自动丢帧以适应设定的推流帧率
     */
    @ReactProp(name = "targetFps", defaultFloat = 15f)
    public void setTargetFps(KSYStreamerView view, float f) {
        view.getStreamerInstance().setTargetFps(f);
    }

    /**
     * 设置视频码率，分别为初始平均码率、最高平均码率、最低平均码率，单位为kbps，另有setVideoBitrate接口，单位为bps
     */
    @ReactProp(name = "videoKBitrate")
    public void setVideoKBitrate(KSYStreamerView view, ReadableArray array) {
        view.getStreamerInstance().setVideoKBitrate(array.getInt(0), array.getInt(1), array.getInt(2));
    }

    /**
     * 设置音频采样率
     */
    @ReactProp(name = "audioSampleRate", defaultInt = 44100)
    public void setAudioSampleRate(KSYStreamerView view, int i) {
        view.getStreamerInstance().setAudioSampleRate(i);
    }

    /**
     * 设置音频码率，单位为kbps，另有setAudioBitrate接口，单位为bps
     */
    @ReactProp(name = "audioKBitrate", defaultInt = 48)
    public void setAudioKBitrate(KSYStreamerView view, int i) {
        view.getStreamerInstance().setAudioKBitrate(i);
    }

    /**
     * 设置编码模式(软编、硬编)，请根据白名单和系统版本来设置软硬编模式，不要全部设成软编或者硬编,白名单可以联系金山云商务:
     * StreamerConstants.ENCODE_METHOD_SOFTWARE
     * StreamerConstants.ENCODE_METHOD_HARDWARE
     */
    @ReactProp(name = "encodeMethod", defaultInt = StreamerConstants.ENCODE_METHOD_SOFTWARE)
    public void setEncodeMethod(KSYStreamerView view, int i) {
        view.getStreamerInstance().setEncodeMethod(i);
    }


    /**
     * 设置屏幕的旋转角度，支持 0, 90, 180, 270
     */
    @ReactProp(name = "rotateDegrees", defaultInt = 0)
    public void setRotateDegrees(KSYStreamerView view, int i) {
        view.getStreamerInstance().setRotateDegrees(i);
    }

    /**
     * 设置开始预览使用前置还是后置摄像头
     * CameraCapture.FACING_FRONT
     * CameraCapture.FACING_BACK
     */
    @ReactProp(name = "cameraFacing", defaultInt = CameraCapture.FACING_FRONT)
    public void setCameraFacing(KSYStreamerView view, int i) {
        view.getStreamerInstance().setCameraFacing(i);
    }
}
