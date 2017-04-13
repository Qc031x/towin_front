package com.sgfm.datacenter.entity;
/** 
 * @author  hejing
 * @date 创建时间：2016-3-22 下午7:53:40 
 * @version 1.0 *
 * @TODO 描述
 */
import java.math.BigDecimal;


/**
 * TConsigneeAddressId entity. @author MyEclipse Persistence Tools
 */

public class TConsigneeAddress  implements java.io.Serializable {


    // Fields    

     private String name;
     private int province;
     private int city;
     private String address;
     private String email;
     private String tel;
     private String mobile;
     private String building;
     private String bestTime;
     private int mid;
     private String postcode;
     private int county;
     private String isDefault;
     private int caId;
     private String type;
     private String cname;
     private String tProvince;
     private String tCity;
     private String tCounty;


    // Constructors

    /** default constructor */
    public TConsigneeAddress() {
    }

    
    

   
    // Property accessors

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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

    public String getBuilding() {
        return this.building;
    }
    
    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBestTime() {
        return this.bestTime;
    }
    
    public void setBestTime(String bestTime) {
        this.bestTime = bestTime;
    }

    public int getMid() {
        return this.mid;
    }
    
    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getCounty() {
        return this.county;
    }
    
    public void setCounty(int county) {
        this.county = county;
    }

    public String getIsDefault() {
        return this.isDefault;
    }
    
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public int getCaId() {
        return this.caId;
    }
    
    public void setCaId(int caId) {
        this.caId = caId;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getCname() {
        return this.cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }

    
    public String getTProvince() {
        return this.tProvince;
    }
    
    public void setTProvince(String tProvince) {
        this.tProvince = tProvince;
    }
    public String getTCity() {
        return this.tCity;
    }
    
    public void setTCity(String tCity) {
        this.tCity = tCity;
    }
    public String getTCounty() {
        return this.tCounty;
    }
    
    public void setTCounty(String tCounty) {
        this.tCounty = tCounty;
    }
}