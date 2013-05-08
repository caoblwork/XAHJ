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
		moduleUrl : '${ctx}/emes/caseInfo'
	};
	pageList.init(parameter);
	//单行删除
	function deleteBtn(id) {
		var form = $("#controlForm");
		var confirm = function(v, h, f) {
			if (v == 'ok') {
				form.attr("action", '${ctx}/emes/caseInfo/delete.do?id=' + id).submit();
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
	function callbackHandlerRegion(name, code) {
		document.getElementById("regionName").value = name;
		document.getElementById("regionCode").value = code;
	}
	function cleanDataRegion(v, h, f) {
		if (v == 0) {
			$('#regionName').val('');
			$('#regionCode').val('');
		}
	}
</script>
</head>
<body>
	<div id="sidebar"></div>
	<div id="content">
		<form id="controlForm" action="" method="post">
			<input type="hidden" id="selectedItemIds" name="ids" />
		</form>
		<div class="search">
			<form:form id="searchForm" modelAttribute="caseInfoSearchCondition" action="${ctx}/emes/caseInfo/list.do" method="post">
				<form:hidden id="pageNumber" path="pageNumber" />
				<form:hidden id="pageSize" path="pageSize" />
				<!-- 在此自己添加查询条件 -->
				<span> <input type="submit" class="button" value="查询" />
				</span>
			</form:form>
		</div>
		<div class="tool">
			<input type="button" class="button" value="新增" onclick="pageList.gotoAddPage();" /> 
			<input type="button" class="button" value="删除" onclick="pageList.gotoDeletePage();" /> 
		</div>
		<c:if test="${not empty message}">
			<div id="message" class="success">${message}</div>
		</c:if>
		<table width="100%" class="tableUI">
			<thead>
				<tr>
					<th class="checkType"><input type="checkbox" name="checkbox" id="chkAll" value="off" onclick="pageList.selectAll()" /></th>
					<th>simpleReason</th>
					<th>caseId</th>
					<th>partyName</th>
					<th>partyAddress</th>
					<th>partyLegalPerson</th>
					<th>partyDuty</th>
					<th>partyPhone</th>
					<th>partyPostcode</th>
					<th>pid</th>
					<th>launcherId</th>
					<th>deployId</th>
					<th class="serialnoType">序号</th>
					<th class="toolIcoType">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageObject.result}" var="object" varStatus="c">
					<tr>
						<td class="alignCenter"><input type="checkbox" name="rowCheckBox" id="chk${c.count}" value="${object.id}" /></td>
						<td class="alignCenter">${c.count}</td>
						<td class="alignLeft">${object.simpleReason}</td>
						<td class="alignLeft">${object.caseId}</td>
						<td class="alignLeft">${object.partyName}</td>
						<td class="alignLeft">${object.partyAddress}</td>
						<td class="alignLeft">${object.partyLegalPerson}</td>
						<td class="alignLeft">${object.partyDuty}</td>
						<td class="alignLeft">${object.partyPhone}</td>
						<td class="alignLeft">${object.partyPostcode}</td>
						<td class="alignLeft">${object.pid}</td>
						<td class="alignLeft">${object.launcherId}</td>
						<td class="alignLeft">${object.deployId}</td>
						<td class="alignCenter">
							<div class="toolIcoArea">
								<a href="show.do?id=${object.id}" class="showIco" title="查看"></a> 
								<a href="edit.do?id=${object.id}" class="editIco" title="编辑"></a> 
								<a href="javascript:deleteBtn('${object.id}')" class="delIco" title="删除"></a>
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
