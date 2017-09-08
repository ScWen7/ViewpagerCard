package com.pinxiango.studytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TransitionTestActivity extends AppCompatActivity {

    public static final String TRANSIT_PIC = "picture";

//    PhotoView picture_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_test);
//        picture_img = (PhotoView)findViewById(picture_img);
//        ViewCompat.setTransitionName(picture_img, TRANSIT_PIC);
//        String url = getIntent().getStringExtra("url");
//        Glide.with(this)
//                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(new SimpleTarget<GlideDrawable>() {
//                    @Override
//                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                        picture_img.setImageDrawable(resource);
//                    }
//                });
    }
}
