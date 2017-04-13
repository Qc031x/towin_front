package com.sgfm.datacenter.entity;

import java.math.BigDecimal;

/**
 * TMakePersonnel entity. @author MyEclipse Persistence Tools
 */

public class TMakePersonnel implements java.io.Serializable {

	// Fields

	private int id;
	private String name;
	private int sex;
	private String marriage;
	private String phone;
	private int tel;
	private int mid;
	private String authorTime;
	private int state;
	private int sort;
	private int age;
	private String idNumber;
	private int isDefault;

	// Constructors

	/** default constructor */
	public TMakePersonnel() {
	}

	/** minimal constructor */
	public TMakePersonnel(int id, String name, int sex,
			String marriage) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.marriage = marriage;
	}

	/** full constructor */
	public TMakePersonnel(int id, String name, int sex,
			String marriage, String phone, int tel, int mid,
			String authorTime, int state, int sort,
			int age, String idNumber, int isDefault) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.marriage = marriage;
		this.phone = phone;
		this.tel = tel;
		this.mid = mid;
		this.authorTime = authorTime;
		this.state = state;
		this.sort = sort;
		this.age = age;
		this.idNumber = idNumber;
		this.isDefault = isDefault;
	}

	// Property accessors

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getAuthorTime() {
		return this.authorTime;
	}

	public void setAuthorTime(String authorTime) {
		this.authorTime = authorTime;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public int getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

}