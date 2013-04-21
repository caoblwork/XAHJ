<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑企业信息</title>
</head>
<body>
	<script>
		$(document).ready(function() {
			$('#form').validation();
		});
	</script>
	<form:form id="form" modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
		<form:hidden path="id" />
		<form:hidden path="version" value="0" />
		<div class="control-group">
			<label class="control-label" for="psCode"> 企业编码:</label>
			<div class="controls">
				<form:input path="psCode" type="text" class="span8" maxlength="20"  />
				<form:errors path="psCode" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="psName">企业名称:</label>
			<div class="controls">
				<form:input path="psName" type="text" class="span8" maxlength="25"  />
				<form:errors path="psName" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="regionName">行政区划:</label>
			<div class="controls">
				<form:input path="regionName" type="text" class="span8" maxlength="13" />
				<form:errors path="regionName" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="psType">企业类型:</label>
			<div class="controls">
				<form:input path="psType" type="text" class="span8"
					maxlength="11" />
				<form:errors path="psType" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="monitorLevel">监测级别:</label>
			<div class="controls">
				<form:input path="monitorLevel" type="text" class="span8" maxlength="12" />
				<form:errors path="monitorLevel" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="psaddress">企业地址:</label>
			<div class="controls">
				<form:input path="psaddress" type="text" class="span8" maxlength="12"  />
				<form:errors path="psaddress" />
			</div>
		</div>
        <div class="control-group">
			<label class="control-label" for="corporation">企业法人:</label>
			<div class="controls">
				<form:input path="corporation" type="text" class="span8" maxlength="12" />
				<form:errors path="corporation" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="linkman">联系人:</label>
			<div class="controls">
				<form:input path="linkman" type="text" class="span8" maxlength="12" />
				<form:errors path="linkman" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="tel">电话:</label>
			<div class="controls">
				<form:input path="tel" type="text" class="span8" maxlength="12"  />
				<form:errors path="tel" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="monitorType">监测类别:</label>
			<div class="controls">
				<form:input path="monitorType" type="text" class="span8" maxlength="12" />
				<form:errors path="monitorType" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="isOnlineEnter">是否在线监控:</label>
			<div class="controls">
				<form:input path="isOnlineEnter" type="text" class="span8" maxlength="12"  />
				<form:errors path="isOnlineEnter" />
			</div>
		</div>
		<div class="form-actions">
			<input type="submit" id="saveBtn" name="saveBtn" value="保存"
				class="btn btn-primary"> <input id="cancel" class="btn"
				type="button" value="返回" onclick="javascript:history.back();" />
		</div>

	</form:form>
</body>
</html>