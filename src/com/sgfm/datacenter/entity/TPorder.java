package com.sgfm.datacenter.entity;

import java.math.BigDecimal;

/**
 * 订单实体类
 * @author 曹雄
 * @date 2015年5月15日18:01:58
 */

public class TPorder implements java.io.Serializable {

	// Fields

	private int oid;
	private double sumPrice;
	private double actualPay;
	private int mid;
	private String email;
	private int province;
	private String name;
	private String address;
	private String postcode;
	private String tel;
	private String mobile;
	private String note;
	private String ip;
	private String postDate;
	private int payType;
	private double payTypeCostPercnet;
	private int deliveryType;
	private int delTypeCost;
	private int handleStatus;
	private String handleNote;
	private String deliveryNo;
	private String payAppendinfo;
	private int city;
	private String provinceName;
	private String cityName;
	private int giveType;
	private String giveGift;
	private int giveMoney;
	private int havePacket;
	private String giveImg;
	private int DProvince;
	private int DCity;
	private String DEmail;
	private String DName;
	private String DTel;
	private String DMobile;
	private String DPostcode;
	private String DAddress;
	private String DProvinceName;
	private String DCityName;
	private int aderMid;
	private int aderDiscount;
	private String cardNo;
	private int improveCost;
	private String handleNoteC;
	private int invoiceId;
	private int payStatus;
	private int payCost;
	private int haveExchange;
	private double readyAccount;
	private String DBestTime;
	private String DBuilding;
	private int DArea;
	private String FWhere;
	private String DAreaName;
	private int hasPay;
	private int consumeStatus;
	private int coin;
	private int pv;
	private String porderCode;
	private String creator;
	private String deliveryTime;
	private String receiveTime;
	private int giveCoin;
	private String giveCoinStatus;
	private String finishedTime;
	private int pvCost;
	private String payedTime;
	private int scid;
	private int sid;
	private int isimport;
	private String orderType;
	private int teamorderStatus;
	private int sendPressmessageCount;
	private String giftcardNo;
	private int giftcardPrice;
	private int bookingVerificationCode;
	private int isValid;
	private int porderType;
	private int kdNumber;
	private int isValidFh;
	private int DCounty;
	private String kdName;
	private String kdDay;
	private String client;
	private int entityCount;
	private int virtualCount;
	private int isEvaluate;
	private int checkOrder;

	public TPorder(){
		
	}

