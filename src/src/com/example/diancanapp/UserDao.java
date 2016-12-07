package com.team.dao;

import com.team.db.DBHelper;
import com.team.model.User;

import android.R.integer;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class UserDao {

	private DBHelper dbHelper;
	public  SQLiteDatabase db;
	
	public UserDao(Context context) {
		dbHelper=new DBHelper(context);
	}
	
	
	/**
	 * 注冊
	 * @param user
	 * @return 
	 */
	public boolean add(integer id,String username,String password)
	{
		db=dbHelper.getWritableDatabase();
		db.execSQL("insert into t_user (id,username,password) values(?,?,?)",new String[]{username,password});
		return false;
	}
	
	/**
	 * 判斷姓名和密碼是否匹配
	 * @return
	 */
	public boolean findUserAndPass(String username,String password)
	{
		
		db=dbHelper.getReadableDatabase();
		Cursor cursor=db.rawQuery("select * from t_user where username=? and password=?", new String[]{username,password});
	
		if(cursor.moveToNext())
		{
			return true;//找到數據
		}
		return false;//沒有找到數據
	}
}
