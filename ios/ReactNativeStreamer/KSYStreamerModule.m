//
//  KSYStremaerModule.m
//  LivePlayerIOS
//
//  Created by bytedance on 2018/1/29.
//  Copyright © 2018年 Facebook. All rights reserved.
//
#import "KSYStreamerModule.h"
#import "KSYStreamerUIView.h"

@implementation KSYStreamerModule {
    bool hasListeners;
}

static KSYGPUStreamerKit * streamer;
static KSYStreamerModule * single;
static KSYStreamerUIView * kitView;

RCT_EXPORT_MODULE();

/**
 复写初始化方法，获取类实例对象
 @return 当前类实例
 */
- (instancetype) init
{
    UIImage * rubbyMat = [UIImage imageNamed:@"3_tianmeikeren"];
    _bfFilter = [[KSYBeautifyFaceFilter alloc] initWithRubbyMaterial: rubbyMat];
    
    single = [super init];
    return single;
}

/**
 @abstract 启动预览
 @param view 预览画面作为subview，插入到 view 的最底层
 @discussion 设置完成采集参数之后，按照设置值启动预览，启动后对采集参数修改不会生效
 @discussion 需要访问摄像头和麦克风的权限，若授权失败，其他API都会拒绝服务
 
 @warning: 开始推流前必须先启动预览
 @see videoDimension, cameraPosition, videoOrientation, videoFPS
 */
RCT_EXPORT_METHOD(startCameraPreview)
{
    [streamer startPreview:kitView];
}

/**
 @abstract 停止采集
 */
RCT_EXPORT_METHOD(stopCameraPreview)
{
    [streamer stopPreview];
}

/**
 @abstract 开启视频配置和采集
 @discussion 设置完成视频采集参数之后，按照设置值启动视频预览，启动后对视频采集参数修改不会生效
 @discussion 需要访问摄像头的权限，若授权失败，其他API都会拒绝服务
 @discussion 视频采集成功返回YES，不成功返回NO
 */
RCT_EXPORT_METHOD(startVideoCap)
{
    [streamer startVideoCap];
}

/**
 @abstract 开始音频配置和采集
 @discussion 设置完成音频采集参数之后，按照设置值启动音频预览，启动后对音频采集参数修改不会生效
 @discussion 需要访问麦克风的权限，若授权失败，其他API都会拒绝服务
 @discussion 音频采集成功返回YES，不成功返回NO
 */
RCT_EXPORT_METHOD(startAudioCap)
{
    [streamer startAudioCap];
}

/**
 @abstract   进入后台: 暂停图像采集
 @discussion 暂停图像采集和预览, 中断旁路录制
 @discussion 如果需要释放mic资源请直接调用停止采集
 @discussion kit内部在收到UIApplicationDidEnterBackgroundNotification 或采集被打断等事件时,会主动调用本接口
 */
RCT_EXPORT_METHOD(appEnterBackground)
{
    [streamer appEnterBackground];
}

/**
 @abstract   回到前台: 恢复采集
 @discussion 恢复图像采集和预览
 @discussion 恢复音频采集
 @discussion kit内部在收到UIApplicationDidBecomeActiveNotification等事件时,会主动调用本接口
 */
RCT_EXPORT_METHOD(appBecomeActive)
{
    [streamer appBecomeActive];
}

/**
 @abstract   启动推流
 */
RCT_EXPORT_METHOD(startStream)
{
    //  NSLog(kitView.cameraFacing);
    NSLog(@"%@", kitView.url);
    NSURL* _hostURL = [[NSURL alloc] initWithString:kitView.url];
    [streamer.streamerBase startStream:_hostURL];
}

/**
 @abstract   停止推流
 */
RCT_EXPORT_METHOD(stopStream)
{
    [streamer.streamerBase stopStream];
}

/**
 @abstract   切换摄像头
 @return     TRUE: 成功切换摄像头， FALSE：当前参数，下一个摄像头不支持，切换失败
 */
RCT_EXPORT_METHOD(switchCamera)
{
    [streamer switchCamera];
}

/**
 @abstract   设置闪光灯
 @param      mode  AVCaptureTorchModeOn/Off
 @discussion 设置闪光灯的开关状态
 @discussion 开始预览后开始有效
 
 @see AVCaptureTorchMode
 */
RCT_EXPORT_METHOD(toggleTorch:(BOOL)toggle)
{
    AVCaptureTorchMode mode;
    if (toggle) {
        mode = AVCaptureTorchModeOn;
    } else {
        mode = AVCaptureTorchModeOff;
    }
    [streamer setTorchMode:mode];
}

// 以下为视频滤镜
/**
 @abstract   设置磨皮级别，范围0-0.8
 */
RCT_EXPORT_METHOD(setGrindRatio:(float) f)
{
    _bfFilter.grindRatio = f;
    [streamer setupFilter: _bfFilter];
}
/**
 @abstract   设置美白级别，范围0-1
 */
