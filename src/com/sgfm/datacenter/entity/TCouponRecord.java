package com.sgfm.datacenter.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TCouponRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COUPON_RECORD", schema = "YIKANG")
public class TCouponRecord implements java.io.Serializable {

	// Fields

	private int crid;
	private int cpid;
	private int mid;
	private String MName;
	private int deductionCoin;
	private String consumeTime;

	// Constructors

	/** default constructor */
	public TCouponRecord() {
	}

	/** minimal constructor */
	public TCouponRecord(int crid, int cpid) {
		this.crid = crid;
		this.cpid = cpid;
	}

	/** full constructor */
	public TCouponRecord(int crid, int cpid, int mid,
			String MName, int deductionCoin, String consumeTime) {
		this.crid = crid;
		this.cpid = cpid;
		this.mid = mid;
		this.MName = MName;
		this.deductionCoin = deductionCoin;
		this.consumeTime = consumeTime;
	}

	// Property accessors
	@Id
	@Column(name = "CRID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getCrid() {
		return this.crid;
	}

	public void setCrid(int crid) {
		this.crid = crid;
	}

	@Column(name = "CPID", nullable = false, precision = 22, scale = 0)
	public int getCpid() {
		return this.cpid;
	}

	public void setCpid(int cpid) {
		this.cpid = cpid;
	}

	@Column(name = "MID", precision = 22, scale = 0)
	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Column(name = "M_NAME", length = 100)
	public String getMName() {
		return this.MName;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}

	@Column(name = "DEDUCTION_COIN", precision = 22, scale = 0)
	public int getDeductionCoin() {
		return this.deductionCoin;
	}

	public void setDeductionCoin(int deductionCoin) {
		this.deductionCoin = deductionCoin;
	}

	@Column(name = "CONSUME_TIME", length = 30)
	public String getConsumeTime() {
		return this.consumeTime;
	}

	public void setConsumeTime(String consumeTime) {
		this.consumeTime = consumeTime;
	}

}