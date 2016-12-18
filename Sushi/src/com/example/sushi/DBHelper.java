package com.example.jc.store.com.team.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;// 定义数据库版本
    private final static String DB_NAME = "store.db";// 数据库名称

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);

    }

    /**
     * 创建数据库
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建用户表
        db.execSQL("create table if not exists  t_user (f_id integer primary key autoincrement,"
                + "f_username varchar(200),f_password varchar(200),f_sex varchar(10),f_phone varchar(100))");
        // 创建菜单表
        db.execSQL("create table if not exists t_good (f_id integer primary key autoincrement,f_type varchar(10),f_name varchar(200),f_parentid varchar(10),"
                + "f_price varchar(20),f_imgpath varchar(300),f_detail varchar(4000))");
        // 创建订单表
        db.execSQL("create table if not exists t_order (f_id integer primary key autoincrement,f_orderid varchar(200),f_time varchar(200),f_totalprice varchar(200),f_address varchar(500),f_phone varchar(100),f_userid varchar(200))");
        // 创建订单详列表
        db.execSQL("create table if not exists t_orderitem (f_id integer primary key autoincrement,f_orderid varchar(200),f_goodid varchar(200),f_number varchar(200)) ");
        // 创建购物车
        db.execSQL("create table if not exists t_gouwuche (f_id integer primary key autoincrement,f_orderid varchar(200),f_goodid varchar(200),f_number varchar(200)) ");
        //创建喜欢
        db.execSQL("create table if not exists t_like (f_id integer primary key autoincrement,f_userid varchar(200),f_goodid varchar(200)) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
