(function ($) {
	
	$.getMyJSON = function(url,data,callback){
		$.ajax({
			"url": url,
			"context": this,
			"data": data,
			"type": "post",
			"cache":false,
			"dataType": "json",
			"success": function(html){
				callback.call(this,html);
			}
		});
	};
	
	$.getMyJSON2 = function(url,data,callback){
		$.ajax({
			"async":false, 
			"url": url,
			"context": this,
			"data": data,
			"type": "post",
			"cache":false,
			"dataType": "json",
			"success": function(html){
				callback.call(this,html);
			}
		});
	};
})(jQuery);





