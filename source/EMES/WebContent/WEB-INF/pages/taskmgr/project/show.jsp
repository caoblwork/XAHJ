<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目信息</title>
</head>
<body>
	<table width="100%"   style=" word-break: break-all;;  word-wrap: break-word" class="table table-striped table-bordered table-condensed">
		<tbody>
			<tr>
				<th><label for="name" class="pull-right">项目名称:</label></th>
				<td>${voModel.name }</td>
			</tr>
			<tr>
				<th><label for="projectCode" class="pull-right">项目编码:</label></th>
				<td>${voModel.projectCode }</td>
			</tr>

			<tr>
				<th><label for="projectType" class="pull-right">项目类型:</label></th>
				<td><hangu:DataDicLabel dataType="projectType"
						dataKey="${voModel.projectType}" /></td>
			</tr>
			<tr>
				<th><label for="stage" class="pull-right">项目阶段:</label></th>
				<td><hangu:DataDicLabel dataType="stage"
						dataKey="${voModel.stage}" /></td>
			</tr>
			<tr>
				<th><label for="projectDynamic" class="pull-right">项目稼动:</label></th>
				<td><hangu:DataDicLabel dataType="projectDynamic"
						dataKey="${voModel.projectDynamic}" /></td>
			</tr>
			<tr>
				<th><label for="projectStatus" class="pull-right">项目状态:</label></th>
				<td><hangu:DataDicLabel dataType="projectStatus"
						dataKey="${voModel.projectStatus}" /></td>
			</tr>
			<tr>
				<th><label for="manger" class="pull-right">项目负责人:</label></th>
				<td>${voModel.manger}</td>
			</tr>
			<tr>
				<th><label for="operatorManger" class="pull-right">运营商负责人:</label></th>
				<td>${voModel.operatorManger}</td>
			</tr>
			<tr>
				<th><label for="customerManger" class="pull-right">客户侧负责人:</label></th>
				<td>${voModel.customerManger}</td>
			</tr>  			
			<tr>
				<th><label for="projectStartTime" class="pull-right">项目启动时间:</label></th>
				<td><fmt:formatDate value="${voModel.projectStartTime }"
						pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<th><label for="projectCloseTime" class="pull-right">项目结束时间:</label></th>
				<td><fmt:formatDate value="${voModel.projectCloseTime }"
						pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<th><label for="operatorPhone" class="pull-right">运营商负责人电话:</label></th>
				<td>${voModel.operatorPhone}</td>
			</tr>
			<tr>
				<th width="24%" height="80%" align="left"><label for="customerPhone" class="pull-right">客户侧负责人电话:</label></th>
				<td>${voModel.customerPhone}</td>
			</tr>
			<tr>
				<th style="width: 10%; height: 80%; text-align: left; word-break: break-all;;  word-wrap: break-word;; border-collapse: collapse" ><label for="emphasis" class="pull-right">项目工作重点:</label></th>		
				 <td  style="width: 80%; height: 80%; text-align: left; ">                  	
                   ${voModel.emphasis}                    	
                  </td>   
			</tr>
			<tr>
				<th style="width: 10%; height: 80%; text-align: left; word-break: break-all;;  word-wrap: break-word;; border-collapse: collapse"><label for="projectProgress" class="pull-right">进展情况记录:</label></th>
				<td style="width: 80%; height: 80%; text-align: left; ">                   
                  ${voModel.projectProgress}
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