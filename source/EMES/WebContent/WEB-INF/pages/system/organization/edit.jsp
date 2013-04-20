<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">

<title>修改部门信息</title>
</head>
<body>

    <form:form id="form" modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
	
		<form:hidden path="id"/>
		
		<div class="control-group">
			<label class="control-label" for="name">部门名称:</label>
			<div class="controls">
				<form:input path="name" type="text" class="span8" maxlength="12" />
				<form:errors path="name" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="description">部门描述:</label>
			<div class="controls">
				<form:textarea path="description" maxlength="200" placeholder="部门描述"/>
			</div>
		</div>

		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存" class="btn btn-primary">
			<a class="btn" href="${ctx}/system/organization/list.do" >返回</a>
		</div>
	</form:form>
	


</body>
</html>