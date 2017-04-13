<%@ page language="java"  pageEncoding="UTF-8"%>
<%--固定项+单项自定义项--%>
<div id="thirdGdData" style="height: 260px;overflow: hidden;">
	<p style="font-size: 1.7rem;text-align: center;color: #404040;margin: 2% 0;">固定&单项</p>
	<ul class="select clearfix">
		
		<li class="clearfix">
			<div class="number title">
				编号
			</div>
			<div class="content title">
				体检项目
			</div>
		</li>
		
		<c:forEach items="${map.productInfo}" var="product" varStatus="index">
			<li sid="${product.ID }" class="list-content clearfix ${index.first?'list-content-click-nochoose':'' }">
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
</div>
<div id="showAllmeal" style="height: 30px;padding: 7px;text-align: center;color: #027ac8;" show="0">点击展开全部</div>



<div class="optional-bar-second">
<p class="optional-content-title" style="font-size: 1.5rem;">自定义选项(根据自身情况多选)</p>
<div class="bar-search">
	<img src="/img/search.png" />
	<input type="text" onblur="getSetMealInfoListThird(${params.esid},1)" id="keyWord3" value="" placeholder="搜索项目内容/项目金额" class="form-control" />
</div>
<ul class="select clearfix" id="setMealPage3"></ul>

<nav aria-label="Page navigation">
	<ul class="pagination myPagination" id="myPagination3"></ul>
</nav>

<ul class="selected clearfix" id="selectSetMeal3">
	<li>您共选择自定义选项 <span id="selectCount3">0项</span></li>
</ul>
</div>


<script type="text/javascript">
	$("#showAllmeal").click(function(){
		if($(this).attr("show")=="0"){
			$("#thirdGdData").css("height","");
			$(this).text("点击收起");
			$(this).attr("show","1");
		}else{
			$("#thirdGdData").css("height","260px");
			$(this).text("点击展开全部");
			$(this).attr("show","0");
		}
	})
$(".optional-bar-third .select li.list-content").click(function() {
	$(this).siblings('li').removeClass('list-content-click-nochoose');
	$(this).addClass('list-content-click-nochoose')
})
	