RCT_EXPORT_METHOD(setWhitenRatio:(float) f)
{
    _bfFilter.whitenRatio = f;
    [streamer setupFilter: _bfFilter];
}

/**
 @abstract   设置红润级别，一般范围为0-1，BeautyPro为-1.0~1.0
 */
RCT_EXPORT_METHOD(setRuddyRatio:(float) f)
{
    _bfFilter.ruddyRatio = f;
    [streamer setupFilter: _bfFilter];
}

// 以下为音频滤镜
/**
 @abstract   混响设置
 */
RCT_EXPORT_METHOD(setAudioReverbFilter:(int) i)
{
    streamer.aCapDev.reverbType = i;
}

/**
 @abstract   变声设置
 */
RCT_EXPORT_METHOD(setAudioEffectFilter:(int) i)
{
    streamer.aCapDev.effectType = i;
}

/**
 @abstract   升降调音效设置
 TODO
 */
RCT_EXPORT_METHOD(setAudioKeyEffectFilter:(int) i)
{
    //  streamer.aCapDev.effectType = i;
}

+ (KSYStreamerModule*) getInstance
{
    return single;
}

+ (void) setStreamer:(KSYGPUStreamerKit*) kit {
    streamer = kit;
}

+ (void) setKitView:(KSYStreamerUIView *)view {
    kitView = view;
    [single sendEventWithName:@"onIOSStreamerInfo" body:@{@"type": @"init", @"msg": @"inited"}];
}

/**
 向JS发送事件
 */
-(void)startObserving {
    hasListeners = YES;
    
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(onCaptureStateChange:)
                                                 name:KSYCaptureStateDidChangeNotification
                                               object:nil];
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(onStreamStateChange:)
                                                 name:KSYStreamStateDidChangeNotification
                                               object:nil];
}

-(void)stopObserving {
    hasListeners = NO;
    
    [[NSNotificationCenter defaultCenter] removeObserver:self
                                                 name:KSYCaptureStateDidChangeNotification
                                               object:nil];
    [[NSNotificationCenter defaultCenter] removeObserver:self
                                                 name:KSYStreamStateDidChangeNotification
                                               object:nil];
}

- (NSArray<NSString *> *)supportedEvents
{
    return @[@"onIOSStreamerInfo"];
}

- (void)sendEventWithType: (NSString *)type withMsg:(NSString *)msg{
    if (hasListeners) {
        [self sendEventWithName:@"onIOSStreamerInfo" body:@{@"type": type, @"msg": msg}];
    }
}

- (void) onCaptureStateChange:(NSNotification *)notification {
    if ( streamer.captureState == KSYCaptureStateIdle){
        [self sendEventWithType:@"CaptureState" withMsg:@"Idle"];
    }
    else if (streamer.captureState == KSYCaptureStateCapturing ) {
        [self sendEventWithType:@"CaptureState" withMsg:@"Capturing"];
    }
    else if (streamer.captureState == KSYCaptureStateClosingCapture ) {
        [self sendEventWithType:@"CaptureState" withMsg:@"Closing"];
    }
    else if (streamer.captureState == KSYCaptureStateDevAuthDenied ) {
        [self sendEventWithType:@"CaptureState" withMsg:@"AuthorizationDenied"];
    }
    else if (streamer.captureState == KSYCaptureStateParameterError ) {
        [self sendEventWithType:@"CaptureState" withMsg:@"ParameterErro"];
    }
    else if (streamer.captureState == KSYCaptureStateDevBusy ) {
        [self sendEventWithType:@"CaptureState" withMsg:@"Busy"];
    }
}

- (void) onStreamStateChange:(NSNotification *)notification {
    if ( streamer.streamerBase.streamState == KSYStreamStateIdle) {
        [self sendEventWithType:@"StreamState" withMsg:@"Idle"];
    }
    else if ( streamer.streamerBase.streamState == KSYStreamStateConnected){
        [self sendEventWithType:@"StreamState" withMsg:@"Connected"];
    }
    else if (streamer.streamerBase.streamState == KSYStreamStateConnecting ) {
        [self sendEventWithType:@"StreamState" withMsg:@"Connecting"];
    }
    else if (streamer.streamerBase.streamState == KSYStreamStateDisconnecting ) {
        [self sendEventWithType:@"StreamState" withMsg:@"Disconnecting"];
    }
    else if (streamer.streamerBase.streamState == KSYStreamStateError ) {
        KSYStreamErrorCode code = streamer.streamerBase.streamErrorCode;
        NSString *codeName = [streamer.streamerBase getKSYStreamErrorCodeName:code];
        [self sendEventWithName:@"onIOSStreamerInfo" body:@{@"type": @"StreamState", @"msg": @"Error", @"codeName": codeName}];
        [self sendEventWithType:@"StreamState" withMsg:@"Error"];
    }
}

@end
