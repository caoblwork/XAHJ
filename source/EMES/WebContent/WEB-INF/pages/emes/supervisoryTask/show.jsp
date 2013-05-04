<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查看汉字业务名</title>
</head>
<body>

	<div id="sidebar">
		<div class="accordion-nav-div">
			<ul class=" accordion-nav-ul-master">
				<li class=" accordion-nav-li-master accordion-master-li-current"><a href="#" class=" active"><span>流程管理</span></a>
					<ul class=" accordion-subnav-ul">
						<li class=" accordion-subnav-li-current"><a href="<c:url value="/workflow/deployManager/list.do"/>"><span>流程管理</span></a></li>
					</ul></li>
				<li class=" accordion-nav-li-master"><a href="#"><span>任务列表</span></a>
					<ul class=" accordion-subnav-ul">
						<li><a href="<c:url value="/emes/supervisoryTask/add.do"/>"><span>任务发布</span></a></li>
						<li><a href="<c:url value="/emes/supervisoryTask/list.do"/>"><span>任务列表</span></a></li>
					</ul></li>
			</ul>
		</div>
	</div>

	<div id="content">
		<table width="100%" class="tableEditMore">
			<tbody>
				<tr>
					<th class="leftLabel">任务名称:</th>
					<td class="leftField">${voModel.name}</td>
				</tr>
				<tr>
					<th class="leftLabel">任务类型:</th>
					<td class="leftField">${voModel.type}</td>
				</tr>
				<tr>
					<th class="leftLabel">污染源:</th>
					<td class="leftField">${voModel.pollutantSourceId}</td>
				</tr>
				<tr>
					<th class="leftLabel">检测项目:</th>
					<td class="leftField">${voModel.monitorItem}</td>
				</tr>
				<tr>
					<th class="leftLabel">进度:</th>
					<td class="leftField">${voModel.progress}</td>
				</tr>
				<tr>
					<th class="leftLabel">任务下达人:</th>
					<td class="leftField">${voModel.creator}</td>
				</tr>
				<tr>
					<th class="leftLabel">任务执行人:</th>
					<td class="leftField">${voModel.executor}</td>
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
