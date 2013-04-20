<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务信息</title>
</head>
<body>
	<table width="100%"    style=" word-break: break-all;;  word-wrap: break-word" class="table table-striped table-bordered table-condensed">
		<tbody>
			<tr>
				<th width="20%" height="10%" align="left"><label for="projectCode" class="pull-right">项目编码:</label></th>
				<td width="80%" height="10%">${voModel.projectCode}</td>
			</tr>
			<tr>
				<th><label for="projectName" class="pull-right">所属项目:</label></th>
				<td>${voModel.projectName}</td>
			</tr>
			<tr>
				<th><label for="organizationName" class="pull-right">所属机构:</label></th>
				<td>${voModel.organizationName}</td>
			</tr>
			<tr>
				<th><label for="name" class="pull-right">任务名称:</label></th>
				<td>${voModel.name }</td>
			</tr>
			<tr>
				<th><label for="status" class="pull-right">任务状态:</label></th>
				<td>${voModel.status}</td>
			</tr>
			<tr>
				<th><label for="projectStartTime" class="pull-right">项目开始时间:</label></th>
				<td><fmt:formatDate value="${voModel.projectStartTime}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<th><label for="projectCloseTime" class="pull-right">项目结束时间:</label></th>
				<td><fmt:formatDate value="${voModel.projectCloseTime}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
           
           
           <tr>
				<th style="width: 10%; height: 80%; text-align: left; word-break: break-all;;  word-wrap: break-word;; border-collapse: collapse" ><label for="emphasis" class="pull-right">任务描述:</label></th>		
				 <td  style="width: 80%; height: 80%; text-align: left; ">                  	
                   ${voModel.description}                    	
                  </td>   
			</tr>
		</tbody>
	</table>
	<div class="form-actions">
		<input id="cancel" class="btn" type="button" value="返回"
			onclick="javascript:history.back();" />
	</div>
</body>
</html>