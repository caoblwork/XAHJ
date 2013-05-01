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
<form:form id="addForm" modelAttribute="voModel" action="${ctx}/system/dataDictionary/save.do" method="post">
	<form:hidden id="id" path="id" />
	<table width="100%" class="tableEditMore">
		<tbody>
			<tr>
				<th class="leftLabel"><label for="type"><font class="highlight">*</font>类型:</label></th>
				<td class="leftField"><input type="text" id="type" name="type" maxlength="20" class="textbox"/><form:errors path="type" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="key"><font class="highlight">*</font>键:</label></th>
				<td class="leftField"><input type="text" id="key" name="key" maxlength="20" class="textbox"/><form:errors path="key" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="value"><font class="highlight">*</font>值:</label></th>
				<td class="leftField"><input type="text" id="value" name="value" maxlength="20" class="textbox"/><form:errors path="value" cssClass="error"/></td>
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
