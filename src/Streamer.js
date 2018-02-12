import React, { Component } from 'react';
import {
  View,
  Platform,
  NativeModules,
  NativeEventEmitter,
  DeviceEventEmitter,
  requireNativeComponent
} from 'react-native';
import PropTypes from 'prop-types';

const KSYStreamer = requireNativeComponent('KSYStreamer', Streamer);
const { KSYStreamerModule } = NativeModules;
const streamerEmitter = new NativeEventEmitter(KSYStreamerModule);

export default class Streamer extends Component {
  static propTyps = {
    url: PropTypes.string,
    cameraFacing: PropTypes.number,
    ...View.propTypes
  }

  componentWillMount() {
    const {onStreamerInfo, onStreamerError} = this.props;
    if (Platform.OS === 'ios') {
      if (onStreamerInfo)
        this.subscription = streamerEmitter.addListener('onIOSStreamerInfo', onStreamerInfo);
    } else {
      if (onStreamerInfo)
        this.infoListener = DeviceEventEmitter.addListener('onStreamerInfoListener', onStreamerInfo);
      if (onStreamerError)
        this.errorListener = DeviceEventEmitter.addListener('onStreamerErrorListener', onStreamerError);
    }
  }

  componentWillUnmount() {
    const {onStreamerInfo, onStreamerError} = this.props;
    if (Platform.OS === 'ios') {
      onStreamerInfo && this.subscription.remove();
    } else {
      onStreamerInfo && this.infoListener.remove();
      onStreamerError && this.errorListener.remove();
    }
  }

  render() {
    return <KSYStreamer {...this.props} />
  }
}
