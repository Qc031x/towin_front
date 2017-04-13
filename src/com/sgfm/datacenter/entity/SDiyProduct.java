package com.sgfm.datacenter.entity;


/**
 * SDiyProduct entity. @author MyEclipse Persistence Tools
 */

public class SDiyProduct implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Integer esid;
	private Double totalprice;
	private Double totaldisprice;
	private String creatTime;

	// Constructors

	/** default constructor */
	public SDiyProduct() {
	}

	/** minimal constructor */
	public SDiyProduct(Integer pid, Integer esid) {
		this.pid = pid;
		this.esid = esid;
	}

	/** full constructor */
	public SDiyProduct(Integer pid, Integer esid, Double totalprice,
			Double totaldisprice, String creatTime) {
		this.pid = pid;
		this.esid = esid;
		this.totalprice = totalprice;
		this.totaldisprice = totaldisprice;
		this.creatTime = creatTime;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getEsid() {
		return this.esid;
	}

	public void setEsid(Integer esid) {
		this.esid = esid;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Double getTotaldisprice() {
		return this.totaldisprice;
	}

	public void setTotaldisprice(Double totaldisprice) {
		this.totaldisprice = totaldisprice;
	}

	public String getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

}