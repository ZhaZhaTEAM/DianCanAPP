package com.example.jc.store.com.team.activity;


import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.jc.store.R;
import com.example.jc.store.com.team.helper.ActivityManagerUtils;

import java.util.ArrayList;
import java.util.List;

public class LoginSuccessActivity extends Activity {


    Context context = null;
    LocalActivityManager manager = null;
    ViewPager pager = null;
    TabHost tabHost = null;
    TextView t1, t2, t3;

    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度
    private ImageView cursor;// 动画图片

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsuccess);

       /* if (!CacheActivity.activityList.contains(LoginSuccessActivity.this)) {
            CacheActivity.addActivity(LoginSuccessActivity.this);
        }*/
        ActivityManagerUtils.getInstance().addActivity(this);

        context = LoginSuccessActivity.this;
        manager = new LocalActivityManager(this, true);
        manager.dispatchCreate(savedInstanceState);

        InitImageView();
        initTextView();
        initPagerViewer();

    }

    /**
     * 初始化标题
     */
    private void initTextView() {
        t1 = (TextView) findViewById(R.id.text1);
        t2 = (TextView) findViewById(R.id.text2);
        t3 = (TextView) findViewById(R.id.text3);

        t1.setOnClickListener(new MyOnClickListener(0));
        t2.setOnClickListener(new MyOnClickListener(1));
        t3.setOnClickListener(new MyOnClickListener(2));

    }

    /**
     * 初始化PageViewer
     */
    private void initPagerViewer() {
        pager = (ViewPager) findViewById(R.id.viewpage);
        final ArrayList<View> list = new ArrayList<View>();
        Intent intent = new Intent(context, ShouYeActivity.class);
        list.add(getView("A", intent));
        Intent intent2 = new Intent(context, GouWuCheActivity.class);
        list.add(getView("B", intent2));
        Intent intent3 = new Intent(context, MineActivity.class);
        list.add(getView("C", intent3));

        pager.setAdapter(new MyPagerAdapter(list));
        pager.setCurrentItem(0);
        pager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    /**
     * 初始化动画
     */
    private void InitImageView() {
        cursor = (ImageView) findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.roller)
                .getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW / 3 - bmpW) / 2;// 计算偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        cursor.setImageMatrix(matrix);// 设置动画初始位置
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /**
     * 通过activity获取视图
     *
     * @param id
     * @param intent
     * @return
     */
    private View getView(String id, Intent intent) {
        return manager.startActivity(id, intent).getDecorView();
    }

    /**
     * Pager适配器
     */
    public class MyPagerAdapter extends PagerAdapter {
        List<View> list = new ArrayList<View>();

        public MyPagerAdapter(ArrayList<View> list) {
            this.list = list;
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            ViewPager pViewPager = ((ViewPager) container);
            pViewPager.removeView(list.get(position));
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ViewPager pViewPager = ((ViewPager) arg0);
            pViewPager.addView(list.get(arg1));
            return list.get(arg1);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
        }
    }

    /**
     * 页卡切换监听
     */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
        int two = one * 2;// 页卡1 -> 页卡3 偏移量

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(one, 0, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, 0, 0, 0);
                    }
                    t1.setBackgroundColor(Color.parseColor("#ea5656"));
                    t2.setBackgroundColor(Color.parseColor("#ff6666"));
                    t3.setBackgroundColor(Color.parseColor("#ff6666"));
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, one, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                    }
                    t1.setBackgroundColor(Color.parseColor("#ff6666"));
                    t2.setBackgroundColor(Color.parseColor("#ea5656"));
                    t3.setBackgroundColor(Color.parseColor("#ff6666"));
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, two, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
                    }
                    t1.setBackgroundColor(Color.parseColor("#ff6666"));
                    t2.setBackgroundColor(Color.parseColor("#ff6666"));
                    t3.setBackgroundColor(Color.parseColor("#ea5656"));
                    break;
            }
            currIndex = arg0;
            animation.setFillAfter(true);// True:图片停在动画结束位置
            animation.setDuration(300);
            cursor.startAnimation(animation);
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }
    }

    /**
     * 头标点击监听
     */
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
            // t1.setTextColor(Color.WHITE);
            //  t1.setBackgroundColor(Color.parseColor("#d71345"));
        }

        @Override
        public void onClick(View v) {
            pager.setCurrentItem(index);
            if (index == 0) {
                t1.setBackgroundColor(Color.parseColor("#ea5656"));
                t2.setBackgroundColor(Color.parseColor("#ff6666"));
                t3.setBackgroundColor(Color.parseColor("#ff6666"));
            }
            if (index == 1) {
                t1.setBackgroundColor(Color.parseColor("#ff6666"));
                t2.setBackgroundColor(Color.parseColor("#ea5656"));
                t3.setBackgroundColor(Color.parseColor("#ff6666"));
            }
            if (index == 2) {
                t1.setBackgroundColor(Color.parseColor("#ff6666"));
                t2.setBackgroundColor(Color.parseColor("#ff6666"));
                t3.setBackgroundColor(Color.parseColor("#ea5656"));
            }

        }
    }

    ;


    //第一种方式
    /*private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsuccess);*/
