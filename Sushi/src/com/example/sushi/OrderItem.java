package com.example.jc.store.com.team.bean;

/**
 * 订单详细表
 * 
 * @author JC
 * 
 */
public class OrderItem {

	private int f_id;// 主键id
	private String f_orderid;// 外键订单id
	private String f_goodid;// 外键商品id
	private String f_number;// 商品数量

	public OrderItem(int f_id, String f_orderid, String f_goodid,
			String f_number) {
		super();
		this.f_id = f_id;
		this.f_orderid = f_orderid;
		this.f_goodid = f_goodid;
		this.f_number = f_number;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_orderid() {
		return f_orderid;
	}

	public void setF_orderid(String f_orderid) {
		this.f_orderid = f_orderid;
	}

	public String getF_goodid() {
		return f_goodid;
	}

	public void setF_goodid(String f_goodid) {
		this.f_goodid = f_goodid;
	}

	public String getF_number() {
		return f_number;
	}

	public void setF_number(String f_number) {
		this.f_number = f_number;
	}

}
