package com.sgfm.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderUtil {

	/**
	 * 订单生成规则
	 * 字母+当前日期(年月日)+随机数(3)+员工ID(后四位)
	 * 字母用来区分下单渠道
	 * 日期方便了解订单产生时间
	 * @param employeeId
	 * @return
	 */
	public static String createOid(String employeeId){
		StringBuffer oid = new StringBuffer("T");
		
		SimpleDateFormat ft = 
      	      new SimpleDateFormat ("yyyyMMdd");
		String date = ft.format(new Date());
		
		int rand = (int)(Math.random()*900+100);
		
		int length = employeeId.length();
		
		if(length < 4){
			StringBuffer str = new StringBuffer();
			for(int i = 0; i < 4-length; i++){
				str.append("0");
			}
			str.append(employeeId);
			employeeId = str.toString();
		}else{
			employeeId = employeeId.substring(length-4);
		}
		
		oid.append(date);
		oid.append(rand);
		oid.append(employeeId);
		
		return oid.toString();
	}
	
	/*public static void main(String[] args) {
		String oid = createOid("12345879576958769567");
		System.out.println(oid);
	}*/
	
}
