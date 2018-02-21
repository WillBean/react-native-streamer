//
//  KSYPlayerManager.m
//  ReactNativeStreamer
//
//  Created by bytedance on 2018/2/21.
//  Copyright © 2018年 bytedance. All rights reserved.
//

#import <React/RCTViewManager.h>
#import <libksygpulive/libksygpulive.h>

#import "KSYPlayerModule.h"
#import "KSYPlayerUIView.h"

@interface KSYPlayerManager : RCTViewManager

@property (nonatomic) KSYPlayerUIView *playerView;

@end

@implementation KSYPlayerManager

RCT_EXPORT_MODULE();

- (UIView *)view
{
    _playerView = [[KSYPlayerUIView alloc] init];
    return _playerView;
}

RCT_EXPORT_VIEW_PROPERTY(url, NSString);

@end
