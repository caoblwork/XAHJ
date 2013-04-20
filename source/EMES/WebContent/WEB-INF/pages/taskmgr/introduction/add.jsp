<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加项目说明</title>
</head>

<body> 
	<form:form modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
			<form:hidden path="id"/>
			<form:hidden path="projectId" value="${projectId}"/>
		 	<div class="control-group">
			<label class="control-label" for="emphasis">工作重点:</label>
            <div class="controls">				
				<form:textarea path="emphasis" cssStyle="width:250px;height:90px" cols="3" rows="5"/>
			    <form:errors path="emphasis" />
			</div>
		   </div>		   		   
			<div class="control-group">
			<label class="control-label" for="projectProgress">项目进展情况:</label>
            <div class="controls">	
            <form:textarea path="projectProgress"  cssStyle="width:300px;height:150px" cols="10" rows="8"/>				
			 <form:errors path="projectProgress" />
			</div>
		</div>		
		 <div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存" class="btn btn-primary">
			<a class="btn" href="${ctx}/taskmgr/introduction/list.do?projectId=${projectId}" >返回</a>
		</div>	
	</form:form>
</body>
</html>