function getSetMealInfoListThird(esid,page){
	var keyWord=$("#keyWord3").val().trim();
	var data;
	var mealIds="";
	$("#thirdGdData ul li.list-content").each(function(){
		mealIds+=$(this).attr("sid")+",";
	})
	if(mealIds.length>0){
		mealIds=mealIds.substr(0,mealIds.length-1);
	}
	if(isNaN(keyWord)){
		data={"esid":esid,"page":page,"keyWord":keyWord,"mealIds":mealIds};
	}else{
		data={"esid":esid,"page":page,"price":keyWord,"mealIds":mealIds};
	}
	 $.getJSON("/core/twechat.getSetMealInfoList.do",data ,function(data){   
		 if(data.length>0){
				var html='<li class="clearfix"><div class="number title">编号</div><div class="content title">体检项目</div><div class="money-sale title">优惠价</div></li>';
				var pageHtml='';
					for(var i=0;i<data[0].list.length;i++){
						html+='<li cid="'+data[0].list[i].ID+'" class="list-content clearfix';
							$("#selectSetMeal3").find(".setmeal").each(function(){
								if($(this).attr("sid")==data[0].list[i].ID){
									html+=' list-content-click'
								}
							})
						html+='"><div class="number">';
						html+=(data[0].pageNo-1)*10+(i+1);
						html+='</div><div class="content">';
						html+='<p class="content-title">'+data[0].list[i].MODEL_NAME+'</p>';
						html+='<p class="introduction">'+data[0].list[i].CONTEXT+'</p>';
						html+='</div><div class="money-sale">';
						html+='￥'+data[0].list[i].PRICE;
						html+='</div></li>';
					}
					
					//页码
					pageHtml='<li num="'+(parseInt(data[0].pageNo)-1)+'"><a ';
					if(parseInt(data[0].pageNo)==1){
						pageHtml+=' style="background-color: #eee;"'
					}
					pageHtml+=' aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
					if(data[0].totalPages<5){
						for(var j=0;j<data[0].totalPages;j++){
							pageHtml+='<li num="'+(j+1)+'"';
							if((j+1)==data[0].pageNo){
								pageHtml+=' class="pagination-active"';
							}
							pageHtml+='><a>'+(j+1)+'</a></li>';
						}
					}else{
						var centerNum=data[0].totalPages/2*10;
						if(centerNum>=10){
							centerNum=(centerNum+"").substr(0,(centerNum+"").length-1);
						}
						if((parseInt(data[0].pageNo)+2)>data[0].totalPages){
							pageHtml+='<li num="1"><a>1</a></li><li style="border: inherit;">...</li>';
							for(var j=0;j<3;j++){
								pageHtml+='<li';
								if(data[0].pageNo==(parseInt(data[0].totalPages)-2+j)){
									pageHtml+=' class="pagination-active"';
								}
								pageHtml+=' num="'+(parseInt(data[0].totalPages)-2+j)+'"><a>'+(parseInt(data[0].totalPages)-2+j)+'</a></li>';
							}
							
						}else{
							if(parseInt(data[0].pageNo)>3 && parseInt(data[0].pageNo)<(parseInt(data[0].totalPages)-1)){
								pageHtml+='<li num="1"><a>1</a></li><li style="border: inherit;padding-top:12px;">...</li>';
								$("#myPagination3").css("padding-left","5%");
							}
							if(data[0].pageNo>1){
								pageHtml+='<li num="'+(parseInt(data[0].pageNo)-1)+'"><a>'+(parseInt(data[0].pageNo)-1)+'</a></li>';
							}
							for(var j=0;j<2;j++){
								pageHtml+='<li num="'+(parseInt(data[0].pageNo)+j)+'"';
								if(j==0){
									pageHtml+=' class="pagination-active"';
								}
								pageHtml+='><a>'+(parseInt(data[0].pageNo)+j)+'</a></li>';
							}
							if(data[0].pageNo==1){
								pageHtml+='<li num="'+(parseInt(data[0].pageNo)+2)+'"><a>'+(parseInt(data[0].pageNo)+2)+'</a></li>';
							}
							pageHtml+='<li style="border: inherit;padding-top:12px;">...</li><li num="'+data[0].totalPages+'"><a>'+data[0].totalPages+'</a></li>'
						}
						
					}
					pageHtml+='<li num="'+(parseInt(data[0].pageNo)+1)+'"><a';
					if(parseInt(data[0].pageNo)==parseInt(data[0].totalPages)){
						pageHtml+=' style="background-color: #eee;"'
					}
					pageHtml+=' aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
					
				$("#setMealPage3").html(html);
				$("#myPagination3").html(pageHtml);
				
				//完全自定义 单项点击事件
				$(".optional-bar-second .select li.list-content").click(function() {
				 if(!$(this).hasClass("list-content-click")){
					$("#createOrder").attr("disabled", true);
					var proOffset=$(this).offset();
					var offset=$("#selectSetMeal3").offset();
					var flyer=$('<div style="background-color:#ffffff;border: 2px solid #027ac8;width:50%;height:40px;overflow:hidden;text-align: center;position:fixed;">'
								+'<span style="font-size:14px;">'+$(this).find(".content-title").text()+'</span></div>'); 
					 var e = event || window.event;
					 var num=$(this).find(".number").text();
					 var countNum=parseInt(num)%10;
					 var count = 10-countNum;
					 	if(countNum==0){
					 		count=0;
					 	}
					 var divH = $(this).outerHeight()*(count)+150;
					flyer.fly({ 
			            start: {
			                left: 0, //开始位置（必填）#fly元素会被设置成position: fixed 
			                top: e.clientY  //开始位置（必填） 
			            }, 
			            end: { 
			                left: offset.left+150, //结束位置（必填） 
			                top: e.clientY+divH,
			                width: 0, //结束时宽度 
			                height: 0 //结束时高度 
			            }, 
			            onEnd: function(){ //结束回调 
			               this.destory(); //移除dom 
			               $("#createOrder").attr("disabled", false);
			            } 
			        });
				 }
					
					var selectSetMeal=$("#selectSetMeal3").text();
					var name=$(this).find(".content .content-title").text();
					var id=$(this).attr("cid");
					var money=$(this).find(".money-sale").text().replace("￥","");
					$(".optional-bar-second .select li.list-content .content .introduction").css("white-space","nowrap");
					$(this).find(".content .introduction").css("white-space","normal");
					if($(this).hasClass("list-content-click")){
						$(this).removeClass('list-content-click')
						$("#selectSetMeal3").find(".setmeal").each(function(){
							if($(this).attr("sid")==id){
								$(this).remove();
							}
						})
					}else{
						$(this).addClass('list-content-click');
						var shtml='<li class="setmeal" sid="'+id+'" money="'+money+'"><span class="lfsetmeal">'+name +'(￥'+money+')</span><span onclick="delSetmealThird('+id+')" class="delbtn">×</span></li> ';
						$("#selectSetMeal3").append(shtml);
					}
					
					$("#selectCount3").text($("#selectSetMeal3").find(".setmeal").length+"项");
					$("#selectSetMeal3 .setmeal .lfsetmeal").each(function(){
						var text=$(this).text();
						if(text.length>10){
							$(this).text(text.substr(0,10)+"...");
						}
					})
					sumMoneyThird();
					
				})
				
				//点击页数
				$("#myPagination3 li a").click(function(){
					var page=$(this).parent().attr("num");
					if($(this).hasClass("pagination-active")){
						return false;
					}
					getSetMealInfoListThird(esid,parseInt(page))
				})
			}else{
				//无可选单项情况
				/*$(".optional-bar-second-bar").hide();
				var diyPid=$("#diyPid").val();
				if(diyPid==null){
					var topHtml='';
					topHtml+='<ul class="listPageNav clearfix" style="width: 100%;border:inherit;border-radius:inherit;">';
					topHtml+='<li class="nav-active fixed" style="width: 100%;background: #027ac8;color:#fff">固定套餐</li>';
					topHtml+='<input type="hidden" id="productType" value="1">';
					topHtml+='</ul>';
					$("#productTypeTitle").html(topHtml);
				}*/
			}
	 })
}
	
function delSetmealThird(id){
	$("#selectSetMeal3").find(".setmeal").each(function(){
		if($(this).attr("sid")==id){
			$(this).remove();
		}
	})
	$(".optional-bar-second .select li.list-content").each(function(){
		if($(this).attr("cid")==id){
			$(this).removeClass("list-content-click");
		}
	})
	$("#selectCount3").text($("#selectSetMeal3").find(".setmeal").length+"项");
	sumMoneyThird();
}
function sumMoneyThird(){
	var price=$("#gdtcPriceInput").val();
	$("#selectSetMeal3").find(".setmeal").each(function(){
		price=parseFloat(price)+parseFloat($(this).attr("money"));
	})
	price=parseFloat(price).toFixed(2);
	$("#divProductPrice").text("￥"+price);
	var roleLimit2=$("#roleLimit2").val();
	if(parseFloat(price) > parseFloat(roleLimit2)){
		$("#shouldPay2").text("￥"+(parseFloat(price) - parseFloat(roleLimit2)).toFixed(2));
		$("#createOrder").val("确认付款");
	}else{
		$("#shouldPay2").text("0");
		$("#createOrder").val("提交预约");
	}
	
}

</script>