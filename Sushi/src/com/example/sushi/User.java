package com.example.jc.store.com.team.bean;

/**
 * 用户表
 * 
 * @author JC
 * 
 */
public class User {

	private int f_id;// 主键id
	private String f_username;// 用户名
	private String f_password;// 密码
	private String f_sex;// 性别
	private String f_phone;// 电话

	public User(int f_id, String f_username, String f_password, String f_sex,
			String f_phone) {
		super();
		this.f_id = f_id;
		this.f_username = f_username;
		this.f_password = f_password;
		this.f_sex = f_sex;
		this.f_phone = f_phone;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_username() {
		return f_username;
	}

	public void setF_username(String f_username) {
		this.f_username = f_username;
	}

	public String getF_password() {
		return f_password;
	}

	public void setF_password(String f_password) {
		this.f_password = f_password;
	}

	public String getF_sex() {
		return f_sex;
	}

	public void setF_sex(String f_sex) {
		this.f_sex = f_sex;
	}

	public String getF_phone() {
		return f_phone;
	}

	public void setF_phone(String f_phone) {
		this.f_phone = f_phone;
	}

}
