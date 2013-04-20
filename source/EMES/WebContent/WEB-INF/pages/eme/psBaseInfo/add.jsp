<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/global.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/icons.css" />" />
<!--<jsp:include page="/components/extjs/extjs.jsp" flush="false" />
<jsp:include page="/components/jquery/validate.jsp" flush="false" />
<jsp:include page="/components/My97DatePicker/DatePicker.jsp" flush="false" />-->
<script type="text/javascript" src="<c:url value='/components/jquery/jquery.form.js'/>"></script>
<title>企业注册</title>
</head>
    <body>
        <div id="content">
            <div id="messageContent"></div>
            <sf:form id="voModelFrm" action="jsonSave.do" commandName="voModel">
                <div id="message">
                    <sf:errors path="*" cssClass="errorBox"></sf:errors>
                </div>
                <table width="99%" align="center" class="editTable">
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="psname"><font color="#FF0000">*</font>公司名称:</label>
                        </td>
                        <td class="fieldcell">
                            <sf:input path="psname" size="40" maxlength="48" cssClass="required" />
                            <sf:errors path="psname"></sf:errors>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="corporationName"><font color="#FF0000">*</font>公司法人:</label>
                        </td>
                        <td class="fieldcell">
                            <sf:input path="corporationName" size="40" maxlength="24" cssClass="required" />
                            <sf:errors path="corporationName"></sf:errors>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="linkman"><font color="#FF0000">*</font>联系人:</label>
                        </td>
                        <td class="fieldcell">
                            <sf:input path="linkman" size="40" maxlength="24" cssClass="required" />
                            <sf:errors path="linkman"></sf:errors>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="officePhone"><font color="#FF0000">*</font>联系电话:</label>
                        </td>
                        <td class="fieldcell">
                            <sf:input path="officePhone" size="40" maxlength="18" cssClass="{required:true,phone:true}" />
                            <sf:errors path="officePhone"></sf:errors>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="communicateAddr">通讯地址:</label>
                        </td>
                        <td class="fieldcell">
                            <sf:input path="communicateAddr" size="40" />
                            <sf:errors path="communicateAddr"></sf:errors>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="regionCode"><font color="#FF0000">*</font>行政区域:</label>
                        </td>
                        <td class="fieldcell">
                            <select id="regionCode" name="regionCode" class="required" style="width:120px">
                                <option value="">请选择</option>
                                <c:forEach items="${areas}" var="area">
                                    <option value="${area.code}">
                                        ${area.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="iType"><font color="#FF0000">*</font>排污类型:</label>
                        </td>
                        <td class="fieldcell">
                            <hgf:DataDicSelect type="iType" id="iType" path="iType" cssClass="select" required="true"  style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="psclassCode"><font color="#FF0000">*</font>污染源类别:</label>
                        </td>
                        <td class="fieldcell">
                            <hgf:DataDicSelect type="psclassCode" id="psclassCode" path="psclassCode" cssClass="select" required="true"  style="width:120px"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="totalArea">占地面积:</label>
                        </td>
                        <td class="fieldcell">
                       	单位:平方米(㎡)<br/>
                            <sf:input path="totalArea" size="17" maxlength="10" cssClass="{number:true,min:0}" />
                            <sf:errors path="totalArea"></sf:errors>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class="labelcell">
                            <label for="runDate"><font color="#FF0000">*</font>投产日期:</label>
                        </td>
                        <td class="fieldcell">
                            <sf:input id="runDate" path="runDate" size="17" class="Wdate required" />
                            <sf:errors path="runDate"></sf:errors>
                            <sf:input id="statusNew" path="statusNew" value="0" type="hidden" />
                        </td>
                    </tr>
                    <tr>
                        <td class="labelcell">
                            <label for="remark">备注:</label>
                        </td>
                        <td class="fieldcell">
                            <sf:textarea path="remark" cols="60" rows="6" cssClass="{maxlength:400}"/>
                            <sf:errors path="remark"></sf:errors>
                        </td>
                    </tr>
                </table>
                <div align="right">
                    <hgf:ExtButtonContainer>
                        <hgf:ExtButton id="saveBtn" text="保存" iconCls="saveIcon" type="submit"></hgf:ExtButton>
                        <hgf:ExtButton id="closeBtn" text="关闭" iconCls="closeIcon"></hgf:ExtButton>
                    </hgf:ExtButtonContainer>
                </div>
            </sf:form>
        </div>
    </body>
    <script type="text/javascript">
    Ext.onReady(function() {
        var runDate = Ext.get('runDate');
        runDate.on('click', function(){
            WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});
        });
        var dataDictAddPage = new Ext.mk.AddPage();
        var closeBtn = Ext.get('closeBtn');
        closeBtn.on('click', dataDictAddPage.closeWindow);
    });
</script>
</html>