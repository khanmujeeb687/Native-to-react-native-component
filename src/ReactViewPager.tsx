import React from 'react';
import {requireNativeComponent} from 'react-native';

export interface INativeImageProps {
  url: string;
  style: any;
  onSuccess: (data: any) => void;
  onFailure: (data: any) => void;
}

export class NativeImage extends React.Component<INativeImageProps> {
  render() {
    return <NativeImageView {...this.props} />;
  }
}

const NativeImageView = requireNativeComponent('RnImageView');
