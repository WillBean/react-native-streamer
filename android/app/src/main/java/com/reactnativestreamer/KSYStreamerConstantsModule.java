package com.reactnativestreamer;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.ksyun.media.streamer.kit.StreamerConstants;

import java.util.HashMap;
import java.util.Map;

public class KSYStreamerConstantsModule extends ReactContextBaseJavaModule {

    public KSYStreamerConstantsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @Override
    public String getName() { return "KSYStreamerConstantsModule"; }

    /**
     * 导出常量
     * 编码相关
     */
    private static final String ENCODE_METHOD_SOFTWARE = "ENCODE_METHOD_SOFTWARE";
    private static final String ENCODE_METHOD_HARDWARE = "ENCODE_METHOD_HARDWARE";
    /**
     * 状态码
     * 参考：
     * https://github.com/ksvc/KSYStreamer_Android/wiki/Info&Error_Listener
     * */
    private static final String KSY_STREAMER_CAMERA_INIT_DONE = "KSY_STREAMER_CAMERA_INIT_DONE";
    private static final String KSY_STREAMER_OPEN_STREAM_SUCCESS = "KSY_STREAMER_OPEN_STREAM_SUCCESS";
    private static final String KSY_STREAMER_FRAME_SEND_SLOW = "KSY_STREAMER_FRAME_SEND_SLOW";
    private static final String KSY_STREAMER_EST_BW_RAISE = "KSY_STREAMER_EST_BW_RAISE";
    private static final String KSY_STREAMER_EST_BW_DROP = "KSY_STREAMER_EST_BW_DROP";
    /**
     * 错误码
     * */
    private static final String KSY_STREAMER_RTMP_ERROR_UNKNOWN = "KSY_STREAMER_RTMP_ERROR_UNKNOWN";
    private static final String KSY_STREAMER_ERROR_DNS_PARSE_FAILED = "KSY_STREAMER_ERROR_DNS_PARSE_FAILED";
    private static final String KSY_STREAMER_ERROR_CONNECT_FAILED = "KSY_STREAMER_ERROR_CONNECT_FAILED";
    private static final String KSY_STREAMER_ERROR_PUBLISH_FAILED = "KSY_STREAMER_ERROR_PUBLISH_FAILED";
    private static final String KSY_STREAMER_ERROR_CONNECT_BREAKED = "KSY_STREAMER_ERROR_CONNECT_BREAKED";
    private static final String KSY_STREAMER_ERROR_AV_ASYNC = "KSY_STREAMER_ERROR_AV_ASYNC";
    private static final String KSY_STREAMER_VIDEO_ENCODER_ERROR_UNSUPPORTED = "KSY_STREAMER_VIDEO_ENCODER_ERROR_UNSUPPORTED";
    private static final String KSY_STREAMER_VIDEO_ENCODER_ERROR_UNKNOWN = "KSY_STREAMER_VIDEO_ENCODER_ERROR_UNKNOWN";
    private static final String KSY_STREAMER_AUDIO_ENCODER_ERROR_UNSUPPORTED = "KSY_STREAMER_AUDIO_ENCODER_ERROR_UNSUPPORTED";
    private static final String KSY_STREAMER_AUDIO_ENCODER_ERROR_UNKNOWN = "KSY_STREAMER_AUDIO_ENCODER_ERROR_UNKNOWN";
    private static final String KSY_STREAMER_CAMERA_ERROR_UNKNOWN = "KSY_STREAMER_CAMERA_ERROR_UNKNOWN";
    private static final String KSY_STREAMER_CAMERA_ERROR_START_FAILED = "KSY_STREAMER_CAMERA_ERROR_START_FAILED";
    private static final String KSY_STREAMER_CAMERA_ERROR_SERVER_DIED = "KSY_STREAMER_CAMERA_ERROR_SERVER_DIED";
    private static final String KSY_STREAMER_AUDIO_RECORDER_ERROR_START_FAILED = "KSY_STREAMER_AUDIO_RECORDER_ERROR_START_FAILED";
    private static final String KSY_STREAMER_AUDIO_RECORDER_ERROR_UNKNOWN = "KSY_STREAMER_AUDIO_RECORDER_ERROR_UNKNOWN";
    private static final String KSY_STREAMER_CAMERA_ERROR_EVICTED = "KSY_STREAMER_CAMERA_ERROR_EVICTED";
    /**
     * 金山云扩展的RTMP推流错误码
     * */
    private static final String KSY_STREAMER_RTMP_ERROR_NonExistDomain = "KSY_STREAMER_RTMP_ERROR_NonExistDomain";
    private static final String KSY_STREAMER_RTMP_ERROR_NonExistApplication = "KSY_STREAMER_RTMP_ERROR_NonExistApplication";
    private static final String KSY_STREAMER_RTMP_ERROR_AlreadyExistStreamName = "KSY_STREAMER_RTMP_ERROR_AlreadyExistStreamName";
    private static final String KSY_STREAMER_RTMP_ERROR_ForbiddenByBlacklist = "KSY_STREAMER_RTMP_ERROR_ForbiddenByBlacklist";
    private static final String KSY_STREAMER_RTMP_ERROR_InternalError = "KSY_STREAMER_RTMP_ERROR_InternalError";
    private static final String KSY_STREAMER_RTMP_ERROR_URLExpired = "KSY_STREAMER_RTMP_ERROR_URLExpired";
    private static final String KSY_STREAMER_RTMP_ERROR_SignatureDoesNotMatch = "KSY_STREAMER_RTMP_ERROR_SignatureDoesNotMatch";
    private static final String KSY_STREAMER_RTMP_ERROR_InvalidAccessKeyId = "KSY_STREAMER_RTMP_ERROR_InvalidAccessKeyId";
    private static final String KSY_STREAMER_RTMP_ERROR_BadParams = "KSY_STREAMER_RTMP_ERROR_BadParams";
    private static final String KSY_STREAMER_RTMP_ERROR_ForbiddenByRegion = "KSY_STREAMER_RTMP_ERROR_ForbiddenByRegion";
    private static final String KSY_STREAMER_RTMP_ERROR_GetUserIdFailed = "KSY_STREAMER_RTMP_ERROR_GetUserIdFailed";
    private static final String KSY_STREAMER_RTMP_ERROR_AkAndUserIsNotMatch = "KSY_STREAMER_RTMP_ERROR_AkAndUserIsNotMatch";
    private static final String KSY_STREAMER_RTMP_ERROR_GetServerInfoFailed = "KSY_STREAMER_RTMP_ERROR_GetServerInfoFailed";
    private static final String KSY_STREAMER_RTMP_ERROR_IllegalOutsideUrl = "KSY_STREAMER_RTMP_ERROR_IllegalOutsideUrl";
    private static final String KSY_STREAMER_RTMP_ERROR_OutsideAuthFailed = "KSY_STREAMER_RTMP_ERROR_OutsideAuthFailed";
    private static final String KSY_STREAMER_RTMP_ERROR_SimpleAuthFailed = "KSY_STREAMER_RTMP_ERROR_SimpleAuthFailed";
    private static final String KSY_STREAMER_RTMP_ERROR_InvalidAuthType = "KSY_STREAMER_RTMP_ERROR_InvalidAuthType";
    private static final String KSY_STREAMER_RTMP_ERROR_IllegalUserId = "KSY_STREAMER_RTMP_ERROR_IllegalUserId";

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(ENCODE_METHOD_SOFTWARE, StreamerConstants.ENCODE_METHOD_SOFTWARE);
        constants.put(ENCODE_METHOD_HARDWARE, StreamerConstants.ENCODE_METHOD_HARDWARE);

