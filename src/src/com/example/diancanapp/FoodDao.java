package com.team.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.team.db.DBHelper;
import com.team.model.Food;

public class FoodDao {
	private DBHelper dbHelper;
	private  SQLiteDatabase db;
	
	public FoodDao(Context context) {
		dbHelper=new DBHelper(context);
	}
	
	
	public List<Food> findAll()
	{
		List<Food> foods=new ArrayList<Food>();
		db=dbHelper.getReadableDatabase();
		Cursor cursor=db.rawQuery("select * from t_food", null);
		while(cursor.moveToNext())
		{
			foods.add(new Food(cursor.getInt(cursor.getColumnIndex("id")),cursor.getInt(cursor.getColumnIndex("type")),cursor.getInt(cursor.getColumnIndex("parentid")),cursor.getString(cursor.getColumnIndex("name")),cursor.getString(cursor.getColumnIndex("price")),cursor.getString(cursor.getColumnIndex("imagepath")),cursor.getString(cursor.getColumnIndex("detail"))));
		}
		return foods;
	}	
}
