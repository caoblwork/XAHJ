<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查看详情</title>
</head>
<body>
	<div id="sidebar">
		<div class="accordion-nav-div">
			<ul class=" accordion-nav-ul-master">
				<li class=" accordion-nav-li-master accordion-master-li-current"><a href="#" class=" active"><span>一厂一档管理</span></a>
					<ul class=" accordion-subnav-ul">
						<li class=" accordion-subnav-li-current"><a href="<c:url value="/emes/wryjbxx/list.do"/>"><span>污染源基本信息</span></a></li>
						<li class=" accordion-subnav-li-current"><a href="<c:url value="/emes/wrydaxx/list.do"/>"><span>企业长期存档</span></a></li>
					</ul></li>
			</ul>
		</div>
	</div>

	<div id="content">
		<table width="100%" class="tableEdit">
			<tbody>
				<tr>
					<th class="leftLabel">污染源名称</th>
					<td class="leftField">${voModel.wrybh}</td>
				</tr>
				<tr>
					<th class="leftLabel">档案编号</th>
					<td class="leftField">${voModel.dabh}</td>
				</tr>
				<tr>
					<th class="leftLabel">档案类型</th>
					<td class="leftField">${voModel.dalx}</td>
				</tr>
				<tr>
					<th class="leftLabel">是否有效</th>
					<td class="leftField">${voModel.sfyx}</td>
				</tr>
				<tr>
					<th class="leftLabel">档案名称</th>
					<td class="leftField">${voModel.damc}</td>
				</tr>
				<tr>
					<th class="leftLabel">文件名称</th>
					<td class="leftField">${voModel.wjmc}</td>
				</tr>
				<tr>
					<th class="leftLabel">文件后缀</th>
					<td class="leftField">${voModel.wjhz}</td>
				</tr>
				<tr>
					<th class="leftLabel">存放路径</th>
					<td class="leftField">${voModel.cflj}</td>
				</tr>
				<tr>
					<th class="leftLabel">备注</th>
					<td class="leftField">${voModel.bz}</td>
				</tr>

			</tbody>
		</table>
		<div class="btnArea">
			<input id="cancel" class="button" type="button" value="返回" onclick="javascript:history.back();" />
		</div>
	</div>
	<div class="clear"></div>
</body>
</html>
