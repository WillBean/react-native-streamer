package com.reactnativestreamer;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.content.Intent;
import com.facebook.react.ReactActivity;

import android.widget.Toast;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.ksyun.media.streamer.capture.CameraCapture;
import com.ksyun.media.streamer.kit.KSYStreamer;
import com.ksyun.media.streamer.kit.StreamerConstants;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */

    @Override
    protected String getMainComponentName() {
        return "RNIdeaTest";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication application = (MainApplication) getApplication();
        ReactNativeHost reactNativeHost = application.getReactNativeHost();
        ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
        DevSupportManager devSupportManager = reactInstanceManager.getDevSupportManager();
        devSupportManager.addCustomDevOption("Custom dev option", new DevOptionHandler() {
            @Override
            public void onOptionSelected() {
                Toast.makeText(MainActivity.this, "Hello from custom dev option", Toast.LENGTH_SHORT).show();
            }
        });

//        System.out.println(111);
//        setContentView(R.layout.activity_live);
//        GLSurfaceView mCameraPreview = (GLSurfaceView) findViewById(R.id.camera_preview);
////        mCameraPreview.setRenderer(new GLRenderer());
//        // 创建KSYStreamer实例
//        KSYStreamer mStreamer = new KSYStreamer(this);
//// 设置预览View
//        mStreamer.setDisplayPreview(mCameraPreview);
//// 设置推流url（需要向相关人员申请，测试地址并不稳定！）
//        mStreamer.setUrl("rtmp://139.199.223.39/live/stream");
//// 设置预览分辨率, 当一边为0时，SDK会根据另一边及实际预览View的尺寸进行计算
//        mStreamer.setPreviewResolution(480, 0);
//// 设置推流分辨率，可以不同于预览分辨率（不应大于预览分辨率，否则推流会有画质损失）
//        mStreamer.setTargetResolution(480, 0);
//// 设置预览帧率
//        mStreamer.setPreviewFps(15);
//// 设置推流帧率，当预览帧率大于推流帧率时，编码模块会自动丢帧以适应设定的推流帧率
//        mStreamer.setTargetFps(15);
//// 设置视频码率，分别为初始平均码率、最高平均码率、最低平均码率，单位为kbps，另有setVideoBitrate接口，单位为bps
//        mStreamer.setVideoKBitrate(600, 800, 400);
//// 设置音频采样率
//        mStreamer.setAudioSampleRate(44100);
//// 设置音频码率，单位为kbps，另有setAudioBitrate接口，单位为bps
//        mStreamer.setAudioKBitrate(48);
///**
// * 设置编码模式(软编、硬编)，请根据白名单和系统版本来设置软硬编模式，不要全部设成软编或者硬编,白名单可以联系金山云商务:
// * StreamerConstants.ENCODE_METHOD_SOFTWARE
// * StreamerConstants.ENCODE_METHOD_HARDWARE
// */
//        mStreamer.setEncodeMethod(StreamerConstants.ENCODE_METHOD_SOFTWARE);
//// 设置屏幕的旋转角度，支持 0, 90, 180, 270
//        mStreamer.setRotateDegrees(0);
//// 设置开始预览使用前置还是后置摄像头
//        mStreamer.setCameraFacing(CameraCapture.FACING_FRONT);
//
//        mStreamer.setOnInfoListener(new KSYStreamer.OnInfoListener() {
//            @Override
//            public void onInfo(int what, int msg1, int msg2) {
//                System.out.println(what);
//                System.out.println(msg1);
//                System.out.println(msg2);
//            }
//        });
//
//        mStreamer.setOnErrorListener(new KSYStreamer.OnErrorListener() {
//            @Override
//            public void onError(int what, int msg1, int msg2) {
//                System.out.println(what);
//                System.out.println(msg1);
//                System.out.println(msg2);
//            }
//        });
//        mStreamer.startCameraPreview();
//        mStreamer.toggleTorch(true);
//        mStreamer.startStream();
    }
}
