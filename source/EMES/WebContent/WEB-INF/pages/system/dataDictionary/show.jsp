<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据字典信息展示</title>
</head>
<body>
	<table width="100%" class="table table-striped table-bordered table-condensed">
		<tbody>
			<tr>
				<th class="span3"><label for="type" class="pull-right">字典类型:</label></th>
				<td>${voModel.type }</td>
			</tr>
			<tr>
				<th class="span3"><label for="key" class="pull-right">字典键:</label></th>
				<td>${voModel.key }</td>
			</tr>
			<tr>
				<th class="span3"><label for="value" class="pull-right">字典值:</label></th>
				<td>${voModel.value }</td>
			</tr>
		</tbody>
	</table>

	<div class="form-actions">
		<input id="cancel" class="btn" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
</body>
</html>