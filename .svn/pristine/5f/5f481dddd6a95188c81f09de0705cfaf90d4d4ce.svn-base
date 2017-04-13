<%@ page language="java"  pageEncoding="UTF-8"%>
		
		<p class="myOrder-title">您已选择套餐</p>
		<div class="order-content">
		<!--固定套餐单项内容  -->
			<c:if test="${info.baseInfo.PRODUCT_TYPE==1}">
				<p class="myOrder-title">固定套餐</p>
				<table border="0" cellspacing="0" cellpadding="0">
					<c:forEach items="${info.productInfo}" var="product" varStatus="index">
						<tr>
							<td>${product.MODEL_NAME}</td>
							<td>${product.CONTEXT}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			
		<!-- 固定项&加项包 -->
		<c:if test="${info.baseInfo.PRODUCT_TYPE==2}">
			<p class="myOrder-title">固定项</p>
			<table border="0" cellspacing="0" cellpadding="0">
				<c:forEach items="${info.diyProductInfo}" var="product" varStatus="index">
					<tr>
						<td>${product.MODEL_NAME}</td>
						<td>${product.CONTEXT}</td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${info.baseInfo.SETMEAL_IDS !=null}">
				<c:forEach items="${info.packList}" var="page" varStatus="index">
					<p class="myOrder-title">包：${page.packName}</p>
					
					<table border="0" cellspacing="0" cellpadding="0">
						<c:forEach items="${page.pcInfo}" var="list" varStatus="index3">
							<tr>
								<td>${list.MODEL_NAME }</td>
								<td>${list.CONTEXT }</td>
							</tr>
						</c:forEach>
					</table>
				</c:forEach>
			</c:if>
			
		</c:if>
		
		<!-- 单项自定义 -->
		<c:if test="${info.baseInfo.PRODUCT_TYPE==3}">
			<p class="myOrder-title">单项自定义套餐</p>
			<table border="0" cellspacing="0" cellpadding="0" class="table-diy">
				<c:forEach items="${info.setMealList}" var="product" varStatus="index">
					<tr>
						<td class="table-name">${product.MODEL_NAME}</td>
						<td class="table-con">${product.CONTEXT}</td>
						<td class="table-price">￥${product.PRICE }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<!-- 固定项&单项自定义 -->
		<c:if test="${info.baseInfo.PRODUCT_TYPE==4}">
			<p class="myOrder-title" style="color: #027ac8;">固定项</p>
			<div class="thirdGdData" style="height: 260px;overflow: hidden;">
				<table border="0" cellspacing="0" cellpadding="0">
					<c:forEach items="${info.productInfo}" var="product" varStatus="index">
						<tr>
							<td>${product.MODEL_NAME}</td>
							<td>${product.CONTEXT}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="showAllmeal" style="height: 30px;padding: 7px;text-align: center;color: #999;box-shadow: 0 5px 10px #eee;" show="0">点击展开全部</div>
			<p class="myOrder-title" style="color: #027ac8;margin-top:1.3rem">自定义项</p>
			<div class="thirdGdData" style="height: 260px;overflow: hidden;">
				<table border="0" cellspacing="0" cellpadding="0" class="table-diy">
					<c:forEach items="${info.setMealList}" var="product" varStatus="index">
						<tr>
							<td class="table-name">${product.MODEL_NAME}</td>
							<td class="table-con">${product.CONTEXT}</td>
							<td class="table-price">￥${product.PRICE }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="showAllmeal" style="height: 30px;padding: 7px;text-align: center;color: #999;box-shadow: 0 5px 10px #eee;" show="0">点击展开全部</div>
		</c:if>
		
		</div>
		
		<!-- <div class="order-btn">
			<input type="button" id="" value="重新预约" class="btn btn-block" />
		</div>
		<div class="order-btn" style="min-height: 5em;">
			<input type="button" id="" value="取消预约" class="btn btn-block" />
		</div> -->
<script>
$(".showAllmeal").click(function(){
	if($(this).attr("show")=="0"){
		$(this).prev(".thirdGdData").css("height","");
		$(this).text("点击收起");
		$(this).attr("show","1");
	}else{
		$(this).prev(".thirdGdData").css("height","260px");
		$(this).text("点击展开全部");
		$(this).attr("show","0");
	}
})
</script>