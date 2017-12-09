package com.reactnativestreamer;

import com.facebook.react.bridge.*;
import com.ksyun.media.streamer.capture.CameraCapture;
import com.ksyun.media.streamer.filter.audio.AudioReverbFilter;
import com.ksyun.media.streamer.filter.audio.KSYAudioEffectFilter;
import com.ksyun.media.streamer.kit.KSYStreamer;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Will Bean on 2017/11/28.
 * App 运行过程中只会实例化一次
 * 在 KSLiveManager 中注册 streamer 实例
 */
public class KSYStreamerModule extends ReactContextBaseJavaModule {
    private static KSYStreamerModule single = null;
    private KSYStreamer streamer = null;

    public KSYStreamerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        single = this;
    }

    public static KSYStreamerModule getInstance() {
        return single;
    }

    public void setStreamer(KSYStreamer s) {
        streamer = s;
    }


    private static final String FACING_FRONT = "FACING_FRONT";
    private static final String FACING_BACK = "FACING_BACK";

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(FACING_FRONT, CameraCapture.FACING_FRONT);
        constants.put(FACING_BACK, CameraCapture.FACING_BACK);
        return constants;
    }

    @Override
    public String getName() {
        return "KSYStreamerModule";
    }

    /**
     * 开始推流
     */
    @ReactMethod
    public void startStream() {
        if (streamer == null) {
            throw new NullPointerException("KSYStreamer尚未初始化");
        } else {
            streamer.startStream();
        }
    }

    /**
     * 开启摄像头预览
     */
    @ReactMethod
    public void startCameraPreview() {
        if (streamer == null) {
            throw new NullPointerException("KSYStreamer尚未初始化");
        } else {
            streamer.startCameraPreview();
        }
    }

    /**
     * 切换摄像头
     */
    @ReactMethod
    public void switchCamera() {
        if (streamer == null) {
            throw new NullPointerException("KSYStreamer尚未初始化");
        } else {
            streamer.switchCamera();
        }
    }

    /**
     * 开关闪光灯
     */
    @ReactMethod
    public void toggleTorch(Boolean t) {
        if (streamer == null) {
            throw new NullPointerException("KSYStreamer尚未初始化");
        } else {
            streamer.toggleTorch(t);
        }
    }

    /**
     * 恢复摄像头采集
     */
    @ReactMethod
    public void onResume() {
        if (streamer == null) {
            throw new NullPointerException("KSYStreamer尚未初始化");
        } else {
            streamer.onResume();
        }
    }

    /**
     * 停止摄像头采集
     */
    @ReactMethod
    public void stopCameraPreview() {
        if (streamer == null) {
            throw new NullPointerException("KSYStreamer尚未初始化");
        } else {
            streamer.stopCameraPreview();
        }
    }

    /**
     * 如果希望App切后台后，停止录制主播端的声音，可以在此切换为DummyAudio采集，
     * 该模块会代替mic采集模块产生静音数据，同时释放占用的mic资源
     */
    @ReactMethod
    public void setUseDummyAudioCapture(Boolean b) {
        if (streamer == null) {
            throw new NullPointerException("KSYStreamer尚未初始化");
        } else {
            streamer.setUseDummyAudioCapture(b);
        }
    }

    /**
     * 清理相关资源
     */
    @ReactMethod
    public void release() {
        if (streamer == null) {
            throw new NullPointerException("KSYStreamer尚未初始化");
        } else {
            streamer.release();
        }
    }

    /**
     * 前置镜像功能效果：主播端预览画面和播放端画面一致。
     * <p>
     * 正常推流的时候，使用前置摄像头，我们希望主播本身看到的画面跟镜面一致，但是希望播放端看到的是正常的画面。
     * 比如拿个写字的纸片，放到前置摄像头之前，主播看到的文字是倒的，而观众看到的文字是正的。
     * 开启前置镜像功能后，则让播放端画面和主播预览画面一致，也就是观众端看到的也是倒的文字。
     * <p>
     * 该功能只针对前置摄像头, 默认不开启。
     */
    @ReactMethod
    public void setFrontCameraMirror(Boolean t) {
        if (streamer == null) {
            throw new NullPointerException("KSYStreamer尚未初始化");
        } else {
            streamer.setFrontCameraMirror(t);
        }
    }

    /**
     * 美颜相关函数
     * 设置美颜滤镜
     * 阉割了SDK的setFilter函数，不能同时设置多种滤镜
     */
    @ReactMethod
    public void setImgTexFilter(int i) {
        streamer.getImgTexFilterMgt().setFilter(streamer.getGLRender(), i);
    }

    /**
     * 美颜相关函数
     * 设置磨皮级别，范围0-1
     */
    @ReactMethod
    public void setGrindRatio(float f) {
        streamer.getImgTexFilterMgt().getFilter().get(0).setGrindRatio(f);
    }

    /**
     * 美颜相关函数
     * 设置红润级别，一般范围为0-1，BeautyPro为-1.0~1.0
     */
    @ReactMethod
    public void setRuddyRatio(float f) {
        streamer.getImgTexFilterMgt().getFilter().get(0).setRuddyRatio(f);
    }

    /**
     * 美颜相关函数
     * 设置美白级别，范围0-1
     */
    @ReactMethod
    public void setWhitenRatio(float f) {
        streamer.getImgTexFilterMgt().getFilter().get(0).setWhitenRatio(f);
    }

    /**
     * 美颜相关函数
     */
    @ReactMethod
    public void isGrindRatioSupported(Callback cb) {
        cb.invoke(streamer.getImgTexFilterMgt().getFilter().get(0).isGrindRatioSupported());
    }

    /**
     * 美颜相关函数
     */
    @ReactMethod
    public void isWhitenRatioSupported(Callback cb) {
        cb.invoke(streamer.getImgTexFilterMgt().getFilter().get(0).isWhitenRatioSupported());
    }

    /**
     * 美颜相关函数
     */
    @ReactMethod
    public void isRuddyRatioSupported(Callback cb) {
        cb.invoke(streamer.getImgTexFilterMgt().getFilter().get(0).isRuddyRatioSupported());
    }

    /**
     * 音频滤镜
     * 参考
     * https://github.com/ksvc/KSYStreamer_Android/wiki/Audio_Filter
     *
     * 混响设置
     */
    @ReactMethod
    public void setAudioReverbFilter(int i) {
        AudioReverbFilter reverb = new AudioReverbFilter();
        reverb.setReverbLevel(i);
        streamer.getAudioFilterMgt().setFilter(reverb);
    }

    /**
     * 变声设置
     */
    @ReactMethod
    public void setAudioEffectFilter(int i) {
        KSYAudioEffectFilter audioEffect = new KSYAudioEffectFilter(i);
        streamer.getAudioFilterMgt().setFilter(audioEffect);
    }

    /**
     * 升降调音效设置
     */
    @ReactMethod
    public void setAudioKeyEffectFilter(int i) {
        KSYAudioEffectFilter audioEffect = new KSYAudioEffectFilter(KSYAudioEffectFilter.AUDIO_EFFECT_TYPE_PITCH);
        audioEffect.setPitchLevel(i);
        streamer.getBGMAudioFilterMgt().setFilter(audioEffect);
    }

}
