package com.sgfm.datacenter.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TProduct entity. @author MyEclipse Persistence Tools
 */

public class TProduct implements java.io.Serializable {

	// Fields

	private int pid;
	private int cid;
	private String name;
	private String shortDesc;
	private String detailDesc;
	private String keywords;
	private int click;
	private int buys;
	private int alive;
	private String imgB;
	private String imgS;
	private double marketPrice;
	private double shopPrice;
	private int star;
	private String postDate;
	private int starP;
	private String attribute;
	private String PNo;
	private int discount;
	private String discountSt;
	private String discountEn;
	private int starAvg;
	private int flagPacket;
	private int storage;
	private int brandId;
	private int catalogCommend;
	private String comNote;
	private String searchTitle;
	private String searchKeywords;
	private String searchDescription;
	private int enjoyCount;
	private int askCount;
	private int evalCount;
	private int sort;
	private int serviceGoods;
	private String MHandinch;
	private String MWeight;
	private String MColor;
	private String MClarity;
	private String MCut;
	private String MPolishing;
	private int type;
	private int mid;
	private int shFlag;
	private int modelsId;
	private int attrnameId;
	private int sid;
	private int userremark;
	private int creditnum;
	private int creditPrice;
	private int creator;
	private String businessmapimg;
	private int lotteryState;
	private int lotteryYellow;
	private String probability;
	private int praiseDegree;
	private int province;
	private int city;
	private int county;
	private int freight;
	private String remark;
	private int cycle;
	private int invoice;
	private int guarantee;
	private int alteration;
	private String rackTime;
	private int firstType;
	private int gbuys;
	private int goldPrice;
	private int coinproductExchangeNum;
	private int aliveflag;
	private int freightnum;
	private String freightsm;
	private int istj;
	private int ltempid;
	private String weight;
	private String volume;
	private String violateCause;
	private String violateRemark;
	private String phoneType;
	private String phoneMode;
	private String recommend;
	private String attrDesc;
	private String projectDesc;
	private int settlementPrice;
	private int commissionPrice;
	private int invoiceSupply;
	private int commissionRatio;
	private int teamPrice;
	private String teamStartdate;
	private String teamEnddate;
	private int typeFlag;
	private String productDec;
	private Boolean isObsolete;
	private String productDesc;
	private String companyGeneral;


	// Constructors

	/** default constructor */
	public TProduct() {
	}

