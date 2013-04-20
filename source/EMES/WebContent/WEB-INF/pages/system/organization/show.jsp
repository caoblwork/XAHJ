<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门信息展示</title>
</head>
<body>
	    <table width="100%" style="word-wrap:break-word;table-layout:fixed;word-break:break-all" class="table table-striped table-bordered table-condensed">
	        <tbody>
	            <tr>
	                <th width="20%"><label for="name" class="pull-right">部门名称:</label></th>
	                <td width="80%">
	                	${voModel.name }
	                </td>
	            </tr>
	            <tr>
	                <th ><label for="description"  class="pull-right">部门描述:</label></th>
	           		<td >
	                	${voModel.description }
	                </td>
	            </tr>
	            <tr>
	                <th ><label for="content"  class="pull-right">创建时间:</label></th>
	           		<td >
	                	<fmt:formatDate value="${voModel.createDate}" pattern="yyyy-MM-dd hh:mm" />
					</td>
	            </tr>
	            
	        </tbody>
	    </table>

	    <div class="form-actions">
	        <input id="cancel" class="btn" type="button" value="返回" onclick="javascript:history.back();" />
	    </div>
</body>
</html>