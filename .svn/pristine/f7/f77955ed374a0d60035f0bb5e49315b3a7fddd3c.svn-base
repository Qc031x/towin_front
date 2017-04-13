package com.sgfm.datacenter.service.twechat.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgfm.datacenter.MsgConstant;
import com.sgfm.base.util.Pager;
import com.sgfm.datacenter.dao.CalDao;
import com.sgfm.datacenter.dao.CommonDao;
import com.sgfm.datacenter.dao.EmployeeDao;
import com.sgfm.datacenter.dao.TwechatDao;
import com.sgfm.datacenter.service.calendar.CalService;
import com.sgfm.datacenter.service.common.CommonService;
import com.sgfm.datacenter.service.login.LoginService;
import com.sgfm.datacenter.service.twechat.TwechatService;
import com.sgfm.datacenter.util.CommUtil;
import com.sgfm.datacenter.util.SysUtils;
import com.taobao.api.ApiException;

@Service
public class TwcehatServiceImpl implements TwechatService {
	
	@Autowired
	private TwechatDao twechatDao;
	@Autowired
	private CalDao calDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private CommonService commonService;
	
	/**
	 * 跳转到分院列表
	 * 
	 * @return
	 * @author 秦光耀
	 */
	public List<HashMap<String, Object>> findBrandchList(HashMap<String, Object> map) {
		List<HashMap<String, Object>> brandchList=twechatDao.findBrandchList(map);
		for(HashMap<String, Object> brand : brandchList){
			List<HashMap<String, Object>> imgList=twechatDao.findBrandchImgByEsid(brand.get("ESID").toString());
			brand.put("img", imgList);
		}
		return brandchList;
	}

	public HashMap<String, Object> getbrandchInfoByEsid(HashMap<String, Object> map) {
		HashMap<String, Object> brandchInfo=twechatDao.getbrandchInfoByEsid(map);
		new CommUtil().setClobToStringMap(brandchInfo, "DESCRIPTION");
		if(!SysUtils.isEmpty(brandchInfo.get("DESCRIPTION"))){
			String descpription=brandchInfo.get("DESCRIPTION").toString().replaceAll("\r|\n", "");
			if(descpription.length()>100){
				brandchInfo.put("DESCRIPTION", descpription.substring(0, 100)+"...");
			}else{
				brandchInfo.put("DESCRIPTION", descpription);
			}
		}
		List<HashMap<String, Object>> imgList=twechatDao.findBrandchImgByEsid(map.get("esid").toString());
		brandchInfo.put("img", imgList);
		
		return brandchInfo;
	}
	/**
	 * 获取套餐信息
	 * @return
	 * @author 秦光耀
	 */
	public Map<String, Object> getProductInfo(Map<String, Object> params) {
		Map<String, Object> info = new HashMap<String, Object>();
		//固定套餐
		List<HashMap<String, Object>> idList=twechatDao.getProductId(params);
		List<HashMap<String, Object>> productInfo =null;
		HashMap<String, Object> productDetail =null;
		if(idList.size()>0){
			 productInfo=twechatDao.getSetmealInfoByPid(idList.get(0).get("PID").toString());
			 productDetail=twechatDao.getProductDetail(idList.get(0).get("PID").toString());//角色套餐价格上限
			 params.put("pid", idList.get(0).get("PID").toString());
			 HashMap<String, Object> bdRole=twechatDao.getBatchRoleByEmployee(params);
			 
			 
			 info.put("productInfo", productInfo); //固定套餐单项
			 info.put("productDetail", productDetail);
			 info.put("bdRole1", bdRole);
		}
		
		
		//自选套餐固定项
		List<HashMap<String, Object>> diyIdList=twechatDao.getDiyProductId(params);
		if(diyIdList.size()>0){
		//List<HashMap<String, Object>> diyProductInfo=twechatDao.getDiySetmealInfoByPid(diyIdList.get(0).get("PID").toString());
		HashMap<String, Object> diyProduct=twechatDao.getDiyProductDetail(diyIdList.get(0).get("PID").toString());
		List<HashMap<String, Object>> diyProductInfo=null;
		if(diyProduct.get("FIXEDTYPE").toString().equals("1")){
			diyProductInfo=twechatDao.getDiySetmealInfoByPid(diyIdList.get(0).get("PID").toString());
		}else{
			diyProductInfo=twechatDao.getSetmealInfoByPid(diyProduct.get("PID").toString());
		}
		params.put("pid", diyIdList.get(0).get("PID").toString());
		HashMap<String, Object> bdRole=twechatDao.getBatchRoleByEmployee(params);
		info.put("bdRole2", bdRole);
		
		 
		 
		HashMap<String, Object> diyProductDetail=twechatDao.getDiyProductDetail(diyIdList.get(0).get("PID").toString());
		
		//加项包内容
		List<Map<String, Object>> packageInfoList = twechatDao.getDiyProductPackages(diyIdList.get(0).get("PID").toString());
		List<Map<String, Object>> packageSet=new ArrayList<Map<String,Object>>();
		for (int i=0;i<packageInfoList.size();i++){
			HashMap<String, Object> newMap=new HashMap<String, Object>();
			newMap.put("PACKAGE_ID", packageInfoList.get(i).get("PACKAGE_ID"));
			newMap.put("PACKAGE_NAME", packageInfoList.get(i).get("PACKAGE_NAME"));
			newMap.put("PRICE", packageInfoList.get(i).get("PRICE"));
			if(packageSet.size()>0){
				for (int j=0;j<packageSet.size();j++){
					if(packageInfoList.get(i).get("PACKAGE_ID").equals(packageSet.get(j).get("PACKAGE_ID"))){
						break;
					}else{
						if((j+1)==packageSet.size()){
							packageSet.add(newMap);
						}
					}
				}
			}else{
				packageSet.add(newMap);
			}
		}
		
		
		
		
		info.put("diyProductInfo", diyProductInfo); //自选套餐固定单项
		info.put("packageInfoList", packageInfoList);// 加项包单项列表
		info.put("packageSet", packageSet); // 加项包id 和 名称列表

		info.put("diyProductDetail", diyProductDetail);
		
		}
		
		return info;
	}

