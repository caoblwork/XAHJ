<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="application" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title><decorator:title default="任务管理系统" /></title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon" href="<c:url value="/components/bootstrap/ico/favicon.ico"/>">
<script src="<c:url value="/components/bootstrap/js/jquery.js"/>"></script>
<script src="<c:url value="/components/jQuery/jquery.extend.js"/>"></script>


<%@ include file="/components/jBox/jBox.jsp"%>

<!-- Le styles -->
<link href="<c:url value="/components/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/components/bootstrap/css/bootstrap-responsive.css"/>" rel="stylesheet">
<link href="<c:url value="/components/bootstrap/css/bootstrap-datepicker.css"/>" rel="stylesheet">
<link href="<c:url value="/staticResource/styles/defaultTpl.css"/>" rel="stylesheet">
<link href="<c:url value="/staticResource/styles/default.css"/>" rel="stylesheet">

<%@ include file="/components/bootstrap/bootstrap.jsp"%>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<!--[endif]-->

<decorator:head />

</head>

<body data-spy="scroll">

	<%@ include file="/WEB-INF/siteMeshlayout/header.jsp"%>
	<div class="container">
		<decorator:body />
	</div>
	<%@ include file="/WEB-INF/siteMeshlayout/footer.jsp"%>
</body>
</html>