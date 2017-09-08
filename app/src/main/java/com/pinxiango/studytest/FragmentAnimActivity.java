package com.pinxiango.studytest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 切换的动画   是根据 position 的 增大和减小来区分的
 * 使用两个不同的动画实现效果
 */

public class FragmentAnimActivity extends AppCompatActivity {

    private CardFragment mFrgA;
    private CardFragment mFrgB;

    private int position = 0;

    private int prePosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_anim);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mFrgA = CardFragment.newInstance("A");
        mFrgB = CardFragment.newInstance("B");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, mFrgA);
        transaction.add(R.id.container, mFrgB);
        transaction.hide(mFrgA);
        transaction.hide(mFrgB);
        transaction.commit();

    }

    public void showA(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (position == 0) {
            position = 1;
            transaction.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out);
        } else {
            position = 0;
            transaction.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_right_out);
        }
        transaction.show(mFrgA);
        transaction.hide(mFrgB);
        transaction.commit();
    }

    public void showB(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (prePosition == 0) {
            prePosition = 1;
            transaction.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out);
        } else {
            prePosition = 0;
            transaction.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_right_out);
        }
        transaction.show(mFrgB);
        transaction.hide(mFrgA);
        transaction.commit();
    }
}
