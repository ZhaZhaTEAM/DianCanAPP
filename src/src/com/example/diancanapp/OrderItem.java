package com.team.model;

/**
 * 订单详情表
 * 
 * @author JC
 * 
 */
public class OrderItem {

	private int id;// 主键id
	private int orderid;// 订单外键
	private int foodid;// 菜单外键
	private int number;// 数量

	

	public OrderItem(int id, int orderid, int foodid, int number) {
		this.id=id;
		this.orderid=orderid;
		this.foodid=foodid;
		this.number=number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getFoodid() {
		return foodid;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
