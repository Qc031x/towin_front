package com.sgfm.datacenter.entity;


/**
 * SNewschannel entity. @author MyEclipse Persistence Tools
 */

public class SNewschannel implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String key;
	private Integer sort;
	private String createUserid;
	private String updateUserid;
	private String createTime;
	private String updateTime;

	// Constructors

	/** default constructor */
	public SNewschannel() {
	}

	/** minimal constructor */
	public SNewschannel(Long id) {
		this.id = id;
	}

	/** full constructor */
	public SNewschannel(Long id, String name, String key,
			Integer sort, String createUserid, String updateUserid,
			String createTime, String updateTime) {
		this.id = id;
		this.name = name;
		this.key = key;
		this.sort = sort;
		this.createUserid = createUserid;
		this.updateUserid = updateUserid;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCreateUserid() {
		return this.createUserid;
	}

	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}

	public String getUpdateUserid() {
		return this.updateUserid;
	}

	public void setUpdateUserid(String updateUserid) {
		this.updateUserid = updateUserid;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}