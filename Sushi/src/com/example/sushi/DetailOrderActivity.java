package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jc.store.R;
import com.example.jc.store.com.team.bean.Good;
import com.example.jc.store.com.team.bean.GouWuChe;
import com.example.jc.store.com.team.bean.MyApplication;
import com.example.jc.store.com.team.bean.Order;
import com.example.jc.store.com.team.bean.OrderItem;
import com.example.jc.store.com.team.com.team.adapter.OrderItemHolder;
import com.example.jc.store.com.team.dao.GoodDao;
import com.example.jc.store.com.team.dao.GouWuCheDao;
import com.example.jc.store.com.team.dao.OrderDao;
import com.example.jc.store.com.team.dao.OrderItemDao;
import com.example.jc.store.com.team.dao.UserDao;

import java.util.List;

/**
 * Created by asus on 2016/12/15.
 */
public class DetailOrderActivity extends Activity{

    private List<OrderItem> mData;
    private TextView mGoods_title;
    private TextView mGoods_price;
    private TextView mGoods_number;
    private TextView mGoods_totalprice;
    private ImageView mGoods_pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_item);
        initView();
        initData();
    }

    private void initView(){
        mGoods_number=(TextView)findViewById(R.id.goods_number);
        mGoods_price=(TextView)findViewById(R.id.goods_price);
        mGoods_title=(TextView)findViewById(R.id.goods_title);
        mGoods_totalprice=(TextView)findViewById(R.id.goods_totalprice);
        mGoods_pic=(ImageView)findViewById(R.id.goods_pic);
    }

    private void initData() {
        final int index = getIntent().getIntExtra("index", -100);
        int position=getIntent().getIntExtra("position",-100);


        OrderItemDao OrderItemDao = new OrderItemDao(DetailOrderActivity.this);
        MyApplication myApplication = (MyApplication) getApplication();
        String username = myApplication.getUsername();//获得全局变量“username”
        UserDao userDao=new UserDao(DetailOrderActivity.this);
        String userid=String.valueOf(userDao.findByUserName(username));

        OrderDao orderDao=new OrderDao(DetailOrderActivity.this);
        String orderid=String.valueOf(orderDao.findAll(userid));

        mData = OrderItemDao.findAll(orderid);//获得数据





    }
class MyAdapter extends BaseAdapter{
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public OrderItem getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return convertView;
    }
}


}
