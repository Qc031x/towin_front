package com.sgfm.datacenter.entity;


/**
 * SAppraise entity. @author MyEclipse Persistence Tools
 */

public class SAppraise implements java.io.Serializable {

	// Fields

	private Integer peid;
	private Integer pid;
	private String postDate;
	private String mid;
	private String usetaste;
	private Integer pelevel;
	private Integer oid;
	private Integer csid;
	private Integer isPass;
	private Integer handleStatus;
	private String updateTime;
	private String name;
	private Integer type;
	private Integer sex;
	private Integer isRecommend;
	private Integer esid;
	private String MImg;

	// Constructors

	/** default constructor */
	public SAppraise() {
	}

	/** minimal constructor */
	public SAppraise(Integer peid, Integer pid, Integer oid) {
		this.peid = peid;
		this.pid = pid;
		this.oid = oid;
	}

	/** full constructor */
	public SAppraise(Integer peid, Integer pid, String postDate,
			String mid, String usetaste, Integer pelevel, Integer oid,
			Integer csid, Integer isPass, Integer handleStatus,
			String updateTime, String name, Integer type, Integer sex,
			Integer isRecommend, Integer esid, String MImg) {
		this.peid = peid;
		this.pid = pid;
		this.postDate = postDate;
		this.mid = mid;
		this.usetaste = usetaste;
		this.pelevel = pelevel;
		this.oid = oid;
		this.csid = csid;
		this.isPass = isPass;
		this.handleStatus = handleStatus;
		this.updateTime = updateTime;
		this.name = name;
		this.type = type;
		this.sex = sex;
		this.isRecommend = isRecommend;
		this.esid = esid;
		this.MImg = MImg;
	}

	// Property accessors

	public Integer getPeid() {
		return this.peid;
	}

	public void setPeid(Integer peid) {
		this.peid = peid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getUsetaste() {
		return this.usetaste;
	}

	public void setUsetaste(String usetaste) {
		this.usetaste = usetaste;
	}

	public Integer getPelevel() {
		return this.pelevel;
	}

	public void setPelevel(Integer pelevel) {
		this.pelevel = pelevel;
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getCsid() {
		return this.csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public Integer getIsPass() {
		return this.isPass;
	}

	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	public Integer getHandleStatus() {
		return this.handleStatus;
	}

	public void setHandleStatus(Integer handleStatus) {
		this.handleStatus = handleStatus;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Integer getEsid() {
		return this.esid;
	}

	public void setEsid(Integer esid) {
		this.esid = esid;
	}

	public String getMImg() {
		return this.MImg;
	}

	public void setMImg(String MImg) {
		this.MImg = MImg;
	}

}