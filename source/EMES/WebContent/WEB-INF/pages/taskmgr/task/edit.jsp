<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改任务</title>
</head>
<body>
	<script type="text/javascript">
		//处理单选，如果只涉及多选就请删除此段代码
		function callbackHandlerOrganUser(name, id) {
			$('#organizationName').val(name);
			$('#organizationId').val(id);
		}
		//“清除功能”
		function cleanOrganUserData(v, h, f) {
			if (v == 0) {
				$('#organizationName').val('');
				$('#organizationId').val('');
			}
		}
		$(document).ready(function() {
			$("#dp2").datepicker();
			$("#form").validation();
		});
	</script>
	<form:form modelAttribute="voModel" method="post" action="save.do"
		class=" well form-horizontal">
		<form:hidden path="id" />
		<div class="control-group">
			<label class="control-label" for="projectName">项目名称:</label>
			<div class="controls">
				<form:input path="projectName" maxlength="24" readonly="true" />
				<form:hidden path="projectId" id="projectId" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="organizationName">下发机构:</label>
			<div class="controls">
				<div class="input-append date" id="tc">
					<form:input path="organizationName" readonly='true' type="text"
						id='organizationName' value="${voModel.organizationName}"
						check-type="required" required-message="下发机构不能为空!"
						placeholder="点击选择所属部门" />
					<form:hidden path="organizationId" id="organizationId" />
					<span class="add-on"><i class="icon-th"
						onclick="$.jBox.open('iframe:${ctx}/global/loadOrganUsers.do?user=false', '请单击选择所属部门', 400, 400, {iframeScrolling: 'no', buttons: {'清空': 0, '关闭': true},submit:cleanOrganUserData } )"></i></span>
				</div>

			</div>
			<form:errors path="organizationName" />
		</div>
		<div class="control-group">
			<label class="control-label" for="status">任务状态:</label>
			<div class="controls">
				<form:input path="status" check-type="required number"
					number-message="任务状态须为0~100增加的整数!" />
				<form:errors path="status" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">任务名称:</label>
			<div class="controls">
				<form:input path="name" check-type="required "
					required-message="任务名称不能为空!" maxlength="24" />
				<form:errors path="name" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="createPerson">修改人员:</label>
			<div class="controls">
				<form:input path="createPerson" maxlength="24" />
				<form:errors path="createPerson" />
			</div>
		</div>
		<div class="control-group">
			<span>
				<div class="control-group">
					<div class="control-label">修改日期:</div>
					<div class="controls">
						<div class="input-append date" id="dp2"
							data-date-format="yyyy-mm-dd">
							<form:input path="createTime" type="text" readonly='true' />
							<span class="add-on"><i class="icon-calendar"> </i></span>
						</div>
					</div>
				</div>
			</span>
			<form:errors path="createTime" />
		</div>
		<div class="control-group">
			<label class="control-label" for="description">任务描述:</label>
			<div class="controls">
				<form:textarea path="description" maxlength="200"
					style="width:320px;height:130px" />
				<form:errors path="description" />
			</div>
		</div>

		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存"
				class="btn btn-primary"> <a class="btn"
				href="${ctx}/taskmgr/task/list.do">返回</a>
		</div>
	</form:form>

</body>
</html>