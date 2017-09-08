package com.pinxiango.studytest;

import android.animation.FloatEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by 解晓辉 on 2017/9/8.
 * 作用：
 */

public class CradTranformer implements ViewPager.PageTransformer {

    public static final int MAX_ELEVATION_FACTOR = 8; //这是Elevation 改变的倍数
    private static final float MIN_SCALE = 0.9F;
    private static final float MIN_ALPHA = 0.6F;
    private float mBaseElevation;

    public CradTranformer(float baseElevation) {
        this.mBaseElevation = baseElevation;
    }

    public void transformPage(View page, float position) {

        CardView cardView = null;

        //类型转换保证安全
        if (page instanceof CardView) {
            cardView = (CardView) page;
        }

        if (position < -1.0F) {
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
            page.setAlpha(MIN_ALPHA);
            if (cardView != null) {
                cardView.setCardElevation(mBaseElevation);
            }
        } else if (position <= 1.0F) {


            if (position < 0) //[0，-1]
            {
                float faction = position / (-1F);
                float factor = new FloatEvaluator().evaluate(faction, 1f, MIN_SCALE);
                page.setScaleX(factor);
                page.setScaleY(factor);
                float alphaFactor = new FloatEvaluator().evaluate(faction, 1f, MIN_ALPHA);
                page.setAlpha(alphaFactor);

                if (cardView != null) {
                    float elevation = new FloatEvaluator().evaluate(faction, mBaseElevation * MAX_ELEVATION_FACTOR, mBaseElevation);
                    cardView.setCardElevation(elevation);
                }
            } else//[1，0]
            {
                float faction = 1 - position / (1F);
                float factor = new FloatEvaluator().evaluate(faction, MIN_SCALE, 1f);
                page.setScaleX(factor);
                page.setScaleY(factor);

                float alphaFactor = new FloatEvaluator().evaluate(faction, MIN_ALPHA, 1f);
                page.setAlpha(alphaFactor);
                if (cardView != null) {
                    float elevation = new FloatEvaluator().evaluate(faction, mBaseElevation, mBaseElevation * MAX_ELEVATION_FACTOR);
                    cardView.setCardElevation(elevation);
                }
            }

        } else {
            page.setScaleY(MIN_SCALE);
            page.setScaleX(MIN_SCALE);
            page.setAlpha(MIN_ALPHA);
            if (cardView != null) {
                cardView.setCardElevation(mBaseElevation);
            }
        }

    }
}
