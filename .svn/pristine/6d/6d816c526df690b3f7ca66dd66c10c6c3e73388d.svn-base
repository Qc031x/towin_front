package com.sgfm.datacenter.entity;


/**
 * TEmployeeOrder entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class TEmployeeOrder implements java.io.Serializable {

	// Fields

	private String oid;
	private String createTime;
	private double orderPay;
	private int payStatus;
	private int payType;
	private String payUser;
	private double totalPay;
	private String payTime;
	private int createUser;

	// Constructors

	/** default constructor */
	public TEmployeeOrder() {
	}

	/** minimal constructor */
	public TEmployeeOrder(String oid) {
		this.oid = oid;
	}

	/** full constructor */
	public TEmployeeOrder(String oid, String createTime, double orderPay,
			int payStatus, int payType, String payUser,
			double totalPay, String payTime, int createUser) {
		this.oid = oid;
		this.createTime = createTime;
		this.orderPay = orderPay;
		this.payStatus = payStatus;
		this.payType = payType;
		this.payUser = payUser;
		this.totalPay = totalPay;
		this.payTime = payTime;
		this.createUser = createUser;
	}

	// Property accessors

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public double getOrderPay() {
		return this.orderPay;
	}

	public void setOrderPay(double orderPay) {
		this.orderPay = orderPay;
	}

	public int getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public int getPayType() {
		return this.payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public String getPayUser() {
		return this.payUser;
	}

	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}

	public double getTotalPay() {
		return this.totalPay;
	}

	public void setTotalPay(double totalPay) {
		this.totalPay = totalPay;
	}

	public String getPayTime() {
		return this.payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public int getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("oid:"+this.getOid()+",");
		str.append("orderPay:"+this.getOrderPay()+",");
		str.append("payStatus:"+this.getPayStatus()+",");
		str.append("payType:"+this.getPayType()+",");
		str.append("payUser:"+this.getPayUser()+",");
		str.append("totalPay:"+this.getTotalPay()+",");
		str.append("payTime:"+this.getPayTime());
		return str.toString();
	}

}