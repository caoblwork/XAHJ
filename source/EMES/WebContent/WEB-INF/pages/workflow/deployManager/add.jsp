<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程部署管理</title>
</head>

<body>
	<div id="sidebar">
		<div class="accordion-nav-div">
			<ul class=" accordion-nav-ul-master">
				<li class=" accordion-nav-li-master accordion-master-li-current"><a href="#" class=" active"><span>流程管理</span></a>
					<ul class=" accordion-subnav-ul">
						<li class=" accordion-subnav-li-current"><a href="<c:url value="/workflow/deployManager/list.do"/>"><span>流程管理</span></a></li>
					</ul></li>
				<li class=" accordion-nav-li-master"><a href="#"><span>任务列表</span></a>
					<ul class=" accordion-subnav-ul">
						<li><a href="<c:url value="/emes/supervisoryTask/add.do"/>"><span>任务发布</span></a></li>
						<li><a href="<c:url value="/emes/supervisoryTask/list.do"/>"><span>任务列表</span></a></li>
					</ul></li>
			</ul>
		</div>
	</div>

	<div id="content">

		<form:form id="addForm" modelAttribute="voModel" action="${ctx}/workflow/deployManager/saveDeployInfo.do" method="post" enctype="multipart/form-data">

			<form:hidden path="version" value="0" />

			<table width="100%" class="tableEditMore">
				<tbody>
					<tr>
						<th class="leftLabel"><label for="cnName"><font class="highlight">*</font>中文名称:</label></th>
						<td class="leftField"><form:input path="cnName" maxlength="20" class="textbox" /> <form:errors path="cnName" /></td>
					</tr>

					<tr>
						<th class="leftLabel"><label for="enName"><font class="highlight">*</font>英文名称:</label></th>
						<td class="leftField"><form:input path="enName" maxlength="20" class="textbox" /> <form:errors path="enName" /></td>
					</tr>

					<tr>
						<th class="leftLabel"><label for="actFile"><font class="highlight">*</font>流程文件:</label></th>
						<td class="leftField"><input type="file" id="actFile" name="actFile" size="20" class="required" /> <form:errors path="filePath" cssClass="error" />
						</td>
					</tr>
				</tbody>
			</table>

			<div class="btnArea">
				<input id="submit" class="button" type="submit" value="提交" /> 
				<input id="cancel" class="button" type="button" value="返回" onclick="javascript:history.back();" />
			</div>

		</form:form>
	</div>
</body>
</html>