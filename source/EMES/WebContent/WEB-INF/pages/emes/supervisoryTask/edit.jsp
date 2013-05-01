<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>编辑汉字业务名</title>
<jsp:include page="/components/jquery-validation/1.9.0/validate.jsp" flush="false" />
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
<div id="sidebar">
	<hgf:VerticalSingleLevelNavigation rootCode="修改成实际的菜单的根编号"/>
</div><div id="content">
<form:form id="editForm"  modelAttribute="voModel" action="${ctx}/app/业务模块名称/supervisoryTask/update.do" method="post">
	<form:hidden id="id" path="id" />
	<form:hidden id="version" path="version" />
	<table width="100%" class="tableEditMore">
		<tbody>
			<tr>
				<th class="leftLabel"><label for="name"><font class="highlight">*</font>name:</label></th>
				<td class="leftField"><input type="text" id="name" name="name" maxlength="20" class="textbox"/><form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="type"><font class="highlight">*</font>type:</label></th>
				<td class="leftField"><input type="text" id="type" name="type" maxlength="20" class="textbox"/><form:errors path="type" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="pollutantSourceId"><font class="highlight">*</font>pollutantSourceId:</label></th>
				<td class="leftField"><input type="text" id="pollutantSourceId" name="pollutantSourceId" maxlength="20" class="textbox"/><form:errors path="pollutantSourceId" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="monitorItem"><font class="highlight">*</font>monitorItem:</label></th>
				<td class="leftField"><input type="text" id="monitorItem" name="monitorItem" maxlength="20" class="textbox"/><form:errors path="monitorItem" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="progress"><font class="highlight">*</font>progress:</label></th>
				<td class="leftField"><input type="text" id="progress" name="progress" maxlength="20" class="textbox"/><form:errors path="progress" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="creator"><font class="highlight">*</font>creator:</label></th>
				<td class="leftField"><input type="text" id="creator" name="creator" maxlength="20" class="textbox"/><form:errors path="creator" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="executor"><font class="highlight">*</font>executor:</label></th>
				<td class="leftField"><input type="text" id="executor" name="executor" maxlength="20" class="textbox"/><form:errors path="executor" cssClass="error"/></td>
			</tr>
		</tbody>
	</table>
	<div class="btnArea">
		<input id="submit" class="button" type="submit" value="提交" />
		<input id="cancel" class="button" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
</form:form>
</div>
<div class="clear"></div>
</body>
</html>
