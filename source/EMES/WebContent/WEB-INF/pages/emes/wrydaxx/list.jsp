<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="<c:url value="/staticResource/scripts/PageList.js"/>" type="text/javascript"></script>
<title>汉字业务名列表</title>
<script type="text/javascript">
	var pageList = new $.PageList();
	var parameter = {
		// 全选checkbox的id
		selectAllId : 'chkAll',
		// 列表中行选择的checkbox的名称
		rowCheckboxName : 'rowCheckBox',
		// 模块URL
		moduleUrl : '${ctx}/emes/wrydaxx'
	};
	pageList.init(parameter);
	//单行删除
	function deleteBtn(id) {
		var form = $("#controlForm");
		var confirm = function(v, h, f) {
			if (v == 'ok') {
				form.attr("action", '${ctx}/emes/wrydaxx/delete/' + id).submit();
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
		<form id="controlForm" action="" method="post">
			<input type="hidden" id="selectedItemIds" name="ids" />
		</form>
		<div class="search">
			<form:form id="searchForm" modelAttribute="wrydaxxSearchCondition" action="${ctx}/emes/wrydaxx/list.do" method="post">
				<form:hidden id="pageNumber" path="pageNumber" />
				<form:hidden id="pageSize" path="pageSize" />
				<!-- 在此自己添加查询条件 -->
				<span> <label for="wrybh">企业名称：</label> <form:input path="wrybh" type="text" id="wrybh" class="span3" maxlength="12" placeholder="名称" />
				</span>
				<span> <input type="submit" class="button" value="查询" />
				</span>
			</form:form>
		</div>
		<div class="tool">
			<input type="button" class="button" value="新增" onclick="pageList.gotoAddPage();" /> <input type="button" class="button" value="删除"
				onclick="pageList.gotoDeletePage();" /> <input type="button" class="button" value="导入" onclick="pageList.gotoImportPage('/Three/fileTemplet/wrydaxx.xls');" />
			<input type="button" class="button" value="导出" onclick="pageList.gotoExportPage();" />
		</div>
		<c:if test="${not empty message}">
			<div id="message" class="success">${message}</div>
		</c:if>
		<table width="100%" class="tableUI">
			<thead>
				<tr>
					<th class="checkType"><input type="checkbox" name="checkbox" id="chkAll" value="off" onclick="pageList.selectAll()" /></th>
					<th class="serialnoType">序号</th>
					<th>污染源名称</th>
					<th>档案编号</th>
					<th>档案类型</th>
					<th>是否有效</th>
					<th>档案名称</th>
					<th>文件名称</th>
					<th class="toolIcoType">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageObject.result}" var="object" varStatus="c">
					<tr>
						<td class="alignCenter"><input type="checkbox" name="rowCheckBox" id="chk${c.count}" value="${object.id}" /></td>
						<td class="alignCenter">${c.count}</td>
						<td class="alignLeft">${object.wrybh}</td>
						<td>${object.dabh}</td>
						<td class="alignLeft">${object.dalx}</td>
						<td class="alignLeft">${object.sfyx}</td>
						<td class="alignLeft">${object.damc}</td>
						<td class="alignLeft">${object.wjmc}</td>
						<td class="alignCenter">
							<div class="toolIcoArea">
								<a href="show.do?id=${object.id}" class="showIco" title="查看"></a> <a href="edit.do?id=${object.id}" class="editIco" title="编辑"></a> <a
									href="remove.do?id=${object.id}" class="delIco" title="删除"></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hgf:PagingNavigation />
	</div>
	<div style="display: none">
		<input id="messageDisplay" type="text" value="" />
	</div>
	<div class="clear"></div>
</body>
</html>
