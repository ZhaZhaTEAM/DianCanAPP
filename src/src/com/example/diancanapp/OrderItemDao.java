package com.team.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.team.db.DBHelper;
import com.team.model.Order;
import com.team.model.OrderItem;

public class OrderItemDao {

	
	private DBHelper dbHelper;
	private  SQLiteDatabase db;
	
	public OrderItemDao(Context context) {
		dbHelper=new DBHelper(context);
	}

	/**
	 * 添加
	 * @param user
	 */
	public void add(OrderItem orderItem)
	{
		db=dbHelper.getWritableDatabase();
		db.execSQL("insert into t_OrderItem (id,orderid,foodid,number) values(?,?,?,?)",new Object[]{orderItem.getId(),orderItem.getOrderid(),orderItem.getFoodid(),orderItem.getNumber()});
	}
	
	/**
	 * 查詢全部
	 */
	public List<OrderItem> findAll(){
		List<OrderItem> orderitems=new ArrayList<OrderItem>();
		db=dbHelper.getReadableDatabase();
		Cursor cursor=db.rawQuery("select * from t_OrderItem", null);
		while(cursor.moveToNext())
		{
			orderitems.add(new OrderItem(cursor.getInt(cursor.getColumnIndex("id")),cursor.getInt(cursor.getColumnIndex("orderid")),cursor.getInt(cursor.getColumnIndex("foodid")),cursor.getInt(cursor.getColumnIndex("number"))));
		}
		return orderitems;
		
	}
	
	/**
	 * 根据订单号查询
	 */
	public List<OrderItem> findByOrderid(int orderid)
	{List<OrderItem> orderitems=new ArrayList<OrderItem>();
	db=dbHelper.getReadableDatabase();
	Cursor cursor=db.rawQuery("select * from t_OrderItem where orderid=?", new String[]{String.valueOf(orderid)});
	while(cursor.moveToNext())
	{
		orderitems.add(new OrderItem(cursor.getInt(cursor.getColumnIndex("id")),cursor.getInt(cursor.getColumnIndex("orderid")),cursor.getInt(cursor.getColumnIndex("foodid")),cursor.getInt(cursor.getColumnIndex("number"))));
	}
	return orderitems;
		
	}
	
}
