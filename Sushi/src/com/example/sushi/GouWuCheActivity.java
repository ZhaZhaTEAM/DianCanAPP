package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jc.store.R;
import com.example.jc.store.com.team.bean.Good;
import com.example.jc.store.com.team.bean.GouWuChe;
import com.example.jc.store.com.team.bean.GouWuCheHolder;
import com.example.jc.store.com.team.bean.Like;
import com.example.jc.store.com.team.bean.MyApplication;
import com.example.jc.store.com.team.bean.User;
import com.example.jc.store.com.team.dao.GoodDao;
import com.example.jc.store.com.team.dao.GouWuCheDao;
import com.example.jc.store.com.team.dao.UserDao;
import com.example.jc.store.com.team.helper.ActivityManagerUtils;

import java.util.List;


/**
 * “购物车”页面
 *
 * @author JC
 */
public class GouWuCheActivity extends Activity {


    private List<GouWuChe> mData;//数据
    private ListView mLv_center;//视图
private List<Good> mDataGood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  if (!CacheActivity.activityList.contains(GouWuCheActivity.this)) {
            CacheActivity.addActivity(GouWuCheActivity.this);
        }*/
        ActivityManagerUtils.getInstance().addActivity(this);
        MyApplication myApplication = (MyApplication) getApplication();
        String username = myApplication.getUsername();

        if (username == "" || ("").equals(username) || ("null").equals(username) || null == username) {
            TextView noloin;
            setContentView(R.layout.nologin);
            noloin = (TextView) findViewById(R.id.nologin);
            noloin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(GouWuCheActivity.this, MainActivity.class);
                    startActivity(intent);
                    ActivityManagerUtils.getInstance().finishActivity(GouWuCheActivity.this);
                    ActivityManagerUtils.getInstance().finishActivityclass(LoginSuccessActivity.class);
                    // finish();
                }
            });
        } else {
            setContentView(R.layout.view2);
            mLv_center = (ListView) findViewById(R.id.cart_shopping_listview);
            initData();
        }


    }


    private void initData() {
        final int index = getIntent().getIntExtra("index", -100);
        //  GoodDao goodDao = new GoodDao(GouWuCheActivity.this);
        GouWuCheDao gouWuCheDao = new GouWuCheDao(GouWuCheActivity.this);
        String parentid = String.valueOf(index);
        //  mData = goodDao.findType(parentid);//获得数据
        MyApplication myApplication = (MyApplication) getApplication();
        String username = myApplication.getUsername();
        UserDao userDao = new UserDao(GouWuCheActivity.this);
        String userid = String.valueOf(userDao.findByUserName(username).getF_id());
        mData = gouWuCheDao.findAll(userid);
        if (mData.size() != 0) {
            mLv_center.setAdapter(new MyAdapter());
            System.out.println("sgkjsdkgjslgjskld");
           /* mLv_center.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplication(), DetailActivity.class);
                    intent.putExtra("index", index);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });*/
        }
     /*   else
        {

        }*/
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Good  getItem(int position) {
            GouWuChe gouWuChe = mData.get(position);
             return getGoodData(gouWuChe);
        }

        public Good getGoodData(GouWuChe gouWuChe)
        {
            int userid = Integer.valueOf(gouWuChe.getF_userid());
            int goodid = Integer.valueOf(gouWuChe.getF_goodid());
            // UserDao userDao = new UserDao(GouWuCheActivity.this);
            // User user = userDao.findById(userid);
            GoodDao goodDao = new GoodDao(GouWuCheActivity.this);
            Good good = goodDao.findById(goodid);
            return good;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            GouWuCheHolder holder;
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.lv_gouwuche, null);
                holder = new GouWuCheHolder();
                holder.setIv_icon((ImageView) convertView.findViewById(R.id.pro_image));
                holder.setTv_name((TextView) convertView.findViewById(R.id.pro_name));
                holder.setTv_price((TextView) convertView.findViewById(R.id.pro_shopPrice));
                holder.setTv_number((TextView) convertView.findViewById(R.id.pro_count));

              /*  holder.setLike((Button) convertView.findViewById(R.id.like));
                holder.setAdd((Button) convertView.findViewById(R.id.add));
*/
              /*  holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
                holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                holder.tv_detail = (TextView) convertView.findViewById(R.id.tv_detail);
                holder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
                holder.tv_superprice = (TextView) convertView.findViewById(R.id.tv_superprice);*/
                convertView.setTag(holder);
            } else {
                holder = (GouWuCheHolder) convertView.getTag();
            }
            Class<com.example.jc.store.R.drawable> cls = R.drawable.class;


           ;
