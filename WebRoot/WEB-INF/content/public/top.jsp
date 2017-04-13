<%@ page language="java"  pageEncoding="UTF-8"%>

<nav class="mynav clearfix">
			<ul>
				<c:if test="${sessionScope.isReservation == 0}">
					<li onclick="toBrandPage();">
						<img src="/img/time.png" />
						<p>体检预约</p>
					</li>
				</c:if>
				<c:if test="${sessionScope.isReservation == 1}">
					<li>
						<img src="/img/time.png" />
						<p>体检报告 </p>
					</li>
				</c:if>
				<!-- <li onclick="window.location.href='https://kdt.im/8geqDr'"> -->
				<li onclick="window.location.href='http://r.51towin.com'">
					<img src="/img/store.png" />
					<p>健康商城</p>
				</li>
				<li onclick="window.location.href='/content/twechat.mine.do'">
					<img src="/img/our2.png" />
					<p>我的特权</p>
				</li>
				<li onclick="window.location.href='/core/twechat.toReservationDetail.do'">
					<img src="/img/mine.png" />
					<p>我的预约</p>
				</li>
			</ul>
		</nav>
<script type="text/javascript">
	function toBrandPage(){
		 $.getJSON("/core/twechat.checkBrandCount.do",null ,function(data){   
			 	console.info(data);
				if(data.length == 0){
					alert("您当前没有可预约信息，预约失败！")		
				}else if(data.length == 1){
					var esId=data[0].ESID;
					var address=data[0].PROVINCE+data[0].CITY+data[0].AREA+data[0].ADDRESS;
					var batchId='${sessionScope.batchId}';
					var employeeId='${sessionScope.employeeId}';
					window.location.href="/core/twechat.toBrandsInfo.do?esid="+esId+"&address="+address+"&batchId="+batchId+"&employeeId="+employeeId;
				}else{
					window.location.href="${ctx}/core/twechat.toBranchList.do";
				}
		});
	}
</script>


