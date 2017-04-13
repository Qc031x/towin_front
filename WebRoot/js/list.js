$.getJSON("/core/twechat.getSetMealInfoList.do",{"esid":$("#esid").val()} ,function(data){ 
	var pid=$("#pid").val();
	var diyPid=$("#diyPid").val();
	var thtml='';
	console.info(data);
	if(pid!=null && pid!="" && (diyPid==null || diyPid=="") && data[0].list.length <=0){
		thtml+='<ul class="listPageNav clearfix" style="width: 100%;border:inherit;border-radius:inherit;">';
		thtml+='<li class="nav-active fixed" style="width: 100%;background: #027ac8;color:#fff">固定套餐</li>';
		thtml+='<input type="hidden" id="productType" value="1">';
		thtml+='</ul>';
		$("#productTypeTitle").html(thtml);
	}
	if(data[0].list.length <=0){
		$("#gdAndDx").hide();
		$("#Dx").hide();
	}else{
		$("#Dx").show();
	}
})
$(".tagulTaocan li").click(function() {
	$(".tagulTaocan li").removeClass('nav-active');
	$(this).addClass('nav-active');
	var productType=$(this).attr("productType")
	$("#productType").val(productType);
	//只有完全自定义时执行以下动作
	var type=0;
	$("#diyTopTitle li").each(function(){
		//alert($(this).attr("diyType"))
		if($(this).attr("diyType")==1){
			type=1;
		}
	})
	//type=0 只有完全自定义  type=1 有加项包
	if(productType !=1 && type==0){
		$("#bar-first").hide();
		$("#bar-second").hide();
		$("#bar-third").show();
		$("#diyTopTitle li").removeClass("bar-active");
		$("#diyTopTitle li:first").addClass("bar-active");
		$("#divProductPrice").text("0")
		$("#productType").val("4");
		$("#myLimit").text($("#roleLimit1").val());
		$("#roleLimit2").val($("#roleLimit1").val());
		var esid=$("#esid").val();
		getSetMealInfoListThird(esid,1);
		sumMoneyThird();
	}
})
$(".fixed").click(function() {
	if($(this).hasClass("nav-active")){
	$(".optional-content").hide();
	$(".fixed-content").show()
	}
})
$(".optional").click(function() {
	if($(this).hasClass("nav-active")){
	$(".fixed-content").hide();
	$(".optional-content").show();
	}
})
//固定套餐
$(".fixed-content .select li.list-content").click(function() {
	$(this).siblings('li').removeClass('list-content-click');
	$(this).addClass('list-content-click')
})

//固定+加项包
$(".optional-bar-first .select li.list-content").click(function() {
	$(this).siblings('li').removeClass('list-content-click');
	$(this).addClass('list-content-click')
})
$(".optional-bar-first .project ul li").click(function() {
	$(this).toggleClass("click");
	$(".pageDiv").hide();
	$("#page"+$(this).attr("data") ).show();
})

$(".pageLi").click(function(){
	 $(".pageDiv").hide();
	 $("#page"+$(this).attr("pageid")).show();
	
	 if($(this).hasClass("click")){
		 $("#createOrder").attr("disabled", true); 
		 var proOffset=$(this).offset();
		 var offset=$("#divPageNameList").offset();
		 
		 var text=$(this).attr("pagename");
		 var flyer=$('<input type="button" class="btn" value="'+text+'"'+
				 'style="font-size: 1.1rem;background: #027ac8;color: #fff;width: 80px;height: 29px;'+
				 'position: relative;top:'+proOffset.top+';left:'+proOffset.left+';">'); 
		 var e = event || window.event;
		 var divH = $("#page"+$(this).attr("pageid")).outerHeight()+30;
		 
		 flyer.fly({ 
	            start: {
	                left: e.clientX, //开始位置（必填）#fly元素会被设置成position: fixed 
	                top: e.clientY  //开始位置（必填） 
	            }, 
	            end: { 
	                left: offset.left, //结束位置（必填） 
	                top: e.clientY+divH,
	                width: 0, //结束时宽度 
	                height: 0 //结束时高度 
	            }, 
	            onEnd: function(){ //结束回调 
	               getCheckPage();
	               this.destory(); //移除dom 
	               $("#createOrder").attr("disabled", false); 
	            } 
	        });
		 
	 }else{
		 var offset=$(this).offset();
		 var text=$(this).attr("pagename");
		 var moveObj=$("#divPageNameList").clone();
		 var proOffset=$("#divPageNameList").offset();
		 moveObj.text(text);
		 moveObj.css({ "position": "absolute", "top": proOffset.top, "left": proOffset.left });
		 $("#divPageNameList").parent().append(moveObj);
		 moveObj.animate({
			 left: offset.left,
             top: offset.top-10,
             width:"10px",
             height:"0px",
             opacity:"0"
		 },"slow");
		 getCheckPage();
		 setTimeout(function(){
			 moveObj.remove();
		 },600)
		 
	 }
})

$(".rePageLi").click(function(){
	if($(this).hasClass("click")){
		$(this).removeClass("click");
	}else{
		$(this).addClass("click");
	}
	 $(".pageDiv").hide();
	 $("#page"+$(this).attr("pageid")).show();
})

