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
		<form:form id="addForm" modelAttribute="voModel" action="${ctx}/emes/supervisoryTask/save.do" method="post">
			<form:hidden id="id" path="id" />
			<table width="100%" class="tableEditMore">
				<tbody>
					<tr>
						<th class="leftLabel"><label for="name"><font class="highlight">*</font>任务名称:</label></th>
						<td class="leftField"><input type="text" id="name" name="name" maxlength="20" class="textbox" />
						<form:errors path="name" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="type"><font class="highlight">*</font>任务类型:</label></th>
						<td class="leftField"><hangu:DataDicSelect path="type" type="task_type" required="true" /> <form:errors path="type" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="pollutantSourceId"><font class="highlight">*</font>污染源:</label></th>
						<td class="leftField"><input type="text" id="pollutantSourceId" name="pollutantSourceId" maxlength="20" class="textbox" />
						<form:errors path="pollutantSourceId" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="monitorItem"><font class="highlight">*</font>检测项目:</label></th>
						<td class="leftField"><input type="text" id="monitorItem" name="monitorItem" maxlength="20" class="textbox" />
						<form:errors path="monitorItem" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="progress"><font class="highlight">*</font>进度:</label></th>
						<td class="leftField"><input type="text" id="progress" name="progress" maxlength="20" class="textbox" />
						<form:errors path="progress" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="creator"><font class="highlight">*</font>任务下达人:</label></th>
						<td class="leftField"><input type="text" id="creatorName" name="creatorName" maxlength="20" class="textbox" readonly="readonly"
							value="<sec:authentication property="principal.realName" />" /> <input type="hidden" id="creator" name="creator" maxlength="20" class="textbox"
							value="<sec:authentication property="principal.userId" />" /> <form:errors path="creator" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="executor"><font class="highlight">*</font>任务执行人:</label></th>
						<td class="leftField"><input type="text" id="executor" name="executor" maxlength="20" class="textbox" />
						<form:errors path="executor" cssClass="error" /></td>
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
