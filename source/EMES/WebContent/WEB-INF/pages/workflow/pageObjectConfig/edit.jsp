<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>编辑汉字业务名</title>
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
<div id="sidebar">
	
</div><div id="content">
<form:form id="editForm"  modelAttribute="voModel" action="${ctx}/workflow/pageObjectConfig/save.do" method="post">
	<form:hidden id="id" path="id" />
	<form:hidden id="version" path="version" />
	<table width="100%" class="tableEditMore">
		<tbody>
			<tr>
				<th class="leftLabel"><label for="formKey"><font class="highlight">*</font>表单对象关系键:</label></th>
				<td class="leftField"><input type="text" id="formKey" name="formKey" maxlength="40" class="textbox" value="${voModel.formKey}"/><form:errors path="formKey" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="objectKey"><font class="highlight">*</font>对象键:</label></th>
				<td class="leftField"><input type="text" id="objectKey" name="objectKey" maxlength="40" class="textbox" value="${voModel.objectKey}"/><form:errors path="objectKey" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="pageKey"><font class="highlight">*</font>表单键:</label></th>
				<td class="leftField"><input type="text" id="pageKey" name="pageKey" maxlength="40" class="textbox" value="${voModel.pageKey}"/><form:errors path="pageKey" cssClass="error"/></td>
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
