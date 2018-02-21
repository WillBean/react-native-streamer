//
//  KSYStremaerModule.m
//  LivePlayerIOS
//
//  Created by bytedance on 2018/1/29.
//  Copyright © 2018年 Facebook. All rights reserved.
//
#import "KSYPlayerModule.h"

@implementation KSYPlayerModule {
    bool hasListeners;
}

static KSYMoviePlayerController * player;
static KSYPlayerModule * single;

RCT_EXPORT_MODULE();

/**
 复写初始化方法，获取类实例对象
 @return 当前类实例
 */
- (instancetype) init
{
    single = [super init];
    return single;
}

RCT_EXPORT_METHOD(prepareToPlay)
{
    [player prepareToPlay];
}

RCT_EXPORT_METHOD(stop)
{
    [player stop];
}

+ (void) setPlayer:(KSYMoviePlayerController *)kit {
    player = kit;
    [single sendEventWithType:@"inited"];
}

/**
 向JS发送事件
 */
-(void)startObserving {
    hasListeners = YES;
    
    // 播放器完成对视频文件的初始化时发送此通知
    [[NSNotificationCenter defaultCenter]addObserver:self
                                            selector:@selector(onMPMediaPlaybackIsPreparedToPlayDidChangeNotification:)
                                                name:(MPMediaPlaybackIsPreparedToPlayDidChangeNotification)
                                              object:nil];
    // 播放状态发生改变时发送此通知
    [[NSNotificationCenter defaultCenter]addObserver:self
                                            selector:@selector(onMPMoviePlayerPlaybackStateDidChangeNotification:)
                                                name:(MPMoviePlayerPlaybackStateDidChangeNotification)
                                              object:nil];
    // 正常播放结束或者因为错误播放失败时发送此通知
    [[NSNotificationCenter defaultCenter]addObserver:self
                                            selector:@selector(onMPMoviePlayerPlaybackDidFinishNotification:)
                                                name:(MPMoviePlayerPlaybackDidFinishNotification)
                                              object:nil];
    // 数据加载状态发生改变时发送此通知
    [[NSNotificationCenter defaultCenter]addObserver:self
                                            selector:@selector(onMPMoviePlayerLoadStateDidChangeNotification:)
                                                name:(MPMoviePlayerLoadStateDidChangeNotification)
                                              object:nil];
    // 第一次检测出视频的宽高或者播放过程中宽高发生改变时发送此通知
    [[NSNotificationCenter defaultCenter]addObserver:self
                                            selector:@selector(onMPMovieNaturalSizeAvailableNotification:)
                                                name:(MPMovieNaturalSizeAvailableNotification)
                                              object:nil];
    // 渲染第一帧视频时发送此通知
    [[NSNotificationCenter defaultCenter]addObserver:self
                                            selector:@selector(onMPMoviePlayerFirstVideoFrameRenderedNotification:)
                                                name:(MPMoviePlayerFirstVideoFrameRenderedNotification)
                                              object:nil];
    // 渲染第一帧音频时发送此通知
    [[NSNotificationCenter defaultCenter]addObserver:self
                                            selector:@selector(onMPMoviePlayerFirstAudioFrameRenderedNotification:)
                                                name:(MPMoviePlayerFirstAudioFrameRenderedNotification)
                                              object:nil];
    // 为提升开播速度，播放器在查找文件格式时只检查少量的数据，如果音视频数据交织情况较差，会导致播放器认为当前码流中只含有视频或者音频数据；但是在播放过程中，发现实际上存在着未检测到的音频或者视频流，此时播放器会发送此通知
    [[NSNotificationCenter defaultCenter]addObserver:self
                                            selector:@selector(onMPMoviePlayerSuggestReloadNotification:)
                                                name:(MPMoviePlayerSuggestReloadNotification)
                                              object:nil];
    // 当播放过程中发生需要上层注意的事件时发送此通知，如实际采用的视频解码方式、解码出现错误等...
    [[NSNotificationCenter defaultCenter]addObserver:self
                                            selector:@selector(onMPMoviePlayerPlaybackStatusNotification:)
                                                name:(MPMoviePlayerPlaybackStatusNotification)
                                              object:nil];
}

