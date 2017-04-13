package com.sgfm.datacenter.action.twechat;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sgfm.base.action.BaseAction;
import com.sgfm.base.util.DateUtil;
import com.sgfm.base.util.OrderUtil;
import com.sgfm.base.util.Pager;
import com.sgfm.base.util.PropsLoader;
import com.sgfm.datacenter.SysConstant;
import com.sgfm.datacenter.exception.AppException;
import com.sgfm.datacenter.service.calendar.CalService;
import com.sgfm.datacenter.service.twechat.TwechatService;
import com.sgfm.datacenter.util.JsonResponseResult;
import com.sgfm.datacenter.util.SysUtils;
import com.sgfm.datacenter.wxsendmsg.SysOfficeAccountSendMsg;

@Controller
@Scope("prototype")
public class TwechatAction extends BaseAction {
	private Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private TwechatService twechatservice;
	@Autowired
	private CalService calService;
	@Autowired
	private PropsLoader propsLoader;


	
	/**
	 * 跳转到分院列表
	 * 
	 * @return
	 * @author 秦光耀
	 */
	public String toBranchList() {
		try {
			String batchId=super.getFromSession("batchId").toString();
			String employeeId=super.getFromSession("employeeId").toString();
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("batchId", batchId);
			map.put("employeeId", employeeId);
			List<HashMap<String,Object>> brandList= twechatservice.findBrandchList(map);
			super.getRequest().setAttribute("brandList", brandList);
			super.getRequest().setAttribute("batchId", batchId);
			super.getRequest().setAttribute("employeeId", employeeId);
		} catch (Exception e) {
			this.logger.error(e);
		}
		//esid address batchId employeeId
		return super.toContentView("twechat", "orglist");
	}
	/**
	 * 跳转到分院详情
	 * 
	 * @return
	 * @author 秦光耀
	 */
	public String toBrandsInfo() {
		try {
			String address=super.getRequest().getParameter("address");
			String esid=super.getRequest().getParameter("esid");
			String batchId=(String) super.getFromSession("batchId");
			String employeeId=(String) super.getFromSession("employeeId");
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("esid", esid);
			map.put("address", address);
			HashMap<String, Object> brandchInfo=twechatservice.getbrandchInfoByEsid(map);
			HashMap<String, Object> batchInfo=twechatservice.getBatchInfoById(batchId);
			super.getRequest().setAttribute("brandchInfo", brandchInfo);
			super.getRequest().setAttribute("batchInfo", batchInfo);
			super.getRequest().setAttribute("address", address);
			super.getRequest().setAttribute("esid", esid);
			
		} catch (Exception e) {
			this.logger.error(e);
		}
		return super.toContentView("twechat", "brandsInfo");
	}
	/**
	 * 跳转到套餐详情
	 * 
	 * @return
	 * @author 秦光耀
	 */
	public String toProductDetail() {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			String esid=super.getRequest().getParameter("esid");
			String batchId=(String) super.getFromSession("batchId");
			String employeeId=(String) super.getFromSession("employeeId");
			String orderTime = super.getRequest().getParameter("orderTime");
			params.put("esid", esid);
			params.put("batchId",batchId);
			params.put("employeeId", employeeId);
			params.put("orderTime", orderTime);
			Map<String, Object> map = twechatservice.getProductInfo(params);
			super.getRequest().setAttribute("map", map);
			super.getRequest().setAttribute("params", params);
			
		} catch (Exception e) {
			this.logger.error(e);
		}
		return super.toContentView("twechat", "productDetail");
	}
	/**
	 * 根据esid，date获取预约日历
	 * @return
	 * @author 秦光耀
	 */
	public String getRiDataByEsid() {
		JsonResponseResult responseResult = null;
		boolean addFlag = false;
		try {
			String esid = super.getRequest().getParameter("esid");
			String date = super.getRequest().getParameter("date");
			Map<String, String[]> map = calService.getRiDataByEsid(esid, date);
			super.jsonResult = JSONArray.fromObject(map).toString();
			responseResult = JsonResponseResult.createSuccess();
			addFlag = true;
		} catch (final AppException app) {
			logger.error(app);
			final String msg = getText(app.getMessage());
			responseResult = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(responseResult).toString();
		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e);
			final String msg = getText("操作失败,请联系管理员！");
			responseResult = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(responseResult).toString();
		}
		responseResult.addData(addFlag);
		return BaseAction.JSON;
	}
	/**
	 * 跳转到我的预约页面
	 * 
	 * @return
	 * @author 秦光耀
	 */
	public String toReservation() {
		try {
			String batchId=super.getFromSession("batchId").toString();
			String employeeId= super.getFromSession("employeeId").toString();
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("batchId", batchId);
			map.put("employeeId", employeeId);
			List<HashMap<String, Object>> reservation=twechatservice.findReservationListByEmployeeId(map);
			super.getRequest().setAttribute("reservation", reservation);
		} catch (Exception e) {
			this.logger.error(e);
		}
		return super.toContentView("twechat", "reservationList");
	}
	
	public String toPayMent() {
		try {
			Map<String, Object> order = new HashMap<String, Object>();
			order.put("oid", super.getRequest().getParameter("oid"));
			order.put("sumPrice", super.getRequest().getParameter("sumPrice"));
			super.getRequest().setAttribute("order", order);
		} catch (Exception e) {
			this.logger.error(e);
		}
		return super.toContentView("payment", "payment");
	}
	/**
	 * 生成订单
	 * @return
	 * @author 秦光耀
	 */
	public String createOrde() {
		JsonResponseResult result = null;
		try {
			String employeeId= super.getFromSession("employeeId").toString();
			/*//13位到毫秒级别的时间戳加100到1000的随机正整数生成oid
			String oid="tw"+System.currentTimeMillis()+(int)(Math.random()*900+100);*/		
			if(StringUtils.isBlank(employeeId)){
				return super.toWebRootView("indexMain");
			}			
			String oid = OrderUtil.createOid(employeeId);
			String type=super.getRequest().getParameter("type");
			HashMap<String, Object> param=new HashMap<String, Object>();
			param.put("batchId", super.getFromSession("batchId"));
			param.put("esid", super.getRequest().getParameter("esid"));
			param.put("employeeId", super.getFromSession("employeeId"));
			param.put("orderTime", super.getRequest().getParameter("orderTime"));
			param.put("pid", super.getRequest().getParameter("pid"));
			param.put("productPrice", super.getRequest().getParameter("productPrice"));
			param.put("productType", super.getRequest().getParameter("productType"));
			param.put("setmealIds", super.getRequest().getParameter("setmealIds"));
			param.put("myWallet", super.getRequest().getParameter("myWallet"));
			param.put("orderPay", super.getRequest().getParameter("orderPay").replaceAll("\\s*", ""));
			param.put("type", super.getRequest().getParameter("type"));
			param.put("oid", oid);
			param.put("openid", this.getFromSession(SysConstant.USER_OPENID));				
            twechatservice.addMemberOrder(param);
        	String catchKey="";
			if(Integer.parseInt(type)==0){
				//发送短信	
				this.setToSession("isReservation", "1");
				twechatservice.sendMessage(param);
				 //微信推送信息给员工
				//1表示员工预约后， map<String ,Object> key说明:name员工姓名| productType 套餐类型1固定，2，3自定义| address 分院地址|date 体检时间
	     		 catchKey=SysOfficeAccountSendMsg.sendOfficiaAccountsMsg(1, param);
	     	 	 this.logger.info("createOrde->catchKey="+catchKey+"-openid="+param.get("openid"));
	     	
			}
			
		  
			result = JsonResponseResult.createSuccess();
			result.addData(oid);
			result.addData(catchKey);
			super.jsonResult = JSONObject.fromObject(result).toString();
			this.logger.info("createOrde->jsonResult="+jsonResult);
		} catch (final AppException app) {
			this.logger.error(app);
			final String msg = app.getMessage();
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		} catch (final Exception e) {
			this.logger.error(e);
			final String msg = "操作失败,请联系管理员！";
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		}
		return BaseAction.JSON;
	}
	/**
	 * 跳转到预约详情页面
	 * 
	 * @return
	 * @author 秦光耀
	 */
	public String toReservationDetail() {
		try {
			String yid=null;
			HashMap<String, Object> map=new HashMap<String, Object>();
			if(!SysUtils.isEmpty(super.getRequest().getParameter("yid"))){
				yid=super.getRequest().getParameter("yid").toString();
			}else{
				String batchId=super.getFromSession("batchId").toString();
				String employeeId= super.getFromSession("employeeId").toString();
				map.put("batchId", batchId);
				map.put("employeeId", employeeId);
				List<HashMap<String, Object>> ylist=twechatservice.checkReservation(map);
				if(ylist.size()<=0){
					return super.toContentView("twechat", "myOrderInitial");
				}
				yid = ylist.get(0).get("YID").toString();
			}
			map.put("yid", yid);
			HashMap<String, Object> info=twechatservice.getReservationDetail(map);
			if(!SysUtils.isEmpty(super.getRequest().getParameter("yid"))){
				//若果是从微信模板消息跳转过来，需要给session赋值batchId和employeeId
				HashMap<String, Object> baseInfo=(HashMap<String, Object>) info.get("baseInfo");
				super.setToSession("batchId", baseInfo.get("BATCH_ID"));
				super.setToSession("employeeId", baseInfo.get("EMPOYEE_ID"));
			}
			super.getRequest().setAttribute("info", info);
		} catch (Exception e) {
			this.logger.error(e);
		}
		return super.toContentView("twechat", "reservationDetail");
	}
	/**
	 * 取消订单、预约
	 * @return
	 * @author 秦光耀
	 */
	public String canelReservation() {
		JsonResponseResult result = null;
		try {
			String yid= super.getRequest().getParameter("yid");
				//如果需要付款1，则生成订单，否则生成预约单0 
			twechatservice.canelReservation(yid);
			this.setToSession("isReservation", "0");
			result = JsonResponseResult.createSuccess();
			super.jsonResult = JSONObject.fromObject(result).toString();

		} catch (final AppException app) {
			this.logger.error(app);
			final String msg = app.getMessage();
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		} catch (final Exception e) {
			this.logger.error(e);
			final String msg = "操作失败,请联系管理员！";
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		}
		return BaseAction.JSON;
	}
	
	/**
	 * 校验体检日期
	 * @return
	 */
	public String checkOrderTime(){
		JsonResponseResult result = null;
		try {
			String orderTime = super.getRequest().getParameter("orderTime");
			String esid = super.getRequest().getParameter("esid");
			DateUtil dt = new DateUtil();
			Calendar calendar = Calendar.getInstance(); 
			calendar.setTime(dt.parseDate(orderTime)); 
			String week = dt.getChineseWeek(calendar,"zh");
			HashMap<String,Object> param = new HashMap<String, Object>();
			param.put("esid", esid);
			param.put("week", week);
			param.put("date",orderTime);
			if(twechatservice.checkOrderTime(param)){
				result = JsonResponseResult.createFalied("请选择有效日期！");
				super.jsonResult = JSONObject.fromObject(result).toString();
				return BaseAction.JSON;
			}
			result = JsonResponseResult.createSuccess();
			super.jsonResult = JSONObject.fromObject(result).toString();
		} catch (final AppException app) {
			this.logger.error(app);
			final String msg = app.getMessage();
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		} catch (final Exception e) {
			this.logger.error(e);
			final String msg = "操作失败,请联系管理员！";
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		}
		return BaseAction.JSON;
	}
	
	
	public String checkBatchStatus() {
		JsonResponseResult result = null;
		try {
			String batchId = getRequest().getParameter("batchId");
			boolean nonStarted = twechatservice.checkBatchStatus(batchId);
			if (nonStarted) {
				result = JsonResponseResult.createFalied("该体检批次已经暂停或结束！");
				super.jsonResult = JSONObject.fromObject(result).toString();
				return JSON;
			}
			result = JsonResponseResult.createSuccess();
		} catch (final AppException app) {
			this.logger.error(app);
			final String msg = app.getMessage();
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		} catch (final Exception e) {
			this.logger.error(e);
			final String msg = "操作失败,请联系管理员！";
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		}
		super.jsonResult = JSONObject.fromObject(result).toString();
		return BaseAction.JSON;
	}
	/**
	 * 下载文件
	 * @return
	 */
	public String downLoadFileUtil(){
		InputStream in=null;
		OutputStream os =null;
		try{
		 //获得请求文件名
		String realPath = propsLoader.props.getProperty("downloadPath");
        String filename = this.getRequest().getParameter("fileName");  
        //filename = URLDecoder.decode(filename, "utf-8");
        System.out.println(filename);  
          
        //设置文件MIME类型  
        this.getResponse().setContentType(getServletContext().getMimeType(filename));  
        //设置Content-Disposition  
        this.getResponse().setHeader("Content-Disposition", "attachment;filename="+filename);  
        //读取目标文件，通过response将目标文件写到客户端  
        //获取目标文件的绝对路径  
        filename = URLDecoder.decode(filename, "utf-8");
        String fullFileName = realPath + filename;  
        System.out.println(fullFileName);  
        //读取文件  
        in = new FileInputStream(fullFileName);  
        os = this.getResponse().getOutputStream();  
          
        //写文件  
        int b;  
        while((b=in.read())!= -1)  
        {  
            os.write(b);  
        }  
        in.close();
		os.flush();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}  
		return null;  
		
	}
	
	/**
	 * 根据esid获取单项集合
	 * @return
	 * @author 秦光耀
	 */
	public String getSetMealInfoList() {
		JsonResponseResult result = null;
		try {
			String esid = getRequest().getParameter("esid");
			String page = getRequest().getParameter("page");
			String keyWord = getRequest().getParameter("keyWord");
			String price = getRequest().getParameter("price");
			String mealIds = getRequest().getParameter("mealIds");
			String employeeId=this.getFromSession("employeeId").toString();
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("esid", esid);
			map.put("page", page);
			map.put("employeeId", employeeId);
			map.put("keyWord", keyWord);
			map.put("price", price);
			map.put("mealIds", mealIds);
			Pager pager=twechatservice.getSetMealInfoList(map);

			super.jsonResult = JSONArray.fromObject(pager).toString();
		} catch (final AppException app) {
			this.logger.error(app);
			final String msg = app.getMessage();
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		} catch (final Exception e) {
			this.logger.error(e);
			final String msg = "操作失败,请联系管理员！";
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		}
		return BaseAction.JSON;
	}
	/**
	 * 查询当前用户的可预约分院数量
	 * @return
	 * @author 秦光耀
	 */
	public String checkBrandCount() {
		JsonResponseResult result = null;
		try {
			String batchId=super.getFromSession("batchId").toString();
			String employeeId=super.getFromSession("employeeId").toString();
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("batchId", batchId);
			map.put("employeeId", employeeId);
			List<HashMap<String,Object>> brandList= twechatservice.findBrandchList(map);
			super.jsonResult = JSONArray.fromObject(brandList).toString();
		} catch (final AppException app) {
			this.logger.error(app);
			final String msg = app.getMessage();
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		} catch (final Exception e) {
			this.logger.error(e);
			final String msg = "操作失败,请联系管理员！";
			result = JsonResponseResult.createFalied(msg);
			super.jsonResult = JSONObject.fromObject(result).toString();
		}
		return BaseAction.JSON;
	}
	
}