<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程部署管理</title>
</head>

<body>
	<form:form modelAttribute="voModel" action="${ctx}/workflow/deployManager/saveDeployInfo.do" method="post" enctype="multipart/form-data" class="well form-horizontal">
		
		<form:hidden path="version" value="0"/>
		
		<div class="control-group">
			<label class="control-label" for="cnName">中文名称:</label>
            <div class="controls">
				<form:input path="cnName" />
				<form:errors path="cnName"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="enName">英文名称:</label>
            <div class="controls">	
				<form:input path="enName" />
				<form:errors path="enName"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="actFile">流程文件:</label>
            <div class="controls">	
				<input type="file" id="actFile" name="actFile" size="20" class="required" /> 
				<form:errors path="filePath" cssClass="error" />
			</div>
		</div>
		
		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存" class="btn btn-primary">
			<input id="cancel" class="btn" type="button" value="返回" onclick='javascript:history.back();' />
		</div>
			
	</form:form>
</body>
</html>