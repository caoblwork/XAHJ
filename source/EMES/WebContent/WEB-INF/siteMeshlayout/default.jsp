<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="application" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title><decorator:title default="陕西环境执法局系统 " /></title>

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

		<div class="row-fluid show-grid">
			<div class="span3">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">系统管理</a>
					</div>
					<div id="collapseOne" class="accordion-body collapse in">
						<div class="accordion-inner">
							<ul class="nav nav-tabs nav-stacked">
								<li class="active"><a href="<c:url value="/system/dataDictionary/list.do"/>">数据字典</a></li>
								<li><a href="<c:url value="/system/role/list.do"/>">角色管理</a></li>
								<li><a href="<c:url value="/system/user/list.do"/>">用户管理</a></li>
								<li><a href="<c:url value="/system/model/list.do"/>">模块管理</a></li>
								<li><a href="<c:url value="/system/resource/list.do"/>">资源管理</a></li>
								<li><a href="<c:url value="/system/organization/list.do"/>">组织机构管理</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">业务菜单</a>
					</div>
					<div id="collapseTwo" class="accordion-body collapse">
						<div class="accordion-inner">
							<ul class="nav nav-tabs nav-stacked">
							    <li><a href="<c:url value="/workflow/deployManager/list.do"/>">流程管理</a></li>
								<li><a href="<c:url value="/taskmgr/task/list.do"/>">任务管理</a></li>		
							    <li><a href="<c:url value="/taskmgr/journal/list.do"/>">待办任务列表</a></li>
							</ul>
						</div>
					</div>
				</div>
				
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#collapseThree">数据中心维护</a>
					</div>
					<div id="collapseThree" class="accordion-body collapse">
						<div class="accordion-inner">
							<ul class="nav nav-tabs nav-stacked">
								<li><a href="<c:url value="/taskmgr/task/list.do"/>">数据源管理</a></li>		
							    <li><a href="<c:url value="/taskmgr/journal/list.do"/>">数据适配管理</a></li>
							</ul>
						</div>
					</div>
				</div>
				
			</div>
			<div class="span7">
				<ul class="breadcrumb">
					<li><a href="#">首页</a> <span class="divider">/</span></li>
					<li><a href="#">库</a> <span class="divider">/</span></li>
					<li class="active">数据</li>
				</ul>
				<decorator:body />
			</div>
		</div>

	</div>
	<%@ include file="/WEB-INF/siteMeshlayout/footer.jsp"%>
</body>
</html>