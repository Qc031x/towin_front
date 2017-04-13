package com.sgfm.datacenter.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TCoupon entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COUPON", schema = "YIKANG")
public class TCoupon implements java.io.Serializable {

	// Fields

	private int cpid;
	private int mid;
	private String MName;
	private String card;
	private String password;
	private String createTime;
	//private String passTime;
	private String sendTime;
	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	private int totalCoin;
	private int balanceCoin;
	private int isValid;
	private int status;
	private int isActive;
	private int batchNumber;
	private int applyClient;
	private int applyEsid;
	private String applyEsName;
	private int applyPid;
	private String applyProName;
	private String activeTime;
	private int fwhere;
	
	
	

	// Constructors

	public int getFwhere() {
		return fwhere;
	}

	public void setFwhere(int fwhere) {
		this.fwhere = fwhere;
	}

	/** default constructor */
	public TCoupon() {
	}

	/** minimal constructor */
	public TCoupon(int cpid) {
		this.cpid = cpid;
	}

	/** full constructor */
	public TCoupon(int cpid, int mid, String MName, String card,
			String password, String createTime, String passTime,
			int totalCoin, int balanceCoin, int isValid,
			int status, int isActive, int batchNumber,
			int applyClient, int applyEsid, String applyEsName,
			int applyPid, String applyProName) {
		this.cpid = cpid;
		this.mid = mid;
		this.MName = MName;
		this.card = card;
		this.password = password;
		this.createTime = createTime;
		//this.passTime = passTime;
		this.totalCoin = totalCoin;
		this.balanceCoin = balanceCoin;
		this.isValid = isValid;
		this.status = status;
		this.isActive = isActive;
		this.batchNumber = batchNumber;
		this.applyClient = applyClient;
		this.applyEsid = applyEsid;
		this.applyEsName = applyEsName;
		this.applyPid = applyPid;
		this.applyProName = applyProName;
	}

	// Property accessors
	@Id
	@Column(name = "CPID", unique = true, nullable = false, precision = 22, scale = 0)
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

	@Column(name = "CARD", length = 100)
	public String getCard() {
		return this.card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "CREATE_TIME", length = 30)
	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/*@Column(name = "PASS_TIME", length = 30)
	public String getPassTime() {
		return this.passTime;
	}

	public void setPassTime(String passTime) {
		this.passTime = passTime;
	}*/

	@Column(name = "TOTAL_COIN", precision = 22, scale = 0)
	public int getTotalCoin() {
		return this.totalCoin;
	}

	public void setTotalCoin(int totalCoin) {
		this.totalCoin = totalCoin;
	}

	@Column(name = "BALANCE_COIN", precision = 22, scale = 0)
	public int getBalanceCoin() {
		return this.balanceCoin;
	}

	public void setBalanceCoin(int balanceCoin) {
		this.balanceCoin = balanceCoin;
	}

	@Column(name = "IS_VALID", precision = 22, scale = 0)
	public int getIsValid() {
		return this.isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	@Column(name = "STATUS", precision = 22, scale = 0)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "IS_ACTIVE", precision = 22, scale = 0)
	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Column(name = "BATCH_NUMBER", precision = 22, scale = 0)
	public int getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(int batchNumber) {
		this.batchNumber = batchNumber;
	}

	@Column(name = "APPLY_CLIENT", precision = 22, scale = 0)
	public int getApplyClient() {
		return this.applyClient;
	}

	public void setApplyClient(int applyClient) {
		this.applyClient = applyClient;
	}

	@Column(name = "APPLY_ESID", precision = 22, scale = 0)
	public int getApplyEsid() {
		return this.applyEsid;
	}

	public void setApplyEsid(int applyEsid) {
		this.applyEsid = applyEsid;
	}

	@Column(name = "APPLY_ES_NAME", length = 100)
	public String getApplyEsName() {
		return this.applyEsName;
	}

	public void setApplyEsName(String applyEsName) {
		this.applyEsName = applyEsName;
	}

	@Column(name = "APPLY_PID", precision = 22, scale = 0)
	public int getApplyPid() {
		return this.applyPid;
	}

	public void setApplyPid(int applyPid) {
		this.applyPid = applyPid;
	}

	@Column(name = "APPLY_PRO_NAME", length = 100)
	public String getApplyProName() {
		return this.applyProName;
	}

	public void setApplyProName(String applyProName) {
		this.applyProName = applyProName;
	}
	
	public String getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}

}