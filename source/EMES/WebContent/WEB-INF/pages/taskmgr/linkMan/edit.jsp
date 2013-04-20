<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/staticResource/scripts/PageList.js"/>"
	type="text/javascript"></script>
<title>修改联系人员信息</title>
</head>
<body>
	<script type="text/javascript">
		//处理多选，如果只涉及单选就请删除此段代码
		function callbackMultHandlerOrganUser(name, id) {
			var namesVal = $("#jbox-iframe")[0].contentWindow.mergerStr(name,
					$('#users').val());
			var idsVal = $("#jbox-iframe")[0].contentWindow.mergerStr(id, $(
					'#userId').val());
			$('#users').val(namesVal);
			$('#userId').val(idsVal);

		}
		//处理单选，如果只涉及多选就请删除此段代码
		function callbackHandlerOrganUser(name, id) {
			$('#users').val(name);
			$('#userId').val(id);
		}
		//“清除功能”
		function cleanOrganUserData(v, h, f) {
			if (v == 0) {
				$('#users').val('');
				$('#userId').val('');
			}
		}
		$(document).ready(function() {
			$('#form').validation();
		});
	</script>


	<form:form id="form" modelAttribute="voModel" method="post" action="save.do"
		class="well form-horizontal">

		<form:hidden path="id" />

		<div class="control-group">
			<label class="control-label" for="name">人员名称:</label>
			<div class="controls">
				<form:input path="name" type="text" class="span8" maxlength="12" check-type="required chinese" required-message="名称输入有误!"/>
				<form:errors path="name" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="users">选择人员组:</label>
			<div class="controls">
				<form:input path="groupName" readonly="true" type="text" class="span8" placeholder="点击选择" maxlength="48" check-type="required " required-message="请选择上级组!" />
            	<form:hidden path="linkManGroupId" />
            	<span class="add-on"><i
					class="icon-th"
					onclick="$.jBox.open('iframe:${ctx}/global/loadLinkManGroup.do?group=false', '请单击选择用户', 400, 400, {iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i></span>
			</div>
				<form:errors path="linkManGroupId" />
		</div>

		<div class="control-group">
			<label class="control-label" for="cellPhone">移动电话:</label>
			<div class="controls">
				<form:input path="cellPhone" type="text" maxlength="11" class="span8" />
				<form:errors path="cellPhone" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="teleNumber">固定电话:</label>
			<div class="controls">
				<form:input path="teleNumber" type="text" class="span8" maxlength="13" />
				<form:errors path="teleNumber" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="qqNumber">QQ号码:</label>
			<div class="controls">
				<form:input path="qqNumber" type="text" class="span8" maxlength="10" />
				<form:errors path="qqNumber" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="eMail">电子信箱:</label>
			<div class="controls">
				<form:input path="eMail" type="text" class="span8" maxlength="24" check-type="required mail" required-message="邮箱地址输入有误!"/>
				<form:errors path="eMail" />
			</div>
		</div>
		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存"
				class="btn btn-primary"> <a class="btn"
				href="${ctx}/taskmgr/linkMan/list.do">返回</a>
		</div>
	</form:form>
</body>
</html>