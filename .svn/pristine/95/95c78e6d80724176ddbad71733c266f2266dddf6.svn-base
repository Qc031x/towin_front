package com.sgfm.datacenter.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TAppraiseTagId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TAppraiseTag implements java.io.Serializable {

	// Fields

	private int agid;
	private String tagName;
	private int tagType;
	private String postDate;
	private String inputMan;

	// Constructors

	/** default constructor */
	public TAppraiseTag() {
	}

	/** minimal constructor */
	public TAppraiseTag(int agid) {
		this.agid = agid;
	}

	/** full constructor */
	public TAppraiseTag(int agid, String tagName, int tagType,
			String postDate, String inputMan) {
		this.agid = agid;
		this.tagName = tagName;
		this.tagType = tagType;
		this.postDate = postDate;
		this.inputMan = inputMan;
	}

	// Property accessors

	@Column(name = "AGID", nullable = false, precision = 22, scale = 0)
	public int getAgid() {
		return this.agid;
	}

	public void setAgid(int agid) {
		this.agid = agid;
	}

	@Column(name = "TAG_NAME", length = 100)
	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Column(name = "TAG_TYPE", precision = 22, scale = 0)
	public int getTagType() {
		return this.tagType;
	}

	public void setTagType(int tagType) {
		this.tagType = tagType;
	}

	@Column(name = "POST_DATE", length = 20)
	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	@Column(name = "INPUT_MAN", length = 50)
	public String getInputMan() {
		return this.inputMan;
	}

	public void setInputMan(String inputMan) {
		this.inputMan = inputMan;
	}

}