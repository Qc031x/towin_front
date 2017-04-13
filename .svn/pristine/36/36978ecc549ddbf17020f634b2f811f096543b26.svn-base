<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/head.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="shortcut icon" href="/img/icon.ico" />
		<meta name="format-detection" content="telephone=no" />
		<title>选择体检时间</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/swiper.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/chooseTime.css" />
		<link href="/css/twui-dialog.css" rel="stylesheet" type="text/css" />
		
		<style type="text/css">
		.yuyue_rili {width: 100%;background: #fff;overflow: hidden;z-index: 9999;}
		.yue_tit {width: 100%;clear: both;height: 2.93rem;line-height: 1.93rem; font-size: 12px;text-align: center;color: #333232;position: relative;}
		.yuyue_rili .fixxingqi {width: 100%;overflow: hidden;height: 1.5rem; line-height: 1.5rem; text-align: center;color: #9f9f9f;}
		.yue_rili .yue_day {width: 100%;clear: both;overflow: hidden;background: url(../images/rililistbigbg.png) 0 0 repeat;background-size: 100% 80px;text-align: center;}
		 ul {padding: 0;margin: 0;list-style: none;}
		.yue_rili .yue_day li.over {color: #999;line-height: 3rem;}
		.yuyue_rili .fixxingqi li:nth-child(7n), .yuyue_rili .fixxingqi li:nth-child(7n+1), .yue_rili .yue_day li:nth-child(7n), .yue_rili .yue_day li:nth-child(7n+1) {color: #027ac8;}
		.yuyue_rili .fixxingqi li:nth-child(7n), .yue_rili .yue_day li:nth-child(7n) {border-right: none;}
		.yue_rili .yue_day li {width: 14.28%;height: 40px;line-height: 20px;font-size: 10px;float: left;font-weight: bold;color: #bcbcbc;border-width: 0 1px 1px 0;position: relative;margin-top: 0px;}
		.yuyue_rili .fixxingqi li {width: 14.28%;height: 1.5rem;float: left;font-size: 12px;margin-top: 0px;}
		.yue_tit .riliqiean1 {width: 8px;height: 15px;background: url(../img/riliqiean1.png) center center no-repeat;background-size: 8px auto;cursor: pointer;display: inline-block;position: absolute;top: 7px;left: 26.5%;overflow: hidden;}
		.yue_tit .riliyear {line-height: 2.93rem;display: inline-block;overflow: hidden;font-size: 16px;}
		.yue_tit .riliqiean2 {width: 8px;height: 15px;background: url(../img/riliqiean2.png) center center no-repeat;background-size: 8px auto;cursor: pointer;display: inline-block;position: absolute;top: 7px;right: 26.5%;overflow: hidden;}
		.zt2{color: #027ac8;}
		.yue_rili .yue_day .active{border: 2px solid #027ac8;border-radius: 50%;}
		</style>
	</head>

	<body>
		<%@include file="/WEB-INF/content/public/top.jsp" %>
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<c:choose>
					<c:when test="${brandchInfo.img[0] !=null}">
						<c:forEach items="${brandchInfo.img}" var="img">
							<div class="swiper-slide"><img src="${ctxImg}/shop/${img.CSID}/${img.ESID}/${img.IMG_URL}" /></div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="swiper-slide"><img src="/img/nohospital_big.jpg" /></div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="swiper-pagination"></div>
		</div>
		
		<div style="width: 100%;background: #fff;">
			<div class="time-page">
				<p class="time-title">${brandchInfo.NAME}</p>
				<ul>
					<li><img src="/img/time-sm.png" />营业时间:${brandchInfo.CHECKUP_TIME}</li>
					<li><img src="/img/phone.png" />联系电话:${brandchInfo.TEL}</li>
					<li><img src="/img/local.png" onclick="window.location.href='/content/twechat.map.do?address=${address}&ename=${brandchInfo.NAME}&description=${brandchInfo.DESCRIPTION}&tel=${brandchInfo.TEL}&img=${brandchInfo.img[0].CSID}/${brandchInfo.img[0].ESID}/${brandchInfo.img[0].IMG_URL}'"/>
						<span>体检地址:</span>${address}
					</li>
				</ul>
			</div>
		</div>
			
		<div style="width: 100%;background: #fff;margin-top:0.833%;">
			<p class="choosetime" style="border-top: none;border-bottom: 1px solid #e8e8e8;"><span>预约体检日期</span></p>
				<input type="hidden" id="batchStartTime" value="${batchInfo.START_TIME }">
				<input type="hidden" id="batchEndTime" value="${batchInfo.END_TIME }">
				<div class="yuyue_rili">
			        <div class="yue_tit">
			            <div class="riliqiean1"></div>
			            <div class="riliyear"><span class="xlxzrili" id="xlyear"></span> 年 <span class="xlxzrili" id="xlmonth"></span> 月</div>
			            <div class="riliqiean2"></div>
			        </div>
			        <ul class="fixxingqi">
			            <li>星期日</li>
			            <li>星期一</li>
			            <li>星期二</li>
			            <li>星期三</li>
			            <li>星期四</li>
			            <li>星期五</li>
			            <li>星期六</li>
			        </ul>
			        <div class="yue_rili">
			        	<input type="hidden" id="page_esid" value="${esid}">
			            <ul class="yue_day"></ul>
			        </div>
			        <div class="clear"></div>
			    </div>
			<p class="choosetime">您已选择体检日期 <span id="selectDate">${batchInfo.START_TIME} ~ ${batchInfo.END_TIME}</span></p>
			</div>
			<div style="width: 93.75%;margin: 0 auto;min-height: 5em;">
				<input style="height: 35px;" type="button" id="" value="进入套餐详情" class="btn btn-block" onclick="toProductDetail();"/>
			</div>
		
	</body>
	
<script src="/js/swiper.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/twui-dialog.js" type="text/javascript"></script>
<script src="/js/chooseTime.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/commonLib.js" type="text/javascript"></script>
<script src="/js/calendar.js" type="text/javascript"></script>
<script type="text/javascript">
		$.showLoading("正在加载体检日期");
		calendar.getjiazairili(8);
		function toProductDetail(){
		   var url ="/core/twechat.checkOrderTime.do",data={"orderTime":$("#selectDate").text(),"esid":'${esid}'};
		   $.getMyJSON(url,data,function(data){
		       if(data.returncode==1){
		    	   $.alert("提示",data.errmsg);
		         return false;
		       }
		        if($(".yue_rili .yue_day").find(".active").length>0){
				window.location.href='/core/twechat.toProductDetail.do?esid=${esid}&orderTime='+$("#selectDate").text();
				}else{
					$.alert("提示","请选择预约日期！");
				}
		   });	
		}
	</script>
</html>