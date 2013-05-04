<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>编辑汉字业务名</title>
<script>
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#第一个输入框的ID").focus();
		// 输入验证
		$("#addForm").validate({
			rules : {
			/*
			在此加入验证代码
			*/
			},
			messages : {
			/*
			在此加入验证消息
			*/
			}
		});
	});
</script>
</head>
<body>
	<div id="sidebar">
		<div class="accordion-nav-div">
			<ul class=" accordion-nav-ul-master">
				<li class=" accordion-nav-li-master accordion-master-li-current"><a href="#" class=" active"><span>一厂一档管理</span></a>
					<ul class=" accordion-subnav-ul">
						<li class=" accordion-subnav-li-current"><a href="<c:url value="/emes/wryjbxx/list.do"/>"><span>污染源基本信息</span></a></li>
						<li class=" accordion-subnav-li-current"><a href="<c:url value="/emes/wrydaxx/list.do"/>"><span>企业长期存档</span></a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>

	<div id="content">
<form:form id="form" modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
	<form:hidden id="id" path="id" />
	<form:hidden id="version" path="version" />
	<table width="100%" class="tableEdit">
		<tbody>
			<tr>
				<th class="leftLabel"><label for="wrybh"><font class="highlight">*</font>污染源名称:</label></th>
				<td class="leftField"><form:input type="text" path="wrybh" name="wrybh" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="dabh"><font class="highlight">*</font>档案编号:</label></th>
				<td class="leftField"><form:input type="text" path="dabh" name="dabh" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="dalx">档案类型:</label></th>
				<td class="leftField"><form:input type="text" path="dalx" name="dalx" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="sfyx"><font class="highlight">*</font>是否有效:</label></th>
				<td class="leftField"><form:input type="text" path="sfyx" name="sfyx" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="damc"><font class="highlight">*</font>档案名称:</label></th>
				<td class="leftField"><form:input type="text" path="damc" name="damc" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wjmc"><font class="highlight">*</font>文件名称:</label></th>
				<td class="leftField"><form:input type="text" path="wjmc" name="wjmc" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wjhz">文件后缀:</label></th>
				<td class="leftField"><form:input type="text" path="wjhz" name="wjhz" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="cflj">存放路径:</label></th>
				<td class="leftField"><form:input type="text" path="cflj" name="cflj" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="bz">备注:</label></th>
				<td class="leftField"><form:input type="text" path="bz" name="bz" maxlength="20" class="textbox"/></td>
			</tr>
		</tbody>
	</table>
	<div class="btnArea">
		<input id="submit" class="button" type="submit" value="提交" />
		<input id="cancel" class="button" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
</form:form>
</div>
<div class="clear"></div>
</body>
</html>
