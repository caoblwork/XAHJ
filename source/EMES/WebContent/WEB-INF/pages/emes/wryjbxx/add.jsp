<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>新增汉字业务名</title>
<script type="text/javascript">
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#第一个输入框的ID").focus();
		// 输入验证
		$("#addForm").validate({
			rules : {
			/*
			在此加入验证代码
			*/
			},
			messages : {
			/*
			在此加入验证消息
			*/
			}
		});
	});
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
<form:form id="addForm" modelAttribute="voModel" action="${ctx}/emes/wryjbxx/save.do" method="post">
	<form:hidden id="id" path="id" />
	<table width="100%" class="tableEdit">
		<tbody>
			<tr>
				<th class="leftLabel"><label for="wrybh"><font class="highlight">*</font>污染源编号:</label></th>
				<td class="leftField"><input type="text" id="wrybh" name="wrybh" maxlength="20" class="textbox"/><form:errors path="wrybh" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wrymc"><font class="highlight">*</font>污染源名称:</label></th>
				<td class="leftField"><input type="text" id="wrymc" name="wrymc" maxlength="20" class="textbox"/><form:errors path="wrymc" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wryjc">简称:</label></th>
				<td class="leftField"><input type="text" id="wryjc" name="wryjc" maxlength="20" class="textbox"/><form:errors path="wryjc" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="czhm">传真号码:</label></th>
				<td class="leftField"><input type="text" id="czhm" name="czhm" maxlength="20" class="textbox"/><form:errors path="czhm" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="lxdh"><font class="highlight">*</font>联系电话:</label></th>
				<td class="leftField"><input type="text" id="lxdh" name="lxdh" maxlength="20" class="textbox"/><form:errors path="lxdh" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="zzjgdm">组织机构:</label></th>
				<td class="leftField"><input type="text" id="zzjgdm" name="zzjgdm" maxlength="20" class="textbox"/><form:errors path="zzjgdm" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="sssf"><font class="highlight">*</font>所属省份:</label></th>
				<td class="leftField"><input type="text" id="sssf" name="sssf" maxlength="20" class="textbox"/><form:errors path="sssf" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="ssds">所属地市:</label></th>
				<td class="leftField"><input type="text" id="ssds" name="ssds" maxlength="20" class="textbox"/><form:errors path="ssds" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="ssqx">所属区县:</label></th>
				<td class="leftField"><input type="text" id="ssqx" name="ssqx" maxlength="20" class="textbox"/><form:errors path="ssqx" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="ssjd">所属街道:</label></th>
				<td class="leftField"><input type="text" id="ssjd" name="ssjd" maxlength="20" class="textbox"/><form:errors path="ssjd" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wgdm">网格代码:</label></th>
				<td class="leftField"><input type="text" id="wgdm" name="wgdm" maxlength="20" class="textbox"/><form:errors path="wgdm" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="gxgs">管辖归属:</label></th>
				<td class="leftField"><input type="text" id="gxgs" name="gxgs" maxlength="20" class="textbox"/><form:errors path="gxgs" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="dwlx"><font class="highlight">*</font>单位类型:</label></th>
				<td class="leftField"><input type="text" id="dwlx" name="dwlx" maxlength="20" class="textbox"/><form:errors path="dwlx" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="dwdz">单位地址:</label></th>
				<td class="leftField"><input type="text" id="dwdz" name="dwdz" maxlength="20" class="textbox"/><form:errors path="dwdz" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="yzbm">邮政编码:</label></th>
				<td class="leftField"><input type="text" id="yzbm" name="yzbm" maxlength="20" class="textbox"/><form:errors path="yzbm" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="frdb"><font class="highlight">*</font>法人代表:</label></th>
				<td class="leftField"><input type="text" id="frdb" name="frdb" maxlength="20" class="textbox"/><form:errors path="frdb" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wz">网址:</label></th>
				<td class="leftField"><input type="text" id="wz" name="wz" maxlength="20" class="textbox"/><form:errors path="wz" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="dzyx">电子邮箱:</label></th>
				<td class="leftField"><input type="text" id="dzyx" name="dzyx" maxlength="20" class="textbox"/><form:errors path="dzyx" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="lsgx">隶属关系:</label></th>
				<td class="leftField"><input type="text" id="lsgx" name="lsgx" maxlength="20" class="textbox"/><form:errors path="lsgx" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="jjlx">经济类型:</label></th>
				<td class="leftField"><input type="text" id="jjlx" name="jjlx" maxlength="20" class="textbox"/><form:errors path="jjlx" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="hydm">行业代码:</label></th>
				<td class="leftField"><input type="text" id="hydm" name="hydm" maxlength="20" class="textbox"/><form:errors path="hydm" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="qygm">企业规模:</label></th>
				<td class="leftField"><input type="text" id="qygm" name="qygm" maxlength="20" class="textbox"/><form:errors path="qygm" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="ztz">总投资:</label></th>
				<td class="leftField"><input type="text" id="ztz" name="ztz" maxlength="20" class="textbox"/><form:errors path="ztz" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="hbtz">环保投资:</label></th>
				<td class="leftField"><input type="text" id="hbtz" name="hbtz" maxlength="20" class="textbox"/><form:errors path="hbtz" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="hblxr">环保联系人:</label></th>
				<td class="leftField"><input type="text" id="hblxr" name="hblxr" maxlength="20" class="textbox"/><form:errors path="hblxr" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="hblxrlxdz">环保联系人地址:</label></th>
				<td class="leftField"><input type="text" id="hblxrlxdz" name="hblxrlxdz" maxlength="20" class="textbox"/><form:errors path="hblxrlxdz" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="jdd">经度（度）:</label></th>
				<td class="leftField"><input type="text" id="jdd" name="jdd" maxlength="20" class="textbox"/><form:errors path="jdd" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="jdf">经度（分）:</label></th>
				<td class="leftField"><input type="text" id="jdf" name="jdf" maxlength="20" class="textbox"/><form:errors path="jdf" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="jdm">经度（秒）:</label></th>
				<td class="leftField"><input type="text" id="jdm" name="jdm" maxlength="20" class="textbox"/><form:errors path="jdm" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wdd">纬度（度）:</label></th>
				<td class="leftField"><input type="text" id="wdd" name="wdd" maxlength="20" class="textbox"/><form:errors path="wdd" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wdf">纬度（分）:</label></th>
				<td class="leftField"><input type="text" id="wdf" name="wdf" maxlength="20" class="textbox"/><form:errors path="wdf" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wdm">纬度（秒）:</label></th>
				<td class="leftField"><input type="text" id="wdm" name="wdm" maxlength="20" class="textbox"/><form:errors path="wdm" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="szgyymc">工业区名称:</label></th>
				<td class="leftField"><input type="text" id="szgyymc" name="szgyymc" maxlength="20" class="textbox"/><form:errors path="szgyymc" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="pwxkzbh">排污许可证:</label></th>
				<td class="leftField"><input type="text" id="pwxkzbh" name="pwxkzbh" maxlength="20" class="textbox"/><form:errors path="pwxkzbh" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wryjs">污染源介绍:</label></th>
				<td class="leftField"><input type="text" id="wryjs" name="wryjs" maxlength="20" class="textbox"/><form:errors path="wryjs" cssClass="error"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="bz">备注:</label></th>
				<td class="leftField"><input type="text" id="bz" name="bz" maxlength="20" class="textbox"/><form:errors path="bz" cssClass="error"/></td>
			</tr>
		</tbody>
	</table>
	<div class="btnArea">
		<input id="submit" class="button" type="submit" value="提交" />
		<input id="cancel" class="button" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
</form:form>
</div>
<div class="clear"></div>
</body>
</html>
