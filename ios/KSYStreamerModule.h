//
//  KSYStreamerManager.h
//  LivePlayerIOS
//
//  Created by bytedance on 2018/1/30.
//  Copyright © 2018年 Facebook. All rights reserved.
//
#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>
#import <GPUImage/GPUImage.h>
#import <libksygpulive/KSYGPUStreamerKit.h>
#import <libksygpulive/KSYBeautifyProFilter.h>

@interface KSYStreamerModule : RCTEventEmitter <RCTBridgeModule>

@property (nonatomic) KSYBeautifyFaceFilter * bfFilter;

- (instancetype) init;
+ (void) setStreamer: (KSYGPUStreamerKit*) kit;
+ (void) setKitView: (UIView*) view;

@end
