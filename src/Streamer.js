import React, { Component } from 'react';
import {
    View,
    requireNativeComponent
} from 'react-native';
import PropTypes from 'prop-types';

const KSYStreamer = requireNativeComponent('KSYStreamer', Streamer);

export default class Streamer extends Component {
    static propTyps = {
        url: PropTypes.string,
        cameraFacing: PropTypes.number,
        ...View.propTypes
    }

    render() {
        return <KSYStreamer {...this.props }
        />
    }
}