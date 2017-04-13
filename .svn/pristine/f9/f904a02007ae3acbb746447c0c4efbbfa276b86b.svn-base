package com.sgfm.datacenter.service.login.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgfm.base.util.StringUtil;
import com.sgfm.datacenter.dao.CommonDao;
import com.sgfm.datacenter.dao.EmployeeDao;
import com.sgfm.datacenter.dao.PCUserDao;
import com.sgfm.datacenter.service.login.LoginService;
import com.sgfm.datacenter.util.SysUtils;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private PCUserDao userDao;
	
	/**
	 * 企业员工登录
	 * @return
	 * @author cliu
	 */
	public HashMap<String,Object> doMemberLogin(Map<String,String> reqParm){		
		HashMap<String,Object> info = new HashMap<String,Object>();		
		System.out.println("数据0--------------" + reqParm);
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("openid", reqParm.get("openid"));
		HashMap<String, Object> userinfo = userDao.findMemInfoByOpenidOrMobile(param); //用openid查询信息
		
		if(SysUtils.isEmpty(userinfo)){
			//没有记录 注册
			HashMap<String, Object> parm = new HashMap<String, Object>();
			parm.put("true_name", reqParm.get("true_name"));
			parm.put("mobileOrIdcard", reqParm.get("mobileOrIdcard"));
			List<Map<String ,Object>> retlist = employeeDao.getBatchListByEmployeeId(parm);
			//如果该登录人没有对应的批次，证明他不是企业员工，提示他需要找贵公司HR  确认，是否进入批次
			if(retlist.size()==0){
				info.put("batchSum", "0");
			} else {
				info.put("batchSum", retlist.size());
				info.put("batchInfo", retlist);
			}
			//不存在首次登录
			param.put("mobile", StringUtil.isHandset(reqParm.get("mobileOrIdcard")) ? reqParm.get("mobileOrIdcard") : null);
			param.put("idcard", StringUtil.isHandset(reqParm.get("mobileOrIdcard")) ? null : reqParm.get("mobileOrIdcard"));
			param.put("account", null);
			param.put("password", null);
			param.put("m_type", "2");
			param.put("employee_id", retlist.get(0).get("EMPLOYEE_ID"));
			param.put("register_date", SysUtils.getTime());
			param.put("last_login", SysUtils.getTime());
			param.put("status", "1");
			param.put("name", reqParm.get("true_name"));
			System.out.println("数据2--------------" + param);
			userDao.addMember4WXUser(param);
			info.put("flag", true);
		}else{
			boolean isUpdate = false;
			boolean isMember = false;
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("openid", reqParm.get("openid"));
			//有记录
			if(StringUtil.isHandset(reqParm.get("mobileOrIdcard"))){
				//手机号码
				if(!SysUtils.isEmpty(userinfo.get("MOBILE"))){
					//数据库有openid注册记录 但是是用身份证登录的
					if(!userinfo.get("MOBILE").toString().equals(reqParm.get("mobileOrIdcard").toString())){
						//并且和登录手机不一样 驳回登录
						isMember = false;
					}else{
						isMember = true;
					}
				}else{
					map.put("mobile", reqParm.get("mobileOrIdcard"));
					isUpdate = true;
					isMember = true;
				}
			}else{
				//身份证
				if(!SysUtils.isEmpty(userinfo.get("IDCARD"))){
					if(!userinfo.get("IDCARD").toString().equals(reqParm.get("mobileOrIdcard").toString())){
						//并且和登录身份证不一样 驳回登录
						isMember = false;
					}else{
						isMember = true;
					}
				}else{
					map.put("idcard", reqParm.get("mobileOrIdcard"));
					isUpdate = true;
					isMember = true;
				}
			}
			
			if(isMember){
				HashMap<String, Object> parm = new HashMap<String, Object>();
				parm.put("true_name", reqParm.get("true_name"));
				parm.put("mobileOrIdcard", reqParm.get("mobileOrIdcard"));
				List<Map<String ,Object>> retlist = employeeDao.getBatchListByEmployeeId(parm);
				//如果该登录人没有对应的批次，证明他不是企业员工，提示他需要找贵公司HR  确认，是否进入批次
				if(retlist.size()==0){
					info.put("batchSum", "0");
				} else {
					info.put("batchSum", retlist.size());
					info.put("batchInfo", retlist);
					if(isUpdate){
						map.put("m_type", 3);
						map.put("employee_id", retlist.get(0).get("EMPLOYEE_ID"));
						map.put("name", reqParm.get("true_name"));
						map.put("last_login", SysUtils.getTime());
						userDao.updMemberInfoByOpenid(map);
					}
				}
			}
			info.put("flag", isMember);
		}
		
		return info;
	}

	/**
	 * 获取登录人的体检信息
	 */
	public Map<String, Object> getCheckupInfo(HashMap<String, String> params) {
		Map<String, Object> info = new HashMap<String, Object>();
		Map<String, Object> employee = employeeDao.getEmployeeInfo(params);
		
		List<Map<String, Object>> checkupInfo = employeeDao.getCheckupBatchInfo(employee);
		info.put("emp", employee);
		info.put("shop", checkupInfo);
		if(checkupInfo.size()<=1){
			HashMap<String, Object> onlyOneShop=new HashMap<String, Object>();
			onlyOneShop.put("shopCount", "1");
			onlyOneShop.put("esid", checkupInfo.get(0).get("esid"));
			info.put("onlyOneShop", onlyOneShop);
		}
		return info;
	}

	public List<Map<String, Object>> checkEmployeeReservation(HashMap<String, String> param) {
		return employeeDao.checkEmployeeReservation(param) ;
	}
	/**
	 * 根据esid获取详细地址
	 * @param param
	 * @return
	 * @author 秦光耀
	 */
	public String getAddressByEsid(String esid) {
		return employeeDao.getAddressByEsid(esid);
	}
	
	@Override
	public List<HashMap<String, Object>> findValidCity() {
		return userDao.findValidCity();
	}
	
}
