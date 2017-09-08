package com.pinxiango.studytest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * Created by 解晓辉 on 2017/9/8.
 * 作用：
 */

public class DrawableRadioButton extends RadioButton {
    public DrawableRadioButton(Context context) {
        this(context, null);
    }

    public DrawableRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        /**
         2.          * 取得自定义属性值
         3.          */
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DrawableRadioButton);
        int drawableWidth = ta.getDimensionPixelSize(R.styleable.DrawableRadioButton_drawableWidth, -1);
        int drawableHeight = ta.getDimensionPixelSize(R.styleable.DrawableRadioButton_drawableWidth, -1);
        /**
         8.          * 取得TextView的Drawable(左上右下四个组成的数组值)
         9.          */
        Drawable[] drawables = getCompoundDrawables();
        Drawable textDrawable = null;
        for (Drawable drawable : drawables) {
            if (drawable != null) {
                textDrawable = drawable;
            }
        }
        /**
         18.          * 设置宽高
         19.          */
        if (textDrawable != null && drawableWidth != -1 && drawableHeight != -1) {
            textDrawable.setBounds(0, 0, drawableWidth, drawableHeight);
        }
        /**
         24.          * 设置给TextView
         25.          */
        setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
        /**
         28.          * 回收ta
         29.          */
        ta.recycle();


    }


}
