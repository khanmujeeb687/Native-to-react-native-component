package com.rnslider.slider_app;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.squareup.picasso.Picasso;

class ReactImageViewManager extends SimpleViewManager<ImageView> {

    public static final String REACT_CLASS = "RnImageView";
    private Context context;
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
        Picasso.with(context).load(url).into(view);
    }



}