//
//  KSYPlayerModule.h
//  ReactNativeStreamer
//
//  Created by bytedance on 2018/2/21.
//  Copyright © 2018年 bytedance. All rights reserved.
//

#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>
#import <libksygpulive/libksygpulive.h>

@interface KSYPlayerModule : RCTEventEmitter <RCTBridgeModule>

- (instancetype) init;
+ (void) setPlayer: (KSYMoviePlayerController *) kit;

@end
