<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/styles/icons.css" />" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/styles/global.css" />" />
		<!--<jsp:include page="/components/extjs/extjs.jsp" flush="false" />
		<jsp:include page="/components/My97DatePicker/DatePicker.jsp" flush="false" />-->
		<script type="text/javascript" src="<c:url value='/scripts/eme/psBaseInfo/PsBaseInfoGridPanel.js'/>"></script>
	</head>
	<body>
		<hgf:ToorbarButton businessCode="psBaseInfo" operation="getCaseInfo" prefixSplit="false" iconCls="itemsDetailAll" handler="onGetCaseInfo" panelPageId="psBaseInfoGridPanel"
			text="查看案件信息" id="onGetCaseInfo"></hgf:ToorbarButton>
		<hgf:ToorbarButton businessCode="psBaseInfo" operation="add" prefixSplit="true" iconCls="addIcon" handler="onAdd" panelPageId="psBaseInfoGridPanel" text="新增"
			id="addButton"></hgf:ToorbarButton>
		<hgf:ToorbarButton businessCode="psBaseInfo" operation="edit" prefixSplit="true" iconCls="editIcon" handler="onEdit" panelPageId="psBaseInfoGridPanel"
			text="编辑" id="editButton"></hgf:ToorbarButton>
		<hgf:ToorbarButton businessCode="psBaseInfo" operation="remove" prefixSplit="true" iconCls="removeIcon" handler="onRemove" panelPageId="psBaseInfoGridPanel"
			text="删除" id="removeButton"></hgf:ToorbarButton>
			<hgf:ToorbarButton businessCode="caseInfo" operation="exportPs" prefixSplit="true" iconCls="exportExcelIcon"  handler="OnExportPs" panelPageId="psBaseInfoGridPanel"
	        text="导出" id="exportButton"></hgf:ToorbarButton>
		<hgf:ToorbarButton businessCode="psBaseInfo" operation="search" prefixSplit="true" iconCls="searchIcon" handler="onSearch" panelPageId="psBaseInfoGridPanel"
			text="查询" id="searchButton"></hgf:ToorbarButton>
		<div id='searchPanelDiv'></div>
		<div id="searchDiv" style="font-size: 12px; margin: 5 0 0 5">
			<form id="operateForm" action="jsonList.do">
				<input type="hidden" id="sortName" name="sortName" value="id" />
				<input type="hidden" id="sortOrder" name="sortOrder" value="DESC" />
				<input type="hidden" id="startIndex" name="startIndex" value="0" />
				<input type="hidden" id="results" name="results" value="0" />
				<input type="hidden" id="pageSize" name="pageSize" value="15" />
				<table width="100%" class="editTable">
					<tr>
						<td class="labelcell">行政区域:</td>
						<td class="fieldcell">
							<select id="regionCode" name="regionCode" style="width:120">
								<option value="">请选择</option>
								<c:forEach items="${areas}" var="area">
									<option value="${area.code}">${area.name}</option>
								</c:forEach>
							</select>
						</td>
						<td class="labelcell">企业名称:</td>
						<td class="fieldcell"><input type="text" id="psname" name="psname" value="" maxlength="30" /></td>
						<td class="labelcell">通讯地址:</td>
						<td class="fieldcell"><input type="text" id="communicateAddr" name="communicateAddr" size="35" maxlength="48" /></td>
					</tr>
					<tr>
						<td class="labelcell">排污类型:</td>
						<td class="fieldcell"><hgf:DataDicSelect type="iType" id="iType" path="iType" cssClass="select" required="false" style="width:120"/></td>
						<td class="labelcell">联系人:</td>
						<td class="fieldcell"><input type="text" id="linkman" name="linkman" value="" maxlength="24" /></td>
						<td class="labelcell">投产日期:</td>
						<td class="fieldcell">
							<input type="text" id="operationTimeBegin" name="operationTimeBegin" size="13" readonly="true" class="Wdate"  style="cursor:pointer" />
							&nbsp;&nbsp;至&nbsp;&nbsp;
							<input type="text" id="operationTimeEnd" name="operationTimeEnd" size="13" readonly="true" class="Wdate"  style="cursor:pointer" />
						    <input type="button" onclick="clickSearchButton();" class="searchButton" value="查询">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="toolBarDiv"></div>
		<div id="gridDiv"></div>
	</body>
	<script type="text/javascript">
    Ext.onReady(function() {
    
        var operationTimeBeginTxt = Ext.get('operationTimeBegin');
        var operationTimeEndTxt = Ext.get('operationTimeEnd');
        
        operationTimeBeginTxt.on('click', function(){
            WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'operationTimeEnd\')||\'%y-%M-%d\'}',  alwaysUseStartDate:true,readOnly:true});
        });
        
        operationTimeEndTxt.on('click', function(){
            WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'operationTimeBegin\')||\'%y-%M-%d\',readOnly:true}'});
        });
    });
    function clickSearchButton() {
        document.getElementById("searchButton").click();
    }
	</script>
</html>
