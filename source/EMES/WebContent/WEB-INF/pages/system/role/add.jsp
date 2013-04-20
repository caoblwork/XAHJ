<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/staticResource/scripts/PageList.js"/>" type="text/javascript"></script>
<title>创建角色</title>
</head>
<body>

	<form:form modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
		<form:hidden path="version" value="0" />
		<div class="control-group">
			<label class="control-label" for="code">角色编码:</label>
			<div class="controls">
				<form:input path="code" type="text" class="span8" />
				<form:errors path="code" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="name">角色名称:</label>
			<div class="controls">
				<form:input path="name" type="text" class="span8" />
				<form:errors path="name" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="status">角色状态:</label>
			<div class="controls">
				<form:input path="status" type="text" class="span8" />
				<form:errors path="status" />
			</div>
		</div>

		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存" class="btn btn-primary"> <a class="btn" href="${ctx}/system/role/list.do">返回</a>
		</div>

	</form:form>
</body>
</html>