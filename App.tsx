import React from 'react';
import {SafeAreaView} from 'react-native';
import {NativeImage} from './src/ReactViewPager';

const App = () => {
  return (
    <SafeAreaView style={{flex: 1, backgroundColor: 'black'}}>
      <NativeImage
        onFailure={(data: any) => {
          console.log(data.nativeEvent);
        }}
        onSuccess={(data: any) => {}}
        style={{flex: 1}}
        url={
          'https://cdn.vox-cdn.com/thumbor/CoDA71sGX9lAX1rXC' +
          'cwtLCT91BY=/0x0:4500x3214/920x613/filters:focal(185' +
          '7x436:2577x1156):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/69377458/1232945457.0.jpg'
        }
      />
    </SafeAreaView>
  );
};

export default App;
