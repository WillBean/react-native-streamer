import React, { Component } from 'react';
import {
  View,
  Platform,
  NativeModules,
  DeviceEventEmitter,
  requireNativeComponent
} from 'react-native';
import PropTypes from 'prop-types';

const KSYStreamer = requireNativeComponent('KSYStreamerManager', Streamer);
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
      this.subscription = streamerEmitter.addListener('onIOSStreamerInfo', onStreamerInfo);
    } else {
      this.infoListener = DeviceEventEmitter.addListener('onStreamerInfoListener', onStreamerInfo);
      this.errorListener = DeviceEventEmitter.addListener('onStreamerErrorListener', onStreamerError);
    }
  }

  componentWillUnmount() {
    if (Platform.OS === 'ios') {
      this.subscription.remove();
    } else {
      this.infoListener.remove();
      this.errorListener.remove();
    }
  }

  render() {
    return <KSYStreamer {...this.props } />
  }
}
