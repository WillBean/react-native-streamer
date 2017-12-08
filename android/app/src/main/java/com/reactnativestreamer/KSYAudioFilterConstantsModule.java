package com.reactnativestreamer;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.ksyun.media.streamer.filter.audio.AudioReverbFilter;
import com.ksyun.media.streamer.filter.audio.KSYAudioEffectFilter;

import java.util.HashMap;
import java.util.Map;

public class KSYAudioFilterConstantsModule extends ReactContextBaseJavaModule {
    public KSYAudioFilterConstantsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "KSYAudioFilterConstantsModule";
    }

    /**
     * 导出常量
     * 参考
     * https://github.com/ksvc/KSYStreamer_Android/wiki/Audio_Filter
     *
     * 混响设置
     */
    private static final String AUDIO_REVERB_LEVEL_1 = "AUDIO_REVERB_LEVEL_1";
    private static final String AUDIO_REVERB_LEVEL_2 = "AUDIO_REVERB_LEVEL_2";
    private static final String AUDIO_REVERB_LEVEL_3 = "AUDIO_REVERB_LEVEL_3";
    private static final String AUDIO_REVERB_LEVEL_4 = "AUDIO_REVERB_LEVEL_4";
    private static final String AUDIO_REVERB_LEVEL_5 = "AUDIO_REVERB_LEVEL_5";
    /**
     * 变声设置
     * */
    private static final String AUDIO_EFFECT_TYPE_FEMALE = "AUDIO_EFFECT_TYPE_FEMALE";
    private static final String AUDIO_EFFECT_TYPE_MALE = "AUDIO_EFFECT_TYPE_MALE";
    private static final String AUDIO_EFFECT_TYPE_HEROIC = "AUDIO_EFFECT_TYPE_HEROIC";
    private static final String AUDIO_EFFECT_TYPE_ROBOT = "AUDIO_EFFECT_TYPE_ROBOT";
    private static final String AUDIO_EFFECT_TYPE_PITCH = "AUDIO_EFFECT_TYPE_PITCH";
    /**
     * 升降调音效设置
     * */
    private static final String AUDIO_PITCH_LEVEL_1 = "AUDIO_PITCH_LEVEL_1";
    private static final String AUDIO_PITCH_LEVEL_2 = "AUDIO_PITCH_LEVEL_2";
    private static final String AUDIO_PITCH_LEVEL_3 = "AUDIO_PITCH_LEVEL_3";
    private static final String AUDIO_PITCH_LEVEL_4 = "AUDIO_PITCH_LEVEL_4";
    private static final String AUDIO_PITCH_LEVEL_5 = "AUDIO_PITCH_LEVEL_5";
    private static final String AUDIO_PITCH_LEVEL_6 = "AUDIO_PITCH_LEVEL_6";
    private static final String AUDIO_PITCH_LEVEL_7 = "AUDIO_PITCH_LEVEL_7";

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(AUDIO_REVERB_LEVEL_1, AudioReverbFilter.AUDIO_REVERB_LEVEL_1);
        constants.put(AUDIO_REVERB_LEVEL_2, AudioReverbFilter.AUDIO_REVERB_LEVEL_2);
        constants.put(AUDIO_REVERB_LEVEL_3, AudioReverbFilter.AUDIO_REVERB_LEVEL_3);
        constants.put(AUDIO_REVERB_LEVEL_4, AudioReverbFilter.AUDIO_REVERB_LEVEL_4);
        constants.put(AUDIO_REVERB_LEVEL_5, AudioReverbFilter.AUDIO_REVERB_LEVEL_5);

        constants.put(AUDIO_EFFECT_TYPE_FEMALE, KSYAudioEffectFilter.AUDIO_EFFECT_TYPE_FEMALE);
        constants.put(AUDIO_EFFECT_TYPE_MALE, KSYAudioEffectFilter.AUDIO_EFFECT_TYPE_MALE);
        constants.put(AUDIO_EFFECT_TYPE_HEROIC, KSYAudioEffectFilter.AUDIO_EFFECT_TYPE_HEROIC);
        constants.put(AUDIO_EFFECT_TYPE_ROBOT, KSYAudioEffectFilter.AUDIO_EFFECT_TYPE_ROBOT);
        constants.put(AUDIO_EFFECT_TYPE_PITCH, KSYAudioEffectFilter.AUDIO_EFFECT_TYPE_PITCH);

        constants.put(AUDIO_PITCH_LEVEL_1, KSYAudioEffectFilter.AUDIO_PITCH_LEVEL_1);
        constants.put(AUDIO_PITCH_LEVEL_2, KSYAudioEffectFilter.AUDIO_PITCH_LEVEL_2);
        constants.put(AUDIO_PITCH_LEVEL_3, KSYAudioEffectFilter.AUDIO_PITCH_LEVEL_3);
        constants.put(AUDIO_PITCH_LEVEL_4, KSYAudioEffectFilter.AUDIO_PITCH_LEVEL_4);
        constants.put(AUDIO_PITCH_LEVEL_5, KSYAudioEffectFilter.AUDIO_PITCH_LEVEL_5);
        constants.put(AUDIO_PITCH_LEVEL_6, KSYAudioEffectFilter.AUDIO_PITCH_LEVEL_6);
        constants.put(AUDIO_PITCH_LEVEL_7, KSYAudioEffectFilter.AUDIO_PITCH_LEVEL_7);

        return constants;
    }
}