function getCheckPage(){
	var divProductPrice=$("#divProductPriceInput").val();
	var roleLimit=parseFloat($("#roleLimit2").val());
	$("#divPageNameList").html("");
	$(".clearfix .click").each(function(){
			
			$("#divPageNameList").append($(this).attr("pageName")+", ");
			divProductPrice=parseFloat(divProductPrice)+parseFloat($(this).attr("pagePrice"));
	})
	var ltext=$("#divPageNameList").text();
	if(ltext.length>0){
		$("#divPageNameList").text(ltext.substr(0,ltext.length-2));
	}else{
		$("#divPageNameList").text("无");
	}
	var shouldPay=0;
	if(divProductPrice-roleLimit>0){
		shouldPay = divProductPrice-roleLimit;
	}
	if(shouldPay>0){
		$("#createOrder").val("确认付款");
	}else{
		$("#createOrder").val("提交预约");
	}
	$("#divProductPrice").text("￥"+parseFloat(divProductPrice).toFixed(2));
	$("#shouldPay2").text("￥"+parseFloat(shouldPay).toFixed(2));
}




//自选套餐的 完全自定义按钮 点击事件
$(".optional-bar li").click(function(){
	var esid=$("#esid").val();
	$(".optional-bar li").removeClass("bar-active");
	$(this).addClass("bar-active");
	if($(this).attr("diyType")=="1"){
		$("#bar-first").show();
		$("#bar-second").hide();
		$("#bar-third").hide();
		$("#productType").val("2");
		getCheckPage();
	}else if($(this).attr("diyType")=="2"){
		if(!$("#bar-second").is(":hidden")){
			return false;
		}
		$("#bar-first").hide();
		$("#bar-second").show();
		$("#bar-third").hide();
		$("#divProductPrice").text("0")
		$("#productType").val("3");
		$("#shouldPay2").text("0");
		getSetMealInfoList(esid,1);
		sumMoney();
	}else if($(this).attr("diyType")=="3"){
		$("#bar-first").hide();
		$("#bar-second").hide();
		$("#bar-third").show();
		$("#divProductPrice").text("0");
		$("#productType").val("4");
		$("#shouldPay2").text("0");
		getSetMealInfoListThird(esid,1);
		sumMoneyThird();
		
	}
})
$(".optional-content .optional-bar-second ul.myPagination li").click(function() {
	$(this).siblings("li").removeClass("pagination-active");
	$(this).addClass("pagination-active")
})

function getSetMealInfoList(esid,page){
	var keyWord=$("#keyWord").val().trim();
	var data;
	if(isNaN(keyWord)){
		data={"esid":esid,"page":page,"keyWord":keyWord};
	}else{
		data={"esid":esid,"page":page,"price":keyWord};
	}
	 $.getJSON("/core/twechat.getSetMealInfoList.do",data ,function(data){   
		 if(data[0].list.length>0){
				var html='<li class="clearfix"><div class="number title">编号</div><div class="content title">体检项目</div><div class="money-sale title">优惠价</div></li>';
				var pageHtml='';
					for(var i=0;i<data[0].list.length;i++){
						html+='<li cid="'+data[0].list[i].ID+'" class="list-content clearfix';
							$("#selectSetMeal").find(".setmeal").each(function(){
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
								$("#myPagination").css("padding-left","5%");
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
					
				$("#setMealPage").html(html);
				$("#myPagination").html(pageHtml);
				
				//完全自定义 单项点击事件
				$(".optional-bar-second .select li.list-content").click(function() {
					var selectSetMeal=$("#selectSetMeal").text();
					var name=$(this).find(".content .content-title").text();
					var id=$(this).attr("cid");
					var money=$(this).find(".money-sale").text().replace("￥","");
					$(".optional-bar-second .select li.list-content .content .introduction").css("white-space","nowrap");
					$(this).find(".content .introduction").css("white-space","normal");
					if($(this).hasClass("list-content-click")){
						$(this).removeClass('list-content-click')
						$("#selectSetMeal").find(".setmeal").each(function(){
							if($(this).attr("sid")==id){
								$(this).remove();
							}
						})
					}else{
						$(this).addClass('list-content-click');
						var shtml='<li class="setmeal" sid="'+id+'" money="'+money+'"><span class="lfsetmeal">'+name +'(￥'+money+')</span><span onclick="delSetmeal('+id+')" class="delbtn">×</span></li> ';
						$("#selectSetMeal").append(shtml);
					}
					
					$("#selectCount").text($("#selectSetMeal").find(".setmeal").length+"项");
					$("#selectSetMeal .setmeal .lfsetmeal").each(function(){
						var text=$(this).text();
						if(text.length>10){
							$(this).text(text.substr(0,10)+"...");
						}
					})
					sumMoney();
					
				})
				
				//点击页数
				$("#myPagination li a").click(function(){
					var page=$(this).parent().attr("num");
					if($(this).hasClass("pagination-active")){
						return false;
					}
					getSetMealInfoList(esid,parseInt(page))
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

function sumMoney(){
	var price=0;
	$("#selectSetMeal").find(".setmeal").each(function(){
		price=parseFloat(price)+parseFloat($(this).attr("money"));
	})
	$("#divProductPrice").text("￥"+parseFloat(price).toFixed(2));
	
	var roleLimit2=$("#roleLimit2").val();
	if(parseFloat(price) > parseFloat(roleLimit2)){
		$("#shouldPay2").text("￥"+(parseFloat(price) - parseFloat(roleLimit2)).toFixed(2));
		$("#createOrder").val("确认付款");
	}else{
		$("#shouldPay2").text("0");
		$("#createOrder").val("提交预约");
	}
	
}

function delSetmeal(id){
	$("#selectSetMeal").find(".setmeal").each(function(){
		if($(this).attr("sid")==id){
			$(this).remove();
		}
	})
	$(".optional-bar-second .select li.list-content").each(function(){
		if($(this).attr("cid")==id){
			$(this).removeClass("list-content-click");
		}
	})
	$("#selectCount").text($("#selectSetMeal").find(".setmeal").length+"项");
	sumMoney();
}



