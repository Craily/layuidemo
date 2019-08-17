layui.use(['jquery', 'element'], function() {
	var $ = layui.$;
	var element = layui.element;
	
	/***u698关闭按钮样式设置****/
	$('.u698').click(function(e){
		$('.u698_menu').slideToggle();
		e.stopPropagation();
	});
	
	$('.u698_menu').mouseout(function(e){
		var s = e.toElement || e.relatedTarget;
		if(!this.contains(s)){
			$(this).slideUp();
		}
	});
	
	//点击其他地区收起展开
	$(document).click(function(e){
		if($('.u698_menu').is(':visible')){
			$('.u698_menu').slideUp();
		}
	});
	
	$('.u698_menu img:eq(0)').hover(function(){
		$(this).attr('src', '../images/工勤宝管理系统/退出系统_u730_mouseOver.png');
	}, function(){
		$(this).attr('src', '../images/工勤宝管理系统/退出系统_u730.png');
	});
	
	$('.u698_menu img:eq(1)').hover(function(){
		$(this).attr('src', '../images/工勤宝管理系统/密码修改_u732_mouseOver.png');
	}, function(){
		$(this).attr('src', '../images/工勤宝管理系统/密码修改_u732.png');
	});
	/***u698关闭按钮样式设置****/
	
	var viewName = $('#viewName').val();
	$('#' + viewName).parent().addClass('layui-this');
	$('#' + viewName).parents('li').addClass('layui-nav-itemed');
	
	//只展开一个菜单
	element.on('nav(nav-tree)', function(elem){
		$(elem).parent().siblings().removeClass('layui-nav-itemed');
		
	});
	
});
