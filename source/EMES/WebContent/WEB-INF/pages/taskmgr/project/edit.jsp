<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改项目</title>
</head>

<body>
<script type="text/javascript">
//处理operatorManger和customerManger多选
function callbackMultHandlerOrganUser(name, id) {
	return false;
}

//处理operatorManger和customerManger单选
function callbackHandlerOrganUser(name,id,index){
	if('0'==index){
		$("#operatorManger").val(name);
		$("#operatorMangerId").val(id);
	}else if('1'==index){
		$('#customerManger').val(name);
		$('#customerMangerId').val(id);
	}else if('2'==index){
		$('#manger').val(name);
		$('#mangerId').val(id);
	}
}

//operatorManger,customerManger“清除功能”
function cleanOrganUserData(v, h, f){
	var id = $('.jbox-body').eq(0).attr('id');  
	if("jbox1" == id){
        $("#operatorManger").val('');
        $("#operatorMangerId").val('');
	}else if('jbox2' == id){
	    $('#customerManger').val('');
    	$('#customerMangerId').val('');
	}else if('jbox3' == id){
	    $('#manger').val('');
    	$('#mangerId').val('');
	}
}
		
  $(document).ready(function() {
	$("#dp1,#dp2,#dp3").datepicker();
	$("#form").Validation();
  });
</script>
	<form:form id="form" modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
		<form:hidden path="id" />
		 	<div class="control-group">
			<label class="control-label" for="name">项目名称:</label>
            <div class="controls">
				<form:input path="name"   maxlength="24"/>
				<form:errors  path="name"/>
			</div>
		   </div>
		   <div class="control-group">
			<label class="control-label" for="projectCode">项目编码:</label>
            <div class="controls">
				<form:input path="projectCode" check-type="char" required-message="项目编码应为英文名!"  maxlength="48"/>
				<form:errors  path="projectCode"/>
			</div>
		   </div>
		    	
		 <div class="control-group">
					<div class="control-label">项目负责人:</div>
					<div class="controls">
						<div class="input-append date" id="tc">
							<form:input path="manger"  readonly='true' type="text" id="manger"
								check-type="required"  required-message="项目负责人不能为空!,请选择!"  placeholder="点击选择项目负责人"  />
								 <form:hidden path="mangerId" id="mangerId"/>
							<span class="add-on"><i class="icon-th"
								onClick="$.jBox.open('iframe:<c:url value="/global/loadOrganUsers.do?selectParent=false&user=true&index=2"/>', '请单击选择负责人', 400, 400, {id:'jbox3',iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i></span>						 	 						
						</div>										
					</div>						
				</div>
		   
		   
		 <div class="control-group">
					<div class="control-label">运营商负责人:</div>
					<div class="controls">
						<div class="input-append date" id="tc">
							<form:input  readonly='true' path="operatorManger" value="${voModel.operatorManger}" type="text" id="operatorManger"
							 check-type="required"  required-message="运营商负责人不能为空，请选择!" 	placeholder="点击选择运营商负责人" /> <form:hidden path="operatorMangerId" id="operatorMangerId"/>
							<span class="add-on"><i class="icon-th"
								onclick="$.jBox.open('iframe:<c:url value="/global/loadLinkManGroup.do?group=true&index=0"/>', '请单击选择负责人', 400, 400, {id:'jbox1',iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i></span>
						</div>
					</div>
					<form:errors path="operatorManger" />
				</div>					
			 <div class="control-group">
					<div class="control-label">客户侧负责人:</div>
					<div class="controls">
						<div class="input-append date" id="tc">
							<form:input path="customerManger" readonly='true' value="${voModel.customerManger}" type="text" id="customerManger"
							  check-type="required"  required-message="客户侧负责人不能为空，请选择!" 	placeholder="点击选择客户侧负责人" /> <form:hidden path="customerMangerId" id="customerMangerId"/>
							<span class="add-on"><i class="icon-th"
								onclick="$.jBox.open('iframe:<c:url value="/global/loadLinkManGroup.do?group=true&index=1"/>', '请单击选择负责人', 400, 400, {id:'jbox2',iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i></span>
						</div>
					</div>
						<form:errors path="customerManger" />
				</div>				
		 <div class="control-group">
		    <span>
				<div class="control-group">
					<div class="control-label">项目稼动:</div>
					<div class="controls">
						<hangu:DataDicSelect  path="projectDynamic" type="projectDynamic"  required="true" />
					</div>
				</div>
			</span> 
		   </div>	
		    <div class="control-group">
		    <span>
				<div class="control-group">
					<div class="control-label">项目阶段:</div>
					<div class="controls">
						<hangu:DataDicSelect  path="stage" type="stage"  required="true" />
					</div>
				</div>
			</span> 
		   </div>	
		   <div class="control-group">
		    <span>
				<div class="control-group">
					<div class="control-label">项目状态:</div>
					<div class="controls">
						<hangu:DataDicSelect  path="projectStatus" type="projectStatus"  required="true" />
					</div>
				</div>
			</span> 
		   </div>	
		   <div class="control-group">
		    <span>
				<div class="control-group">
					<div class="control-label">项目类型:</div>
					<div class="controls">
						<hangu:DataDicSelect  path="projectType" type="projectType"  required="true" />
					</div>
				</div>
			</span> 
		   </div>	
		   <div class="control-group">
			<span>
				<div class="control-group">
					<div class="control-label">项目启动时间:</div>
					<div class="controls">
						<div class="input-append date" id="dp1"
							data-date-format="yyyy-mm-dd">
							<form:input path="projectStartTime"  type="text"
								readonly='true' />							
							<span class="add-on"><i class="icon-calendar"> </i></span>
								
						</div>
					</div>
				</div>
			</span>
			<form:errors  path="projectStartTime"/>
		</div>					
		<div class="control-group">
			<span>
				<div class="control-group">
					<div class="control-label">项目结束时间:</div>
					<div class="controls">
						<div class="input-append date" id="dp2"
							data-date-format="yyyy-mm-dd">
							<form:input path="projectCloseTime"  type="text"
								readonly='true' />									
							<span class="add-on"><i class="icon-calendar"> </i></span>
							
						</div>
					</div>
				</div>
			</span>
			<form:errors  path="projectCloseTime"/>
		</div>
			<div class="control-group">
			<label class="control-label" for="createPerson">修改人员:</label>
            <div class="controls">
				<form:input path="createPerson" maxlength="12"/>
				<form:errors path="createPerson" />
			</div>
		   </div>		   
		   <div class="control-group">
			<span>
				<div class="control-group">
					<div class="control-label">修改日期:</div>
					<div class="controls">
						<div class="input-append date" id="dp3"
							data-date-format="yyyy-mm-dd">
							<form:input path="createTime"  type="text"
								readonly='true' />
							<span class="add-on"><i class="icon-calendar"> </i></span>
						</div>
					</div>
				</div>
			</span>
			<form:errors path="createTime" />
		</div>		   				
			<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存" class="btn btn-primary">
			<a class="btn" href="${ctx}/taskmgr/project/list.do" >返回</a>
		   </div>		  			
	</form:form>
</body>
</html>