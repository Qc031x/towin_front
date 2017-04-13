package com.sgfm.datacenter.entity;

import java.math.BigDecimal;

/**
 * 购物车实体类
 * @author 曹雄
 * @date 2015年5月15日18:01:58
 */

public class TShoppingcart implements java.io.Serializable {

	// Fields

	private int cid;
	private int mid;
	private int pid;
	private int quantity;
	private double shopPrice;
	private double marketPrice;
	private String productName;
	private int productAttr;
	private String productImg;
	private String productDec;
	private String insertDate;
	private String passDate;
	private String ip;
	private int isInvoice;
	private int cardType;
	private double sumPrice;
	private int isFromCart;
	private int FWhere;
	private int ratios;
	private String imgPhone;
	private String PName;
	private String discount;
	
	// Constructors

	public String getImgPhone() {
		return imgPhone;
	}


	public String getDiscount() {
		return discount;
	}


	public void setDiscount(String discount) {
		this.discount = discount;
	}


	public String getPName() {
		return PName;
	}


	public void setPName(String pName) {
		PName = pName;
	}


	public void setImgPhone(String imgPhone) {
		this.imgPhone = imgPhone;
	}


	public int getRatios() {
		return ratios;
	}


	public void setRatios(int ratios) {
		this.ratios = ratios;
	}


	/** default constructor */
	public TShoppingcart() {
	}

	
	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getShopPrice() {
		return this.shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductAttr() {
		return this.productAttr;
	}

	public void setProductAttr(int productAttr) {
		this.productAttr = productAttr;
	}

	public String getProductImg() {
		return this.productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductDec() {
		return this.productDec;
	}

	public void setProductDec(String productDec) {
		this.productDec = productDec;
	}

	public String getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getPassDate() {
		return this.passDate;
	}

	public void setPassDate(String passDate) {
		this.passDate = passDate;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getIsInvoice() {
		return this.isInvoice;
	}

	public void setIsInvoice(int isInvoice) {
		this.isInvoice = isInvoice;
	}
	
	public int getCardType() {
		return this.cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	
	public double getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public double getSumPrice() {
		return this.sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getIsFromCart() {
		return this.isFromCart;
	}

	public void setIsFromCart(int isFromCart) {
		this.isFromCart = isFromCart;
	}
	
	public int getFWhere() {
		return this.FWhere;
	}

	public void setFWhere(int FWhere) {
		this.FWhere = FWhere;
	}
}