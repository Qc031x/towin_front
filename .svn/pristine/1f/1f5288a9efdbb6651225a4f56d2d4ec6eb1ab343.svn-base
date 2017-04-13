<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/head.jsp" %>
<%
	request.setAttribute("address", request.getParameter("address"));
	request.setAttribute("ename", request.getParameter("ename"));
	request.setAttribute("description", request.getParameter("description"));
	request.setAttribute("tel", request.getParameter("tel"));
	request.setAttribute("img", request.getParameter("img"));
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="shortcut icon" href="/img/icon.ico" />
		<meta name="format-detection" content="telephone=no" />
		<title>医院地址</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
	
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=aUdXt1rFwxj5gddQTWAj4cDi4dxqcuhy&s=1"></script>	
<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<script src="/js/twui-dialog.js" type="text/javascript" ></script>
<link rel="stylesheet" type="text/css" href="/css/twui-dialog.css" />
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
	
	</head>

	<body>
		<%@include file="/WEB-INF/content/public/top.jsp" %>
		<input type="hidden" value="${address}" id="address">		
		<input type="hidden" value="${ename}" id="ename">	
		<input type="hidden" value="${description}" id="description">	
		<input type="hidden" value="${tel}" id="tel">
		<input type="hidden" value="${img}" id="img">
		
		<div id="allmap" style="width: 100%;height: 60%"></div>
		<div class="mapChooseType" id="mapChooseType">
			<a class="car">驾车</a>
			<a class="bus">公交</a>
			<a class="foot">步行</a>
		</div>
		<div id="r-result" style="width:100%;overflow: hidden;"></div>
	</body>
<script src="/js/map.js" type="text/javascript" ></script>	
<style type="text/css">
		#BMapLib_nav0{
		overflow: hidden;
		}
		#BMapLib_nav0  ul li table tr td input{
			margin-right: 3px;
    		font-size: 12px;
		}
		#BMapLib_stationText0{
			font-size: 12px;
		    width: 26px;
		}
		.BMapLib_SearchInfoWindow .iw_bt, .BMapLib_SearchInfoWindow .iw_bt_down, .BMapLib_SearchInfoWindow .iw_bt_over{
			width: 44px;
		    height: 22px;
		    line-height: 18px;
		    cursor: pointer;
		    border: 1px solid #a5acb2;
		    border-radius: 3px;
		    background-color: #fff;
		    background: inherit;
		}
		#r-result {width:100%; font-size:14px;line-height:20px;}
		
		.mapChooseType{
			width: 100%;
			height: 40px;
    		text-align: center;
    		display: inline-flex;
    		border: 1px solid #eee;
		}
		.mapChooseType a{
			width: 33%;
			padding: 10px;
			border-left: 1px solid #eee;
			border-right: 1px solid #eee;
		}
		.mapChooseType a:FIRST-CHILD{
			border: 0px;
		}
		.mapChooseType a:LAST-CHILD{
			border: 0px;
			width: 34%;
		}
		.mapChooseType a.active{
			background-color: #eee;
		}
		.sel_n .sel_body_name{
		height: inherit;
		}
	</style>
</html>