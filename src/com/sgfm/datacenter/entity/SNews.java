package com.sgfm.datacenter.entity;


/**
 * SNews entity. @author MyEclipse Persistence Tools
 */

public class SNews implements java.io.Serializable {

	// Fields

	private Long id;
	private Long typeid;
	private String title;
	private String summary;
	private String img;
	private String content;
	private String postDate;
	private String createUserid;
	private String updateUserid;
	private String createTime;
	private String updateTime;
	private Integer sort;
	private Long click;
	private String source;
	private String channel;
	private String author;
	// Constructors

	/** default constructor */
	public SNews() {
	}

	/** minimal constructor */
	public SNews(Long id) {
		this.id = id;
	}

	/** full constructor */
	public SNews(Long id, Long typeid, String title,
			String summary, String img, String content, String postDate,
			String createUserid, String updateUserid, String createTime,
			String updateTime,String source, Long click,String author) {
		this.id = id;
		this.typeid = typeid;
		this.title = title;
		this.summary = summary;
		this.img = img;
		this.content = content;
		this.postDate = postDate;
		this.createUserid = createUserid;
		this.updateUserid = updateUserid;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.click = click;
		this.source = source;
		this.author = author;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getCreateUserid() {
		return this.createUserid;
	}

	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}

	public String getUpdateUserid() {
		return this.updateUserid;
	}

	public void setUpdateUserid(String updateUserid) {
		this.updateUserid = updateUserid;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Long getClick() {
		return this.click;
	}

	public void setClick(Long click) {
		this.click = click;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
}