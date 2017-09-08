package com.pinxiango.studytest;

import android.animation.FloatEvaluator;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by 解晓辉 on 2017/6/19.
 * 作用：
 */

public class CustomTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.9F;
    private static final float MIN_ALPHA = 0.6F;

    public CustomTransformer() {
    }

    public void transformPage(View page, float position) {
        if (position < -1.0F) {
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
            page.setAlpha(MIN_ALPHA);
        } else if (position <= 1.0F) {
//            float scale = Math.max(0.9F, 1.0F - Math.abs(position));
//            page.setScaleY(scale);
//            float ALPHA = Math.max(MIN_ALPHA, 1.0F - Math.abs(position));
//            page.setAlpha(ALPHA);

            if (position < 0) //[0，-1]
            {
                Log.e("TAG", "position:" + position);
                float factor = new FloatEvaluator().evaluate(position / (-1F), 1f, MIN_SCALE);
                page.setScaleX(factor);
                page.setScaleY(factor);
                float alphaFactor = new FloatEvaluator().evaluate(position / (-1f), 1f, MIN_ALPHA);
                page.setAlpha(alphaFactor);

            } else//[1，0]
            {
                float faction = 1 - position / (1F);
                float factor = new FloatEvaluator().evaluate(faction, MIN_SCALE, 1f);
                page.setScaleX(factor);
                page.setScaleY(factor);

                float alphaFactor = new FloatEvaluator().evaluate(faction, MIN_ALPHA, 1f);
                page.setAlpha(alphaFactor);
            }

        } else {
            page.setScaleY(MIN_SCALE);
            page.setScaleX(MIN_SCALE);
            page.setAlpha(MIN_ALPHA);
        }

    }
}
