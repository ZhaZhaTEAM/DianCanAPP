package com.example.jc.store.com.team.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jc.store.com.team.bean.GouWuChe;
import com.example.jc.store.com.team.helper.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class GouWuCheDao {

    public static String path = "data/data/com.example.jc.store/files/store.db";// 数据库路径;
    SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,
            SQLiteDatabase.OPEN_READWRITE);
    private DBHelper dbHelper;

    //private SQLiteDatabase db;
    public GouWuCheDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    /**
     * 查询该用户下的购物车
     */

    public List<GouWuChe> findAll(String userid) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        List<GouWuChe> gouwuche = new ArrayList<GouWuChe>();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(
                    "select * from t_gouwuche where f_userid=?",
                    new String[]{userid});
            while (cursor.moveToNext()) {
                gouwuche.add(new GouWuChe(cursor.getString(cursor
                        .getColumnIndex("f_goodid")), cursor.getString(cursor
                        .getColumnIndex("f_userid")), cursor.getString(cursor
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

        return gouwuche;
    }

    /**
     * 添加到购物车
     */
    public void add(GouWuChe gouWuChe) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        try {
            db.execSQL(
                    "insert into t_gouwuche (f_userid,f_goodid,f_number) values(?,?,?)",
                    new String[]{gouWuChe.getF_userid(), gouWuChe.getF_goodid(), gouWuChe.getF_number()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
    /*	Cursor cursor = db.rawQuery(
                "select * from t_gouwuche where f_userid=? and f_goodid=?",
				new String[]{gouWuChe.getF_userid(), gouWuChe.getF_goodid()});
		boolean is=cursor.moveToFirst();*/
    }


    /**
     * 查询是否已经添加到购物车
     */
    public boolean isExist(GouWuChe gouWuChe) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor = null;
        boolean isexist = false;
        try {
            cursor = db.rawQuery(
                    "select * from t_gouwuche where f_userid=? and f_goodid=?",
                    new String[]{gouWuChe.getF_userid(), gouWuChe.getF_goodid()});
            isexist = cursor.moveToFirst();
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
        return isexist;// 如果是空就返回false，如果不是空就返回true
    }

    /**
     * 删除购物车
     */

    /**
     *更改购物车数量
     */

}