//                String img = "food_" + getItem(position).f_imgpath;
//                img = img.substring(0, img.indexOf("."));

            String imgpath = getItem(position).getF_imgpath() + ".jpg";
            int value = getImageResourceId(imgpath);
            // int value = cls.getDeclaredField(getItem(position).getF_imgpath()).getInt(null);
            holder.getIv_icon().setImageResource(value);
            holder.getTv_name().setText(getItem(position).getF_name());
           // holder.getTv_number().setText(goods.getF_number());
            holder.getTv_price().setText("￥" + getItem(position).getF_price());




          /*  //"喜欢"按钮监听
            convertView.findViewById(R.id.like).setBackgroundColor(Color.parseColor("#ff6666"));
            convertView.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {//监听“喜欢”按钮
                @Override
                public void onClick(View v) {
                    MyApplication myApplication = (MyApplication) getApplication();
                    String username = myApplication.getUsername();//获得全局变量“username”
                    UserDao userDao = new UserDao(GouWuCheActivity.this);
                    String userid = String.valueOf(userDao.findByUserName(username).getF_id());
                    String goodid = String.valueOf(getItem(position).getF_id());//获得商品的id
                    Like like = new Like(0, userid, goodid);
                    LikeDao likeDao = new LikeDao(GouWuCheActivity.this);
                    boolean isexist = likeDao.isExist(like);
                    if (!isexist) {
                        likeDao.add(like);//添加到“喜欢”
                        Toast.makeText(GouWuCheActivity.this, "添加到“喜欢”啦~", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GouWuCheActivity.this, "已经添加到“喜欢”啦~", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            //“购物车”按钮监听
            convertView.findViewById(R.id.add).setBackgroundColor(Color.parseColor("#ff6666"));
            convertView.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyApplication myApplication = (MyApplication) getApplication();
                    String username = myApplication.getUsername();//获得全局变量“username”
                    UserDao userDao = new UserDao(GouWuCheActivity.this);
                    String userid = String.valueOf(userDao.findByUserName(username).getF_id());
                    String goodid = String.valueOf(getItem(position).getF_id());//获得商品的id
                    GouWuChe gouWuChe = new GouWuChe(goodid, userid, "1");
                    GouWuCheDao gouWuCheDao = new GouWuCheDao(GouWuCheActivity.this);
                    boolean isexist = gouWuCheDao.isExist(gouWuChe);
                    if (!isexist) {
                        gouWuCheDao.add(gouWuChe);//添加到“喜欢”
                        Toast.makeText(GouWuCheActivity.this, "添加到“购物车”啦~", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GouWuCheActivity.this, "已经添加到“购物车”啦~", Toast.LENGTH_SHORT).show();
                    }
                }
            });*/

           /* if (getItem(position).f_superprice == null) {
                holder.tv_superprice.setText("");
            } else {
                holder.tv_superprice.setText("会员价：" + getItem(position).f_superprice);
            }*/
            return convertView;
        }

        int getImageResourceId(String name) {
            R.drawable drawables = new R.drawable();
            //默认的id
            int resId = 0x7f02000b;
            try {
                //根据字符串字段名，取字段//根据资源的ID的变量名获得Field的对象,使用反射机制来实现的
                java.lang.reflect.Field field = R.drawable.class.getField(name);
                //取值
                resId = (Integer) field.get(drawables);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return resId;
        }
    }

}
