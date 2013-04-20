<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
	
</script>
<script src="<c:url value="/staticResource/scripts/PageList.js"/>"
	type="text/javascript"></script>
<title>创建资源</title>
</head>
<body>
	<form:form modelAttribute="voModel" method="post" action="save.do"
		class="well form-horizontal">

		<form:hidden path="version" value="0" />

		<div class="control-group">
			<label class="control-label" for="name">资源名称:</label>
			<div class="controls">
				<form:input path="name" typ="text" class="span8"/>
				<form:errors path="name" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="type">资源类型:</label>
			<div class="controls">
				<form:input path="type" type="text" class="span8" />
				<form:errors path="type" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="address">资源地址:</label>
			<div class="controls">
				<form:input path="address" type="text" class="span8"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="status">资源状态:</label>
			<div class="controls">
				<form:input path="status" type="text" class="span8" />
				<form:errors path="status" />
			</div>
		</div>

		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存"
				class="btn btn-primary"> <a class="btn"
				href="${ctx}/system/resource/list.do">返回</a>
		</div>

	</form:form>



</body>
</html>