/*
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
		mViewPager = (ViewPager) findViewById(R.id.vp_view);

		mInflater = LayoutInflater.from(this);
		view1 = mInflater.inflate(R.layout.view1, null);
		view2 = mInflater.inflate(R.layout.view2, null);
		view3 = mInflater.inflate(R.layout.view3, null);

		//添加页卡视图
		mViewList.add(view1);
		mViewList.add(view2);
		mViewList.add(view3);

		//添加页卡标题
		mTitleList.add("首页");
		mTitleList.add("购物车");
		mTitleList.add("我的");

		mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前默认为系统模式
		mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));
		mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
		mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));*/
    /**
     * ViewPager适配器
     */
    /*class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

		public MyPagerAdapter(List<View> mViewList) {
			this.mViewList = mViewList;
		}

		@Override
		public int getCount() {
			return mViewList.size();//页卡数
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;//官方推荐写法
		}

		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(mViewList.get(position));//添加页卡
			return mViewList.get(position);
		}

		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(mViewList.get(position));//删除页卡
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mTitleList.get(position);//页卡标题
		}
	}*/


    //第二种方式
    // extends FragmentActivity implements ViewPager.OnPageChangeListener
   /* private List<View> viewList;
    private List<String> titleList;
    private ViewPager pager;
    private PagerTabStrip tab;//顶部标题

    private List<Fragment> fragList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registersuccess);
        viewList = new ArrayList<View>();
        titleList = new ArrayList<String>();
        tab = (PagerTabStrip) findViewById(R.id.tab);

        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        View view3 = View.inflate(this, R.layout.view3, null);


        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);


        fragList = new ArrayList<Fragment>();
        fragList.add(new Fragment());
        fragList.add(new Fragment());
        fragList.add(new Fragment());

        //为ViewPager页卡设置标题
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        //为PagerTabStrip设置一些属性
        tab.setBackgroundColor(Color.WHITE);
        tab.setDrawFullUnderline(false);
        tab.setTabIndicatorColor(Color.BLUE);

        pager = (ViewPager) findViewById(R.id.pager);
        //MyPagerAdapter adapter = new MyPagerAdapter(viewList,titleList);
        //MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragList, titleList);
        */
    /**
     * 使用getSupportFragmentManager()该Activity必须继承FragmentActivity
     *//*
        MyFragmentPagerAdapter2 adapter = new MyFragmentPagerAdapter2(getSupportFragmentManager(), fragList, titleList);
        pager.setAdapter(adapter);
       // pager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        Toast.makeText(this, "当前是第" + (arg0 + 1) + "个界面", Toast.LENGTH_SHORT).show();

    }*/


}
