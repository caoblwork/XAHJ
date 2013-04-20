<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理平台</title>
<link href="<c:url value="/staticResource/styles/login.css"/>"
	rel="stylesheet">
</head>
<body class="login">
	<div id="container">
		<div id="main">
			<div class="loginbox">
				<form method="post"
					action="<c:url value='j_spring_security_check'/>">
					<!--  
		<div class="control-group">
			<label class="control-label" for="j_username">用户名:</label>
			<div class="controls">
				<input type="text" id='j_username' name='j_username' class="span3" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="j_password">密码:</label>
			<div class="controls">
				<input type="password" id='j_password' name='j_password'
					class="span3" />
			</div>
		</div>

		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="登录"
				class="btn btn-primary">
		</div>
-->
					<dl>
						<dt>用户名:</dt>
						<dd>
							<input type="text" class="textbox" value="caobl" id="j_username"
								name="j_username" />
						</dd>
					</dl>
					<dl>
						<dt>密 码:</dt>
						<dd>
							<input type="password" class="textbox" value="123456"
								id="j_password" name="j_password" />
						</dd>
					</dl>
					<dl>
						<dt>验证码:</dt>
						<dd>
							<input name="textfield2" type="text" class="codebox"
								id="textfield2" /> <span class="codeimg"> <img
								src="staticResource/images/code.gif" width="180" height="50" />
							</span>
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input name="saveBtn" type="submit" class="login_button"
								value="登 录" />
						</dd>
					</dl>
				</form>
			</div>
		</div>
		<div id="footer">
			<div class="copyright">XXX管理信息平台 版权所有 &copy; 2013</div>
		</div>
		<div class="bodyBottomBg"></div>
	</div>
</body>
</html>