package com.team.model;

/**
 * 菜单表
 * 
 * @author JC
 * 
 */
public class Food {

	private int id;// 主键id
	private int type;// 类型1、寿司 2、刺身
	private int parentid;// 父id
	private String name;// 菜名
	private String price;// 单价
	private String imagepath;// 图片路径
	private String detail;// 详细信息

	

	public Food(int id, int type, int parentid, String name, String price,
			String imagepath, String detail) {
		this.id=id;
		this.type=type;
		this.parentid=parentid;
		this.name=name;
		this.price=price;
		this.imagepath=imagepath;
		this.detail=detail;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
