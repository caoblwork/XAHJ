<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>创建联系人组</title>
</head>
<body>

    
    <form:form id="form" modelAttribute="voModel" method="post" action="save.do"
		class="well form-horizontal">

		<form:hidden path="version" value="0" />

		<div class="control-group">
			<label class="control-label" for="name">联系人员组名称:</label>
			<div class="controls">
				<form:input path="name" type="text" class="span8" maxlength="12" />
				<form:errors path="name" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="description">联系人组描述:</label>
			<div class="controls">
				<form:textarea path="description" maxlength="200" placeholder="联系人组描述"></form:textarea>
			</div>
		</div>

		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存"
				class="btn btn-primary"> <a class="btn"
				href="${ctx}/taskmgr/linkManGroup/list.do">返回</a>
		</div>

	</form:form>

	


</body>
</html>