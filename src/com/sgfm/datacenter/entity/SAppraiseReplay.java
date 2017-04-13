/**
 * 
 */
package com.sgfm.datacenter.entity;

/** 
 * @author cxj
 * @date 2016-3-31 下午2:32:38
 * @version V 1.0
 * @TODO 描述
 */
public class SAppraiseReplay {

	// Fields

		private Integer rid;
		private Integer peid;
		private Integer mid;
		private String content;
		private String postDate;
		private Integer floor;
		private Integer handle;
		private String name;
		private Integer type;

		// Constructors

		/** default constructor */
		public SAppraiseReplay() {
		}

		/** full constructor */
		public SAppraiseReplay(Integer rid, Integer peid, Integer mid,
				String content, String postDate, Integer floor,
				Integer handle, String name, Integer type) {
			this.rid = rid;
			this.peid = peid;
			this.mid = mid;
			this.content = content;
			this.postDate = postDate;
			this.floor = floor;
			this.handle = handle;
			this.name = name;
			this.type = type;
		}

		// Property accessors

		public Integer getRid() {
			return this.rid;
		}

		public void setRid(Integer rid) {
			this.rid = rid;
		}

		public Integer getPeid() {
			return this.peid;
		}

		public void setPeid(Integer peid) {
			this.peid = peid;
		}

		public Integer getMid() {
			return this.mid;
		}

		public void setMid(Integer mid) {
			this.mid = mid;
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

		public Integer getFloor() {
			return this.floor;
		}

		public void setFloor(Integer floor) {
			this.floor = floor;
		}

		public Integer getHandle() {
			return this.handle;
		}

		public void setHandle(Integer handle) {
			this.handle = handle;
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

		

}