	/** minimal constructor */
	public TProduct(int pid) {
		this.pid = pid;
	}


	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getDetailDesc() {
		return this.detailDesc;
	}

	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getClick() {
		return this.click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public int getBuys() {
		return this.buys;
	}

	public void setBuys(int buys) {
		this.buys = buys;
	}

	public int getAlive() {
		return this.alive;
	}

	public void setAlive(int alive) {
		this.alive = alive;
	}

	public String getImgB() {
		return this.imgB;
	}

	public void setImgB(String imgB) {
		this.imgB = imgB;
	}

	public String getImgS() {
		return this.imgS;
	}

	public void setImgS(String imgS) {
		this.imgS = imgS;
	}

	public double getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public double getShopPrice() {
		return this.shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public int getStar() {
		return this.star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public int getStarP() {
		return this.starP;
	}

	public void setStarP(int starP) {
		this.starP = starP;
	}

	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getPNo() {
		return this.PNo;
	}

	public void setPNo(String PNo) {
		this.PNo = PNo;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getDiscountSt() {
		return this.discountSt;
	}

	public void setDiscountSt(String discountSt) {
		this.discountSt = discountSt;
	}

	public String getDiscountEn() {
		return this.discountEn;
	}

	public void setDiscountEn(String discountEn) {
		this.discountEn = discountEn;
	}

	public int getStarAvg() {
		return this.starAvg;
	}

	public void setStarAvg(int starAvg) {
		this.starAvg = starAvg;
	}

	public int getFlagPacket() {
		return this.flagPacket;
	}

	public void setFlagPacket(int flagPacket) {
		this.flagPacket = flagPacket;
	}

	public int getStorage() {
		return this.storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public int getBrandId() {
		return this.brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getCatalogCommend() {
		return this.catalogCommend;
	}

	public void setCatalogCommend(int catalogCommend) {
		this.catalogCommend = catalogCommend;
	}

	public String getComNote() {
		return this.comNote;
	}

	public void setComNote(String comNote) {
		this.comNote = comNote;
	}

	public String getSearchTitle() {
		return this.searchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public String getSearchKeywords() {
		return this.searchKeywords;
	}

	public void setSearchKeywords(String searchKeywords) {
		this.searchKeywords = searchKeywords;
	}

	public String getSearchDescription() {
		return this.searchDescription;
	}

	public void setSearchDescription(String searchDescription) {
		this.searchDescription = searchDescription;
	}

	public int getEnjoyCount() {
		return this.enjoyCount;
	}

	public void setEnjoyCount(int enjoyCount) {
		this.enjoyCount = enjoyCount;
	}

	public int getAskCount() {
		return this.askCount;
	}

	public void setAskCount(int askCount) {
		this.askCount = askCount;
	}

	public int getEvalCount() {
		return this.evalCount;
	}

	public void setEvalCount(int evalCount) {
		this.evalCount = evalCount;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getServiceGoods() {
		return this.serviceGoods;
	}

	public void setServiceGoods(int serviceGoods) {
		this.serviceGoods = serviceGoods;
	}

	public String getMHandinch() {
		return this.MHandinch;
	}

	public void setMHandinch(String MHandinch) {
		this.MHandinch = MHandinch;
	}

	public String getMWeight() {
		return this.MWeight;
	}

	public void setMWeight(String MWeight) {
		this.MWeight = MWeight;
	}

	public String getMColor() {
		return this.MColor;
	}

	public void setMColor(String MColor) {
		this.MColor = MColor;
	}

	public String getMClarity() {
		return this.MClarity;
	}

	public void setMClarity(String MClarity) {
		this.MClarity = MClarity;
	}

	public String getMCut() {
		return this.MCut;
	}

	public void setMCut(String MCut) {
		this.MCut = MCut;
	}

	public String getMPolishing() {
		return this.MPolishing;
	}

	public void setMPolishing(String MPolishing) {
		this.MPolishing = MPolishing;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getShFlag() {
		return this.shFlag;
	}

	public void setShFlag(int shFlag) {
		this.shFlag = shFlag;
	}

	public int getModelsId() {
		return this.modelsId;
	}

	public void setModelsId(int modelsId) {
		this.modelsId = modelsId;
	}

	public int getAttrnameId() {
		return this.attrnameId;
	}

	public void setAttrnameId(int attrnameId) {
		this.attrnameId = attrnameId;
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUserremark() {
		return this.userremark;
	}

	public void setUserremark(int userremark) {
		this.userremark = userremark;
	}

	public int getCreditnum() {
		return this.creditnum;
	}

	public void setCreditnum(int creditnum) {
		this.creditnum = creditnum;
	}

	public int getCreditPrice() {
		return this.creditPrice;
	}

	public void setCreditPrice(int creditPrice) {
		this.creditPrice = creditPrice;
	}

	public int getCreator() {
		return this.creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public String getBusinessmapimg() {
		return this.businessmapimg;
	}

	public void setBusinessmapimg(String businessmapimg) {
		this.businessmapimg = businessmapimg;
	}

	public int getLotteryState() {
		return this.lotteryState;
	}

	public void setLotteryState(int lotteryState) {
		this.lotteryState = lotteryState;
	}

	public int getLotteryYellow() {
		return this.lotteryYellow;
	}

	public void setLotteryYellow(int lotteryYellow) {
		this.lotteryYellow = lotteryYellow;
	}

	public String getProbability() {
		return this.probability;
	}

	public void setProbability(String probability) {
		this.probability = probability;
	}

	public int getPraiseDegree() {
		return this.praiseDegree;
	}

	public void setPraiseDegree(int praiseDegree) {
		this.praiseDegree = praiseDegree;
	}

	public int getProvince() {
		return this.province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return this.city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getCounty() {
		return this.county;
	}

	public void setCounty(int county) {
		this.county = county;
	}

	public int getFreight() {
		return this.freight;
	}

	public void setFreight(int freight) {
		this.freight = freight;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCycle() {
		return this.cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public int getInvoice() {
		return this.invoice;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public int getGuarantee() {
		return this.guarantee;
	}

	public void setGuarantee(int guarantee) {
		this.guarantee = guarantee;
	}

	public int getAlteration() {
		return this.alteration;
	}

	public void setAlteration(int alteration) {
		this.alteration = alteration;
	}

	public String getRackTime() {
		return this.rackTime;
	}

	public void setRackTime(String rackTime) {
		this.rackTime = rackTime;
	}

	public int getFirstType() {
		return this.firstType;
	}

	public void setFirstType(int firstType) {
		this.firstType = firstType;
	}

	public int getGbuys() {
		return this.gbuys;
	}

	public void setGbuys(int gbuys) {
		this.gbuys = gbuys;
	}

	public int getGoldPrice() {
		return this.goldPrice;
	}

	public void setGoldPrice(int goldPrice) {
		this.goldPrice = goldPrice;
	}

	public int getCoinproductExchangeNum() {
		return this.coinproductExchangeNum;
	}

	public void setCoinproductExchangeNum(int coinproductExchangeNum) {
		this.coinproductExchangeNum = coinproductExchangeNum;
	}

	public int getAliveflag() {
		return this.aliveflag;
	}

	public void setAliveflag(int aliveflag) {
		this.aliveflag = aliveflag;
	}

	public int getFreightnum() {
		return this.freightnum;
	}

	public void setFreightnum(int freightnum) {
		this.freightnum = freightnum;
	}

	public String getFreightsm() {
		return this.freightsm;
	}

	public void setFreightsm(String freightsm) {
		this.freightsm = freightsm;
	}

	public int getIstj() {
		return this.istj;
	}

	public void setIstj(int istj) {
		this.istj = istj;
	}

	public int getLtempid() {
		return this.ltempid;
	}

	public void setLtempid(int ltempid) {
		this.ltempid = ltempid;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getViolateCause() {
		return this.violateCause;
	}

	public void setViolateCause(String violateCause) {
		this.violateCause = violateCause;
	}

	public String getViolateRemark() {
		return this.violateRemark;
	}

	public void setViolateRemark(String violateRemark) {
		this.violateRemark = violateRemark;
	}

	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneMode() {
		return this.phoneMode;
	}

	public void setPhoneMode(String phoneMode) {
		this.phoneMode = phoneMode;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getAttrDesc() {
		return this.attrDesc;
	}

	public void setAttrDesc(String attrDesc) {
		this.attrDesc = attrDesc;
	}

	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public int getSettlementPrice() {
		return this.settlementPrice;
	}

	public void setSettlementPrice(int settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public int getCommissionPrice() {
		return this.commissionPrice;
	}

	public void setCommissionPrice(int commissionPrice) {
		this.commissionPrice = commissionPrice;
	}

	public int getInvoiceSupply() {
		return this.invoiceSupply;
	}

	public void setInvoiceSupply(int invoiceSupply) {
		this.invoiceSupply = invoiceSupply;
	}

	public int getCommissionRatio() {
		return this.commissionRatio;
	}

	public void setCommissionRatio(int commissionRatio) {
		this.commissionRatio = commissionRatio;
	}

	public int getTeamPrice() {
		return this.teamPrice;
	}

	public void setTeamPrice(int teamPrice) {
		this.teamPrice = teamPrice;
	}

	public String getTeamStartdate() {
		return this.teamStartdate;
	}

	public void setTeamStartdate(String teamStartdate) {
		this.teamStartdate = teamStartdate;
	}

	public String getTeamEnddate() {
		return this.teamEnddate;
	}

	public void setTeamEnddate(String teamEnddate) {
		this.teamEnddate = teamEnddate;
	}

	public int getTypeFlag() {
		return this.typeFlag;
	}

	public void setTypeFlag(int typeFlag) {
		this.typeFlag = typeFlag;
	}

	public String getProductDec() {
		return this.productDec;
	}

	public void setProductDec(String productDec) {
		this.productDec = productDec;
	}

	public Boolean getIsObsolete() {
		return this.isObsolete;
	}

	public void setIsObsolete(Boolean isObsolete) {
		this.isObsolete = isObsolete;
	}

	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getCompanyGeneral() {
		return this.companyGeneral;
	}

	public void setCompanyGeneral(String companyGeneral) {
		this.companyGeneral = companyGeneral;
	}

	

}