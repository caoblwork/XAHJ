<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作日志信息</title>
</head>
<body>
	    <table width="100%"  style=" word-break: break-all;;  word-wrap: break-word"   class="table table-striped table-bordered table-condensed">
	        <tbody>
	            <tr>
	                <th ><label for="name" class="pull-right">日志名称:</label></th>
	                <td >
	                	${voModel.name }
	                </td>
	            </tr>
	            <tr>
	                <th ><label for="taskName"  class="pull-right">任务名称:</label></th>
	           		<td >
	                	${voModel.taskName }
	                </td>
	            </tr> 
	             <tr>
	                <th ><label for="taskStatus"  class="pull-right">任务状态:</label></th>
	           		<td >
	                	${voModel.taskStatus}
	                </td>
	            </tr> 
	              <tr>
	                <th ><label for="createPerson"  class="pull-right">创建人员:</label></th>
	           		<td >
	                	${voModel.createPerson }
	                </td>
	            </tr>  
	            <tr>
	                <th ><label for="createTime"  class="pull-right">创建日期:</label></th>
	           		<td >
	                <fmt:formatDate value="${voModel.createTime }" pattern="yyyy-MM-dd"/>	
	                </td>
	            </tr>             
	            <tr>	           
	                <th style="width: 15%; height: 80%; text-align: left; word-break: break-all;;  word-wrap: break-word;; border-collapse: collapse" ><label for="content"  class="pull-right">日志内容:</label></th>
	           		<td  style="width: 80%; height: 80%; text-align: left; ">	           		
                      ${voModel.content}                                        	           		   
	                </td>
	            </tr>
	        </tbody>
	    </table>
	    <div class="form-actions">
	        <input id="cancel" class="btn" type="button" value="返回" onclick="javascript:history.back();" />
	    </div>
</body>
</html>