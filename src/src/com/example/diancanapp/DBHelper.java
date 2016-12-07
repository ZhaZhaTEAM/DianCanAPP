package com.team.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

	private static final int VERSION=1;//定义数据库版本
	private static final String DBNAME="diancan.db";//定义数据库名
	
	
	/**
	 * 定义构造函数
	 * @param context
	 */
	public DBHelper(Context context) {
		super(context, DBNAME, null, VERSION);
	}

	/**
	 * 创建数据库
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建用户表
		db.execSQL("create table if not exists  t_user (id integer primary key autoincrement," +
				"username varchar(100),password varchar(100))");
		//创建菜单表
		db.execSQL("create table if not exists t_food (id integer primary key autoincrement,type integer,parentid integer,name varchar(200)," +
				"price varchar(100),imagepath varchar(200),detail varchar(1000))");
		//创建订单表
		db.execSQL("create table if not exists t_order (id integer primary key autoincrement,orderid bigint,totalprice varchar(100),tableid integer,time varchar(100))");
		//创建订单详列表
		db.execSQL("create table if not exists t_orderitem (id integer primary key autoincrement,orderid integer,foodid integer,number integer) ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
