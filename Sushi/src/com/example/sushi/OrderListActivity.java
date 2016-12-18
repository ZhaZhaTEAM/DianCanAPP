package com.example.jc.store.com.team.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jc.store.R;
import com.example.jc.store.com.team.bean.MyApplication;
import com.example.jc.store.com.team.bean.Order;
import com.example.jc.store.com.team.bean.OrderItem;
import com.example.jc.store.com.team.com.team.adapter.OrderHolder;
import com.example.jc.store.com.team.dao.OrderDao;
import com.example.jc.store.com.team.dao.OrderItemDao;
import com.example.jc.store.com.team.dao.UserDao;

import java.util.List;

/**
 * Created by asus on 2016/12/15.
 */
public class OrderListActivity extends Activity {

    private List<Order> mData;
    private List<OrderItem> mDataItem;
    private ListView mLv_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_order);

        initView();
        initData();
    }

    private void initView() {
        mLv_order = (ListView) findViewById(R.id.orderlistView);
    }

    private void initData() {
        final int index = getIntent().getIntExtra("index", -100);
        OrderDao OrderDao = new OrderDao(OrderListActivity.this);
        OrderItemDao OrderItemDao = new OrderItemDao(OrderListActivity.this);
        //    String userid = String.valueOf(index);
        MyApplication myApplication = (MyApplication) getApplication();
        String username = myApplication.getUsername();//获得全局变量“username”
        UserDao userDao = new UserDao(OrderListActivity.this);

        String userid = String.valueOf(userDao.findByUserName(username).getF_id());
        //   String userid1=String.valueOf(OrderDao.findAll(userid));
        mData = OrderDao.findAll(userid);//获得数据
//        mDataItem = OrderItemDao.findAll(userid); //获得item里面的详细数据
        if (mData != null || mDataItem != null) {
            mLv_order.setAdapter(new MyAdapter());
   //         mLv_order.setAdapter(new MyAdaptertwo());
            mLv_order.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplication(), DetailOrderActivity.class);
                    intent.putExtra("index", index);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });
        }
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Order getItem(int position) {
            return mData.get(position);
        }

//        public List<OrderItem> getItem_2(int position) {
//
//          /*  OrderDao orderDao =new OrderDao(OrderListActivity.this);
//            String orderid=orderDao.findById(order);*/
//            Order order = mData.get(position);
//            OrderItemDao orderItemDao = new OrderItemDao(OrderListActivity.this);
//            List<OrderItem> orderItem = orderItemDao.findAll(String.valueOf(order.getF_id()));
//
//
//            return orderItem;
//        }

//        public List<Good> getItem_3(int position) {
//
//          /*  OrderDao orderDao =new OrderDao(OrderListActivity.this);
//            String orderid=orderDao.findById(order);*/
//            Order order = mData.get(position);
//            OrderItemDao orderItemDao = new OrderItemDao(OrderListActivity.this);
//            List<OrderItem> orderItem = orderItemDao.findAll(String.valueOf(order.getF_id()));
//            List<Good> goods = new ArrayList<Good>();
//            for (int i = 0; i < orderItem.size(); i++) {
//                GoodDao goodDao = new GoodDao(OrderListActivity.this);
//                Good good = goodDao.findById(goods);
//                goods.add(good);
//            }
//            return goods;
//        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            OrderHolder holder;
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.order, null);
                holder = new OrderHolder();

                holder.setF_address((TextView) convertView.findViewById(R.id.address));
                holder.setF_orderid((TextView) convertView.findViewById(R.id.orderid));
//                holder.setF_phone((TextView) convertView.findViewById(R.id.phone));
                holder.setF_time((TextView) convertView.findViewById(R.id.time));
                holder.setF_totalprice((TextView) convertView.findViewById(R.id.totalprice));

                convertView.setTag(holder);
            } else {
                holder = (OrderHolder) convertView.getTag();
            }

            holder.getF_address().setText(getItem(position).getF_address());
            holder.getF_orderid().setText(getItem(position).getF_orderid());
//            holder.getF_phone().setText(getItem(position).getF_phone());
            holder.getF_time().setText(getItem(position).getF_time());
            holder.getF_totalprice().setText(getItem(position).getF_totalprice());

//            for (int i=0;i <getItem_2(position).size(); i++) {
//                String imgpath = getItem_3(position).get(i).getF_imgpath() + ".jpg";
//                int value = getImageResourceId(imgpath);
//                           holder.getIv_icon().setImageResource(value);//拿到圖片
//                holder.setName((getItem_3(position).get(i).getF_name());//拿到圖片
//                holder.setNumer(getItem_2(position).get(i).getF_number());//拿到數量
//
//            }


            return convertView;
        }
    }

    /*class MyAdaptertwo extends BaseAdapter{
        @Override
        public int getCount() {
            return mDataItem.size();
        }

        @Override
        public Order getItem(int position) {
            OrderItem orderItem=mDataItem.get(position);
            return getOrderData(order);
        }


        public Order getItem_2(int position) {
            Order order=mDataItem.get(position);
            OrderItem
            List<OrderItem> orderItem=
            return getOrderData(OrderItem);
        }
        public  Order getOrderData(Order order){
            int userid = Integer.valueOf(order.getF_userid());
            int orderid = Integer.valueOf(order.getF_orderid());
            OrderDao orderDao=new OrderDao(OrderListActivity.this);
            Order Order=orderDao.findAll(order);
//            GoodDao goodDao = new GoodDao(GouWuCheActivity.this);
//            Good good = goodDao.findById(goodid);
            return order;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
         //   OrderHolder holder;
            OrderItemHolder holder;
            if(convertView==null){
                convertView=View.inflate(getApplicationContext(), R.layout.order,null);
           //     holder=new OrderHolder();
                holder=new OrderItemHolder();
                holder.setF_goods_number((TextView)convertView.findViewById(R.id.goods_number));
                holder.setF_goods_price((TextView)convertView.findViewById(R.id.goods_price));
                holder.setF_goods_title((TextView)convertView.findViewById(R.id.goods_title));
                holder.setF_goods_totalprice((TextView)convertView.findViewById(R.id.goods_totalprice));
                holder.setF_goods_pic((ImageView) convertView.findViewById(R.id.goods_pic));
                convertView.setTag(holder);
            }else {
               // holder=(OrderHolder)convertView.getTag();
                holder=(OrderItemHolder)convertView.getTag();
            }

            holder.getF_goods_number().setText(getItem(position).getF_number());
            holder.getF_goods_title().setText(getItem(position).get);

            return convertView;
        }
    }
*/
//    int getImageResourceId(String name) {
//        R.drawable drawables = new R.drawable();
//        //默认的id
//        int resId = 0x7f02000b;
//        try {
//            //根据字符串字段名，取字段//根据资源的ID的变量名获得Field的对象,使用反射机制来实现的
//            java.lang.reflect.Field field = R.drawable.class.getField(name);
//            //取值
//            resId = (Integer) field.get(drawables);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return resId;
//    }

}
