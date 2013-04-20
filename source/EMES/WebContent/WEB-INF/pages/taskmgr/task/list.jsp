<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/staticResource/scripts/PageList.js"/>"
	type="text/javascript"></script>
<title>任务列表</title>
<script type="text/javascript">
	var pageList = new $.PageList();
	var parameter = {
		// 全选checkbox的id
		selectAllId : 'chkAll',
		// 列表中行选择的checkbox的名称
		rowCheckboxName : 'rowCheckBox',
		// 模块URL
		moduleUrl : '${ctx}/taskmgr/task',
		//单个删除还是批量删除都走这个URL
		deletePageUrl : '${ctx}/taskmgr/task/remove.do'
	};
	pageList.init(parameter);
	// 单行删除
	function deleteBtn(id) {
		var form = $("#controlForm");
		var confirm = function(v, h, f) {
			if (v == 'ok') {
				form.attr("action", '${ctx}/taskmgr/task/delete.do?id=' + id)
						.submit();
				return true;
			} else if (v == 'cancel') {
				return true;
			}
			return true;
		};
		$.jBox.confirm("确定要删除吗？", "提示", confirm, {
			top : '35%'
		});
	}
</script>
</head>
<body>
	<form id="controlForm" action="" method="post">
		<input type="hidden" id="selectedItemIds" name="ids" />
	</form>

	<form:form id="searchForm" modelAttribute="taskSearchCondition"
		class="well form-inline" action="${ctx}/taskmgr/task/list.do"
		method="post">
		<form:hidden id="pageNumber" path="pageNumber" />
		<form:hidden id="pageSize" path="pageSize" />
		<span> <label for="status">任务状态：</label> <form:input
				path="status" id="status" class="span3" maxlength="100"
				placeholder="用户编号" />
		</span>

		<span> <label for="name">任务名称：</label> <form:input path="name"
				id="name" class="span3" maxlength="100" placeholder="任务名称" />
		</span>
		<span> 	
		<input type="submit" class="btn" value="查询" />
		</span>
	</form:form>


	<div class="well well-small">
		<input type="button" class="btn" value="删除"
			onclick="pageList.gotoDeletePage();" />
	</div>
	<table width="100%"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th class="checkType"><input type="checkbox" name="checkbox"
					id="chkAll" value="off" onclick="pageList.selectAll()" /></th>
				<th class="serialnoType">序       列</th>
				<th>所属项目</th>
				<th>任务名称</th>
				<th>所属机构</th>
				<th>任务状态</th>
				<th>操        作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageObject.result}" var="record" varStatus="c">
				<tr>
					<td class="alignCenter" align="center"><input type="checkbox"
						name="rowCheckBox" align="middle" id="chk${c.count}"
						value="${record.id}" /></td>
					<td class="alignCenter" align="center">${c.count}</td>
					<td class="alignCenter" align="center">${record.projectName}</td>
					<td class="alignCenter" align="center"><c:choose>
							<c:when test="${fn:length(record.name)>12}">
                       ${fn:substring(record.name,0,12)}.....
                     </c:when>
							<c:otherwise>
                      ${record.name}                     
                     </c:otherwise>
						</c:choose></td>
						
					<td class="alignCenter" align="center">${record.organizationName}</td>
					<td class="alignCenter" align="center">${record.status}</td>
					<td class="alignCenter" align="center">
						<div class="toolIcoArea">
							<a href="show.do?id=${record.id}" title="查看"><i
								class="icon-info-sign"></i></a> <a href="edit.do?id=${record.id}"
								title="编辑"><i class="icon-pencil"></i></a> <a
								href='<c:url value="/taskmgr/journal/add.do?id=${record.id}"/>'
								title="添加日志"><i class="icon-plus"></i></a> <a
								href="remove.do?id=${record.id}" title="删除"><i
								class="icon-minus-sign"></i></a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hangu:PagingNavigation />
</body>
</html>