	public HashMap<String, Object> getBatchInfoById(String batchId) {
		return twechatDao.getBatchInfoById(batchId);
	}


	public void addMemberOrder(HashMap<String, Object> param) throws ApiException{
		int yid;
		//0 不需要付款，只有预约单。 1 需要付款，有预约单和订单
		if(Integer.parseInt((String)param.get("type"))==0){
			param.put("orderStatus", 0);
			twechatDao.updateEmployeeOrder(param);
			twechatDao.updateEmployeeYY(param);
			yid=twechatDao.createEmployeeYY(param);
		}else{
		    param.put("orderStatus", 3);
		    twechatDao.updateEmployeeOrder(param);
			twechatDao.updateEmployeeYY(param);
		    yid=twechatDao.createEmployeeYY(param);
		    twechatDao.createEmployeeOrder(param);
		}
		//若是完全自定义，还需将用户选择的单项插入表中
		if(param.get("productType").toString().equals("3") || param.get("productType").toString().equals("4")){
			param.put("yid", yid);
			twechatDao.addEmployeeSetMeal(param);
		}
		
	}
	/**
	 * 查找会员预约单
	 * @return
	 * @author 秦光耀
	 */
	public List<HashMap<String, Object>> findReservationListByEmployeeId(HashMap<String, Object> map) {
		return twechatDao.findReservationListByEmployeeId(map);
	}

