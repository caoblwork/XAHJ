<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
	<table width="100%" class="table table-striped table-bordered table-condensed">
		<tbody>
			<tr>
				<th width="20%"><label for="organizationName" class="pull-right">所属部门:</label></th>
				<td width="80%">${voModel.organizationName }</td>
			</tr>
			<tr>
				<th ><label for="account" class="pull-right">用户帐户:</label></th>
				<td>${voModel.loginId }</td>
			</tr>
			<tr>
				<th ><label for="name" class="pull-right">用户姓名:</label></th>
				<td>${voModel.name }</td>
			</tr>
			<tr>
				<th ><label for="sex" class="pull-right">用户性别:</label></th>
				<td><hangu:DataDicLabel dataType="sex" dataKey="${voModel.sex}" /></td>
			</tr>

			<tr>
				<th class="span3"><label for="phone" class="pull-right">固定电话:</label></th>
				<td>${voModel.phone }</td>
			</tr>
			<tr>
				<th class="span3"><label for="mobileNumber" class="pull-right">移动电话:</label></th>
				<td>${voModel.mobileNumber }</td>
			</tr>
		</tbody>
	</table>

	<div class="form-actions">
		<input id="cancel" class="btn" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
</body>
</html>