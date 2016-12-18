package com.example.jc.store.com.team.bean;


/**
 * 订单表
 * 
 * @author JC
 * 
 */
public class Order {

	private int f_id;// 主键id
	private String f_orderid;// 订单编号
	private String f_time;// 添加时间
	private String f_totalprice;// 总价格
	private String f_address;// 地址
	private String f_phone;// 电话
	private String f_userid;// 用户id

	public Order(int f_id, String f_orderid, String f_time,
			String f_totalprice, String f_address, String f_phone,
			String f_userid) {
		super();
		this.f_id = f_id;
		this.f_orderid = f_orderid;
		this.f_time = f_time;
		this.f_totalprice = f_totalprice;
		this.f_address = f_address;
		this.f_phone = f_phone;
		this.f_userid = f_userid;
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

	public String getF_time() {
		return f_time;
	}

	public void setF_time(String f_time) {
		this.f_time = f_time;
	}

	public String getF_totalprice() {
		return f_totalprice;
	}

	public void setF_totalprice(String f_totalprice) {
		this.f_totalprice = f_totalprice;
	}

	public String getF_address() {
		return f_address;
	}

	public void setF_address(String f_address) {
		this.f_address = f_address;
	}

	public String getF_phone() {
		return f_phone;
	}

	public void setF_phone(String f_phone) {
		this.f_phone = f_phone;
	}

	public String getF_userid() {
		return f_userid;
	}

	public void setF_userid(String f_userid) {
		this.f_userid = f_userid;
	}

}
