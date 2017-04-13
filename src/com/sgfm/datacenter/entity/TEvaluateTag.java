package com.sgfm.datacenter.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TEvaluateTag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_EVALUATE_TAG", schema = "YIKANG")
public class TEvaluateTag implements java.io.Serializable {

	// Fields

	private int etid;
	private int peid;
	private int agid;
	private String tagName;

	// Constructors

	/** default constructor */
	public TEvaluateTag() {
	}

	/** minimal constructor */
	public TEvaluateTag(int etid, int peid) {
		this.etid = etid;
		this.peid = peid;
	}

	/** full constructor */
	public TEvaluateTag(int etid, int peid, int agid,
			String tagName) {
		this.etid = etid;
		this.peid = peid;
		this.agid = agid;
		this.tagName = tagName;
	}

	// Property accessors
	@Id
	@Column(name = "ETID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getEtid() {
		return this.etid;
	}

	public void setEtid(int etid) {
		this.etid = etid;
	}

	@Column(name = "PEID", nullable = false, precision = 22, scale = 0)
	public int getPeid() {
		return this.peid;
	}

	public void setPeid(int peid) {
		this.peid = peid;
	}

	@Column(name = "AGID", precision = 22, scale = 0)
	public int getAgid() {
		return this.agid;
	}

	public void setAgid(int agid) {
		this.agid = agid;
	}

	@Column(name = "TAG_NAME", length = 150)
	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}