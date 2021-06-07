package com.rnslider.slider_app;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.squareup.picasso.Picasso;

import java.util.Map;

class ReactImageViewManager extends SimpleViewManager<ImageView> {

    public static final String REACT_CLASS = "RnImageView";
    private ThemedReactContext context;
    @Override
    public String getName() {
        return REACT_CLASS;
    }



    @Override
    protected ImageView createViewInstance(ThemedReactContext reactContext) {
        this.context=reactContext;
        return new ImageView(reactContext);
    }


    @ReactProp(name = "url")
    public void setUrls(ImageView view, @Nullable String url) {
        if(url==null) return;
        Picasso.with(context).load(url).into(view,new com.squareup.picasso.Callback() {
            WritableMap event = Arguments.createMap();

            @Override
            public void onSuccess() {
                emitEvent(event,"onSuccess",view.getId());
            }
            @Override
            public void onError() {
                emitEvent(event,"onError",view.getId());
            }
        });
    }

    @Override
    public @Nullable
    Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder<String, Object> builder = MapBuilder.builder();
        builder.put("onVideoChange", MapBuilder.of("registrationName", "onVideoChange"));
        builder.put("onEndReached", MapBuilder.of("registrationName", "onEndReached"));
        return builder.build();
    }


    private void emitEvent(WritableMap eventData, String eventName,int viewId){
        context.getJSModule(RCTEventEmitter.class).receiveEvent(viewId, eventName, eventData);
    }



}