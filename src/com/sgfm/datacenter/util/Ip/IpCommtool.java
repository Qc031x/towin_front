package com.sgfm.datacenter.util.Ip;

import java.util.HashMap;
import java.util.Map;

public class IpCommtool {
	static Map<String ,String> cityMap=new HashMap<String ,String>();
	static Map<String ,String> areaMap=new HashMap<String ,String>();
	static{
		////////////////下面是根据区号 id找城市/////////////////////////////	
		cityMap.put("010", "10101");		//北京
		cityMap.put("0519","10184");		//常州
		cityMap.put("0431","10151");		//长春
		cityMap.put("0731","10287");		//长沙
		cityMap.put("028","10355");		//成都
		cityMap.put("0411","10146");		//大连
		cityMap.put("0796","10311");		//东莞
		cityMap.put("0591","10215");		//福州
		cityMap.put("020","10301");		//广州
		cityMap.put("0571","10187");		//杭州
		cityMap.put("0531","10235");		//济南
		cityMap.put("0791","10224");		//南昌
		cityMap.put("025","10174");		//南京
		cityMap.put("0513","10182");		//南通
		cityMap.put("0532","10243");		//青岛
		cityMap.put("021","10173");		//上海
		cityMap.put("0755","10312");		//深圳
		cityMap.put("0512","10186");		//苏州
		cityMap.put("0351","10114");		//太原
		cityMap.put("022","10102");		//天津
		cityMap.put("0510","10185");		//无锡
		cityMap.put("027","10270");		//武汉
		cityMap.put("029","10408");		//西安
		cityMap.put("0291","10412");		//咸阳
		cityMap.put("023","10354");		//重庆
		cityMap.put("024","10137");		//沈阳
		cityMap.put("0536","10240");	//潍坊		
		cityMap.put("024","10137");		//沈阳
		cityMap.put("0631","10242");		// 威海 
		cityMap.put("0951","10440");	 //银川
		cityMap.put("0535","10241");      //       烟台
	////////////////下面是根据城市id找区号/////////////////////////////	
		areaMap.put("10101","010");		//北京
		areaMap.put("10184","0519");		//常州
		areaMap.put("10151","0431");		//长春
		areaMap.put("10287","0731");		//长沙
		areaMap.put("10355","028");		//成都
		areaMap.put("10146","0411");		//大连
		areaMap.put("10311","0796");		//东莞
		areaMap.put("10215","0591");		//福州
		areaMap.put("10301","020");		//广州
		areaMap.put("10187","0571");		//杭州
		areaMap.put("10235","0531");		//济南
		areaMap.put("10224","0791");		//南昌
		areaMap.put("10174","025");		//南京
		areaMap.put("10182","0513");		//南通
		areaMap.put("10243","0532");		//青岛
		areaMap.put("10173","021");		//上海
		areaMap.put("10312","0755");		//深圳
		areaMap.put("10186","0512");		//苏州
		areaMap.put("10114","0351");		//太原
		areaMap.put("10102","022");		//天津
		areaMap.put("10185","0510");		//无锡
		areaMap.put("10270","027");		//武汉
		areaMap.put("10408","029");		//西安
		areaMap.put("10412","0291");		//咸阳
		areaMap.put("10354","023");		//重庆
		areaMap.put("10137","024");		//沈阳
		areaMap.put("10242","0631");		// 威海 
		areaMap.put("10440","0951");	 //银川
		areaMap.put("10241","0535");      //       烟台
		areaMap.put("10240","0536");	//潍坊	
        }
	
	public static IPSeeker initIpSeeker(){
		IPSeeker ipSeeker = IPSeeker.getInstance();
		return ipSeeker;
	}
	/*public static Map<String ,String>  getAreaMap(){
		
		
		return cityMap;
	}*/
	
	public static String  getMapByareaNo(String key){
		String value=cityMap.get(key);
		return value;
	}
	public static String  getMapByCityId(String key){
		String value=areaMap.get(key);
		return value;
	}
	

}
