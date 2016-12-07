package com.team.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.team.db.DBHelper;
import com.team.model.Food;
import com.team.model.Order;

public class OrderDao {
	private DBHelper dbHelper;
	private  SQLiteDatabase db;
	
	public OrderDao(Context context) {
		dbHelper=new DBHelper(context);
	}

	/**
	 * 添加
	 * @param user
	 */
	public void add(Order order)
	{
		db=dbHelper.getWritableDatabase();
		db.execSQL("insert into t_order (id,orderid,totalprice,tableid,time) values(?,?,?,?,?)",new Object[]{order.getId(),order.getOrderid(),order.getTotalprice(),order.getTableid(),order.getTime()});
	}
	
	/**
	 * 查詢
	 */
	public List<Order> findAll(){
		List<Order> orders=new ArrayList<Order>();
		db=dbHelper.getReadableDatabase();
		Cursor cursor=db.rawQuery("select * from t_order", null);
		while(cursor.moveToNext())
		{
			orders.add(new Order(cursor.getInt(cursor.getColumnIndex("id")),cursor.getLong(cursor.getColumnIndex("orderid")),cursor.getString(cursor.getColumnIndex("totalprice")),cursor.getInt(cursor.getColumnIndex("tableid")),cursor.getString(cursor.getColumnIndex("time"))));
		}
		return orders;
		
	}
	
}
