package com.reactnativestreamer;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.ksyun.media.streamer.filter.imgtex.ImgTexFilterMgt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Will Bean on 2017/11/28.
 */
public class ImgTexFilterConstantsModule extends ReactContextBaseJavaModule {

    public ImgTexFilterConstantsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ImgTexFilterModule";
    }

    private static final String KSY_FILTER_BEAUTY_DISABLE = "KSY_FILTER_BEAUTY_DISABLE";
    private static final String KSY_FILTER_BEAUTY_DENOISE = "KSY_FILTER_BEAUTY_DENOISE";
    private static final String KSY_FILTER_BEAUTY_SKINWHITEN = "KSY_FILTER_BEAUTY_SKINWHITEN";
    private static final String KSY_FILTER_BEAUTY_SOFT = "KSY_FILTER_BEAUTY_SOFT";
    private static final String KSY_FILTER_BEAUTY_ILLUSION = "KSY_FILTER_BEAUTY_ILLUSION";
    private static final String KSY_FILTER_BEAUTY_SMOOTH = "KSY_FILTER_BEAUTY_SMOOTH";
    private static final String KSY_FILTER_BEAUTY_SOFT_EXT = "KSY_FILTER_BEAUTY_SOFT_EXT";
    private static final String KSY_FILTER_BEAUTY_SOFT_SHARPEN = "KSY_FILTER_BEAUTY_SOFT_SHARPEN";
    private static final String KSY_FILTER_BEAUTY_PRO = "KSY_FILTER_BEAUTY_PRO";

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(KSY_FILTER_BEAUTY_DISABLE, ImgTexFilterMgt.KSY_FILTER_BEAUTY_DISABLE);
        constants.put(KSY_FILTER_BEAUTY_DENOISE, ImgTexFilterMgt.KSY_FILTER_BEAUTY_DENOISE);
        constants.put(KSY_FILTER_BEAUTY_SKINWHITEN, ImgTexFilterMgt.KSY_FILTER_BEAUTY_SKINWHITEN);
        constants.put(KSY_FILTER_BEAUTY_SOFT, ImgTexFilterMgt.KSY_FILTER_BEAUTY_SOFT);
        constants.put(KSY_FILTER_BEAUTY_ILLUSION, ImgTexFilterMgt.KSY_FILTER_BEAUTY_ILLUSION);
        constants.put(KSY_FILTER_BEAUTY_SMOOTH, ImgTexFilterMgt.KSY_FILTER_BEAUTY_SMOOTH);
        constants.put(KSY_FILTER_BEAUTY_SOFT_EXT, ImgTexFilterMgt.KSY_FILTER_BEAUTY_SOFT_EXT);
        constants.put(KSY_FILTER_BEAUTY_SOFT_SHARPEN, ImgTexFilterMgt.KSY_FILTER_BEAUTY_SOFT_SHARPEN);
        constants.put(KSY_FILTER_BEAUTY_PRO, ImgTexFilterMgt.KSY_FILTER_BEAUTY_PRO);
        return constants;
    }
}
