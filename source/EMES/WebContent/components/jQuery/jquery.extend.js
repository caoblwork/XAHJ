/**
 * 提供了对jquery的扩展
 */
(function($){

    /**
     * 支持多浏览器的返回前页方法
     */
	$.backHistory = function() {
		if($.browser.msie) {  
		  history.back();  
		} else if($.browser.safari) {  
			var referurl;
			referurl=document.referrer;
			window.location.href=referurl;
		} else if($.browser.mozilla) {  
		  	history.back();
		} else if($.browser.opera) {  
		  	history.back();
		} else {  
		  	history.back();
		}  
	},
    /**
     * 判断字符串是否为空
     */
	$.isNull = function(string) {
		var testString = $.trim(string);
		if(null == string || '' == string) {
			return true;
		}
		return false;
	}
})(jQuery);
