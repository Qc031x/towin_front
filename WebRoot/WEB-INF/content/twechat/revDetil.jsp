<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/content/public/head.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="shortcut icon" href="/img/icon.ico" />
		<title>欢迎</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/hello.css" />
	</head>

	<body>
		<%@include file="/WEB-INF/content/public/top.jsp" %>
		<div style="width: 100%;background: #FFF;">
		<div class="page">
			<div class="hello-name">
				<p>尊敬的 <span>${emp.rname }</span>
				<c:choose>
					<c:when test="${emp.sex == 0 }">
						<span>先生</span>
					</c:when>
					<c:otherwise>
						<span>女士</span>
					</c:otherwise>
				</c:choose>
				:</p>
				<p><span>${emp.name }</span>已经安排了您<span>${emp.checkup_year }年</span>的体检计划</p>
			</div>
			<div class="hello-time">
				<p>开始预约体检:<span>${emp.start_time }</span></p>
				<p>体检结束日期:<span>${emp.end_time }</span></p>
			</div>
			<div class="hello-money">
				<p>本次体检您的可用额度为:<span>${emp.role_Limit2==null || emp.role_Limit2==""? emp.role_Limit :emp.role_Limit2}元</span></p>
			</div>
			<div class="hello-add">
				<p>体检机构:<span>
					<c:forEach items="${shop }" var="shop" varStatus="index">
						${shop.ename }
						<c:if test="${!index.last}">、</c:if>
						<c:if test="${index.last}">
							<input id="esidCount" value="${index.index+1}" type="hidden">
						</c:if>
					</c:forEach>
				</span></p>
				<p style="color: #666;">*在基础套餐之外，您可以根据自身健康状况自选体检项目</p>
			</div>
			<div class="hello-tel">
				<p>咨询电话:<span> 4006616669</span></p>
			</div>
			</div>
		</div>
		<div class="hello-btn">
			<input type="button" id="" value="立即选择体检机构" class="btn btn-block" onclick="toNextPage()" />
		</div>
		<script type="text/javascript">
			function toNextPage(){
				if($("#esidCount").val()>1){
					window.location.href="${ctx}/core/twechat.toBranchList.do";
				}else{
					var esId='${shopMap.esid}';
					var address='${shopMap.address}';
					var batchId='${shopMap.batchId}';
					var employeeId='${shopMap.employeeId}';
					window.location.href="/core/twechat.toBrandsInfo.do?esid="+esId+"&address="+address+"&batchId="+batchId+"&employeeId="+employeeId;
				}
			}
		</script>
	</body>

</html>