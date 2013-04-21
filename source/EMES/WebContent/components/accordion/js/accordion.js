$(document).ready(function() {
	// 一级菜单
	var accordion_head = $('.accordion-nav-ul-master > li > a');
	// 二级菜单
	var	accordion_body = $('.accordion-nav-ul-master li > .accordion-subnav-ul');
	// 打当前选中的菜单
	var accordion_head_current = $(".active");
	accordion_head_current.each(function(){
		$(this).next().slideDown('fast');
	});
	// 一级菜单点击后的处理
	accordion_head.on('click', function(event) {
		var classValue = $(this).attr('class');
		// Disable header links
		event.preventDefault();
		if(classValue == undefined) {
			classValue = "";
		}
		// 如果菜单没有激活,则激该菜单
		if (classValue.indexOf('active') < 0){
			//accordion_body.slideUp('slow');
			$(this).next().stop(true,true).slideToggle('fast');
			//accordion_head.removeClass('active');
			$(this).addClass('active');
			$(this).parent().addClass('accordion-master-li-current');
		} else {
			// 如果已经激活则隐藏该菜单
			$(this).removeClass('active');
			$(this).parent().removeClass('accordion-master-li-current');
			$(this).next().stop(true,true).slideToggle('fast');
		}
	});
});