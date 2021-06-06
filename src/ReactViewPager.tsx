import React from 'react';
import {requireNativeComponent} from 'react-native';

export interface INativeImageProps {
  url: string;
  style:any;
}

export class NativeImage extends React.Component<INativeImageProps> {
  render() {
    return <NativeImageView {...this.props} />;
  }
}

const NativeImageView = requireNativeComponent('RnImageView');
