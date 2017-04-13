<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<META name=viewport content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>立即预约</title>
<link href="/css/style.css" type="text/css" rel="stylesheet">
<link href="/css/sgfmform.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/autosize.min.js"></script>
<script type="text/javascript" src="/js/commonLib.js"></script>
<script type="text/javascript" src="/js/ykcalendar.js"></script>
<script type="text/javascript" src="/js/jquery.sgfmform.js"></script>
<script>
$(document).ready(function(){
	$(".yuyuetime").click(function(){
		//$(".fixmdrldiv .fenyuantit").text($(this).parents(".list").find("a").text());
		if($("#select2").val() == ""){
			$.fn.sgfmform.sn.showmsg("请选择预约分院！",1,{},"alwaysshow");
			return;
		}
		$(".fenyuantit").text($("#select2 option:selected").text());
		ykrili.getjiazairili();
		$(".fixmdrldiv").fadeIn();
	});
	
		$(".fixmdrldiv .guanbirili").click(function(){
			$(".fixmdrldiv").fadeOut();
		});
		$(".gaunbixzlxr").click(function(){
			$(".tanxzlxr").fadeOut();
		});
		
	$("#saveCardRe").sgfmform({
			btnSubmit : "#subCardRs",
			ajaxurl : "/core/reservation.doNewCardReservationOnLine.do",
			tiptype : 1,
			submittype : 2,
			callback : function(data, url){
				if(data.returncode == 0){
					$.fn.sgfmform.sn.showmsg("预约成功！",1,{},"alwaysshow");
					setTimeout('self.location=document.referrer', 2000);
				}else{
					$.fn.sgfmform.sn.showmsg("预约失败！",1,{},"alwaysshow");
				}
			}
		});
});
</script>
</head>
<body>
<div class="headtop">
    <a class="back" href="javascript:history.go(-1);" title="返回上一页"></a>
    <p>体检卡预约</p>
</div>
<div class="topblank"></div>
<form id="saveCardRe">
<div class="formmain">
	<div class="xmlist">
        <span class="tit">体检卡号</span>
        <div class="input">${card }</div>    
		<span class="tit1">密 码</span>
		<div class="input1">******</div> 
    </div>

	<div class="xmlist">    	
		<span class="tit">体检套餐</span>
        <div class="input2">${infoMap['product']['PNAME']}</div>         
        <input type="hidden" value="${infoMap['product']['PNAME']}" name="reservation.PName">
    </div>

	<div class="xmlist">
    	<span class="tit">城　　市</span>
    	<select id="select1" class="xlysl" name="reservation.city" onchange='comm.setSelectT(this, ${infoMap["temp"]}, ${infoMap["medicals"]})'>
    		<option value="">请选择城市</option>
            <c:forEach items="${infoMap['areaMap']}" var="areas" >
             	<option value="${areas.key}">${areas.value}</option>
             </c:forEach>
        </select>
    </div>

    <div class="xmlist">
    	<span class="tit">门　　店</span>
    	<select id="select2" class="xlysl1" name="reservation.esid" onchange='comm.setSelectH(this, ${infoMap["medicals"]}, ${infoMap["address"]})'>
        	<option value="">请选择</option>
        </select>
    </div>
    
    <input type="hidden" id="page_esid" />
    <input type="hidden" id="pid" name="reservation.pid" value="${infoMap['product']['PID']}" />
    <input type="hidden" name="reservation.card" value="${card}" />
    <input type="hidden" name="reservation.password" value="${password}" />
    <input type="hidden" value="${infoMap['type']}" id="calendarType" name="rsType"/>

	<div class="xmlist">
    	<span class="tit">地　　址</span>
    	<span class="cons1"><textarea  class="input2 address" readonly></textarea></span>
    </div>
	
	<div class="xmlist">
    	<span class="tit">时　　间</span>
        <input class="input4 ord_icon yuyuetime" readonly datatype="*" nullmsg="请选择预约日期" name="reservation.createrTime"/>
    </div>

	<div class="xmlist">
    	<span class="tit">姓　　名</span>
    	<input class="input3" name="reservation.reName" value="" datatype="s2-18" nullmsg="请填写体检人姓名" errormsg="仅支持中英文及数字下划线"/>
    	<span class="tit1">性 别</span>
    	<select class="xlysl2" name="reservation.reSex" nullmsg="请选择预约性别" datatype="*">
        	<option value="0">男</option>
            <option value="1">女</option>
        </select>
    </div>

	<div class="xmlist">    	
		<span class="tit">身&nbsp;&nbsp;份&nbsp;&nbsp;证</span>
        <input class="input4 idCheck" value="" name="reservation.reCid" datatype="z" nullmsg="请填写体检人身份证" errormsg="请填写正确身份证"/>         
    </div>

	<div class="xmlist">
    	<span class="tit">年　　龄</span>
    	<input class="input3" name="reservation.reYear" id="age" class="inputk4 tanage" value="" datatype="^(?:[1-9][0-9]?|1[01][0-9]|120)$" nullmsg="请填写体检人年龄" errormsg="请填写正确年龄"/>
    	<span class="tit1">婚否</span>
    	<select class="xlysl2" name="reservation.reMarriage" nullmsg="请选择预约人婚否" datatype="*">
        	<option value="0">未婚</option>
            <option value="1">已婚</option>
        </select>
    </div>

	<div class="xmlist">
        <span class="tit">手　　机</span>
        <input class="input" value="" name="reservation.reTel" datatype="^0{0,1}1[3|4|5|7|8]\d{9}$" nullmsg="请填写手机号码" errormsg="请填写正确手机号码"/>    
		<span class="tit2">体检报告</span>
		<c:choose>
   			<c:when test="${infoMap['product']['REPORT'] eq 1}">
   				<input class="input5" value="有" readonly/> 
   				<input type="hidden" name="reservation.docReports" value="1"/>
   			</c:when>
   			<c:otherwise>
   				<input class="input5" value="无 " readonly/> 
   				<input type="hidden" name="reservation.docReports" value="0"/>
   			</c:otherwise>
   		</c:choose>
		
    </div>

	<div class="xmlist" style="height: 9rem;">
		<span class="tit">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span>
		<textarea type="text" class="input6" placeholder="" name="reservation.reDesc"></textarea>
	</div>
</div>

<div class="button">
	<div class="but_l"><a href="javascript:void(0);" id="subCardRs">确定</a></div>
	<div class="but_r"><a href="javascript:void(0);" onclick="self.location=document.referrer;">取消</a></div>
</div>

</form>
<div class="fixmdrldiv" style="z-index:999999;">
    <div class="rilidiv">
        <div class="fenyuantit">分院名称分院名称</div>
        <div class="yuyue_rili re">
            <div class="yue_tit">
                <div class="riliqiean1"></div>
                <div class="riliyear"><select class="xlxzrili" id="xlyear"></select> 年 <select class="xlxzrili" id="xlmonth"></select> 月</div>
                <div class="riliqiean2"></div>
            </div>
            <ul class="fixxingqi">
              <li>日</li>
              <li>一</li>
              <li>二</li>
              <li>三</li>
              <li>四</li>
              <li>五</li>
              <li>六</li>
            </ul>
            <div class="yue_rili">
                <ul class="yue_day"></ul>
            </div>
            <div class="clear"></div>
        </div>
        <span class="guanbirili"></span>
    </div>
</div>



</body>
</html>