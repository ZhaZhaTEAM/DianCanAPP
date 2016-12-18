package com.example.jc.store.com.team.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jc.store.com.team.bean.User;
import com.example.jc.store.com.team.helper.DBHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户表dao层
 *
 * @author JC
 */
public class UserDao {
    public static String path = "data/data/com.example.jc.store/files/store.db";// 数据库路径;
    SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null,
            SQLiteDatabase.OPEN_READWRITE);

    private DBHelper dbHelper;

    // private SQLiteDatabase db;
    public UserDao(Context context) {
        dbHelper = new DBHelper(context);

    }

    /**
     * 通过id查询
     */
    public User findById(int userid) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        // db = dbHelper.getReadableDatabase();
        User user = null;
        Cursor cursor = db.rawQuery(
                "select * from t_user where f_id=" + userid,
                null);
        while (cursor.moveToNext()) {
            user = new User(cursor.getInt(cursor
                    .getColumnIndex("f_id")), cursor.getString(cursor
                    .getColumnIndex("f_username")), cursor.getString(cursor
                    .getColumnIndex("f_password")), cursor.getString(cursor
                    .getColumnIndex("f_sex")), cursor.getString(cursor
                    .getColumnIndex("f_phone")));
        }
        cursor.close();
        db.close();
        return user;
    }

    /**
     * 查询用户名与密码是否匹配
     */
    public boolean findUserAndPass(String username, String password) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor = null;
        boolean isexist = false;
        // db = dbHelper.getReadableDatabase();
        try {
            cursor = db.rawQuery(
                    "select * from t_user where f_username=? and f_password=?",
                    new String[]{username, password});

      /*  if (cursor.moveToNext()) {
            return true;
        }*/
            isexist = cursor.moveToFirst();// 如果是空就返回false，如果不是空就返回true
            // return false;
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
        return isexist;
    }

    /**
     * 添加（注册）
     */
    public void add(User user) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        try {
            db.execSQL(
                    "insert into t_user (f_username,f_password,f_sex,f_phone) values(?,?,?,?)",
                    new String[]{user.getF_username(), user.getF_password(),
                            user.getF_sex(), user.getF_phone()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (db != null) {
                db.close();
            }

        }

    }

    /**
     * 根据username查询
     */
    public User findByUserName(String username) {
        db = dbHelper.getReadableDatabase();
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        // db = dbHelper.getReadableDatabase();
        User user = null;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(
                    "select * from t_user where f_username=?",
                    new String[]{username});
            while (cursor.moveToNext()) {
                user = new User(cursor.getInt(cursor
                        .getColumnIndex("f_id")), cursor.getString(cursor
                        .getColumnIndex("f_username")), cursor.getString(cursor
                        .getColumnIndex("f_password")), cursor.getString(cursor
                        .getColumnIndex("f_sex")), cursor.getString(cursor
                        .getColumnIndex("f_phone")));
            }

            return user;
        } catch (Exception e) {

        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }

        }
        return user;
    }
}
