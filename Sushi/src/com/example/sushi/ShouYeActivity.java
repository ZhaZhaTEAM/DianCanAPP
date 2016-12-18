package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jc.store.R;
import com.example.jc.store.com.team.helper.ActivityManagerUtils;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * “首页”页面
 *
 * @author JC
 */
public class ShouYeActivity extends Activity{
    private ImageView nanpiao, nvpiao, fumu, baobei, jiyou, guimi;
    private int imageIds[];
    private String[] titles;
    private ArrayList<ImageView> images;
    private ArrayList<View> dots;
    private TextView title;
    private ViewPager mViewPager;
    private ViewPagerAdapter adapter;
    private int oldPosition = 0;//记录上一次点的位置
    private int currentItem; //当前页面
    private ScheduledExecutorService scheduledExecutorService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1);
     /*   if (!CacheActivity.activityList.contains(ShouYeActivity.this)) {
            CacheActivity.addActivity(ShouYeActivity.this);
        }*/
        ActivityManagerUtils.getInstance().addActivity(this);
        nanpiao = (ImageView) findViewById(R.id.naopiao);
        nvpiao = (ImageView) findViewById(R.id.nvpiao);
        fumu = (ImageView) findViewById(R.id.fumu);
        baobei = (ImageView) findViewById(R.id.baobei);
        jiyou = (ImageView) findViewById(R.id.jiyou);
        guimi = (ImageView) findViewById(R.id.guimi);

        //图片ID
        imageIds = new int[]{
                R.drawable.baobei_1,
                R.drawable.fengmian_1,
                R.drawable.jiyou_1,
                R.drawable.nanpiao_1,
                R.drawable.guimi_2
        };

        //图片标题
        titles = new String[]{
                "军舰",
                "刺身",
                "前菜",
                "寿司",
                "小卷"
        };

        //显示的图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);

            images.add(imageView);

        }

        //显示的点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));
        dots.add(findViewById(R.id.dot_4));

        title = (TextView) findViewById(R.id.title);
        title.setText(titles[0]);

        mViewPager = (ViewPager) findViewById(R.id.vp);

        adapter = new ViewPagerAdapter();
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(1);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                title.setText(titles[position]);

                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
                dots.get(position).setBackgroundResource(R.drawable.dot_focused);

                oldPosition = position;
                currentItem = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        nanpiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ShouYeActivity.this, GoodListActivity.class);
                intent1.putExtra("index", 1);
                startActivity(intent1);
            }
        });

        nvpiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ShouYeActivity.this, GoodListActivity.class);
                intent1.putExtra("index", 2);
                startActivity(intent1);
            }
        });

        fumu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ShouYeActivity.this, GoodListActivity.class);
                intent1.putExtra("index", 3);
                startActivity(intent1);
            }
        });

        baobei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ShouYeActivity.this, GoodListActivity.class);
                intent1.putExtra("index", 4);
                startActivity(intent1);
            }
        });

        jiyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ShouYeActivity.this, GoodListActivity.class);
                intent1.putExtra("index", 5);
                startActivity(intent1);
            }
        });

        guimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ShouYeActivity.this, GoodListActivity.class);
                intent1.putExtra("index", 6);
                startActivity(intent1);
            }
        });
    }




 /*   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.img_list);





    }*/


    private class ViewPagerAdapter extends PagerAdapter {

        @Override


        public int getCount() {
            // TODO Auto-generated method stub
            return images.size();

        }


        //是否是同一张图片

        @Override


        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;

        }


        @Override

        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
            //            super.destroyItem(container, position, object);
            //            view.removeViewAt(position);
            view.removeView(images.get(position));


        }


        @Override


        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));

            return images.get(position);

        }


    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        //每隔2秒钟切换一张图片

        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(), 2, 2, TimeUnit.SECONDS);

    }

    //切换图片


    private class ViewPagerTask implements Runnable {


        @Override
        public void run() {
            // TODO Auto-generated method stub
            currentItem = (currentItem + 1) % imageIds.length;
            //更新界面
            //            handler.sendEmptyMessage(0);
            handler.obtainMessage().sendToTarget();

        }


    }


    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            //设置当前页面
            mViewPager.setCurrentItem(currentItem);

        }

    };

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();

    }

    /*public void click(View view) {
        switch (view.getId()) {
            case R.id.naopiao:
                Intent intent1 = new Intent(this, GoodListActivity.class);
                intent1.putExtra("index", 1);
                startActivity(intent1);
                break;
            case R.id.nvpiao:
                Intent intent2 = new Intent(this, GoodListActivity.class);
                intent2.putExtra("index", 2);
                startActivity(intent2);
                break;
            case R.id.fumu:
                Intent intent3 = new Intent(this, GoodListActivity.class);
                intent3.putExtra("index", 3);
                startActivity(intent3);
                break;
            case R.id.baobei:
                Intent intent4 = new Intent(this, GoodListActivity.class);
                intent4.putExtra("index", 4);
                startActivity(intent4);
                break;
            case R.id.jiyou:
                Intent intent5 = new Intent(this, GoodListActivity.class);
                intent5.putExtra("index", 5);
                startActivity(intent5);
                break;
            case R.id.guimi:
                Intent intent6 = new Intent(this, GoodListActivity.class);
                intent6.putExtra("index", 6);
                startActivity(intent6);
                break;

        }
    }
*/

}
