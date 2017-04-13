package com.sgfm.datacenter.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TMemberCard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MEMBER_CARD", schema = "YIKANG")
public class TMemberCard implements java.io.Serializable {

	// Fields

	private int mcid;
	private String mcno;
	private String mcStatus;
	private int mid;
	private int mlid;
	private double balance;
	private int currentCredit;
	private String curreny;
	private String activeDate;
	private String postDate;
	private String applyDate;
	private String distributeState;
	private String distributeDate;
	private String useState;
	private String frozenReason;
	private String frozenSdate;
	private String frozenEdate;
	private String unfreezeReason;
	private String createType;
	private int cardcreateId;
	private int cardapplyId;
	private String tradeSyn;
	private String creditSyn;

	// Constructors

	/** default constructor */
	public TMemberCard() {
	}

	/** minimal constructor */
	public TMemberCard(int mcid, int mlid) {
		this.mcid = mcid;
		this.mlid = mlid;
	}

	/** full constructor */
	public TMemberCard(int mcid, String mcno, String mcStatus,
			int mid, int mlid, int balance,
			int currentCredit, String curreny, String activeDate,
			String postDate, String applyDate, String distributeState,
			String distributeDate, String useState, String frozenReason,
			String frozenSdate, String frozenEdate, String unfreezeReason,
			String createType, int cardcreateId, int cardapplyId,
			String tradeSyn, String creditSyn) {
		this.mcid = mcid;
		this.mcno = mcno;
		this.mcStatus = mcStatus;
		this.mid = mid;
		this.mlid = mlid;
		this.balance = balance;
		this.currentCredit = currentCredit;
		this.curreny = curreny;
		this.activeDate = activeDate;
		this.postDate = postDate;
		this.applyDate = applyDate;
		this.distributeState = distributeState;
		this.distributeDate = distributeDate;
		this.useState = useState;
		this.frozenReason = frozenReason;
		this.frozenSdate = frozenSdate;
		this.frozenEdate = frozenEdate;
		this.unfreezeReason = unfreezeReason;
		this.createType = createType;
		this.cardcreateId = cardcreateId;
		this.cardapplyId = cardapplyId;
		this.tradeSyn = tradeSyn;
		this.creditSyn = creditSyn;
	}

	// Property accessors
	@Id
	@Column(name = "MCID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getMcid() {
		return this.mcid;
	}

	public void setMcid(int mcid) {
		this.mcid = mcid;
	}

	@Column(name = "MCNO", length = 2000)
	public String getMcno() {
		return this.mcno;
	}

	public void setMcno(String mcno) {
		this.mcno = mcno;
	}

	@Column(name = "MC_STATUS", length = 2000)
	public String getMcStatus() {
		return this.mcStatus;
	}

	public void setMcStatus(String mcStatus) {
		this.mcStatus = mcStatus;
	}

	@Column(name = "MID", precision = 22, scale = 0)
	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Column(name = "MLID", nullable = false, precision = 22, scale = 0)
	public int getMlid() {
		return this.mlid;
	}

	public void setMlid(int mlid) {
		this.mlid = mlid;
	}

	@Column(name = "BALANCE", precision = 22, scale = 0)
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Column(name = "CURRENT_CREDIT", precision = 22, scale = 0)
	public int getCurrentCredit() {
		return this.currentCredit;
	}

	public void setCurrentCredit(int currentCredit) {
		this.currentCredit = currentCredit;
	}

	@Column(name = "CURRENY", length = 2000)
	public String getCurreny() {
		return this.curreny;
	}

	public void setCurreny(String curreny) {
		this.curreny = curreny;
	}

	@Column(name = "ACTIVE_DATE", length = 2000)
	public String getActiveDate() {
		return this.activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	@Column(name = "POST_DATE", length = 2000)
	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	@Column(name = "APPLY_DATE", length = 2000)
	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	@Column(name = "DISTRIBUTE_STATE", length = 2000)
	public String getDistributeState() {
		return this.distributeState;
	}

	public void setDistributeState(String distributeState) {
		this.distributeState = distributeState;
	}

	@Column(name = "DISTRIBUTE_DATE", length = 2000)
	public String getDistributeDate() {
		return this.distributeDate;
	}

	public void setDistributeDate(String distributeDate) {
		this.distributeDate = distributeDate;
	}

	@Column(name = "USE_STATE", length = 2000)
	public String getUseState() {
		return this.useState;
	}

	public void setUseState(String useState) {
		this.useState = useState;
	}

	@Column(name = "FROZEN_REASON", length = 2000)
	public String getFrozenReason() {
		return this.frozenReason;
	}

	public void setFrozenReason(String frozenReason) {
		this.frozenReason = frozenReason;
	}

	@Column(name = "FROZEN_SDATE", length = 2000)
	public String getFrozenSdate() {
		return this.frozenSdate;
	}

	public void setFrozenSdate(String frozenSdate) {
		this.frozenSdate = frozenSdate;
	}

	@Column(name = "FROZEN_EDATE", length = 2000)
	public String getFrozenEdate() {
		return this.frozenEdate;
	}

	public void setFrozenEdate(String frozenEdate) {
		this.frozenEdate = frozenEdate;
	}

	@Column(name = "UNFREEZE_REASON", length = 2000)
	public String getUnfreezeReason() {
		return this.unfreezeReason;
	}

	public void setUnfreezeReason(String unfreezeReason) {
		this.unfreezeReason = unfreezeReason;
	}

	@Column(name = "CREATE_TYPE", length = 2000)
	public String getCreateType() {
		return this.createType;
	}

	public void setCreateType(String createType) {
		this.createType = createType;
	}

	@Column(name = "CARDCREATE_ID", precision = 22, scale = 0)
	public int getCardcreateId() {
		return this.cardcreateId;
	}

	public void setCardcreateId(int cardcreateId) {
		this.cardcreateId = cardcreateId;
	}

	@Column(name = "CARDAPPLY_ID", precision = 22, scale = 0)
	public int getCardapplyId() {
		return this.cardapplyId;
	}

	public void setCardapplyId(int cardapplyId) {
		this.cardapplyId = cardapplyId;
	}

	@Column(name = "TRADE_SYN", length = 2000)
	public String getTradeSyn() {
		return this.tradeSyn;
	}

	public void setTradeSyn(String tradeSyn) {
		this.tradeSyn = tradeSyn;
	}

	@Column(name = "CREDIT_SYN", length = 2000)
	public String getCreditSyn() {
		return this.creditSyn;
	}

	public void setCreditSyn(String creditSyn) {
		this.creditSyn = creditSyn;
	}

}