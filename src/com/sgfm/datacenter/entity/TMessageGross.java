package com.sgfm.datacenter.entity;

public class TMessageGross implements java.io.Serializable {
	// Fields

	private String currentTime;
	private String mobile;
	private String title;



	public String getCurrentTime() {
		return this.currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
