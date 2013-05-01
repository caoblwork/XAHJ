<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>新增任务</title>
<jsp:include page="/components/jquery-validation/1.9.0/validate.jsp" flush="false" />
<script type="text/javascript">
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#第一个输入框的ID").focus();
		// 输入验证
		$("#addForm").validate({
			rules : {
			/*
			在此加入验证代码
			 */
			},
			messages : {
			/*
			在此加入验证消息
			 */
			}
		});
	});
</script>
</head>
<body>
	<div id="fullcontent">
		<form:form id="form" modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
			<form:hidden path="version" value="0" />
			<form:hidden id="id" path="id" />
			<table width="100%" class="tableEditMore">
				<tbody>
					<tr>
						<th class="leftLabel"><label for="psCode"><font class="highlight">*</font>企业编码:</label></th>
						<td class="leftField"><form:input path="psCode" type="text" class="span8" maxlength="20" /> <form:errors path="psCode" /></td>
					</tr>

					<tr>
						<th class="leftLabel"><label for="psName"><font class="highlight">*</font>企业名称:</label></th>
						<td class="leftField"><form:input path="psName" type="text" class="span8" maxlength="25" /> <form:errors path="psName" /></td>
					</tr>

					<tr>
						<th class="leftLabel"><label for="regionName"><font class="highlight">*</font>行政区划:</label></th>
						<td class="leftField"><form:input path="regionName" type="text" class="span8" maxlength="13" /> <form:errors path="regionName" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="psType"><font class="highlight">*</font>企业类型:</label></th>
						<td class="leftField"><form:input path="psType" type="text" class="span8" maxlength="11" /> <form:errors path="psType" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="monitorLevel"><font class="highlight">*</font>监测级别:</label></th>
						<td class="leftField"><form:input path="monitorLevel" type="text" class="span8" maxlength="12" /> <form:errors path="monitorLevel" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="psaddress"><font class="highlight">*</font>企业地址:</label></th>
						<td class="leftField"><form:input path="psaddress" type="text" class="span8" maxlength="12" /> <form:errors path="psaddress" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="corporation"><font class="highlight">*</font>企业法人:</label></th>
						<td class="leftField"><form:input path="corporation" type="text" class="span8" maxlength="12" /> <form:errors path="corporation" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="linkman"><font class="highlight">*</font>联系人:</label></th>
						<td class="leftField"><form:input path="linkman" type="text" class="span8" maxlength="12" /> <form:errors path="linkman" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="tel"><font class="highlight">*</font>电话:</label></th>
						<td class="leftField"><form:input path="tel" type="text" class="span8" maxlength="12" /> <form:errors path="tel" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="monitorType"><font class="highlight">*</font>监测类别:</label></th>
						<td class="leftField"><form:input path="monitorType" type="text" class="span8" maxlength="12" /> <form:errors path="monitorType" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="isOnlineEnter"><font class="highlight">*</font>是否在线监控:</label></th>
						<td class="leftField"><form:input path="isOnlineEnter" type="text" class="span8" maxlength="12" /> <form:errors path="isOnlineEnter" /></td>
					</tr>
				</tbody>
			</table>
			<div class="btnArea">
				<input id="submit" class="button" type="submit" value="提交" /> <input id="cancel" class="button" type="button" value="返回"
					onclick="javascript:history.back();" />
			</div>
		</form:form>
	</div>
	<div class="clear"></div>
</body>
</html>