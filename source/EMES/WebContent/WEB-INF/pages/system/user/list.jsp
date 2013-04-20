<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/staticResource/scripts/PageList.js"/>"
	type="text/javascript"></script>
<title>用户管理</title>
<script type="text/javascript">
	var pageList = new $.PageList();
	var parameter = {
		// 全选checkbox的id
		selectAllId : 'chkAll',
		// 列表中行选择的checkbox的名称
		rowCheckboxName : 'rowCheckBox',
		// 模块URL
		moduleUrl : '${ctx}/system/user',
		//单个删除还是批量删除都走这个URL
		deletePageUrl : '${ctx}/system/user/remove.do'
	};
	pageList.init(parameter);
	// 单行删除
	function deleteBtn(id) {
		var form = $("#controlForm");
		var confirm = function(v, h, f) {
			if (v == 'ok') {
				form.attr("action", '${ctx}/system/user/delete.do?id=' + id)
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

	<form:form id="searchForm" class="well form-inline"
		modelAttribute="userSearchCondition"
		action="${ctx}/system/user/list.do" method="post">
		<form:hidden id="pageNumber" path="pageNumber" />
		<form:hidden id="pageSize" path="pageSize" />
		<span> <label for="loginId">用户账户：</label> <form:input
				path="loginId" type="text" id="loginId" class="span3"
				maxlength="12" placeholder="用户账户" />
		</span>
		<span> <label for="name">用户姓名：</label> <form:input path="name"
				type="text" id="name" class="span3" maxlength="12"
				placeholder="用户名称" />
		</span>
		<span> <input type="submit" class="btn" value="查询" />
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
				<th class="serialnoType">序 列</th>
				<th>所属部门</th>
				<th>用户账号</th>
				<th>用户姓名</th>
				<th>操 作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageObject.result}" var="record" varStatus="c">
				<tr>
					<td class="alignCenter"><input type="checkbox"
						name="rowCheckBox" align="middle" id="chk${c.count}"
						value="${record.id}" /></td>
					<td class="alignCenter" align="center">${c.count}</td>
					<td class="alignCenter" align="center">${record.organizationName}</td>
					<td class="alignCenter" align="center">${record.loginId}</td>
					<td class="alignCenter" align="center">${record.name}</td>
					<td class="alignCenter" align="center">
						<div class="toolIcoArea">
							<a href="show.do?id=${record.id}" title="查看"><i
								class="icon-info-sign"></i></a> <a href="edit.do?id=${record.id}"
								title="编辑"><i class="icon-pencil"></i></a> <a
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