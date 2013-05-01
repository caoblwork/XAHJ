<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理平台</title>
<link href="<c:url value="/staticResource/styles/login.css"/>" rel="stylesheet">
</head>
<body class="login">
	<div id="container">
		<div id="main">
			<div class="loginbox">
				<form method="post" action="<c:url value='j_spring_security_check'/>">
					<dl>
						<dt>用户名:</dt>
						<dd>
							<input type="text" class="textbox" value="caobl" id="j_username" name="j_username" />
						</dd>
					</dl>
					<dl>
						<dt>密 码:</dt>
						<dd>
							<input type="password" class="textbox" value="123456" id="j_password" name="j_password" />
						</dd>
					</dl>
					<dl>
						<dt>验证码:</dt>
						<dd>
							<input name="textfield2" type="text" class="codebox" id="textfield2" /> <span class="codeimg"> <img src="staticResource/images/code.gif"
								width="180" height="50" />
							</span>
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input name="saveBtn" type="submit" class="login_button" value="登 录" />
						</dd>
					</dl>
				</form>
			</div>
		</div>
		<div id="footer">
			<div class="copyright">Copyright &copy;2013 陕西省环境保护执法局版权所有</div>
		</div>
		<div class="bodyBottomBg"></div>
	</div>
</body>
</html>