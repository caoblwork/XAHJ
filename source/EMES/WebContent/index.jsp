<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
request.getRequestDispatcher("/system/dataDictionary/list.do").forward(request,response); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>框架导航页面</title>
</head>
<body>

	<ul>
		<li><a href="${ctx}/workflow/deployManager/list.do">流程部署管理</a></li>
		<li><a href="${ctx}/workflow/deployManager/list.do">流程部署管理</a></li>
		<li><a href="<c:url value="/emes/psBaseInfo/list.do"/>">企业信息</a></li>
		<li><a href="<c:url value="/emes/supervisoryTask//list.do"/>">执法任务</a></li>
	</ul>
</body>
</html>