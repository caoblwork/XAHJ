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
	                <th class="span3"><label for="name" class="pull-right">资源名称:</label></th>
	                <td >
	                	${voModel.name }
	                </td>
	            </tr>
	            <tr>
	                <th class="span3"><label for="type"  class="pull-right">资源类型:</label></th>
	           		<td >
	                	${voModel.type }
	                </td>
	            </tr>
	            <tr>
	                <th class="span3"><label for="address"  class="pull-right">资源地址:</label></th>
	           		<td >
	                	${voModel.address }
	                </td>
	            </tr>
	            <tr>
	                <th class="span3"><label for="status"  class="pull-right">资源状态:</label></th>
	           		<td >
	                	${voModel.status }
	                </td>
	            </tr>
	            <tr>
	                <th class="span3"><label for="createBy" class="pull-right">创建人员:</label></th>
	           		<td >
	                	${voModel.createBy }
	                </td>
	            </tr>
	        </tbody>
	    </table>

	    <div class="form-actions">
	        <input id="cancel" class="btn" type="button" value="返回" onclick="javascript:history.back();" />
	    </div>
</body>
</html>