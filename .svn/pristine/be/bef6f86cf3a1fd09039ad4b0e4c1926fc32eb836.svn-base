package com.sgfm.datacenter.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TCreditLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CREDIT_LOG", schema = "YIKANG")
public class TCreditLog implements java.io.Serializable {

	// Fields

	private int clid;
	private int preCredit;
	private int opCredit;
	private int postCredit;
	private String operDesc;
	private int approveFlag;
	private int approved;
	private String note;
	private String postDate;
	private String mcid;
	private int oid;
	private String logType;
	private String operator;
	private double preCoupon;
	private double opCoupon;
	private double postCoupon;
	private String card;
	
	private String opClass;
	private String creditOpType;
	private String couponOpType;
	
	private String type;
	private String ids;


	public String getOpClass() {
		return opClass;
	}

	public void setOpClass(String opClass) {
		this.opClass = opClass;
	}
	


	/**
	 * @return the cieditoptype
	 */
	public String getCreditOpType() {
		return creditOpType;
	}

	/**
	 * @param cieditoptype the cieditoptype to set
	 */
	public void setCreditOpType(String creditOpType) {
		this.creditOpType = creditOpType;
	}

	/**
	 * @return the couponoptype
	 */
	public String getCouponOpType() {
		return couponOpType;
	}

	/**
	 * @param couponoptype the couponoptype to set
	 */
	public void setCouponOpType(String couponOpType) {
		this.couponOpType = couponOpType;
	}
	
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	
	public void setIds(String ids){
		this.ids = ids;
	}
	public String getIds(){
		return ids;
	}

	/** default constructor */
	public TCreditLog() {
	}

	/** minimal constructor */
	public TCreditLog(int clid) {
		this.clid = clid;
	}

	
	// Property accessors
	@Id
	@Column(name = "CLID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getClid() {
		return this.clid;
	}

	public void setClid(int clid) {
		this.clid = clid;
	}

	@Column(name = "PRE_CREDIT", precision = 22, scale = 0)
	public int getPreCredit() {
		return this.preCredit;
	}

	public void setPreCredit(int preCredit) {
		this.preCredit = preCredit;
	}

	@Column(name = "OP_CREDIT", precision = 22, scale = 0)
	public int getOpCredit() {
		return this.opCredit;
	}

	public void setOpCredit(int opCredit) {
		this.opCredit = opCredit;
	}

	@Column(name = "POST_CREDIT", precision = 22, scale = 0)
	public int getPostCredit() {
		return this.postCredit;
	}

	public void setPostCredit(int postCredit) {
		this.postCredit = postCredit;
	}

	@Column(name = "OPER_DESC", length = 2000)
	public String getOperDesc() {
		return this.operDesc;
	}

	public void setOperDesc(String operDesc) {
		this.operDesc = operDesc;
	}

	@Column(name = "APPROVE_FLAG", precision = 22, scale = 0)
	public int getApproveFlag() {
		return this.approveFlag;
	}

	public void setApproveFlag(int approveFlag) {
		this.approveFlag = approveFlag;
	}

	@Column(name = "APPROVED", precision = 22, scale = 0)
	public int getApproved() {
		return this.approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	@Column(name = "NOTE", length = 2000)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "POST_DATE", length = 2000)
	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	@Column(name = "MCID", length = 2000)
	public String getMcid() {
		return this.mcid;
	}

	public void setMcid(String mcid) {
		this.mcid = mcid;
	}

	@Column(name = "OID", precision = 22, scale = 0)
	public int getOid() {
		return this.oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	@Column(name = "LOG_TYPE", length = 2000)
	public String getLogType() {
		return this.logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	@Column(name = "OPERATOR", length = 2000)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name = "PRE_COUPON", precision = 22, scale = 0)
	public double getPreCoupon() {
		return this.preCoupon;
	}

	public void setPreCoupon(double preCoupon) {
		this.preCoupon = preCoupon;
	}

	@Column(name = "OP_COUPON", precision = 22, scale = 0)
	public double getOpCoupon() {
		return this.opCoupon;
	}

	public void setOpCoupon(double opCoupon) {
		this.opCoupon = opCoupon;
	}

	@Column(name = "POST_COUPON", precision = 22, scale = 0)
	public double getPostCoupon() {
		return this.postCoupon;
	}

	public void setPostCoupon(double postCoupon) {
		this.postCoupon = postCoupon;
	}

	@Column(name = "CARD", length = 100)
	public String getCard() {
		return this.card;
	}

	public void setCard(String card) {
		this.card = card;
	}

}