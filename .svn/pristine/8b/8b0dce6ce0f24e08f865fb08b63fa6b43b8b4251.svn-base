$(".tc-cont-left").click(function() {
	$(".tc-cont-left").removeClass('tc-active').addClass('tc-active')
	$(".tc-cont-right").removeClass('tc-active')
	$(".tjxm-zxtc").removeClass('tjxm-show').addClass('tjxm-hide')
	$(".tjxm-gdtc").removeClass('tjxm-hide').addClass('tjxm-show')
	$("#tcType").text("固定套餐")
	$("#zxtcPrice").text("0 RMB");
	$("#shouldPay").text("0 RMB");
	$("#gdtcPrice").text( $("#gdtcPriceInput").val() + " RMB");
	$("#productType").val("1");
	
	$(".allCheck").prop('checked',false);
	$(".childCheck").prop('checked',false);
})
$(".tc-cont-right").click(function() {
	$(".tc-cont-right").removeClass('tc-active').addClass('tc-active')
	$(".tc-cont-left").removeClass('tc-active')
	$(".tjxm-gdtc").removeClass('tjxm-show').addClass('tjxm-hide')
	$(".tjxm-zxtc").removeClass('tjxm-hide').addClass('tjxm-show')
	$("#tcType").text("自选套餐")
	$("#shouldPay").text("0 RMB");
	$("#zxtcPrice").text( $("#zxtcPriceInput").val() + " RMB");
	$("#gdtcPrice").text("0 RMB");
	$("#productType").val("2");
})
$(".btn-zln").click(function(){
	$(".zlntc").show()
	$(".xxgtc").hide()
})
$(".btn-xug").click(function(){
	$(".xxgtc").show()
	$(".zlntc").hide()
})
$(".diy-btn").click(function(){
	$(".zxtc-cont").hide();
	$(".tcpage"+$(this).attr("data")).show();
	var sort=0;
	$(".tcpage"+$(this).attr("data")).find(".details-check").each(function(){
		if(sort%2!=0){
			$(this).addClass("bg-f1");
		}else{
			$(this).removeClass("bg-f1");
		}
		sort++;
	})

})
	
$(".allCheck").click(function(){
	var n=$(this).attr("name");
	if($(this).is(':checked')){
		$("input[name='"+n+"']").prop('checked',true);
		
	}else{
		$("input[name='"+n+"']").prop('checked',false);
	}
	
	$(".zxtc-cont").hide();
	$(".tcpage"+$(this).attr("data")).show();
	var sort=0;
	$(".tcpage"+$(this).attr("data")).find(".details-check").each(function(){
		if(sort%2!=0){
			$(this).addClass("bg-f1");
		}else{
			$(this).removeClass("bg-f1");
		}
		sort++;
	})
	
	var priceCount=parseInt($("#zxtcPriceInput").val());
	$(".allCheck").each(function(){
		if($(this).is(':checked')){
			priceCount+=parseInt($(this).attr("packagePrice"));
		}
	})
	changePrice(priceCount);
})


function changePrice(diyPrice){
	$("#zxtcPrice").text( diyPrice + " RMB");
	if(diyPrice - $("#myMoneyInput").val()>0){
		$("#shouldPay").text(diyPrice -$("#myMoneyInput").val() +" RMB");
	}else{
		$("#shouldPay").text("0 RMB");
	}
}