package com.example.jc.store.com.team.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jc.store.com.team.bean.Good;
import com.example.jc.store.com.team.bean.User;
import com.example.jc.store.com.team.helper.DBHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * 商品表dao层
 *
 * @author JC
 */
public class GoodDao {
    public static String path = "data/data/com.example.jc.store/files/store.db";// 数据库路径
    SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,
            SQLiteDatabase.OPEN_READWRITE);// 创建对象，最后一个参数是一旦创建对象就打开数据库

    private DBHelper dbHelper;
    // private SQLiteDatabase db;

    public GoodDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    /**
     * 通过id查询、
     */
    public Good findById(int goodid) {
        //  db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        Good good = null;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(
                    "select * from t_good where f_id=" + goodid,
                    null);
            while (cursor.moveToNext()) {
                good = new Good(cursor.getInt(cursor.getColumnIndex("f_id")),
                        cursor.getString(cursor.getColumnIndex("f_type")), cursor
                        .getString(cursor.getColumnIndex("f_name")), cursor
                        .getString(cursor.getColumnIndex("f_parentid")),
                        cursor.getString(cursor.getColumnIndex("f_price")), cursor
                        .getString(cursor.getColumnIndex("f_imgpath")),
                        cursor.getString(cursor.getColumnIndex("f_detail")), cursor.getString(cursor.getColumnIndex("f_number")));
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

        return good;
    }

    /**
     * 查詢全部
     *
     * @return
     */
    public List<Good> findAll() {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        List<Good> goods = new ArrayList<Good>();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("select * from t_good", null);
            while (cursor.moveToNext()) {
                goods.add(new Good(cursor.getInt(cursor.getColumnIndex("f_id")),
                        cursor.getString(cursor.getColumnIndex("f_type")), cursor
                        .getString(cursor.getColumnIndex("f_name")), cursor
                        .getString(cursor.getColumnIndex("f_parentid")),
                        cursor.getString(cursor.getColumnIndex("f_price")), cursor
                        .getString(cursor.getColumnIndex("f_imgpath")),
                        cursor.getString(cursor.getColumnIndex("f_detail")), cursor.getString(cursor.getColumnIndex("f_number"))));
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
        return goods;
    }

    /**
     * 查詢分類的商品
     */
    public List<Good> findType(String parentid) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        List<Good> goods = new ArrayList<Good>();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("select * from t_good where f_parentid = ? ", new String[]{parentid});
            while (cursor.moveToNext()) {
                goods.add(new Good(cursor.getInt(cursor.getColumnIndex("f_id")),
                        cursor.getString(cursor.getColumnIndex("f_type")), cursor
                        .getString(cursor.getColumnIndex("f_name")), cursor
                        .getString(cursor.getColumnIndex("f_parentid")),
                        cursor.getString(cursor.getColumnIndex("f_price")), cursor
                        .getString(cursor.getColumnIndex("f_imgpath")),
                        cursor.getString(cursor.getColumnIndex("f_detail")), cursor.getString(cursor.getColumnIndex("f_number"))));
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

        return goods;
    }

}
