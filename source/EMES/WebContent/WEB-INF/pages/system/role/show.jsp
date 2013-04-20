<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色信息</title>
</head>
<body>
	<table width="100%" class="table table-striped table-bordered table-condensed">
		<tbody>
			<tr>
				<th class="span3"><label for="code" class="pull-right">角色名称:</label></th>
				<td>${voModel.code}</td>
			</tr>
			<tr>
				<th class="span3"><label for="name" class="pull-right">角色权限:</label></th>
				<td>${voModel.name}</td>
			</tr>
			<tr>
				<th class="span3"><label for="status" class="pull-right">角色状态:</label></th>
				<td>${voModel.status }</td>
			</tr>
		</tbody>
	</table>

	<div class="form-actions">
		<input id="cancel" class="btn" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
</body>
</html>