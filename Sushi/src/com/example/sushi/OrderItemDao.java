package com.example.jc.store.com.team.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jc.store.com.team.bean.OrderItem;
import com.example.jc.store.com.team.helper.DBHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * 订单详细表dao层
 *
 * @author JC
 */
public class OrderItemDao {

    public static String path = "data/data/com.example.jc.store/files/store.db";// 数据库路径;
    SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,
            SQLiteDatabase.OPEN_READWRITE);


    private DBHelper dbHelper;
    //private SQLiteDatabase db;

    public OrderItemDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    /**
     * 查询每个订单下的全部
     */
    public List<OrderItem> findAll(String orderid) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        List<OrderItem> orderitems = new ArrayList<OrderItem>();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(
                    "select * from t_orderitem where f_orderid=?",
                    new String[]{orderid});
            while (cursor.moveToNext()) {
                orderitems.add(new OrderItem(cursor.getInt(cursor
                        .getColumnIndex("f_id")), cursor.getString(cursor
                        .getColumnIndex("f_orderid")), cursor.getString(cursor
                        .getColumnIndex("f_goodid")), cursor.getString(cursor
                        .getColumnIndex("f_number"))));
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

        return orderitems;
    }

    /**
     * 添加订单的详列信息
     */

    public void add(OrderItem orderItem) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        try {
            db.execSQL(
                    "insert into t_orderitem (f_orderid,f_goodid,f_number) values(?,?,?)",
                    new String[]{orderItem.getF_orderid(),
                            orderItem.getF_goodid(), orderItem.getF_number()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }

    }
}
