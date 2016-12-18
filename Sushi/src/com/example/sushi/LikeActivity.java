package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jc.store.R;
import com.example.jc.store.com.team.bean.Like;
import com.example.jc.store.com.team.bean.MyApplication;
import com.example.jc.store.com.team.com.team.adapter.LikeHolder;
import com.example.jc.store.com.team.dao.LikeDao;
import com.example.jc.store.com.team.dao.UserDao;

import java.util.List;

/**
 * Created by asus on 2016/12/15.
 */
public class LikeActivity extends Activity {
    private List<Like> mData;//数据
    private ListView mLv_center;//视图
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_like);
        mLv_center = (ListView) findViewById(R.id.likelistView);


        initData();
    }
    private void initData() {
        final int index = getIntent().getIntExtra("index", -100);
        LikeDao likeDao = new LikeDao(LikeActivity.this);
        String userid = String.valueOf(index);
        mData = likeDao.findAll(userid);//获得数据
        if (mData.size()!=0) {
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
        public Like getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LikeHolder holder;
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.like_item, null);
                holder = new LikeHolder();
                holder.setIv_icon((ImageView) convertView.findViewById(R.id.iv_icon));
                holder.setTv_title((TextView) convertView.findViewById(R.id.tv_title));
                holder.setTv_price((TextView) convertView.findViewById(R.id.tv_price));
                holder.setTv_detail((TextView) convertView.findViewById(R.id.tv_detail));

                holder.setUnlike((Button) convertView.findViewById(R.id.unlike));
                holder.setAdd((Button) convertView.findViewById(R.id.add));
                convertView.setTag(holder);
            } else {
                holder = (LikeHolder) convertView.getTag();
            }
            Class<R.drawable> cls = R.drawable.class;
            try {
//                String img = "food_" + getItem(position).f_imgpath;
//                img = img.substring(0, img.indexOf("."));

                int value = cls.getDeclaredField(getItem(position).getF_userid()).getInt(null);
                holder.getIv_icon().setImageResource(value);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }


            holder.getTv_title().setText(getItem(position).getF_goodtitle());
            holder.getTv_detail().setText(getItem(position).getF_gooddetail());
            holder.getTv_price().setText("￥" + getItem(position).getF_goodprice());

            //"喜欢"按钮监听
            convertView.findViewById(R.id.like).setBackgroundColor(Color.parseColor("#ff6666"));
            convertView.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {//监听“喜欢”按钮
                @Override
                public void onClick(View v) {
                    MyApplication myApplication = (MyApplication) getApplication();
                    String username = myApplication.getUsername();//获得全局变量“username”
                    UserDao userDao = new UserDao(LikeActivity.this);
                    String userid = String.valueOf(userDao.findByUserName(username).getF_id());
                    String likeid = String.valueOf(getItem(position).getF_id());//获得商品的id
                    Like like = new Like(0, userid, likeid);
                    LikeDao likeDao = new LikeDao(LikeActivity.this);
                    likeDao.delete(like);
//
                }
            });

            return convertView;
        }

    }
}
