<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>详情</title>
</head>
<body>
	<div id="sidebar">
		<div class="accordion-nav-div">
			<ul class=" accordion-nav-ul-master">
				<li class=" accordion-nav-li-master accordion-master-li-current"><a href="#" class=" active"><span>一厂一档管理</span></a>
					<ul class=" accordion-subnav-ul">
						<li class=" accordion-subnav-li-current"><a href="<c:url value="/emes/wryjbxx/list.do"/>"><span>污染源基本信息</span></a></li>
						<li class=" accordion-subnav-li-current"><a href="<c:url value="/emes/wrydaxx/list.do"/>"><span>企业长期存档</span></a></li>
					</ul></li>
			</ul>
		</div>
	</div>

	<div id="content">
		<table width="100%" class="tableEditMore">
			<tbody>
				<tr>
					<th class="leftLabel">污染源编号</th>
					<td class="leftField">${voModel.wrybh}</td>
					<th class="leftLabel">污染源名称</th>
					<td class="leftField">${voModel.wrymc}</td>
				</tr>
				<tr>
					<th class="leftLabel">简称</th>
					<td class="leftField">${voModel.wryjc}</td>
					<th class="leftLabel">传真号码</th>
					<td class="leftField">${voModel.czhm}</td>
				</tr>
				<tr>
					<th class="leftLabel">联系电话</th>
					<td class="leftField">${voModel.lxdh}</td>
					<th class="leftLabel">组织机构</th>
					<td class="leftField">${voModel.zzjgdm}</td>
				</tr>
				<tr>
					<th class="leftLabel">所属省份</th>
					<td class="leftField">${voModel.sssf}</td>
					<th class="leftLabel">所属地市</th>
					<td class="leftField">${voModel.ssds}</td>
				</tr>
				<tr>
					<th class="leftLabel">所属区县</th>
					<td class="leftField">${voModel.ssqx}</td>
					<th class="leftLabel">所属街道</th>
					<td class="leftField">${voModel.ssjd}</td>
				</tr>
				<tr>
					<th class="leftLabel">网格代码</th>
					<td class="leftField">${voModel.wgdm}</td>
					<th class="leftLabel">管辖归属</th>
					<td class="leftField">${voModel.gxgs}</td>
				</tr>
				<tr>
					<th class="leftLabel">单位类型</th>
					<td class="leftField">${voModel.dwlx}</td>
					<th class="leftLabel">单位地址</th>
					<td class="leftField">${voModel.dwdz}</td>
				</tr>
				<tr>
					<th class="leftLabel">邮政编码</th>
					<td class="leftField">${voModel.yzbm}</td>
					<th class="leftLabel">法人代表</th>
					<td class="leftField">${voModel.frdb}</td>
				</tr>
				<tr>
					<th class="leftLabel">网址</th>
					<td class="leftField">${voModel.wz}</td>
					<th class="leftLabel">电子邮箱</th>
					<td class="leftField">${voModel.dzyx}</td>
				</tr>
				<tr>
					<th class="leftLabel">隶属关系</th>
					<td class="leftField">${voModel.lsgx}</td>
					<th class="leftLabel">经济类型</th>
					<td class="leftField">${voModel.jjlx}</td>
				</tr>
				<tr>
					<th class="leftLabel">行业代码</th>
					<td class="leftField">${voModel.hydm}</td>
					<th class="leftLabel">企业规模</th>
					<td class="leftField">${voModel.qygm}</td>
				</tr>
				<tr>
					<th class="leftLabel">总投资</th>
					<td class="leftField">${voModel.ztz}</td>
					<th class="leftLabel">环保投资</th>
					<td class="leftField">${voModel.hbtz}</td>
				</tr>
				<tr>
					<th class="leftLabel">环保联系人</th>
					<td class="leftField">${voModel.hblxr}</td>
					<th class="leftLabel">联系人地址</th>
					<td class="leftField">${voModel.hblxrlxdz}</td>
				</tr>
				<tr>
					<th class="leftLabel">经度（度）</th>
					<td class="leftField">${voModel.jdd}</td>
					<th class="leftLabel">经度（分）</th>
					<td class="leftField">${voModel.jdf}</td>
				</tr>
				<tr>
					<th class="leftLabel">经度（秒）</th>
					<td class="leftField">${voModel.jdm}</td>
					<th class="leftLabel">纬度（度）</th>
					<td class="leftField">${voModel.wdd}</td>
				</tr>
				<tr>
					<th class="leftLabel">纬度（分）</th>
					<td class="leftField">${voModel.wdf}</td>
					<th class="leftLabel">纬度（秒）</th>
					<td class="leftField">${voModel.wdm}</td>
				</tr>
				<tr>
					<th class="leftLabel">工业区名称</th>
					<td class="leftField">${voModel.szgyymc}</td>
					<th class="leftLabel">排污许可证</th>
					<td class="leftField">${voModel.pwxkzbh}</td>
				</tr>
				<tr>
					<th class="leftLabel">污染源介绍</th>
					<td class="leftField">${voModel.wryjs}</td>
					<th class="leftLabel">备注</th>
					<td class="leftField">${voModel.bz}</td>
				</tr>
			</tbody>
		</table>
		<div class="btnArea">
			<input id="cancel" class="button" type="button" value="返回" onclick="javascript:history.back();" />
		</div>
	</div>
	<div class="clear"></div>
</body>
</html>
