package com.example.jc.store.com.team.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jc.store.com.team.bean.Like;
import com.example.jc.store.com.team.bean.Order;
import com.example.jc.store.com.team.helper.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * “喜欢”dao
 * Created by JC on 2016/12/14.
 */
public class LikeDao {

    public static String path = "data/data/com.example.jc.store/files/store.db";// 数据库路径;
    SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,
            SQLiteDatabase.OPEN_READWRITE);

    private DBHelper dbHelper;
    // private SQLiteDatabase db;

    public LikeDao(Context context) {
        dbHelper = new DBHelper(context);

    }

    /**
     * 添加喜欢
     */
    public void add(Like like) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        try {
            db.execSQL(
                    "insert into t_like (f_userid) values(?,?)",
                    new String[]{like.getF_userid(), like.getF_goodid()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (db != null) {
                db.close();
            }
        }


    }

    /**
     * 查询该用户“喜欢”
     */

    public List<Like> findAll(String userid) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        List<Like> likes = new ArrayList<Like>();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("select * from t_like where f_userid=?",
                    new String[]{userid});
            while (cursor.moveToNext()) {
                likes.add(new Like(cursor.getInt(cursor.getColumnIndex("f_id")),
                        cursor.getString(cursor.getColumnIndex("f_userid")),
                        cursor.getString(cursor.getColumnIndex("f_goodid"))));
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
        return likes;
    }

    /**
     * 查询该用户喜欢的商品是否存在
     */
    public boolean isExist(Like like) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor = null;
        boolean isexist = false;
        try {
            cursor = db.rawQuery(
                    "select * from t_like where f_userid=? and f_goodid=?",
                    new String[]{like.getF_userid(), like.getF_goodid()});
            isexist = cursor.moveToFirst();
        } catch (Exception e) {

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
     * 取消"喜欢"
     */

    public void delete(Like like) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        try {
            db.execSQL("delete from t_like where f_userid=? and f_goodid=?", new String[]{like.getF_userid(), like.getF_goodid()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

}
