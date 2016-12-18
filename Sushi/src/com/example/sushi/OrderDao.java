package com.example.jc.store.com.team.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jc.store.com.team.bean.Order;
import com.example.jc.store.com.team.helper.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单表dao层
 *
 * @author JC
 */
public class OrderDao {

    public static String path = "data/data/com.example.jc.store/files/store.db";// 数据库路径
    SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,
            SQLiteDatabase.OPEN_READWRITE);// 创建对象，最后一个参数是一旦创建对象就打开数据库

    private DBHelper dbHelper;

    //private SQLiteDatabase db;
    public OrderDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    /**
     * 查询全部订单
     *
     * @return
     */
    public List<Order> findAll(String userid) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        List<Order> orders = new ArrayList<Order>();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("select * from t_order where f_userid=?",
                    new String[]{userid});
            while (cursor.moveToNext()) {
                orders.add(new Order(cursor.getInt(cursor.getColumnIndex("f_id")),
                        cursor.getString(cursor.getColumnIndex("f_orderid")),
                        cursor.getString(cursor.getColumnIndex("f_time")), cursor
                        .getString(cursor.getColumnIndex("f_totalprice")),
                        cursor.getString(cursor.getColumnIndex("f_address")),
                        cursor.getString(cursor.getColumnIndex("f_phone")), cursor
                        .getString(cursor.getColumnIndex("f_userid"))));
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return orders;
    }

    /**
     * 添加订单
     */

    public void add(Order order) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        try {
            db.execSQL(
                    "insert into t_order (f_orderid,f_time,f_totalprice,f_address,f_phone,f_userid) values(?,?,?,?,?,?)",
                    new String[]{order.getF_orderid(), order.getF_time(),
                            order.getF_totalprice(), order.getF_address(),
                            order.getF_phone(), order.getF_userid()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }


    }

}
