package com.pinxiango.studytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pinxiango.studytest.adapter.CommonAdapter;
import com.pinxiango.studytest.adapter.CommonViewHolder;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import static com.pinxiango.studytest.TransitionTestActivity.TRANSIT_PIC;

public class MainActivity extends AppCompatActivity implements OnBannerListener {

    ViewPager view_pager;
    private ArrayList<ImageView> imageViews;
    int[] imgs = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.image4, R.mipmap.image5, R.mipmap.image6, R.mipmap.image7, R.mipmap.image8, R.mipmap.image1
    };
    List<Integer> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        view_pager.setOffscreenPageLimit(5);

        initData();
        initViewpager();
    }

    private void initViewpager() {

        //设置Page间间距
        view_pager.setPageMargin(20);
        view_pager.setPageTransformer(false, new CustomTransformer());
        view_pager.setAdapter(new CommonAdapter<Integer>(this, mList, R.layout.image) {
            @Override
            protected void convert(CommonViewHolder commonViewHolder, Integer item, int position) {
                commonViewHolder.setImageResource(R.id.image_icon, item);
            }
        });
        view_pager.setCurrentItem(1);

//        view_pager.setCurrentItem(imageViews.size() * 500 / 2);
    }

    @Override
    public void OnBannerClick(int position) {
        Intent intent = new Intent(this, TransitionTestActivity.class);
        intent.putExtra("url", imgs[position]);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, view_pager, TRANSIT_PIC);//与xml文件对应
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

    private void initData() {
        for (int i = 0; i < imgs.length; i++) {
            mList.add(imgs[i]);
        }
    }

    class MyPagerAdapter extends PagerAdapter {

        /**
         * 相当于getView方法
         *
         * @param container ViewPager容器
         * @param position  要创建页面的位置
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            int relPosition = position % imgs.length;
            final ImageView imageView = new ImageView(container.getContext());
            imageView.setImageResource(imgs[relPosition]);
            //添加到容器(ViewPager)中
            container.addView(imageView);
            Log.e("MainActivity", "instantiateItem==position==" + position);
            return imageView;
        }

        /**
         * 比较视图是否是同一个页面
         *
         * @param view   比较的页面
         * @param object 由instantiateItem返回回来的值
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 销毁某一条
         *
         * @param container
         * @param position
         * @param object
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            Log.e("MainActivity", "destroyItem==position==" + position);
        }

        /**
         * 得到数据的总条数
         *
         * @return
         */
        @Override
        public int getCount() {
//            return imageViews.size();
            return imageViews.size() * 500;
        }


    }


}
