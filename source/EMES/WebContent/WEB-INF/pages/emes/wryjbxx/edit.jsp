<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>编辑</title>
<script >
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
<form:form id="form" modelAttribute="voModel" method="post" action="save.do" class="well form-horizontal">
	<form:hidden id="id" path="id" />
	<form:hidden id="version" path="version" />
	<table width="100%" class="tableEdit">
		<tbody>
			<tr>
				<th class="leftLabel"><label for="wrybh"><font class="highlight">*</font>污染源编号:</label></th>
				<td class="leftField"><form:input type="text" path="wrybh" name="wrybh" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wrymc"><font class="highlight">*</font>污染源名称:</label></th>
				<td class="leftField"><form:input type="text" path="wrymc" name="wrymc" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wryjc">简称:</label></th>
				<td class="leftField"><form:input type="text" path="wryjc" name="wryjc" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="czhm">传真号码:</label></th>
				<td class="leftField"><form:input type="text" path="czhm" name="czhm" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="lxdh"><font class="highlight">*</font>联系电话:</label></th>
				<td class="leftField"><form:input type="text" path="lxdh" name="lxdh" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="zzjgdm">组织机构:</label></th>
				<td class="leftField"><form:input type="text" path="zzjgdm" name="zzjgdm" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="sssf">所属省份:</label></th>
				<td class="leftField"><form:input type="text" path="sssf" name="sssf" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="ssds">所属地市</label></th>
				<td class="leftField"><form:input type="text" path="ssds" name="ssds" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="ssqx">所属区县:</label></th>
				<td class="leftField"><form:input type="text" path="ssqx" name="ssqx" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="ssjd">所属街道:</label></th>
				<td class="leftField"><form:input type="text" path="ssjd" name="ssjd" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wgdm">网格代码:</label></th>
				<td class="leftField"><form:input type="text" path="wgdm" name="wgdm" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="gxgs">管辖归属:</label></th>
				<td class="leftField"><form:input type="text" path="gxgs" name="gxgs" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="dwlx">单位类型:</label></th>
				<td class="leftField"><form:input type="text" path="dwlx" name="dwlx" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="dwdz">单位地址:</label></th>
				<td class="leftField"><form:input type="text" path="dwdz" name="dwdz" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="yzbm">邮政编码:</label></th>
				<td class="leftField"><form:input type="text" path="yzbm" name="yzbm" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="frdb">法人代表:</label></th>
				<td class="leftField"><form:input type="text" path="frdb" name="frdb" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wz">网址:</label></th>
				<td class="leftField"><form:input type="text" path="wz" name="wz" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="dzyx">电子邮箱:</label></th>
				<td class="leftField"><form:input type="text" path="dzyx" name="dzyx" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="lsgx">隶属关系:</label></th>
				<td class="leftField"><form:input type="text" path="lsgx" name="lsgx" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="jjlx">经济类型:</label></th>
				<td class="leftField"><form:input type="text" path="jjlx" name="jjlx" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="hydm">行业代码:</label></th>
				<td class="leftField"><form:input type="text" path="hydm" name="hydm" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="qygm">企业规模:</label></th>
				<td class="leftField"><form:input type="text" path="qygm" name="qygm" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="ztz">总投资:</label></th>
				<td class="leftField"><form:input type="text" path="ztz" name="ztz" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="hbtz">环保投资:</label></th>
				<td class="leftField"><form:input type="text" path="hbtz" name="hbtz" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="hblxr">环保联系人:</label></th>
				<td class="leftField"><form:input type="text" path="hblxr" name="hblxr" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="hblxrlxdz">环保联系人地址:</label></th>
				<td class="leftField"><form:input type="text" path="hblxrlxdz" name="hblxrlxdz" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="jdd">经度（度）:</label></th>
				<td class="leftField"><form:input type="text" path="jdd" name="jdd" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="jdf">经度（分）:</label></th>
				<td class="leftField"><form:input type="text" path="jdf" name="jdf" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="jdm">经度（秒）:</label></th>
				<td class="leftField"><form:input type="text" path="jdm" name="jdm" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wdd">纬度（度）:</label></th>
				<td class="leftField"><form:input type="text" path="wdd" name="wdd" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wdf">经度（分）:</label></th>
				<td class="leftField"><form:input type="text" path="wdf" name="wdf" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wdm">经度（秒）:</label></th>
				<td class="leftField"><form:input type="text" path="wdm" name="wdm" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="szgyymc">工业区名称:</label></th>
				<td class="leftField"><form:input type="text" path="szgyymc" name="szgyymc" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="pwxkzbh">排污许可证:</label></th>
				<td class="leftField"><form:input type="text" path="pwxkzbh" name="pwxkzbh" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="wryjs">污染源介绍:</label></th>
				<td class="leftField"><form:input type="text" path="wryjs" name="wryjs" maxlength="20" class="textbox"/></td>
			</tr>
			<tr>
				<th class="leftLabel"><label for="bz">备注:</label></th>
				<td class="leftField"><form:input type="text" path="bz" name="bz" maxlength="20" class="textbox"/></td>
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
