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
	<div id="sidebar"></div>
	<div id="content">
		<form:form id="addForm" modelAttribute="voModel" action="${ctx}/emes/caseInfo/save.do" method="post">
			<form:hidden id="id" path="id" />
			<table width="100%" class="tableEditMore">
				<tbody>
					<tr>
						<th class="leftLabel"><label for="simpleReason"><font class="highlight">*</font>simpleReason:</label></th>
						<td class="leftField"><input type="text" id="simpleReason" name="simpleReason" maxlength="20" class="textbox" />
						<form:errors path="simpleReason" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="caseId"><font class="highlight">*</font>caseId:</label></th>
						<td class="leftField"><input type="text" id="caseId" name="caseId" maxlength="20" class="textbox" />
						<form:errors path="caseId" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="partyName"><font class="highlight">*</font>partyName:</label></th>
						<td class="leftField"><input type="text" id="partyName" name="partyName" maxlength="20" class="textbox" />
						<form:errors path="partyName" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="partyAddress"><font class="highlight">*</font>partyAddress:</label></th>
						<td class="leftField"><input type="text" id="partyAddress" name="partyAddress" maxlength="20" class="textbox" />
						<form:errors path="partyAddress" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="partyLegalPerson"><font class="highlight">*</font>partyLegalPerson:</label></th>
						<td class="leftField"><input type="text" id="partyLegalPerson" name="partyLegalPerson" maxlength="20" class="textbox" />
						<form:errors path="partyLegalPerson" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="partyDuty"><font class="highlight">*</font>partyDuty:</label></th>
						<td class="leftField"><input type="text" id="partyDuty" name="partyDuty" maxlength="20" class="textbox" />
						<form:errors path="partyDuty" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="partyPhone"><font class="highlight">*</font>partyPhone:</label></th>
						<td class="leftField"><input type="text" id="partyPhone" name="partyPhone" maxlength="20" class="textbox" />
						<form:errors path="partyPhone" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="partyPostcode"><font class="highlight">*</font>partyPostcode:</label></th>
						<td class="leftField"><input type="text" id="partyPostcode" name="partyPostcode" maxlength="20" class="textbox" />
						<form:errors path="partyPostcode" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="pid"><font class="highlight">*</font>pid:</label></th>
						<td class="leftField"><input type="text" id="pid" name="pid" maxlength="20" class="textbox" />
						<form:errors path="pid" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="launcherId"><font class="highlight">*</font>launcherId:</label></th>
						<td class="leftField"><input type="text" id="launcherId" name="launcherId" maxlength="20" class="textbox" />
						<form:errors path="launcherId" cssClass="error" /></td>
					</tr>
					<tr>
						<th class="leftLabel"><label for="deployId"><font class="highlight">*</font>deployId:</label></th>
						<td class="leftField"><input type="text" id="deployId" name="deployId" maxlength="20" class="textbox" />
						<form:errors path="deployId" cssClass="error" /></td>
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
