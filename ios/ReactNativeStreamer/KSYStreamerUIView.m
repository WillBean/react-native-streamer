//
//  KSYStreamerUIView.m
//  LivePlayerIOS
//
//  Created by bytedance on 2018/2/3.
//  Copyright © 2018年 Facebook. All rights reserved.
//

#import "KSYStreamerUIView.h"

@implementation KSYStreamerUIView

- (instancetype) init
{
    if (!_streamer) {
        _streamer = [[KSYGPUStreamerKit alloc] initWithDefaultCfg];
    }
    if (!_view) {
        _view = [super init];
    }
    [KSYStreamerModule setStreamer:_streamer];
    [KSYStreamerModule setKitView:_view];
    return _view;
}

@end
