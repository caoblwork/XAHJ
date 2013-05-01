<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="${ctx}/staticResource/scripts/PageList.js" type="text/javascript"></script>
<title>汉字业务名列表</title>
<script type="text/javascript">
	var pageList = new $.PageList();
	var parameter = {
		// 全选checkbox的id
		selectAllId : 'chkAll',
		// 列表中行选择的checkbox的名称
		rowCheckboxName : 'rowCheckBox',
		// 模块URL
		moduleUrl : '${ctx}/emes/psBaseInfo',
		//单个删除还是批量删除都走这个URL
		deletePageUrl : '${ctx}/emes/psBaseInfo/remove.do'
	};
	pageList.init(parameter);
	// 单行删除
	function deleteBtn(id) {
		var form = $("#controlForm");
		var confirm = function(v, h, f) {
			if (v == 'ok') {
				form.attr("action", '${ctx}/emes/psBaseInfo/remove.do?id=' + id).submit();
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
	<div id="fullcontent">
		<form id="controlForm" action="" method="post">
			<input type="hidden" id="selectedItemIds" name="ids" />
		</form>

		<div class="search">
			<form:form id="searchForm" modelAttribute="psBaseInfoSearchCondition" action="${ctx}/emes/psBaseInfo/list.do" method="post">
				<form:hidden id="pageNumber" path="pageNumber" />
				<form:hidden id="pageSize" path="pageSize" />
				<span> <label for="psName">企业名称：</label> <form:input path="psName" type="text" id="psName" class="span3" maxlength="12" placeholder="企业名称" />
				</span>
				<span> <input type="submit" class="button" value="查询" />
				</span>
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
					<th>企业名称</th>
					<th>行政区划</th>
					<th>企业类型</th>
					<th>检测级别</th>
					<th>联系人</th>
					<th>电话</th>
					<th>操 作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageObject.result}" var="record" varStatus="c">
					<tr>
						<td class="alignCenter"><input type="checkbox" name="rowCheckBox" align="middle" id="chk${c.count}" value="${record.id}" /></td>
						<td class="alignCenter" align="center">${c.count}</td>
						<td class="alignCenter" align="center">${record.psName}</td>
						<td class="alignCenter" align="center">${record.regionName}</td>
						<td class="alignCenter" align="center">${record.psType}</td>
						<td class="alignCenter" align="center">${record.monitorLevel}</td>
						<td class="alignCenter" align="center">${record.linkman}</td>
						<td class="alignCenter" align="center">${record.tel}</td>
						<td class="alignCenter">
							<div class="toolIcoArea">
								<a href="show.do?id=${record.id}" class="showIco" title="查看"></a> <a href="edit.do?id=${record.id}" class="editIco" title="编辑"></a> <a
									href="javascript:deleteBtn('${record.id}')" class="delIco" title="删除"></a>
							</div>
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