	public HashMap<String, Object> getReservationDetail(HashMap<String, Object> map) {
		HashMap<String, Object> info=new HashMap<String, Object>();
		HashMap<String, Object> baseInfo=twechatDao.getReservationDetail(map);
		if(baseInfo.get("PRODUCT_TYPE").toString().equals("1")){
			//固定套餐体检项信息
			List<HashMap<String, Object>> productInfo=twechatDao.getSetmealInfoByPid(baseInfo.get("PID").toString());
			info.put("productInfo", productInfo);
		}else if(baseInfo.get("PRODUCT_TYPE").toString().equals("2")){
			//自选套餐信息
			HashMap<String, Object> diyProduct=twechatDao.getDiyProductDetail(baseInfo.get("PID").toString());
			List<HashMap<String, Object>> diyProductInfo=null;
			if(diyProduct.get("FIXEDTYPE").toString().equals("1")){
				diyProductInfo=twechatDao.getDiySetmealInfoByPid(baseInfo.get("PID").toString());
			}else{
				diyProductInfo=twechatDao.getSetmealInfoByPid(diyProduct.get("PID").toString());
			}
			info.put("diyProductInfo", diyProductInfo);
			
			
			//加项包内容
			List<Map<String, Object>> packageInfoList = twechatDao.getDiyProductPackages(baseInfo.get("PID").toString());
			if(!SysUtils.isEmpty(baseInfo.get("SETMEAL_IDS"))){
				String[] mealIds=baseInfo.get("SETMEAL_IDS").toString().split(",");
				List<HashMap<String, Object>> packList=new ArrayList<HashMap<String,Object>>();
				for(int i=0;i<mealIds.length;i++){
					HashMap<String, Object> newMap=new HashMap<String, Object>();
					newMap.put("pcId", mealIds[i]);
					List<Map<String, Object>> newList=new ArrayList<Map<String,Object>>();
					int kk=0;
					for(int j=0;j<packageInfoList.size();j++){
						if(packageInfoList.get(j).get("PACKAGE_ID").toString().equals(mealIds[i].toString())){
							if(kk==0){
								newMap.put("packName", packageInfoList.get(j).get("PACKAGE_NAME"));
								kk=1;
							}
							newList.add(packageInfoList.get(j));
						}
					}
					newMap.put("pcInfo", newList);
					packList.add(newMap);
				}
				info.put("packList", packList);
				}
			
			/*List<Map<String, Object>> packageSet=new ArrayList<Map<String,Object>>();
			for (int i=0;i<packageInfoList.size();i++){
				HashMap<String, Object> newMap=new HashMap<String, Object>();
				newMap.put("PACKAGE_ID", packageInfoList.get(i).get("PACKAGE_ID"));
				newMap.put("PACKAGE_NAME", packageInfoList.get(i).get("PACKAGE_NAME"));
				newMap.put("PRICE", packageInfoList.get(i).get("PRICE"));
				if(packageSet.size()>0){
					for (int j=0;j<packageSet.size();j++){
						if(packageInfoList.get(i).get("PACKAGE_ID").equals(packageSet.get(j).get("PACKAGE_ID"))){
							break;
						}else{
							if((j+1)==packageSet.size()){
								packageSet.add(newMap);
							}
						}
					}
				}else{
					packageSet.add(newMap);
				}
			}
			info.put("packageSet", packageSet); // 加项包id 和 名称列表
			info.put("packageInfoList", packageInfoList);// 加项包单项列表
*/			
		}else if(baseInfo.get("PRODUCT_TYPE").toString().equals("3")){
			//完全自定义套餐内容
			List<HashMap<String, Object>> setMeal=twechatDao.findSetMealListByYid(map.get("yid").toString());
			info.put("setMealList", setMeal);
		}else if(baseInfo.get("PRODUCT_TYPE").toString().equals("4")){
			//固定项部分
			List<HashMap<String, Object>> productInfo=twechatDao.getSetmealInfoByPid(baseInfo.get("PID").toString());
			//单项自定义部分
			List<HashMap<String, Object>> setMeal=twechatDao.findSetMealListByYid(map.get("yid").toString());
			info.put("productInfo", productInfo);
			info.put("setMealList", setMeal);
		}
		
		List<HashMap<String, Object>> imgList=twechatDao.findBrandchImgByEsid(baseInfo.get("ESID").toString());
		HashMap<String, Object> img =null ;
		for(int i=0;i<imgList.size();i++){
			if(imgList.get(i).get("MODEL_FLAG").toString().equals("0")){
				img=imgList.get(i);
			}
		}
		new CommUtil().setClobToStringMap(baseInfo, "DESCRIPTION");
		if(!SysUtils.isEmpty(baseInfo.get("DESCRIPTION"))){
			String descpription=baseInfo.get("DESCRIPTION").toString().replaceAll("\r|\n", "");
			//System.out.println(descpription);
			//System.out.println(descpription.replaceAll("\r|\n", ""));
			if(descpription.length()>100){
				baseInfo.put("DESCRIPTION", descpription.substring(0, 100)+"...");
			}else{
				baseInfo.put("DESCRIPTION", descpription);
			}
		}
		info.put("baseInfo", baseInfo);
		info.put("img", img);
		return info;
	}

