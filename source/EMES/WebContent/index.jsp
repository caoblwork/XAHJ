<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>框架导航页面</title>
</head>
<body>
	
	<ul>bootStrap
		<li><a href="test.jsp">test</a></li>
		<li><a href="layout.jsp">bootStrap布局</a></li>
	</ul>
	<ul>
		<li><a href="${ctx}/workflow/deployManager/list.do">流程部署管理</a></li>
		<li><a href="${ctx}/workflow/deployManager/list.do">流程部署管理</a></li>
		<li><a href="${ctx}/eme/psBaseInfo/list.do">企业信息</a></li>
	</ul>
</body>
</html>