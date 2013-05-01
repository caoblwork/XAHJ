// 固定电话号码验证
jQuery.validator.addMethod("telephone", function(value, element) {
    //电话号码格式010-12345678
    var telephoneReg = /^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    return this.optional(element) || (telephoneReg.test(value));
}, "请填写正确的电话号码");

// 电话号码验证(含手机、固话)
jQuery.validator.addMethod("phone", function (value, element, param) {
    var phone = /^(1[3-9]\d{9})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
    return this.optional(element) || phone.test(value);
},"请输入正确的电话号码");

// 手机号码验证
jQuery.validator.addMethod("mobile", function(value, element) {
    var length = value.length;
    var mobile =  /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请填写正确的手机号码");

// 身份证号码验证
jQuery.validator.addMethod("idCard", function(value, element) {
    var length = value.length;
    var idCard =  /^([1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3})|([1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X))$/;
    return this.optional(element) || ((length == 15 || length == 18) && idCard.test(value));
}, "请填写正确的身份证号码");

// 邮政编码验证
jQuery.validator.addMethod("zipCode", function(value, element) {
    var zipCode = /^[0-9]{6}$/;
    return this.optional(element) || (zipCode.test(value));
}, "邮政编码格式错误");
// QQ号码验证
jQuery.validator.addMethod("qq", function(value, element) {
    var qq = /^[1-9]\d{4,9}$/;
    return this.optional(element) || (qq.test(value));
}, "qq号码格式错误");
// IP地址验证
jQuery.validator.addMethod("ip", function(value, element) {
    var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    return this.optional(element) || (ip.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
}, "Ip地址格式错误");
//字符验证
jQuery.validator.addMethod("stringCheck", function(value, element) { 
   return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value); 
}, "只能包括中文字、英文字母、数字和下划线");
// 字母和数字的验证
jQuery.validator.addMethod("chrnum", function(value, element) {
    var chrnum = /^([a-zA-Z0-9]+)$/;
    return this.optional(element) || (chrnum.test(value));
}, "只能输入数字和字母(字符A-Z, a-z, 0-9)");
// 中文的验证
jQuery.validator.addMethod("chinese", function(value, element) {
    var chinese = /^[\u4e00-\u9fa5]+$/;
    return this.optional(element) || (chinese.test(value));
}, "只能输入中文");
// 英文验证
jQuery.validator.addMethod("english", function (value, element, param) {
    var dReg = /^[A-Za-z]+$/;
    return this.optional(element) || dReg.test(value);
},"只能输入字母(字符A-Z, a-z)");
// 字符验证
jQuery.validator.addMethod("string", function(value, element) {
    return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
}, "不允许包含特殊符号!");
//必须以特定字符串开头验证
jQuery.validator.addMethod("begin", function(value, element, param) {
    var begin = new RegExp("^" + param);
    return this.optional(element) || (begin.test(value));
}, $.validator.format("必须以 {0} 开头!"));
// 下拉框验证
jQuery.validator.addMethod("selectNone", function(value, element) {
    return value != "";
}, "必须选择一项");
// 字节长度验证
jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {
    var length = value.length;
    for (var i = 0; i < value.length; i++) {
        if (value.charCodeAt(i) > 127) {
            length++;
        }
    }
    return this.optional(element) || (length >= param[0] && length <= param[1]);
}, $.validator.format("请确保输入的值在{0}-{1}个字节之间(一个中文字算2个字节)"));
//字符最小长度验证（一个中文字符长度为2）
jQuery.validator.addMethod("byteMinLength", function(value, element, param) {
    var length = value.length;
    for ( var i = 0; i < value.length; i++) {
        if (value.charCodeAt(i) > 127) {
                length++;
            }
        }
    return this.optional(element) || (length >= param);
}, $.validator.format("长度不能小于{0}(一个中文字算2个字节)"));

// 字符最大长度验证（一个中文字符长度为2）
jQuery.validator.addMethod("byteMaxLength", function(value, element, param) {
    var length = value.length;
        for ( var i = 0; i < value.length; i++) {
            if (value.charCodeAt(i) > 127) {
                length++;
            }
        }
    return this.optional(element) || (length <= param);
}, $.validator.format("长度不能大于{0}(一个中文字算2个字节)"));

// 验证两次输入值是否不相同
jQuery.validator.addMethod("notEqualTo", function(value, element, param) {
    return value != $(param).val();
}, "两次输入不能相同");

// 验证值不允许与特定值等于
jQuery.validator.addMethod("notEqual", function(value, element, param) {
    return value != param;
}, $.validator.format("输入值不允许为{0}"));

// 验证值必须大于特定值(不能等于)
jQuery.validator.addMethod("gt", function(value, element, param) {
    return value > param;
}, $.validator.format("输入值必须大于{0}"));

// 验证值小数位数不能超过两位
jQuery.validator.addMethod("decimal2", function(value, element) {
    var decimal = /^-?\d+(\.\d{1,2})?$/;
    return this.optional(element) || (decimal.test(value));
}, "小数位数不能超过两位");
//验证值小数位数不能超过两位
jQuery.validator.addMethod("decimal4", function(value, element) {
    var decimal = /^-?\d+(\.\d{1,4})?$/;
    return this.optional(element) || (decimal.test(value));
}, "小数位数不能超过四位");
//采集批次验证
jQuery.validator.addMethod("batchCode", function(value, element) {
    var batchCode = /^(20\d{4})$/;
    return this.optional(element) || (batchCode.test(value));
}, "采集批次格式不正确");