        constants.put(KSY_STREAMER_CAMERA_INIT_DONE, StreamerConstants.KSY_STREAMER_CAMERA_INIT_DONE);
        constants.put(KSY_STREAMER_OPEN_STREAM_SUCCESS, StreamerConstants.KSY_STREAMER_OPEN_STREAM_SUCCESS);
        constants.put(KSY_STREAMER_FRAME_SEND_SLOW, StreamerConstants.KSY_STREAMER_FRAME_SEND_SLOW);
        constants.put(KSY_STREAMER_EST_BW_RAISE, StreamerConstants.KSY_STREAMER_EST_BW_RAISE);
        constants.put(KSY_STREAMER_EST_BW_DROP, StreamerConstants.KSY_STREAMER_EST_BW_DROP);

        constants.put(KSY_STREAMER_RTMP_ERROR_UNKNOWN, StreamerConstants.KSY_STREAMER_RTMP_ERROR_UNKNOWN);
        constants.put(KSY_STREAMER_ERROR_DNS_PARSE_FAILED, StreamerConstants.KSY_STREAMER_ERROR_DNS_PARSE_FAILED);
        constants.put(KSY_STREAMER_ERROR_CONNECT_FAILED, StreamerConstants.KSY_STREAMER_ERROR_CONNECT_FAILED);
        constants.put(KSY_STREAMER_ERROR_PUBLISH_FAILED, StreamerConstants.KSY_STREAMER_ERROR_PUBLISH_FAILED);
        constants.put(KSY_STREAMER_ERROR_CONNECT_BREAKED, StreamerConstants.KSY_STREAMER_ERROR_CONNECT_BREAKED);
        constants.put(KSY_STREAMER_ERROR_AV_ASYNC, StreamerConstants.KSY_STREAMER_ERROR_AV_ASYNC);
        constants.put(KSY_STREAMER_VIDEO_ENCODER_ERROR_UNSUPPORTED, StreamerConstants.KSY_STREAMER_VIDEO_ENCODER_ERROR_UNSUPPORTED);
        constants.put(KSY_STREAMER_VIDEO_ENCODER_ERROR_UNKNOWN, StreamerConstants.KSY_STREAMER_VIDEO_ENCODER_ERROR_UNKNOWN);
        constants.put(KSY_STREAMER_AUDIO_ENCODER_ERROR_UNSUPPORTED, StreamerConstants.KSY_STREAMER_AUDIO_ENCODER_ERROR_UNSUPPORTED);
        constants.put(KSY_STREAMER_AUDIO_ENCODER_ERROR_UNKNOWN, StreamerConstants.KSY_STREAMER_AUDIO_ENCODER_ERROR_UNKNOWN);
        constants.put(KSY_STREAMER_CAMERA_ERROR_UNKNOWN, StreamerConstants.KSY_STREAMER_CAMERA_ERROR_UNKNOWN);
        constants.put(KSY_STREAMER_CAMERA_ERROR_START_FAILED, StreamerConstants.KSY_STREAMER_CAMERA_ERROR_START_FAILED);
        constants.put(KSY_STREAMER_CAMERA_ERROR_SERVER_DIED, StreamerConstants.KSY_STREAMER_CAMERA_ERROR_SERVER_DIED);
        constants.put(KSY_STREAMER_AUDIO_RECORDER_ERROR_START_FAILED, StreamerConstants.KSY_STREAMER_AUDIO_RECORDER_ERROR_START_FAILED);
        constants.put(KSY_STREAMER_AUDIO_RECORDER_ERROR_UNKNOWN, StreamerConstants.KSY_STREAMER_AUDIO_RECORDER_ERROR_UNKNOWN);
        constants.put(KSY_STREAMER_CAMERA_ERROR_EVICTED, StreamerConstants.KSY_STREAMER_CAMERA_ERROR_EVICTED);

