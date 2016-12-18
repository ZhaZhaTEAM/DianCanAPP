package com.example.jc.store.com.team.bean;

public class GouWuChe {

	private int f_id;// 主键id
	private String f_goodid;// 商品id
	private String f_userid;// 用户id
	private String f_number;// 数量

	public GouWuChe(String f_goodid, String f_userid, String f_number) {
		this.f_goodid = f_goodid;
		this.f_userid = f_userid;
		this.f_number = f_number;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_goodid() {
		return f_goodid;
	}

	public void setF_goodid(String f_goodid) {
		this.f_goodid = f_goodid;
	}

	public String getF_userid() {
		return f_userid;
	}

	public void setF_userid(String f_userid) {
		this.f_userid = f_userid;
	}

	public String getF_number() {
		return f_number;
	}

	public void setF_number(String f_number) {
		this.f_number = f_number;
	}

}
