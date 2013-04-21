<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业信息详情</title>
</head>
<body>
	<table width="100%" class="table table-striped table-bordered table-condensed">
		<tbody>
			<tr>
				<th width="20%"><label for="psCode" class="pull-right">企业编码:</label></th>
				<td width="80%">${voModel.psCode }</td>
			</tr>
			<tr>
				<th ><label for="psName" class="pull-right">企业名称:</label></th>
				<td>${voModel.psName }</td>
			</tr>
			<tr>
				<th ><label for="regionName" class="pull-right">行政区划:</label></th>
				<td>${voModel.regionName }</td>
			</tr>
			<tr>
				<th ><label for="psType" class="pull-right">企业类型:</label></th>
				<td>${voModel.psType}</td>
			</tr>

			<tr>
				<th class="span3"><label for="monitorLevel" class="pull-right">监测级别:</label></th>
				<td>${voModel.monitorLevel }</td>
			</tr>
			<tr>
				<th class="span3"><label for="psaddress" class="pull-right">企业地址:</label></th>
				<td>${voModel.psaddress }</td>
			</tr>
			<tr>
				<th class="span3"><label for="corporation" class="pull-right">企业法人:</label></th>
				<td>${voModel.corporation }</td>
			</tr>
			<tr>
				<th class="span3"><label for="linkman" class="pull-right">联系人:</label></th>
				<td>${voModel.linkman}</td>
			</tr>
			<tr>
				<th class="span3"><label for="tel" class="pull-right">电话:</label></th>
				<td>${voModel.tel }</td>
			</tr>
			<tr>
				<th class="span3"><label for="monitorType" class="pull-right">监测类别:</label></th>
				<td>${voModel.monitorType }</td>
			</tr>
			<tr>
				<th class="span3"><label for="isOnlineEnter" class="pull-right">是否在线监控:</label></th>
				<td>${voModel.isOnlineEnter}</td>
			</tr>
		</tbody>
	</table>

	<div class="form-actions">
		<input id="cancel" class="btn" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
</body>
</html>