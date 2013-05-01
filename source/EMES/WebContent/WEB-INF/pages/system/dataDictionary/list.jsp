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
		moduleUrl : '${ctx}/system/dataDictionary',
		//单个删除还是批量删除都走这个URL
		//deletePageUrl : '${ctx}/system/dataDictionary/remove.do'
		//单个删除还是批量删除都走这个URL
		deletePageUrl : '${ctx}/system/dataDictionary/remove.do'
	};
	pageList.init(parameter);
	//单行删除
	function deleteBtn(id) {
		var form = $("#controlForm");
		var confirm = function(v, h, f) {
			if (v == 'ok') {
				form.attr("action", '${ctx}/system/dataDictionary/remove.do?id=' + id).submit();
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
<!-- 
	<div id="sidebar">
		<div class="accordion-nav-div">
			<ul class=" accordion-nav-ul-master">
				<li class=" accordion-nav-li-master accordion-master-li-current"><a href="/Three/" class=" active"><span>农户基本信息</span></a>
					<ul class=" accordion-subnav-ul">
						<li class=" accordion-subnav-li-current"><a href="/Three/app/grass/grassFarmer/list.do?uniqueMenuMark=007001001"><span>基本信息</span></a></li>
					</ul></li>
				<li class=" accordion-nav-li-master"><a href="/Three/"><span>玉米生产信息</span></a>
					<ul class=" accordion-subnav-ul">
						<li><a href="/Three/app/grass/farmerCornProduction/list.do"><span>生产数据</span></a></li>
						<li><a href="/Three/app/grass/farmerCornProductionSum/list.do"><span>村级汇总上报</span></a></li>
						<li><a href="/Three/app/grass/farmerCornProductionAudit/list.do"><span>审批汇总</span></a></li>
					</ul></li>
				<li class=" accordion-nav-li-master"><a href="/Three/"><span>饲草生产信息</span></a>
					<ul class=" accordion-subnav-ul">
						<li><a href="/Three/app/grass/farmerGrassProduction/list.do"><span>生产数据</span></a></li>
						<li><a href="/Three/app/grass/farmerGrassProductionSum/list.do"><span>村级汇总上报</span></a></li>
						<li><a href="/Three/app/grass/farmerGrassProductionAudit/list.do"><span>审批汇总</span></a></li>
					</ul></li>
				<li class=" accordion-nav-li-master"><a href="/Three/"><span>秸秆饲料化</span></a>
					<ul class=" accordion-subnav-ul">
						<li><a href="/Three/app/grass/farmerStrawForage/list.do"><span>饲料化数据</span></a></li>
						<li><a href="/Three/app/grass/farmerStrawForageSum/list.do"><span>村级汇总上报</span></a></li>
						<li><a href="/Three/app/grass/farmerStrawForageAudit/list.do"><span>审批汇总</span></a></li>
					</ul></li>
			</ul>
		</div>
	</div>
 
	<div id="content">-->
	<div id="fullcontent">
		<form id="controlForm" action="" method="post">
			<input type="hidden" id="selectedItemIds" name="ids" />
		</form>

		<div class="search">
			<form:form id="searchForm" modelAttribute="dataDictionarySearchCondition" action="${ctx}/system/dataDictionary/list.do" method="post">
				<form:hidden id="pageNumber" path="pageNumber" />
				<form:hidden id="pageSize" path="pageSize" />
				<span> <label for="type">类型：</label> <form:input path="type" id="type" class="span3" maxlength="100" placeholder="类型" />
				</span>
				<span> <label for="key">键：</label> <form:input path="key" id="key" class="span3" maxlength="100" placeholder="键" />
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
					<th class="serialnoType">序号</th>

					<th>类型</th>
					<th>键</th>
					<th>值</th>

					<th class="toolIcoType">操作</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageObject.result}" var="record" varStatus="c">
					<tr>
						<td class="alignCenter"><input type="checkbox" name="rowCheckBox" id="chk${c.count}" value="${object.id}" /></td>
						<td class="alignCenter">${c.count}</td>
						<td class="alignCenter">${record.type}</td>
						<td class="alignCenter">${record.key}</td>
						<td class="alignCenter">${record.value}</td>
						<td class="alignCenter">
							<div class="toolIcoArea">
								<a href="show.do?id=${record.id}" class="showIco" title="查看"></a> <a href="edit.do?id=${record.id}" class="editIco" title="编辑"></a> 
								<a href="javascript:deleteBtn('${record.id}')" class="delIco" title="删除"></a>
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
