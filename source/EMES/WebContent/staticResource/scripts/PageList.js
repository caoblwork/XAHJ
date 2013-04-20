(function ($) {
    $.PageList = function () {
	// 初始化方法
	this.init = function(config) {
		// 全选checkbox的id
		this.selectAllId = config.selectAllId;
		// 列表中行选择的checkbox的名称
		this.rowCheckboxName = config.rowCheckboxName;
		// 选择的行数组
		this.selectedItems = new Array();
		// 选择的行组装的字符串(逗号分隔)
		this.selectedItemsStr = null;
		// 模块URL
		this.moduleUrl = config.moduleUrl;
		// 新增页面url
		this.addPageUrl = config.addPageUrl;
		// 编辑页面url
		this.editPageUrl = config.editPageUrl;
		// 删除url
		this.deletePageUrl = config.deletePageUrl;
		// 详细页面url
		this.detailPageUrl = config.detailPageUrl;
		// 导入页面url
		this.importPageUrl = config.importPageUrl;
		// 导出页面url
		this.exportPageUrl = config.exportPageUrl;
		// 列表页面url
		this.listPageUrl = config.listPageUrl;
	},
	// 选择全部或反选
	this.selectAll = function () {
		if($.isNull(this.selectAllId)) {
			this.selectAllId = 'chkAll';
		}
		var isChecked = $('#' + this.selectAllId).val();
		if (isChecked == 'off'){
			// 全选
			$("[name='" + this.rowCheckboxName + "']").attr("checked",'true');
			$('#' + this.selectAllId).val("on");
		}else if (isChecked == 'on') {
			// 取消全选
			$("[name='" +this.rowCheckboxName + "']").removeAttr("checked");
			$('#' + this.selectAllId).val("off");
		}
	},
	// 获取选中项目
	this.getSelectedItems = function(){
		var selectedItems = [];
		var selectedItemsStr = '';
		$("[name='" + this.rowCheckboxName + "']:checked").each(function(i){
			selectedItems[i] = $(this).val();
			selectedItemsStr = selectedItemsStr + $(this).val() + ',';
		});
		selectedItemsStr = selectedItemsStr.substr(0,selectedItemsStr.length-1);
		//alert(selectedItemsStr);
		this.selectedItems = selectedItems;
		$("#selectedItemIds").val(selectedItemsStr);
	},
	// 跳转到新增页面
	this.gotoAddPage = function(){
		if($.isNull(this.addPageUrl)) {
			if(!$.isNull(this.moduleUrl)) {
				this.addPageUrl = this.moduleUrl + '/add.do';
			} 
		}
		$("#controlForm").attr("action", this.addPageUrl).submit();
	},
	// 跳转到编辑页面
	this.gotoEditPage = function(){
		// 取得选中的项目
		this.getSelectedItems();
		if(this.selectedItems.length <= 0){
			$.jBox.info('请选择要编辑的记录', '提示信息',{top: '35%'});
			return false;
		}
		if (this.selectedItems.length > 1){
			$.jBox.info('每次只能选择一条记录进行编辑', '提示信息',{top: '35%'});
			return false;
		}
		if($.isNull(this.editPageUrl)) {
			if(!$.isNull(this.moduleUrl)) {
				this.editPageUrl = this.moduleUrl + '/edit/' + this.selectedItems[0];
			} 
		} else {
			this.editPageUrl = this.editPageUrl + '/' + this.selectedItems[0];
		}
		$("#controlForm").attr("action", this.editPageUrl).submit();
	},
	// 跳转到删除页面
	this.gotoDeletePage = function(){
		// 取得选中的项目
		this.getSelectedItems();
		if($.isNull(this.deletePageUrl)) {
			if(!$.isNull(this.moduleUrl)) {
				this.deletePageUrl = this.moduleUrl + '/batchRemove.do';
			} 
		}
		if(this.selectedItems.length <= 0){
			$.jBox.info('请选择要删除的记录', '提示信息',{top: '35%'});
			return false;
		} else {
			var form = $("#controlForm");
			var deletePageUrl = this.deletePageUrl;
			var confirm = function (v, h, f) {
				if (v == 'ok') {
					form.attr("action", deletePageUrl).submit();
					return true;
				}else if (v == 'cancel') {
					return true;
				}
				return true;
			};
			$.jBox.confirm("确定要删除吗？", "提示", confirm,{top:'35%'});
		}
	},
	// 跳转到详细页面
	this.gotoDetailPage = function(id){
		if($.isNull(this.detailPageUrl)) {
			if(!$.isNull(this.moduleUrl)) {
				this.detailPageUrl = this.moduleUrl + '/show';
			} 
		}
		this.detailPageUrl = this.detailPageUrl + '/' + id;
		$("#controlForm").attr("action", this.detailPageUrl).submit();
	},
	// 跳转到导入页面
	this.gotoImportPage = function(url){
		if(!$.isNull(this.moduleUrl)) {
			var html = '<div class="toLead"> <form id="operateForm" action="import.do" method="post" enctype="multipart/form-data"><br/>'
			+'<input type="file" id="uploadFile" name="uploadFile" class="inputbox" >'
			+'<button type="submit">上传文件</button>'
			+'</form>'
			+'<div id="tip_content" class="tipContent"><font color="#FF0000">注意：</font><br/>只有(.xls和.xlsx的excel文件才可导入，严格按照模版样例文件来输入数据，如果数据不正确根据下面的提示信息配合相应的操作。)<br/>'
			+'样例模版: [<a href="'+url+'"><font color="#FF0000">下载</font></a>]</div></div>';
			var submit = function (v, h, f) {
				 window.location.reload();
				 return true;
			};
			$.jBox(html, { 
				top: '40%',
				title: "数据导入",
				width: 400,
				height: 220,
				iframeScrolling: 'no',
				border: 5,
				buttons: { '关闭': true }
			});
			
		} 
	},
	// 跳转到导出页面
	this.gotoExportPage = function(url){
		// 优先级3：默认的导出url
		if($.isNull(this.exportPageUrl)) {
			if(!$.isNull(this.moduleUrl)) {
				this.exportPageUrl = this.moduleUrl + '/export.do';
			} 
		}
        // 优先级2：初始化时配置的exportPageUrl
        // 优先级1：传参中的url
        if(!$.isNull(url)) {
            this.exportPageUrl = url;
        }
		$("#searchForm").attr("action", this.exportPageUrl).submit();
		$("#searchForm").attr("action", this.moduleUrl + '/list.do');
	};
    };
})(jQuery);