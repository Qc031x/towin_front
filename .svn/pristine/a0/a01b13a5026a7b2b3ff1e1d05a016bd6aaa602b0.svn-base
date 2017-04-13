package com.sgfm.datacenter.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TPEvaluateReplay entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_P_EVALUATE_REPLAY", schema = "YIKANG")
public class TPEvaluateReplay implements java.io.Serializable {

	// Fields

	private int rid;
	private int peid;
	private String content;
	private int MIdentification;
	private String postDate;
	private int floor;
	private int handle;
	private int mid;
	private String name;
	private int type;
	
	// Constructors

	/** default constructor */
	public TPEvaluateReplay() {
	}

	/** minimal constructor */
	public TPEvaluateReplay(int rid) {
		this.rid = rid;
	}

	/** full constructor */
	public TPEvaluateReplay(int rid, int peid, String content,
			int MIdentification, String postDate, int floor,
			int handle) {
		this.rid = rid;
		this.peid = peid;
		this.content = content;
		this.MIdentification = MIdentification;
		this.postDate = postDate;
		this.floor = floor;
		this.handle = handle;
	}

	// Property accessors
	@Id
	@Column(name = "RID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getRid() {
		return this.rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Column(name = "PEID", precision = 22, scale = 0)
	public int getPeid() {
		return this.peid;
	}

	public void setPeid(int peid) {
		this.peid = peid;
	}

	@Column(name = "CONTENT", length = 2000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "M_IDENTIFICATION", precision = 22, scale = 0)
	public int getMIdentification() {
		return this.MIdentification;
	}

	public void setMIdentification(int MIdentification) {
		this.MIdentification = MIdentification;
	}

	@Column(name = "POST_DATE", length = 2000)
	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	@Column(name = "FLOOR", precision = 22, scale = 0)
	public int getFloor() {
		return this.floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Column(name = "HANDLE", precision = 22, scale = 0)
	public int getHandle() {
		return this.handle;
	}

	public void setHandle(int handle) {
		this.handle = handle;
	}
	
	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}