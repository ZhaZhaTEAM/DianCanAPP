package com.team.model;

/**
 * 用户表
 * 
 * @author JC
 * 
 */
public class User {

	private int id;// 主键id
	private String username;// 账号
	private String password;// 密码

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
