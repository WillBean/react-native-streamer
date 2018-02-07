//
//  KSYStreamerManager.m
//  LivePlayerIOS
//
//  Created by bytedance on 2018/1/30.
//  Copyright © 2018年 Facebook. All rights reserved.
//
#import <React/RCTViewManager.h>
#import <GPUImage/GPUImage.h>
#import <libksygpulive/KSYGPUStreamerKit.h>

#import "KSYStreamerModule.h"
#import "KSYStreamerUIView.h"

@interface KSYStreamerManager : RCTViewManager
@end

KSYGPUStreamerKit * kit;
UIView * kitView;

NSString *kitUrl;

@implementation KSYStreamerManager

RCT_EXPORT_MODULE();

- (UIView *)view
{
  return [[KSYStreamerUIView alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(url, NSString);

RCT_EXPORT_VIEW_PROPERTY(cameraFacing, NSInteger);

@end
