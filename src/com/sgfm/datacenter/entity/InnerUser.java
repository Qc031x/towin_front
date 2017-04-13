package com.sgfm.datacenter.entity;

import com.sgfm.datacenter.util.NoDatabaseFieldAnnotation;

/**
 * 内部用户实体
 * 
 * @author likai
 */
public class InnerUser
{
    private Long innerUserId;// 用户编号
    private String loginName;// 用户登录名
    private String userName;// 用户名称
    private Integer sex;// 用户性别
    private Integer certificateType;// 证件类型
    private String certificateNo;// 证件编号
    private String concatPhone;// 联系电话
    private String emergencyConcatName;// 紧急联系人
    private String emergencyConcatPhone;// 紧急联系电话
    private Integer userType;// 用户类型
    private Integer status;// 用户状态
    private String userPwd;// 用户密码
    private Integer canBet;//是否可在第三方下注 
    
    @NoDatabaseFieldAnnotation
    private Integer opertionNumberForSingle;//单式操盘赛事数量。
    
    @NoDatabaseFieldAnnotation
    private Integer opertionNumberForGrounder;//滚球操盘赛事数量。

    


	public Integer getOpertionNumberForSingle() {
		return opertionNumberForSingle;
	}

	public void setOpertionNumberForSingle(Integer opertionNumberForSingle) {
		this.opertionNumberForSingle = opertionNumberForSingle;
	}

	public Integer getOpertionNumberForGrounder() {
		return opertionNumberForGrounder;
	}

	public void setOpertionNumberForGrounder(Integer opertionNumberForGrounder) {
		this.opertionNumberForGrounder = opertionNumberForGrounder;
	}

	public Long getInnerUserId()
    {
        return innerUserId;
    }

    public void setInnerUserId(Long innerUserId)
    {
        this.innerUserId = innerUserId;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getCertificateNo()
    {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo)
    {
        this.certificateNo = certificateNo;
    }

    public String getConcatPhone()
    {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone)
    {
        this.concatPhone = concatPhone;
    }

    public String getEmergencyConcatName()
    {
        return emergencyConcatName;
    }

    public void setEmergencyConcatName(String emergencyConcatName)
    {
        this.emergencyConcatName = emergencyConcatName;
    }

    public String getEmergencyConcatPhone()
    {
        return emergencyConcatPhone;
    }

    public void setEmergencyConcatPhone(String emergencyConcatPhone)
    {
        this.emergencyConcatPhone = emergencyConcatPhone;
    }

    public String getUserPwd()
    {
        return userPwd;
    }

    public void setUserPwd(String userPwd)
    {
        this.userPwd = userPwd;
    }

    public Integer getSex()
    {
        return sex;
    }

    public void setSex(Integer sex)
    {
        this.sex = sex;
    }

    public Integer getCertificateType()
    {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType)
    {
        this.certificateType = certificateType;
    }

    public Integer getUserType()
    {
        return userType;
    }

    public void setUserType(Integer userType)
    {
        this.userType = userType;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

	public Integer getCanBet() {
		return canBet;
	}

	public void setCanBet(Integer canBet) {
		this.canBet = canBet;
	}
    

}
