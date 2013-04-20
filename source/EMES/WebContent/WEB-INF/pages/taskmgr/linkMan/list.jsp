<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/staticResource/scripts/PageList.js"/>"
	type="text/javascript"></script>
<title>联系人管理</title>
<script type="text/javascript">
	var pageList = new $.PageList();
	var parameter = {
		// 全选checkbox的id
		selectAllId : 'chkAll',
		// 列表中行选择的checkbox的名称
		rowCheckboxName : 'rowCheckBox',
		// 模块URL
		moduleUrl : '${ctx}/taskmgr/linkMan',
		//单个删除还是批量删除都走这个URL
		deletePageUrl : '${ctx}/taskmgr/linkMan/remove.do'
	};
	pageList.init(parameter);
	// 单行删除
	function deleteBtn(id) {
		var form = $("#controlForm");
		var confirm = function(v, h, f) {
			if (v == 'ok') {
				form.attr("action",
						'${ctx}/taskmgr/linkManGroup/delete.do?id=' + id)
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

	<form:form class="well form-inline" id="searchForm"
		modelAttribute="linkManSearchCondition"
		action="${ctx}/taskmgr/linkMan/list.do" method="post">
		<form:hidden id="pageNumber" path="pageNumber" />
		<form:hidden id="pageSize" path="pageSize" />
		<span> <label for="name">人员名称：</label> <form:input path="name"
				id="name" type="text" Class="span3" maxlength="12"
				placeholder="人员名称" />
		</span>
		<span> <label for="cellPhone">手机号码：</label> <form:input
				path="cellPhone" id="cellPhone" type="text" Class="span3"
				maxlength="11" placeholder="手机号码" />
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
				<th class="serialnoType">序列</th>
				<th>人员名称</th>
				<th>手机号码</th>
				<th>电子邮箱</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageObject.result}" var="record" varStatus="c">
				<tr>
					<td class="alignCenter"><input type="checkbox"
						name="rowCheckBox" id="chk${c.count}" value="${record.id}" /></td>
					<td class="alignCenter">${c.count}</td>
					<td class="alignCenter">${record.name}</td>
					<td class="alignCenter">${record.cellPhone}</td>
					<td class="alignCenter"><c:choose>
							<c:when test="${fn:length(record.eMail)>12}">
                    			${fn:substring(record.eMail,0,12)}……
                    		</c:when>
							<c:otherwise>
                    			${record.eMail}
                    		</c:otherwise>
						</c:choose></td>
					<td class="alignCenter">
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