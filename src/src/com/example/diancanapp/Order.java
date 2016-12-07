package com.team.model;

import java.util.Date;

/**
 * 订单表
 * 
 * @author JC
 * 
 */
public class Order {

	private int id;// 主键id
	private long orderid;// 订单编号
	private String totalprice;// 总金额
	private int tableid;// 桌号
	private String time;// 订单形成实际

	
	public Order(int id, long orderid, String totalprice, int tableid, String time) {
	this.id=id;
	this.orderid=orderid;
	this.totalprice=totalprice;
	this.tableid=tableid;
	this.time=time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public int getTableid() {
		return tableid;
	}

	public void setTableid(int tableid) {
		this.tableid = tableid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	

}
