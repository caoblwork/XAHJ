<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/staticResource/scripts/PageList.js"/>"
	type="text/javascript"></script>
<title>项目列表</title>
<script type="text/javascript">
	var pageList = new $.PageList();
	var parameter = {
		// 全选checkbox的id
		selectAllId : 'chkAll',
		// 列表中行选择的checkbox的名称
		rowCheckboxName : 'rowCheckBox',
		// 模块URL
		moduleUrl : '${ctx}/taskmgr/project',
		//单个删除还是批量删除都走这个URL
		deletePageUrl : '${ctx}/taskmgr/project/remove.do'
	};
	pageList.init(parameter);
	// 单行删除
	function deleteBtn(id) {
		var form = $("#controlForm");
		var confirm = function(v, h, f) {
			if (v == 'ok') {
				form.attr("action",'${ctx}/taskmgr/project/delete.do?id=' + id).submit();
				return true;
			} else if (v == 'cancel') {
				return true;
			}
			return true;
		};
		$.jBox.confirm("确定要删除吗？", "提示", confirm, {top : '35%'});
	}
</script>
</head>
<body>

	<form id="controlForm" action="" method="post">
		<input type="hidden" id="selectedItemIds" name="ids" />
	</form>
	<form:form id="searchForm" modelAttribute="projectSearchCondition"
		class="well form-inline" action="${ctx}/taskmgr/project/list.do"
		method="post">
		<form:hidden id="pageNumber" path="pageNumber" />
		<form:hidden id="pageSize" path="pageSize" />
		<span> <label for="name">项目名称：</label> <form:input path="name"
				id="name" class="span3" maxlength="48" placeholder="项目名称" />
		</span>
		<span> <label class="control-label" for="projectCode">项目类型：</label>
			<hangu:DataDicSelect path="projectType" class="span3"
				type="projectType" required="false" />
		</span>
		<br />
		<span> <label class="control-label" for="projectCode">项目编码：</label>
			<form:input path="projectCode" id="projectCode" class="span3"
				maxlength="48" placeholder="项目编码" />
		</span>
		<span> <label class="control-label" for="projectDynamic">项目稼动：</label>
			<hangu:DataDicSelect path="projectDynamic" class="span3"
				type="projectDynamic" required="false" />
		</span>
		<br />
		<span> <label class="control-label" for="stage">项目阶段：</label> <hangu:DataDicSelect
				path="stage" class="span3" type="stage" required="false" />
		</span>
		<span> <label class="control-label" for="projectStatus">项目状态：</label>
			<hangu:DataDicSelect path="projectStatus" class="span3"
				type="projectStatus" required="false" />
		</span>				
		<span> 			
			<input type="submit" class="btn" value="查询" />
		</span>
	</form:form>
	<div class="well well-small">
		<input type="button" class="btn" value="新增"
			onclick="pageList.gotoAddPage();" /> <input type="button"
			class="btn" value="删除" onclick="pageList.gotoDeletePage();" />
	</div>
	<table width="100%"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th class="checkType"><input type="checkbox" name="checkbox"
					id="chkAll" value="off" onclick="pageList.selectAll()" /></th>
				<th class="serialnoType">序       列</th>
				<th>项目名称</th>
				<th>项目编码</th>
				<th>项目负责人</th>
				<th>项目状态</th>
				<th>操       作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageObject.result}" var="record" varStatus="c">
				<tr>
					<td class="alignCenter"><input type="checkbox"
						name="rowCheckBox" id="chk${c.count}" value="${record.id}" /></td>
					<td class="alignCenter" align="center">${c.count}</td>

					<td class="alignCenter"><c:choose>
							<c:when test="${fn:length(record.name)>10}">
                    			${fn:substring(record.name,0,10)}……
                    		</c:when>
							<c:otherwise>
                    			${record.name}
                    		</c:otherwise>
						</c:choose></td>
					<td class="alignCenter" align="center">${record.projectCode}</td>
					<td class="alignCenter" align="center">${record.manger}</td>
					<td class="alignCenter" align="center"><hangu:DataDicLabel
							dataType="projectStatus" dataKey="${record.projectStatus}" /></td>
					<td class="alignCenter" align="center"><a
						href="show.do?id=${record.id}" title="查看"><i
							class="icon-info-sign"></i></a> <a href="edit.do?id=${record.id}"
						title="编辑"><i class="icon-pencil"></i></a> <a
						href="<c:url value="/taskmgr/task/add.do?id=${record.id}"/>"
						title="下发任务"><i class="icon-plus"></i></a> <a
						href="<c:url value="/taskmgr/introduction/add.do?id=${record.id}"/>"
						title="添加项目说明"><i class="icon-plus-sign"></i></a> <a
						href="<c:url value="/taskmgr/introduction/list.do?projectId=${record.id}"/>"
						title="项目说明列表"><i class="icon-list-alt"></i></a> <a
						href="remove.do?id=${record.id}" title="删除"><i
							class="icon-minus-sign"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hangu:PagingNavigation />
</body>
</html>