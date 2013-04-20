<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<html>
<head>
<title>违法编码详细信息</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/global.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/icons.css" />" />
<!--<jsp:include page="/components/extjs/extjs.jsp" flush="false" />-->  
</head>
<body>
<div id="detailContent" style="margin: 5 5 5 5;">
<table width="99%" align="center" class="editTable">
    <tr>
        <td width="20%" class="labelcell"><label for="psname">企业名称:</label></td>
        <td>${voModel.psname}</td>
    </tr>
    <tr>
        <td width="20%" class="labelcell"><label for="corporationName">法人代表:</label></td>
        <td>${voModel.corporationName}</td>
    </tr>
    <tr>
        <td width="20%" class="labelcell"><label for="linkman">联系人:</label></td>
        <td>${voModel.linkman}</td>
    </tr>
    <tr>
        <td width="20%" class="labelcell"><label for="officePhone">联系方式:</label></td>
        <td>${voModel.officePhone}</td>
    </tr>
    <tr>
        <td width="20%" class="labelcell"><label for="regionCode">行政区域:</label></td>
        <td>${voModel.areaInfo.name}</td>
    </tr>
    <tr>
        <td width="20%" class="labelcell"><label for="iType">排污类型:</label></td>
        <td>${voModel.iTypeName}</td>
    </tr>   
    <tr>
        <td width="20%" class="labelcell"><label for="psclassCode">污染源类别:</label></td>
        <td>${voModel.psClassName}</td>
    </tr>   
    <tr>
        <td width="20%" class="labelcell"><label for="communicateAddr">联系地址:</label></td>
        <td>${voModel.communicateAddr}</td>
    </tr>   
    <tr>
        <td width="20%" class="labelcell"><label for="runDate">投产日期:</label></td>
        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${voModel.runDate}" /></td>
    </tr>   
    <tr>
        <td width="20%" class="labelcell"><label for="totalArea">总面积:</label></td>
        <td>${voModel.totalArea}㎡</td>
    </tr>
    <tr>
        <td width="20%" class="labelcell"><label for="remark">备注:</label></td>
        <td>${voModel.remark}</td>
    </tr>   
</table>


    <div align="right">
        <hgf:ExtButtonContainer>
            <hgf:ExtButton id="closeBtn" text="关闭" iconCls="closeIcon"></hgf:ExtButton>
        </hgf:ExtButtonContainer>
    </div>
    
</div>
</body>
<script type="text/javascript">
    Ext.onReady(function() {
        var closeBtn = Ext.get('closeBtn');
        closeBtn.on('click', function() {
            parent.Ext.getCmp("readWin").close();
        });
    });
</script>
</html>