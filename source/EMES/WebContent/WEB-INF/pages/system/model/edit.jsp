<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
</script>
<script src="<c:url value="/staticResource/scripts/PageList.js"/>" type="text/javascript"></script>
<title>修改模块信息</title>
</head>
<body>
	
	<form:form modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
	
		<form:hidden path="id"/>
		
		<div class="control-group">
			<label class="control-label" for="name">模块名称:</label>
            <div class="controls">
				<form:input path="name" class="span8" type="text"/>
				<form:errors path="name" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="code">模块编码:</label>
            <div class="controls">	
				<form:input path="code" type="text" class="span8"/>
				<form:errors path="code"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="description">模块描述:</label>
			<div class="controls">
				<form:textarea path="description" id="description" placeholder="模块描述" />
				<form:errors path="description" />
			</div>
		</div>
		
		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存" class="btn btn-primary">
			<a class="btn" href="${ctx}/system/model/list.do" >返回</a>
		</div>
</form:form>
</body>
</html>