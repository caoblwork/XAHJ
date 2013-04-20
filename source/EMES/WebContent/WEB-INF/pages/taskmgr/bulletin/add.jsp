<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>发布公告</title>
</head>
<body>
	<script type="text/javascript">
		//处理多选，如果只涉及单选就请删除此段代码
		function callbackMultHandlerOrganUser(name, id) {
			var namesVal = $("#jbox-iframe")[0].contentWindow.mergerStr(name,
					$('#userNames').val());
			var idsVal = $("#jbox-iframe")[0].contentWindow.mergerStr(id, $(
					'#userId').val());
			$('#userNames').val(namesVal);
			$('#userId').val(idsVal);

		}
		//处理单选，如果只涉及多选就请删除此段代码
		function callbackHandlerOrganUser(name, id) {
			$('#userNames').val(name);
			$('#userId').val(id);
		}
		//“清除功能”
		function cleanOrganUserData(v, h, f) {
			if (v == 0) {
				$('#userNames').val('');
				$('#userId').val('');
			}
		}
		$(document).ready(function() {
			$('#form').validation();
		});
	</script>

	<form:form id="form" modelAttribute="voModel" method="post"
		action="save.do" class="well form-horizontal">

		<form:hidden path="version" value="0" />

		<div class="control-group">
			<label class="control-label" for="title">公告标题:</label>
			<div class="controls">
				<form:input path="title" type="text" class="span8" maxlength="12" />
				<form:errors path="title" />
			</div>
		</div>

		<div class="control-group">
			<div class="control-label">选择用户:</div>
			<div class="controls">
				<form:input type="text" readonly='true' class="span8"
					path="userNames" placeholder="点击选择用户" />
				<form:hidden path="userId" />
				<span class="add-on"><i class="icon-th"
					onclick="$.jBox.open('iframe:${ctx}/global/loadOrganUsers.do?selectParent=false&user=true', '请单击选择用户', 400, 400, {iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i></span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="content">公告内容:</label>
			<div class="controls">
				<form:textarea path="content" maxlength="200" placeholder="公告内容"
					check-type="required " required-message="请输入日志内容!" />
				<form:errors path="content" />
			</div>
		</div>

		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存"
				class="btn btn-primary"> <a class="btn"
				href="${ctx}/taskmgr/bulletin/list.do">返回</a>
		</div>

	</form:form>




</body>
</html>