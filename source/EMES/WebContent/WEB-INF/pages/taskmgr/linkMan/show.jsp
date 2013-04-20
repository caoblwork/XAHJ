<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员组信息展示</title>
</head>
<body>
	    <table width="100%" class="table table-striped table-bordered table-condensed">
	        <tbody>
	            <tr>
	                <th width="20%"><label for="name" class="pull-right">联系人名称:</label></th>
	                <td width="80%">
	                	${voModel.name }
	                </td>
	            </tr>
	            <tr>
	                <th ><label for="cellPhone"  class="pull-right">移动电话:</label></th>
	           		<td >
	                	${voModel.cellPhone }
	                </td>
	            </tr>
	            <tr>
	                <th ><label for="teleNumber"  class="pull-right">固定电话:</label></th>
	           		<td >
	                	${voModel.teleNumber }
	                </td>
	            </tr>
	            <tr>
	                <th ><label for="qqNumber"  class="pull-right">QQ号码:</label></th>
	           		<td >
	                	${voModel.qqNumber }
	                </td>
	            </tr>
	            <tr>
	                <th ><label for="eMail"  class="pull-right">电子信箱:</label></th>
	           		<td >
	                	${voModel.eMail }
	                </td>
	            </tr>
	            
	        </tbody>
	    </table>

	    <div class="form-actions">
	        <input id="cancel" class="btn" type="button" value="返回" onclick="javascript:history.back();" />
	    </div>
</body>
</html>