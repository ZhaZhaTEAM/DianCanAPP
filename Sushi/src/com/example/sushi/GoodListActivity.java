package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jc.store.R;
import com.example.jc.store.com.team.bean.Good;
import com.example.jc.store.com.team.bean.GouWuChe;
import com.example.jc.store.com.team.bean.Like;
import com.example.jc.store.com.team.bean.MyApplication;
import com.example.jc.store.com.team.bean.ViewHolder;
import com.example.jc.store.com.team.dao.GoodDao;
import com.example.jc.store.com.team.dao.GouWuCheDao;
import com.example.jc.store.com.team.dao.LikeDao;
import com.example.jc.store.com.team.dao.UserDao;
import com.example.jc.store.com.team.helper.ActivityManagerUtils;

import java.util.List;

/**
 * Created by JC on 2016/12/11.
 */
public class GoodListActivity extends Activity {
    private List<Good> mData;//数据
    private ListView mLv_center;//视图

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.good_list);
     /*   if (!CacheActivity.activityList.contains(GoodListActivity.this)) {
             CacheActivity.addActivity(GoodListActivity.this);
             }*/
        ActivityManagerUtils.getInstance().addActivity(this);
        mLv_center = (ListView) findViewById(R.id.listView);
        initData();
    }

    private void initData() {
        final int index = getIntent().getIntExtra("index", -100);
        GoodDao goodDao = new GoodDao(GoodListActivity.this);
        String parentid = String.valueOf(index);
        mData = goodDao.findType(parentid);//获得数据
        if (mData.size() != 0) {
            mLv_center.setAdapter(new MyAdapter());
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
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Good getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.lv_item, null);
                holder = new ViewHolder();
                holder.setIv_icon((ImageView) convertView.findViewById(R.id.iv_icon));
                holder.setTv_title((TextView) convertView.findViewById(R.id.tv_title));
                holder.setTv_price((TextView) convertView.findViewById(R.id.tv_price));
                holder.setTv_detail((TextView) convertView.findViewById(R.id.tv_detail));

                holder.setLike((Button) convertView.findViewById(R.id.like));
                holder.setAdd((Button) convertView.findViewById(R.id.add));

              /*  holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
                holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                holder.tv_detail = (TextView) convertView.findViewById(R.id.tv_detail);
                holder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
                holder.tv_superprice = (TextView) convertView.findViewById(R.id.tv_superprice);*/
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Class<com.example.jc.store.R.drawable> cls = R.drawable.class;
            try {
//                String img = "food_" + getItem(position).f_imgpath;
//                img = img.substring(0, img.indexOf("."));
                int value = cls.getDeclaredField(getItem(position).getF_imgpath()).getInt(null);
                holder.getIv_icon().setImageResource(value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            holder.getTv_title().setText(getItem(position).getF_name());
            holder.getTv_detail().setText(getItem(position).getF_detail());
            holder.getTv_price().setText("￥" + getItem(position).getF_price());

            //"喜欢"按钮监听
            convertView.findViewById(R.id.like).setBackgroundColor(Color.parseColor("#ff6666"));
            convertView.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {//监听“喜欢”按钮
                @Override
                public void onClick(View v) {
                    MyApplication myApplication = (MyApplication) getApplication();
                    String username = myApplication.getUsername();//获得全局变量“username”
                    if (username == "" || ("").equals(username) || ("null").equals(username) || null == username) {
                        new AlertDialog.Builder(GoodListActivity.this).setTitle("提示框").setMessage("您还未登录~是否前往登录界面？")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent();
                                        intent.setClass(GoodListActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        ActivityManagerUtils.getInstance().finishActivityclass(LoginSuccessActivity.class);
                                        //finish();
                                    }
                                })
                                .setNegativeButton("取消", null)
                                .show();
                    } else {
                        UserDao userDao = new UserDao(GoodListActivity.this);
                        String userid = String.valueOf(userDao.findByUserName(username).getF_id());
                        String goodid = String.valueOf(getItem(position).getF_id());//获得商品的id
                        Like like = new Like(0, userid, goodid);
                        LikeDao likeDao = new LikeDao(GoodListActivity.this);
                        boolean isexist = likeDao.isExist(like);
                        if (!isexist) {
                            likeDao.add(like);//添加到“喜欢”
                            Toast.makeText(GoodListActivity.this, "添加到“喜欢”啦~", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(GoodListActivity.this, "已经添加到“喜欢”啦~", Toast.LENGTH_SHORT).show();
                        }
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
                    if (username == "" || ("").equals(username) || ("null").equals(username) || null == username) {
                        new AlertDialog.Builder(GoodListActivity.this).setTitle("提示框").setMessage("您还未登录~是否前往登录界面？")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent();
                                        intent.setClass(GoodListActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        ActivityManagerUtils.getInstance().finishActivityclass(LoginSuccessActivity.class);
                                        //finish();
                                    }
                                })
                                .setNegativeButton("取消", null)
                                .show();
                    } else {
                        UserDao userDao = new UserDao(GoodListActivity.this);
                        String userid = String.valueOf(userDao.findByUserName(username).getF_id());
                        String goodid = String.valueOf(getItem(position).getF_id());//获得商品的id
                        GouWuChe gouWuChe = new GouWuChe(goodid, userid, "1");
                        GouWuCheDao gouWuCheDao = new GouWuCheDao(GoodListActivity.this);
                        boolean isexist = gouWuCheDao.isExist(gouWuChe);
                        if (!isexist) {
                            gouWuCheDao.add(gouWuChe);//添加到“喜欢”
                            Toast.makeText(GoodListActivity.this, "添加到“购物车”啦~", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(GoodListActivity.this, "已经添加到“购物车”啦~", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            });

           /* if (getItem(position).f_superprice == null) {
                holder.tv_superprice.setText("");
            } else {
                holder.tv_superprice.setText("会员价：" + getItem(position).f_superprice);
            }*/
            return convertView;
        }
    }


}
