<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/staticResource/scripts/PageList.js"/>" type="text/javascript"></script>
<title>项目说明列表</title>
<script type="text/javascript">
	var pageList = new $.PageList();
	var parameter = {
		// 全选checkbox的id
		selectAllId : 'chkAll',
		// 列表中行选择的checkbox的名称
		rowCheckboxName : 'rowCheckBox',
		// 模块URL
		moduleUrl : '${ctx}/workflow/deployManager',
		//单个删除还是批量删除都走这个URL
		deletePageUrl : '${ctx}/workflow/deployManager/remove.do'
	};
	pageList.init(parameter);
	// 单行删除
	function deleteBtn(id) {
		var form = $("#controlForm");
		var confirm = function(v, h, f) {
			if (v == 'ok') {
				form.attr("action", '${ctx}/workflow/deployManager/delete.do?id=' + id).submit();
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

		<form id="controlForm" action="" method="post">
			<input type="hidden" id="selectedItemIds" name="ids" />
		</form>

		<div class="search">
			<form:form id="searchForm" modelAttribute="deployManagerSearchCondition" action="${ctx}/workflow/deployManager/list.do" method="post">
				<form:hidden id="pageNumber" path="pageNumber" />
				<form:hidden id="pageSize" path="pageSize" />

				<span> <label for="enName">英文姓名：</label> <form:input path="enName" class="span3" maxlength="48" placeholder="英文姓名" />
				</span>
				<span> <label for="cnName">中文名称：</label> <form:input path="cnName" class="span3" maxlength="48" placeholder="中文名称" />
				</span>

				<span><input type="submit" class="button" value="查询" /></span>

			</form:form>
		</div>

		<div class="tool">
			<input type="button" class="button" value="新增" onclick="pageList.gotoAddPage();" /> <input type="button" class="button" value="删除"
				onclick="pageList.gotoDeletePage();" />
		</div>
		
		<c:if test="${not empty message}">
			<div id="message" class="success">${message}</div>
		</c:if>
		<table width="100%" class="tableUI">
			<thead>
				<tr>
					<th class="checkType"><input type="checkbox" name="checkbox" id="chkAll" value="off" onclick="pageList.selectAll()" /></th>
					<th class="serialnoType">序 列</th>
					<th>中文名称</th>
					<th>英文名称</th>
					<th>流程状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageObject.result}" var="record" varStatus="c">
					<tr>
						<td class="alignCenter"><input type="checkbox" name="rowCheckBox" id="chk${c.count}" value="${record.id}" /></td>
						<td class="alignCenter" align="center">${c.count}</td>

						<td class="alignCenter">${record.cnName}</td>
						<td class="alignCenter">${record.enName}</td>
						<td class="alignCenter">${record.status}</td>

						<td class="alignCenter" align="center">
							<c:choose>
								<c:when test="${record.status==1}">
									<a href="#">已部署</a>
								</c:when>
								<c:otherwise>
									<a href="deploy.do?id=${record.id}">部署</a>
								</c:otherwise>
							</c:choose> 
							
							<a href="remove.do?id=${record.id}" title="删除"><i class="icon-minus-sign"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hangu:PagingNavigation />
	</div>
	<div style="display: none">
		<input id="messageDisplay" type="text" value="" />
	</div>
	<div class="clear"></div>

</body>
</html>