	public int getOid() {
		return this.oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public double getSumPrice() {
		return this.sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public double getActualPay() {
		return this.actualPay;
	}

	public void setActualPay(double actualPay) {
		this.actualPay = actualPay;
	}

	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProvince() {
		return this.province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public int getPayType() {
		return this.payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public double getPayTypeCostPercnet() {
		return this.payTypeCostPercnet;
	}

	public void setPayTypeCostPercnet(double payTypeCostPercnet) {
		this.payTypeCostPercnet = payTypeCostPercnet;
	}

	public int getDeliveryType() {
		return this.deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getDelTypeCost() {
		return this.delTypeCost;
	}

	public void setDelTypeCost(int delTypeCost) {
		this.delTypeCost = delTypeCost;
	}

	public int getHandleStatus() {
		return this.handleStatus;
	}

	public void setHandleStatus(int handleStatus) {
		this.handleStatus = handleStatus;
	}

	public String getHandleNote() {
		return this.handleNote;
	}

	public void setHandleNote(String handleNote) {
		this.handleNote = handleNote;
	}

	public String getDeliveryNo() {
		return this.deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getPayAppendinfo() {
		return this.payAppendinfo;
	}

	public void setPayAppendinfo(String payAppendinfo) {
		this.payAppendinfo = payAppendinfo;
	}

	public int getCity() {
		return this.city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getGiveType() {
		return this.giveType;
	}

	public void setGiveType(int giveType) {
		this.giveType = giveType;
	}

	public String getGiveGift() {
		return this.giveGift;
	}

	public void setGiveGift(String giveGift) {
		this.giveGift = giveGift;
	}

	public int getGiveMoney() {
		return this.giveMoney;
	}

	public void setGiveMoney(int giveMoney) {
		this.giveMoney = giveMoney;
	}

	public int getHavePacket() {
		return this.havePacket;
	}

	public void setHavePacket(int havePacket) {
		this.havePacket = havePacket;
	}

	public String getGiveImg() {
		return this.giveImg;
	}

	public void setGiveImg(String giveImg) {
		this.giveImg = giveImg;
	}

	public int getDProvince() {
		return this.DProvince;
	}

	public void setDProvince(int DProvince) {
		this.DProvince = DProvince;
	}

	public int getDCity() {
		return this.DCity;
	}

	public void setDCity(int DCity) {
		this.DCity = DCity;
	}

	public String getDEmail() {
		return this.DEmail;
	}

	public void setDEmail(String DEmail) {
		this.DEmail = DEmail;
	}

	public String getDName() {
		return this.DName;
	}

	public void setDName(String DName) {
		this.DName = DName;
	}

	public String getDTel() {
		return this.DTel;
	}

	public void setDTel(String DTel) {
		this.DTel = DTel;
	}

	public String getDMobile() {
		return this.DMobile;
	}

	public void setDMobile(String DMobile) {
		this.DMobile = DMobile;
	}

	public String getDPostcode() {
		return this.DPostcode;
	}

	public void setDPostcode(String DPostcode) {
		this.DPostcode = DPostcode;
	}

	public String getDAddress() {
		return this.DAddress;
	}

	public void setDAddress(String DAddress) {
		this.DAddress = DAddress;
	}

	public String getDProvinceName() {
		return this.DProvinceName;
	}

	public void setDProvinceName(String DProvinceName) {
		this.DProvinceName = DProvinceName;
	}

	public String getDCityName() {
		return this.DCityName;
	}

	public void setDCityName(String DCityName) {
		this.DCityName = DCityName;
	}

	public int getAderMid() {
		return this.aderMid;
	}

	public void setAderMid(int aderMid) {
		this.aderMid = aderMid;
	}

	public int getAderDiscount() {
		return this.aderDiscount;
	}

	public void setAderDiscount(int aderDiscount) {
		this.aderDiscount = aderDiscount;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getImproveCost() {
		return this.improveCost;
	}

	public void setImproveCost(int improveCost) {
		this.improveCost = improveCost;
	}

	public String getHandleNoteC() {
		return this.handleNoteC;
	}

	public void setHandleNoteC(String handleNoteC) {
		this.handleNoteC = handleNoteC;
	}

	public int getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public int getPayCost() {
		return this.payCost;
	}

	public void setPayCost(int payCost) {
		this.payCost = payCost;
	}

	public int getHaveExchange() {
		return this.haveExchange;
	}

	public void setHaveExchange(int haveExchange) {
		this.haveExchange = haveExchange;
	}

	public double getReadyAccount() {
		return this.readyAccount;
	}

	public void setReadyAccount(double readyAccount) {
		this.readyAccount = readyAccount;
	}

	public String getDBestTime() {
		return this.DBestTime;
	}

	public void setDBestTime(String DBestTime) {
		this.DBestTime = DBestTime;
	}

	public String getDBuilding() {
		return this.DBuilding;
	}

	public void setDBuilding(String DBuilding) {
		this.DBuilding = DBuilding;
	}

	public int getDArea() {
		return this.DArea;
	}

	public void setDArea(int DArea) {
		this.DArea = DArea;
	}

	public String getFWhere() {
		return this.FWhere;
	}

	public void setFWhere(String FWhere) {
		this.FWhere = FWhere;
	}

	public String getDAreaName() {
		return this.DAreaName;
	}

	public void setDAreaName(String DAreaName) {
		this.DAreaName = DAreaName;
	}

	public int getHasPay() {
		return this.hasPay;
	}

	public void setHasPay(int hasPay) {
		this.hasPay = hasPay;
	}

	public int getConsumeStatus() {
		return this.consumeStatus;
	}

	public void setConsumeStatus(int consumeStatus) {
		this.consumeStatus = consumeStatus;
	}

	public int getCoin() {
		return this.coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getPv() {
		return this.pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public String getPorderCode() {
		return this.porderCode;
	}

	public void setPorderCode(String porderCode) {
		this.porderCode = porderCode;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public int getGiveCoin() {
		return this.giveCoin;
	}

	public void setGiveCoin(int giveCoin) {
		this.giveCoin = giveCoin;
	}

	public String getGiveCoinStatus() {
		return this.giveCoinStatus;
	}

	public void setGiveCoinStatus(String giveCoinStatus) {
		this.giveCoinStatus = giveCoinStatus;
	}

	public String getFinishedTime() {
		return this.finishedTime;
	}

	public void setFinishedTime(String finishedTime) {
		this.finishedTime = finishedTime;
	}

	public int getPvCost() {
		return this.pvCost;
	}

	public void setPvCost(int pvCost) {
		this.pvCost = pvCost;
	}

	public String getPayedTime() {
		return this.payedTime;
	}

	public void setPayedTime(String payedTime) {
		this.payedTime = payedTime;
	}

	public int getScid() {
		return this.scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getIsimport() {
		return this.isimport;
	}

	public void setIsimport(int isimport) {
		this.isimport = isimport;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getTeamorderStatus() {
		return this.teamorderStatus;
	}

	public void setTeamorderStatus(int teamorderStatus) {
		this.teamorderStatus = teamorderStatus;
	}

	public int getSendPressmessageCount() {
		return this.sendPressmessageCount;
	}

	public void setSendPressmessageCount(int sendPressmessageCount) {
		this.sendPressmessageCount = sendPressmessageCount;
	}

	public String getGiftcardNo() {
		return this.giftcardNo;
	}

	public void setGiftcardNo(String giftcardNo) {
		this.giftcardNo = giftcardNo;
	}

	public int getGiftcardPrice() {
		return this.giftcardPrice;
	}

	public void setGiftcardPrice(int giftcardPrice) {
		this.giftcardPrice = giftcardPrice;
	}

	public int getBookingVerificationCode() {
		return this.bookingVerificationCode;
	}

	public void setBookingVerificationCode(int bookingVerificationCode) {
		this.bookingVerificationCode = bookingVerificationCode;
	}

	public int getIsValid() {
		return this.isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public int getPorderType() {
		return this.porderType;
	}

	public void setPorderType(int porderType) {
		this.porderType = porderType;
	}

	public int getKdNumber() {
		return this.kdNumber;
	}

	public void setKdNumber(int kdNumber) {
		this.kdNumber = kdNumber;
	}

	public int getIsValidFh() {
		return this.isValidFh;
	}

	public void setIsValidFh(int isValidFh) {
		this.isValidFh = isValidFh;
	}

	public int getDCounty() {
		return this.DCounty;
	}

	public void setDCounty(int DCounty) {
		this.DCounty = DCounty;
	}

	public String getKdName() {
		return this.kdName;
	}

	public void setKdName(String kdName) {
		this.kdName = kdName;
	}

	public String getKdDay() {
		return this.kdDay;
	}

	public void setKdDay(String kdDay) {
		this.kdDay = kdDay;
	}
	
	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public int getEntityCount() {
		return this.entityCount;
	}

	public void setEntityCount(int entityCount) {
		this.entityCount = entityCount;
	}
	
	public int getVirtualCount() {
		return this.virtualCount;
	}

	public void setVirtualCount(int virtualCount) {
		this.virtualCount = virtualCount;
	}
	
	public int getIsEvaluate() {
		return this.isEvaluate;
	}

	public void setIsEvaluate(int isEvaluate) {
		this.isEvaluate = isEvaluate;
	}
	
	public int getCheckOrder() {
		return this.checkOrder;
	}

	public void setCheckOrder(int checkOrder) {
		this.checkOrder = checkOrder;
	}

}