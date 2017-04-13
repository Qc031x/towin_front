<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/head.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="shortcut icon" href="img/icon.ico" />
		<meta name="format-detection" content="telephone=no" />
		<title>选择体检机构</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/chooseHospital.css" />
	</head>

	<body>
		<%@include file="/WEB-INF/content/public/top.jsp" %>
		
		<c:forEach items="${brandList}" var="list" varStatus="index">
			<div class="hospital" onclick="toBrandsInfo(${list.ESID});">
				<c:if test="${index.first}">
					<p class="hospital-title">体检机构选择</p>
				</c:if>
				<div class="hospital-content clearfix">
					<div class="img clearfix">
						<c:choose>
							<c:when test="${list.img[0] !=null}">
								<c:forEach items="${list.img}" var="img">
									<c:if test="${img.MODEL_FLAG == 0}">
									    <img src="${ctxImg}/shop/${list.CSID}/${img.ESID}/${img.IMG_URL}"/>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<img src="/img/nohospital_small.jpg"/>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="describe">
						<p class="describe-title">${list.NAME}</p>
						<p>营业时间:${list.CHECKUP_TIME}</p>
						<p>联系电话:${list.TEL}</p>
						<p>体检地址:
						<span class="addressTest" esid="${list.ESID}">
							${list.PROVINCE}${list.CITY}${list.AREA}${list.ADDRESS}
						</span>
							<input type="hidden" value="${list.PROVINCE}${list.CITY}${list.AREA}${list.ADDRESS==null?'':list.ADDRESS}" id="address${list.ESID}">
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</body>
<script type="text/javascript">
	/*$(".addressTest").each(function(){
		var address=$.trim($(this).text());
		if(address.length>13){
			$(this).text(address.substr(0,13)+"...");
		}
	})*/

	function toBrandsInfo(esId){
		var address=$.trim($("#address"+esId).val());
		window.location.href="/core/twechat.toBrandsInfo.do?esid="+esId+"&address="+address+"&batchId="+${batchId}+"&employeeId="+${employeeId};
	}
</script>
</html>