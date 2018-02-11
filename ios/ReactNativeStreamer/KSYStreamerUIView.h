//
//  KSYStreamerUIView.h
//  LivePlayerIOS
//
//  Created by bytedance on 2018/2/3.
//  Copyright © 2018年 Facebook. All rights reserved.
//

#import <GPUImage/GPUImage.h>
#import <libksygpulive/KSYGPUStreamerKit.h>
#import "KSYStreamerModule.h"

@interface KSYStreamerUIView : UIView

@property (nonatomic, readwrite) KSYGPUStreamerKit * streamer;

@property (nonatomic, readwrite) KSYStreamerUIView * view;

@property (nonatomic, copy) NSString * url;

@property (nonatomic) NSInteger * cameraFacing;

- (instancetype) init;

@end
