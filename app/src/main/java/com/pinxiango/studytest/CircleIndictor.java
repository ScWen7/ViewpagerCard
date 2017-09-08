package com.pinxiango.studytest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 解晓辉 on 2017/6/19.
 * 作用：
 */

public class CircleIndictor extends View {

    private int radius = DisplayUtils.dpToPx(10);
    private int strokeWidth = DisplayUtils.dpToPx(1);
    private int mSpace = DisplayUtils.dpToPx(20);
    private int count = 5;

    private List<PointF> mPositions = new ArrayList<>();


    private Paint circlePaint;
    private Paint textPaint;

    private int selectPosition = 4;

    private int dotNormalColor = Color.GRAY;
    private int dotSelectColor = Color.GREEN;

    public CircleIndictor(Context context) {
        super(context);

        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        circlePaint = new Paint();
        circlePaint.setDither(true); // 设置防抖动
        circlePaint.setAntiAlias(true); //抗锯齿

        textPaint = new Paint();
        textPaint.setDither(true);
        textPaint.setAntiAlias(true);
    }

    public CircleIndictor(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = radius * 2 + strokeWidth * 2 + mSpace * (count - 1);  //宽度
        int height = radius + 2 + strokeWidth * 2;  //高度
        initPosition();
        setMeasuredDimension(width, height);
    }


    private void initPosition() {
        float toX = 0;
        for (int i = 0; i < count; i++) {
            PointF pointF = new PointF();
            if (i == 0) {
                toX = radius + strokeWidth;
            } else {
                toX += radius * 2 + strokeWidth * 2 + mSpace;
            }
            pointF.x = toX;
            pointF.y = radius + strokeWidth;
            mPositions.add(pointF);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (int i = 0; i < mPositions.size(); i++) {

            PointF indicator = mPositions.get(i);
            float x = indicator.x;

            float y = indicator.y;

            if (selectPosition == i) {
                circlePaint.setStyle(Paint.Style.FILL);
                circlePaint.setColor(dotSelectColor);
            } else {
                circlePaint.setColor(dotNormalColor);

                circlePaint.setStyle(Paint.Style.FILL);

            }
            //绘制圆形
            canvas.drawCircle(x, y, radius, circlePaint);


        }
    }

    enum IndictorStyle {
        Circle
    }
}
