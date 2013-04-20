<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
</head>
<body>
	<form method="post" action="<c:url value='j_spring_security_check'/>" class="well form-horizontal">

		<div class="control-group">
			<label class="control-label" for="j_username">用户名:</label>
			<div class="controls">
				<input type="text" id='j_username' name='j_username' class="span3" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="j_password">密码:</label>
			<div class="controls">
				<input type="password" id='j_password' name='j_password' class="span3" />
			</div>
		</div>

		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="登录" class="btn btn-primary">
		</div>

	</form>
</body>
</html>