        constants.put(KSY_STREAMER_RTMP_ERROR_NonExistDomain, StreamerConstants.KSY_STREAMER_RTMP_ERROR_NonExistDomain);
        constants.put(KSY_STREAMER_RTMP_ERROR_NonExistApplication, StreamerConstants.KSY_STREAMER_RTMP_ERROR_NonExistApplication);
        constants.put(KSY_STREAMER_RTMP_ERROR_AlreadyExistStreamName, StreamerConstants.KSY_STREAMER_RTMP_ERROR_AlreadyExistStreamName);
        constants.put(KSY_STREAMER_RTMP_ERROR_ForbiddenByBlacklist, StreamerConstants.KSY_STREAMER_RTMP_ERROR_ForbiddenByBlacklist);
        constants.put(KSY_STREAMER_RTMP_ERROR_InternalError, StreamerConstants.KSY_STREAMER_RTMP_ERROR_InternalError);
        constants.put(KSY_STREAMER_RTMP_ERROR_URLExpired, StreamerConstants.KSY_STREAMER_RTMP_ERROR_URLExpired);
        constants.put(KSY_STREAMER_RTMP_ERROR_SignatureDoesNotMatch, StreamerConstants.KSY_STREAMER_RTMP_ERROR_SignatureDoesNotMatch);
        constants.put(KSY_STREAMER_RTMP_ERROR_InvalidAccessKeyId, StreamerConstants.KSY_STREAMER_RTMP_ERROR_InvalidAccessKeyId);
        constants.put(KSY_STREAMER_RTMP_ERROR_BadParams, StreamerConstants.KSY_STREAMER_RTMP_ERROR_BadParams);
        constants.put(KSY_STREAMER_RTMP_ERROR_ForbiddenByRegion, StreamerConstants.KSY_STREAMER_RTMP_ERROR_ForbiddenByRegion);
        constants.put(KSY_STREAMER_RTMP_ERROR_GetUserIdFailed, StreamerConstants.KSY_STREAMER_RTMP_ERROR_GetUserIdFailed);
        constants.put(KSY_STREAMER_RTMP_ERROR_AkAndUserIsNotMatch, StreamerConstants.KSY_STREAMER_RTMP_ERROR_AkAndUserIsNotMatch);
        constants.put(KSY_STREAMER_RTMP_ERROR_GetServerInfoFailed, StreamerConstants.KSY_STREAMER_RTMP_ERROR_GetServerInfoFailed);
        constants.put(KSY_STREAMER_RTMP_ERROR_IllegalOutsideUrl, StreamerConstants.KSY_STREAMER_RTMP_ERROR_IllegalOutsideUrl);
        constants.put(KSY_STREAMER_RTMP_ERROR_OutsideAuthFailed, StreamerConstants.KSY_STREAMER_RTMP_ERROR_OutsideAuthFailed);
        constants.put(KSY_STREAMER_RTMP_ERROR_SimpleAuthFailed, StreamerConstants.KSY_STREAMER_RTMP_ERROR_SimpleAuthFailed);
        constants.put(KSY_STREAMER_RTMP_ERROR_InvalidAuthType, StreamerConstants.KSY_STREAMER_RTMP_ERROR_InvalidAuthType);
        constants.put(KSY_STREAMER_RTMP_ERROR_IllegalUserId, StreamerConstants.KSY_STREAMER_RTMP_ERROR_IllegalUserId);

        return constants;
    }
}
