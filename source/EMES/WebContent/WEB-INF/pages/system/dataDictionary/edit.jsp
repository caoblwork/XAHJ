<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑数据字典</title>
</head>
<body>

	<form:form modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
	
		<form:hidden path="id"/>
		
		<div class="control-group">
			<label class="control-label" for="type">类型:</label>
            <div class="controls">
				<form:input path="type" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="key">键:</label>
            <div class="controls">	
				<form:input path="key" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="value">值:</label>
            <div class="controls">	
				<form:input path="value" />
			</div>
		</div>
		
		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存" class="btn btn-primary">
			<input id="cancel" class="btn" type="button" value="返回" onclick='javascript:history.back();' />
		</div>
	</form:form>

</body>
</html>