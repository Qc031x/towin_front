<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>支付成功</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/list.css" />
		<link rel="stylesheet" type="text/css" href="/css/chooseTime.css" />
	</head>
<body>
	<%@include file="/WEB-INF/content/public/top.jsp" %>
	
		<br>
		<p style="padding:5px;font-size:18px;margin-left:20px">恭喜您购买成功</p>
		<div class="time-page" style="min-height: initial;">
			<ul>
				<li style="margin-left: 18px;">订单号:${order.OID} </li>
				<li style="margin-left: 18px;">订购时间:${order.PAY_TIME} </li>
				<li style="margin-left: 18px;">订购套餐:
					<c:choose>
					   <c:when test="${order.PRODUCT_TYPE == 1}">${order.PRODUCTNAME}</c:when>
					   <c:when test="${order.PRODUCT_TYPE == 2}">${order.CUSTOMNAME}</c:when>
					   <c:when test="${order.PRODUCT_TYPE == 3}">单项自定义套餐</c:when>
					   <c:when test="${order.PRODUCT_TYPE == 4}">固定项&自定义项套餐</c:when>
					  
					</c:choose>
				</li>
				<li style="margin-left: 18px;">支付金额:￥${order.TOTAL_PAY} </li>
			</ul>
			<div class="list-btn">
				<input type="button" id="" value="查看详情" class="btn btn-block" onclick="window.location.href='/core/twechat.toReservationDetail.do?yid=${order.YID}'"/>
			</div>
		</div>
		
	
</body>
</html>