<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
</head>
<body>
	<script>
		//处理单选，如果只涉及多选就请删除此段代码
		function callbackHandlerOrganUser(name, id) {
			$('#users').val(name);
			$('#userids').val(id);
		}

		//“清除功能”
		function cleanOrganUserData(v, h, f) {
			if (v == 0) {
				$('#users').val('');
				$('#userids').val('');
			}
		}

		$(document).ready(function() {
			$('#form').validation();
		});
	</script>
	<form:form id="form" modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
		<form:hidden path="id" />
		<div class="control-group">
			<div class="control-label">所属部门:</div>
			<div class="controls">
				<input value="${voModel.organizationName}" name="organizationName" type="text" readonly='readonly' class="span8" id="organizationName" placeholder="点击图标选择部门" check-type="required" required-message="请选择部门!">
				<input value="${voModel.organizationId}"   type="hidden" id="organizationId" name="organizationId"> 
				<span class="add-on">
					<i class="icon-th" onclick="$.jBox.open('iframe:${ctx}/global/loadOrganUsers.do?user=false', '请单击选择部门', 400, 400, {iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i>
				</span>
			</div>
			<form:errors path="organizationId" />
		</div>

		<div class="control-group">
			<label class="control-label" for="name"> 用户姓名:</label>
			<div class="controls">
				<form:input path="name" type="text" class="span8" maxlength="12" check-type="required chinese" required-message="名称输入有误!" />
				<form:errors path="name" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="sex">用户性别:</label>
			<div class="controls">
				<hangu:DataDicSelect type="sex" path="sex" class="span8" required="true"/>
				<form:errors path="sex" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="phone">固定电话:</label>
			<div class="controls">
				<form:input path="phone" type="text" class="span8" maxlength="13" />
				<form:errors path="phone" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="mobileNumber">手机号码:</label>
			<div class="controls">
				<form:input path="mobileNumber" type="text" class="span8" maxlength="11" />
				<form:errors path="mobileNumber" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="loginId">用户帐户:</label>
			<div class="controls">
				<form:input path="loginId" type="text" class="span8" maxlength="12" check-type="required char" required-message="帐户输入有误!" />
				<form:errors path="loginId" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="password">初始密码:</label>
			<div class="controls">
				<form:input path="password" type="text" class="span8" maxlength="12" check-type="required " required-message="请输入密码" />
				<form:errors path="password" />
			</div>
		</div>
		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存" class="btn btn-primary"> 
			<input id="cancel" class="btn" type="button" value="返回" onclick="javascript:history.back();" />
		</div>


	</form:form>

</body>
</html>