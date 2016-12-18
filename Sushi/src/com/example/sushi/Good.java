package com.example.jc.store.com.team.bean;

/**
 * 商品表
 * 
 * @author JC
 * 
 */
public class Good {
	private int f_id;// 主键id
	private String f_type;// 类型
	private String f_name;// 名字
	private String f_parentid;// 父id
	private String f_price;// 价格
	private String f_imgpath;// 图片路劲
	private String f_detail;// 细节
	private String f_number;//数量

	


	public Good(int f_id, String f_type, String f_name, String f_parentid,
			String f_price, String f_imgpath, String f_detail,String f_number) {
		super();
		this.f_id = f_id;
		this.f_type = f_type;
		this.f_name = f_name;
		this.f_parentid = f_parentid;
		this.f_price = f_price;
		this.f_imgpath = f_imgpath;
		this.f_detail = f_detail;
		this.f_number=f_number;
	}




	public int getF_id() {
		return f_id;
	}




	public void setF_id(int f_id) {
		this.f_id = f_id;
	}




	public String getF_type() {
		return f_type;
	}




	public void setF_type(String f_type) {
		this.f_type = f_type;
	}




	public String getF_name() {
		return f_name;
	}




	public void setF_name(String f_name) {
		this.f_name = f_name;
	}




	public String getF_parentid() {
		return f_parentid;
	}




	public void setF_parentid(String f_parentid) {
		this.f_parentid = f_parentid;
	}




	public String getF_price() {
		return f_price;
	}




	public void setF_price(String f_price) {
		this.f_price = f_price;
	}




	public String getF_imgpath() {
		return f_imgpath;
	}




	public void setF_imgpath(String f_imgpath) {
		this.f_imgpath = f_imgpath;
	}




	public String getF_detail() {
		return f_detail;
	}




	public void setF_detail(String f_detail) {
		this.f_detail = f_detail;
	}


	public String getF_number() {
		return f_number;
	}

	public void setF_number(String f_number) {
		this.f_number = f_number;
	}
}
