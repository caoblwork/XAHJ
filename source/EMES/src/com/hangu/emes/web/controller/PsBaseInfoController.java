package com.hangu.emes.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hangu.common.util.DateUtil;
import com.hangu.emes.service.PsBaseInfoService;
import com.hangu.emes.vo.PsBaseInfoSearchCondition;
import com.hangu.emes.vo.PsBaseInfoVo;
import com.hangu.emes.web.validator.PsBaseInfoValidator;
import com.hangu.framework.web.controller.EntityController;
/**
 * 企业信息controller
 * @author hupeng
 *
 */
@Controller
@RequestMapping("/eme/psBaseInfo/*")
public class PsBaseInfoController extends EntityController<PsBaseInfoVo, PsBaseInfoSearchCondition> {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;
    private PsBaseInfoService psBaseInfoService;
    @Autowired
    public void setPsBaseInfoService(PsBaseInfoService service) {
        setEntityService(service);
    }

    /**
     * 类型转换
     * 
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(DateUtil.getDatePattern()), true));
    }
    /**
     * 构造初始化
     */
    public PsBaseInfoController() {
        super();
//        addValidator = new PsBaseInfoValidator();
//        editValidator = addValidator;
        pathPrefix = "eme/";
    }
   
}
