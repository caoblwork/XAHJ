<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查看汉字业务名</title>
</head>
<body>
<div id="sidebar">
	<hgf:VerticalSingleLevelNavigation rootCode="修改成实际的菜单的根编号"/>
</div>
<div id="content">
	<table width="100%" class="tableEditMore">
		<tbody>
			<tr>
				<th colspan="2" class="tabcaption">汉字业务名</th>
			</tr>
			<tr>
				<th class="leftLabel">simpleReason</th>
				<td class="leftField">${voModel.simpleReason}</td>
			</tr>
			<tr>
				<th class="leftLabel">caseId</th>
				<td class="leftField">${voModel.caseId}</td>
			</tr>
			<tr>
				<th class="leftLabel">partyName</th>
				<td class="leftField">${voModel.partyName}</td>
			</tr>
			<tr>
				<th class="leftLabel">partyAddress</th>
				<td class="leftField">${voModel.partyAddress}</td>
			</tr>
			<tr>
				<th class="leftLabel">partyLegalPerson</th>
				<td class="leftField">${voModel.partyLegalPerson}</td>
			</tr>
			<tr>
				<th class="leftLabel">partyDuty</th>
				<td class="leftField">${voModel.partyDuty}</td>
			</tr>
			<tr>
				<th class="leftLabel">partyPhone</th>
				<td class="leftField">${voModel.partyPhone}</td>
			</tr>
			<tr>
				<th class="leftLabel">partyPostcode</th>
				<td class="leftField">${voModel.partyPostcode}</td>
			</tr>
			<tr>
				<th class="leftLabel">pid</th>
				<td class="leftField">${voModel.pid}</td>
			</tr>
			<tr>
				<th class="leftLabel">launcherId</th>
				<td class="leftField">${voModel.launcherId}</td>
			</tr>
			<tr>
				<th class="leftLabel">deployId</th>
				<td class="leftField">${voModel.deployId}</td>
			</tr>
			
		</tbody>
	</table>
	<div class="btnArea">
		<input id="cancel" class="button" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
</div>
<div class="clear"></div>
</body>
</html>