	public void canelReservation(String yid) {
		twechatDao.canelReservation(yid);
		twechatDao.canelOrderByOid(yid);
	}

	public Boolean checkOrderTime(HashMap<String,Object> param){
		List<HashMap<String,Object>> list = calDao.checkOrderTimePlayDay(param);
		List<HashMap<String,Object>> list2 = calDao.checkOrderTimeHoliday(param);
		List<HashMap<String,Object>> list3 = calDao.checkOrderTimeSignday(param);
		if(list.size()>0 ||list2.size()>0||list3.size()>0){
			return true;
		}
		return false;
	}

	public boolean checkBatchStatus(String batchId) {
		int status = twechatDao.checkBatchStatus(batchId);
		return status == 3 || status == 4;
	}

	public Map<String, String> getSendCodeParam(HashMap<String, Object> param) {
		return twechatDao.getSendCodeParam(param);
	}

	public void addMsgrecord(String id) {
		twechatDao.addMsgrecord(id);
	}

	
	
	/**
	 * 分页方法整合
	 * 
	 * @param count
	 *            数量
	 * @param pageNo
	 *            第几页(页数)
	 * @param map
	 *            查询条件集合
	 * @param pagesize
	 *            单页的数量
	 * @return
	 */
	public Pager setPager(int count, String pageNo,
			HashMap<String, Object> map, int pagesize) {
		Pager pager = new Pager();
		if (pageNo == null)
			pageNo = "0";
		pager.setPageNo(pageNo); // 第几页
		pager.setPageSize(pagesize);// 单页的数量
		pager.setTotalRows(map, count);
		return pager;
	}
	/**
	 * 根据esid获取单项集合
	 * @return
	 * @author 秦光耀
	 */
	public Pager getSetMealInfoList(HashMap<String, Object> map) {
		// 获取批次员工数量
		int count = twechatDao.getSetMealInfoListCount(map);

		Pager pager = setPager(count, map.get("page") == null ? "0" : map.get("page").toString(), map, 10);
		// 获取批次员工集和
		List<HashMap<String, Object>> list = twechatDao.getSetMealInfoList(map);
		pager.setList(list);
		return pager;
	}

	public void sendMessage(HashMap<String, Object> param) {
		Map<String, String> sendMap=getSendCodeParam(param);
		Map<String, String> params=new HashMap<String, String>();
		params.put("name", sendMap.get("NAME").toString());
		params.put("date", param.get("orderTime").toString());
		String address=employeeDao.getAddressByEsid(param.get("esid").toString());
		params.put("address", address);
		//回传给微信公众号参数 beg
		param.put("name", sendMap.get("NAME").toString());
		param.put("date", param.get("orderTime").toString());
		param.put("address", address);
		//end
		try {
			commonService.sendMessage(params, MsgConstant.TMPL_RESERVATION_NOTIFY, sendMap.get("MOBILE").toString());
			addMsgrecord(param.get("employeeId").toString());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
	}

	public List<HashMap<String, Object>> checkReservation(HashMap<String, Object> map) {
		return twechatDao.checkReservation(map);
	}
	
}
