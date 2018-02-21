//
//  KSYPlayerUIView.h
//  ReactNativeStreamer
//
//  Created by bytedance on 2018/2/21.
//  Copyright © 2018年 bytedance. All rights reserved.
//

#import <React/RCTViewManager.h>
#import <libksygpulive/libksygpulive.h>
#import "KSYPlayerModule.h"

@interface KSYPlayerUIView : UIView

@property (nonatomic, readwrite) KSYMoviePlayerController * player;

@property (nonatomic, readwrite) KSYPlayerUIView * view;

@property (nonatomic, copy) NSString * url;

- (instancetype) init;

@end
