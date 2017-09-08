package com.pinxiango.studytest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by 解晓辉 on 2017/9/8.
 * 作用：
 */

public class CardFragmentAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> mFragments;

    public CardFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
