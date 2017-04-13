package com.sgfm.datacenter.entity;

import java.math.BigDecimal;

/**
 * TProductAttribute entity. @author MyEclipse Persistence Tools
 */

public class TProductAttribute implements java.io.Serializable {

	// Fieldsint

	private int attriId;
	private int mapType;
	private int mapOwner;
	private int attValId;
	private String title;
	private String img;

	// Constructors

	/** default constructor */
	public TProductAttribute() {
	}

	/** minimal constructor */
	public TProductAttribute(int attriId) {
		this.attriId = attriId;
	}

	/** full constructor */
	public TProductAttribute(int attriId, int mapType,
			int mapOwner, int attValId, String title, String img) {
		this.attriId = attriId;
		this.mapType = mapType;
		this.mapOwner = mapOwner;
		this.attValId = attValId;
		this.title = title;
		this.img = img;
	}

	// Property accessors

	public int getAttriId() {
		return this.attriId;
	}

	public void setAttriId(int attriId) {
		this.attriId = attriId;
	}

	public int getMapType() {
		return this.mapType;
	}

	public void setMapType(int mapType) {
		this.mapType = mapType;
	}

	public int getMapOwner() {
		return this.mapOwner;
	}

	public void setMapOwner(int mapOwner) {
		this.mapOwner = mapOwner;
	}

	public int getAttValId() {
		return this.attValId;
	}

	public void setAttValId(int attValId) {
		this.attValId = attValId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}