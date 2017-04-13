package com.sgfm.datacenter.entity;

import java.math.BigDecimal;

/**
 * RProduct entity. @author MyEclipse Persistence Tools
 */

public class RProduct implements java.io.Serializable {

	// Fields

	private BigDecimal pid;
	private String name;
	private String PNo;
	private String maintitle;
	private String vicetitle;
	private BigDecimal invoiceSupply;
	private String newImg;
	private String searchTitle;
	private String searchKeywords;
	private String searchDescription;
	private String productDec;
	private BigDecimal alive;
	private BigDecimal serviceGoods;
	private String createDate;
	private String updateDate;
	private String createUserid;
	private String updateUserid;

	// Constructors

	/** default constructor */
	public RProduct() {
	}

	/** minimal constructor */
	public RProduct(BigDecimal pid) {
		this.pid = pid;
	}

	/** full constructor */
	public RProduct(BigDecimal pid, String name, String PNo, String maintitle,
			String vicetitle, BigDecimal invoiceSupply, String newImg,
			String searchTitle, String searchKeywords,
			String searchDescription, String productDec, BigDecimal alive,
			BigDecimal serviceGoods, String createDate, String updateDate,
			String createUserid, String updateUserid) {
		this.pid = pid;
		this.name = name;
		this.PNo = PNo;
		this.maintitle = maintitle;
		this.vicetitle = vicetitle;
		this.invoiceSupply = invoiceSupply;
		this.newImg = newImg;
		this.searchTitle = searchTitle;
		this.searchKeywords = searchKeywords;
		this.searchDescription = searchDescription;
		this.productDec = productDec;
		this.alive = alive;
		this.serviceGoods = serviceGoods;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.createUserid = createUserid;
		this.updateUserid = updateUserid;
	}

	// Property accessors

	public BigDecimal getPid() {
		return this.pid;
	}

	public void setPid(BigDecimal pid) {
		this.pid = pid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPNo() {
		return this.PNo;
	}

	public void setPNo(String PNo) {
		this.PNo = PNo;
	}

	public String getMaintitle() {
		return this.maintitle;
	}

	public void setMaintitle(String maintitle) {
		this.maintitle = maintitle;
	}

	public String getVicetitle() {
		return this.vicetitle;
	}

	public void setVicetitle(String vicetitle) {
		this.vicetitle = vicetitle;
	}

	public BigDecimal getInvoiceSupply() {
		return this.invoiceSupply;
	}

	public void setInvoiceSupply(BigDecimal invoiceSupply) {
		this.invoiceSupply = invoiceSupply;
	}

	public String getNewImg() {
		return this.newImg;
	}

	public void setNewImg(String newImg) {
		this.newImg = newImg;
	}

	public String getSearchTitle() {
		return this.searchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public String getSearchKeywords() {
		return this.searchKeywords;
	}

	public void setSearchKeywords(String searchKeywords) {
		this.searchKeywords = searchKeywords;
	}

	public String getSearchDescription() {
		return this.searchDescription;
	}

	public void setSearchDescription(String searchDescription) {
		this.searchDescription = searchDescription;
	}

	public String getProductDec() {
		return this.productDec;
	}

	public void setProductDec(String productDec) {
		this.productDec = productDec;
	}

	public BigDecimal getAlive() {
		return this.alive;
	}

	public void setAlive(BigDecimal alive) {
		this.alive = alive;
	}

	public BigDecimal getServiceGoods() {
		return this.serviceGoods;
	}

	public void setServiceGoods(BigDecimal serviceGoods) {
		this.serviceGoods = serviceGoods;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
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

}