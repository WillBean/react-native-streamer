//
//  KSYPlayerUIView.m
//  ReactNativeStreamer
//
//  Created by bytedance on 2018/2/21.
//  Copyright © 2018年 bytedance. All rights reserved.
//

#import "KSYPlayerUIView.h"

@implementation KSYPlayerUIView

- (instancetype) init
{
    if (!_view) {
        _view = [super init];
    }
    return _view;
}

- (void) setUrl:(NSString *)url
{
    _url = url;
    
    _view.frame = CGRectMake( 0, 0,  self.view.bounds.size.width,  self.view.bounds.size.height);
    _view.backgroundColor = [UIColor lightGrayColor];
    _player = [[KSYMoviePlayerController alloc] initWithContentURL: [NSURL URLWithString:_url]];
    _player.controlStyle = MPMovieControlStyleNone;
    [_player.view setFrame: _view.bounds];  // player's frame must match parent's
    [_view addSubview: _player.view];
    _view.autoresizesSubviews = TRUE;
    _player.view.autoresizingMask = UIViewAutoresizingFlexibleWidth|UIViewAutoresizingFlexibleHeight;
    _player.shouldAutoplay = TRUE;
    _player.scalingMode = MPMovieScalingModeAspectFit;
    [KSYPlayerModule setPlayer: _player];
}

@end