-(void)stopObserving {
    hasListeners = NO;
    [[NSNotificationCenter defaultCenter]removeObserver:self
                                                   name:MPMediaPlaybackIsPreparedToPlayDidChangeNotification
                                                 object:nil];
    [[NSNotificationCenter defaultCenter]removeObserver:self
                                                   name:MPMoviePlayerPlaybackStateDidChangeNotification
                                                 object:nil];
    [[NSNotificationCenter defaultCenter]removeObserver:self
                                                   name:MPMoviePlayerPlaybackDidFinishNotification
                                                 object:nil];
    [[NSNotificationCenter defaultCenter]removeObserver:self
                                                   name:MPMoviePlayerLoadStateDidChangeNotification
                                                 object:nil];
    [[NSNotificationCenter defaultCenter]removeObserver:self
                                                   name:MPMovieNaturalSizeAvailableNotification
                                                 object:nil];
    [[NSNotificationCenter defaultCenter]removeObserver:self
                                                   name:MPMoviePlayerFirstVideoFrameRenderedNotification
                                                 object:nil];
    [[NSNotificationCenter defaultCenter]removeObserver:self
                                                   name:MPMoviePlayerFirstAudioFrameRenderedNotification
                                                 object:nil];
    [[NSNotificationCenter defaultCenter]removeObserver:self
                                                   name:MPMoviePlayerSuggestReloadNotification
                                                 object:nil];
    [[NSNotificationCenter defaultCenter]removeObserver:self
                                                   name:MPMoviePlayerPlaybackStatusNotification
                                                 object:nil];
}

- (NSArray<NSString *> *)supportedEvents
{
    return @[@"onIOSPlayerInfo"];
}

- (void)sendEventWithType: (NSString *)type {
    if (hasListeners) {
        [self sendEventWithName:@"onIOSPlayerInfo" body:@{@"type": type}];
    }
}

- (void) onMPMediaPlaybackIsPreparedToPlayDidChangeNotification:(NSNotification *)notification {
    [self sendEventWithType:@"MPMediaPlaybackIsPreparedToPlayDidChangeNotification"];
}

- (void) onMPMoviePlayerPlaybackStateDidChangeNotification:(NSNotification *)notification {
    [self sendEventWithType:@"MPMoviePlayerPlaybackStateDidChangeNotification"];
}

- (void) onMPMoviePlayerPlaybackDidFinishNotification:(NSNotification *)notification {
    [self sendEventWithType:@"MPMoviePlayerPlaybackDidFinishNotification"];
}

- (void) onMPMoviePlayerLoadStateDidChangeNotification:(NSNotification *)notification {
    [self sendEventWithType:@"MPMoviePlayerLoadStateDidChangeNotification"];
}

- (void) onMPMovieNaturalSizeAvailableNotification:(NSNotification *)notification {
    [self sendEventWithType:@"MPMovieNaturalSizeAvailableNotification"];
}

- (void) onMPMoviePlayerFirstVideoFrameRenderedNotification:(NSNotification *)notification {
    [self sendEventWithType:@"MPMoviePlayerFirstVideoFrameRenderedNotification"];
}

- (void) onMPMoviePlayerFirstAudioFrameRenderedNotification:(NSNotification *)notification {
    [self sendEventWithType:@"MPMoviePlayerFirstAudioFrameRenderedNotification"];
}

- (void) onMPMoviePlayerSuggestReloadNotification:(NSNotification *)notification {
    [self sendEventWithType:@"MPMoviePlayerSuggestReloadNotification"];
}

- (void) onMPMoviePlayerPlaybackStatusNotification:(NSNotification *)notification {
    [self sendEventWithType:@"MPMoviePlayerPlaybackStatusNotification"];
}
@end
