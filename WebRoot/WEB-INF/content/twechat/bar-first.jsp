<%@ page language="java"  pageEncoding="UTF-8"%>
<p class="optional-content-title" style="font-size: 1.7rem;">固定&包</p>
<ul class="select clearfix">
	<li class="clearfix">
		<div class="number title">
			编号
		</div>
		<div class="content title">
			体检项目
		</div>
	</li>
	
	<c:forEach items="${map.diyProductInfo}" var="product" varStatus="index">
		<li class="list-content clearfix ${index.first?'list-content-click':'' }">
			<div class="number">
				${index.index+1}
			</div>
			<div class="content">
				<p class="content-title">${product.MODEL_NAME}</p>
				<p class="introduction">${product.CONTEXT}</p>
			</div>
		</li>
	</c:forEach>
</ul>
<p class="optional-content-title">自选包（可多选）</p>
<div class="project clearfix">
	<ul class="clearfix" id="flyObj">
	<c:forEach items="${map.packageSet}" var="page" varStatus="index">
		<li class="pageLi" style="position: relative;" pageId="${page.PACKAGE_ID}" pageName="${page.PACKAGE_NAME}" pagePrice="${page.PRICE }">${page.PACKAGE_NAME}</li>
		<c:if test="${(index.index+1)%4 == 0 || index.last}">
			<c:forEach items="${map.packageSet}" var="page2" varStatus="index2">
				<c:if test="${(index2.index+1) <= (index.index+1) && (index2.index+1) > fn:substring((index.index)/4,0,fn:indexOf((index.index)/4,'.'))*4}">
				<div class="project-content clearfix pageDiv" id="page${page2.PACKAGE_ID}">
					<p class="project-content-title">${page2.PACKAGE_NAME}<span>￥${page2.PRICE }</span></p>
					<c:forEach items="${map.packageInfoList}" var="list" varStatus="index3">
						<c:if test="${page2.PACKAGE_ID==list.PACKAGE_ID}">
							<p class="project-int">${list.MODEL_NAME }<span> ${list.CONTEXT }</span></p>
						</c:if>
					</c:forEach>
				</div>
				</c:if>
			</c:forEach>
		</c:if>
	</c:forEach>
	</ul>
</div>
<p class="optional-content-title" style="font-size: 1.3rem;">您已选择自选包项目：<span id="divPageNameList">无</span></p>
