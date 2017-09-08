package com.pinxiango.studytest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {


    private ViewPager view_pager;
    private List<Fragment> mFragments;

    private String[] images = {
            "http://oqe10cpgp.bkt.clouddn.com/image/greateimage/01.jpg",
            "http://oqe10cpgp.bkt.clouddn.com/image/greateimage/02.jpg",
            "http://oqe10cpgp.bkt.clouddn.com/image/greateimage/03.jpg",
            "http://oqe10cpgp.bkt.clouddn.com/image/greateimage/04.jpg",
            "http://oqe10cpgp.bkt.clouddn.com/image/greateimage/05.jpg",
            "http://oqe10cpgp.bkt.clouddn.com/image/greateimage/06.jpg",
    };

    private List<CardItem> mCardItems;

    private String link = "http://www.artbloger.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        view_pager.setOffscreenPageLimit(3);

        initCardItems();
        initFragments();

        view_pager.setPageTransformer(false, new CradTranformer(dpToPixels(2, this)));

        CardFragmentAdapter cardFragmentAdapter = new CardFragmentAdapter(getSupportFragmentManager(), mFragments);
        view_pager.setAdapter(cardFragmentAdapter);

    }

    private void initCardItems() {
        mCardItems = new ArrayList<>();
        String content = getString(R.string.content);
        for (int i = 0; i < images.length; i++) {
            mCardItems.add(new CardItem(images[i], content, link));
        }
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mCardItems.size(); i++) {
            mFragments.add(CardFragment.newInstance(mCardItems.get(i)));
        }
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }


}
