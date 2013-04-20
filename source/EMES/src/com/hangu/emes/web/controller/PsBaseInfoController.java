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

@Controller
@RequestMapping("/eme/psBaseInfo/*")
public class PsBaseInfoController extends EntityController<PsBaseInfoVo, PsBaseInfoSearchCondition> {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    public void setPsBaseInfoService(PsBaseInfoService service) {
        setEntityService(service);
    }

//    @Autowired
//    private AreaInfoService areaInfoService;
//
//    @Autowired
//    private CaseInfoService caseInfoService;
//    /**
//     * 数据字典服务
//     */
//    @Autowired
//    private DataDictionaryService dataDictionaryService = null;

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
        addValidator = new PsBaseInfoValidator();
        editValidator = addValidator;
        pathPrefix = "eme/";
    }

//    @Override
//    public ModelAndView list(PsBaseInfoSearchCondition searchCondition, BindingResult bindingResult) {
//
//        String viewName = pathPrefix + getEntityName() + "/list";
//        ModelAndView mav = new ModelAndView(viewName);
//        String areaCode= SpringSecurityUtils.getCurrentUser().getAreaCode();
//        List<AreaInfoVo> areas = areaInfoService.getAreaCodeByProvince(Constants.LEVER_TWO);
//        if(areaCode.equals("620000000")){
//            mav.addObject("areas",areas);
//        }else{
//            areas = areaInfoService.getAreaName(areaCode);
//            mav.addObject("areas", areas);
//        }
//        return mav;
//    }
//
//    @Override
//    protected void decorateShowResult(PsBaseInfoVo psinfoVo) {
//        psinfoVo.setiTypeName(dataDictionaryService.fingDataItemsByTypeKey("iType", psinfoVo.getiType().toString()).getValue());
//        psinfoVo.setPsClassName(dataDictionaryService.fingDataItemsByTypeKey("psclassCode", psinfoVo.getPsclassCode()).getValue());
//    }
//
//    @Override
//    protected void decorateSearchResult(SearchResult<PsBaseInfoVo> searchResult, SearchCondition searchCondition) {
//        super.decorateSearchResult(searchResult, searchCondition);
//        List<PsBaseInfoVo> infos = searchResult.getResult();
//        for (PsBaseInfoVo info : infos) {
//            info.setiTypeName(dataDictionaryService.fingDataItemsByTypeKey("iType", info.getiType().toString()).getValue());
//        }
//    }
//
//    @Override
//    protected void prepareSearchCondition(Search search, SearchCondition searchCondition) {
//        super.prepareSearchCondition(search, searchCondition);
//        
//        String areaCode= SpringSecurityUtils.getCurrentUser().getAreaCode();
//        PsBaseInfoSearchCondition condition = (PsBaseInfoSearchCondition) searchCondition;
//        // 企业名称匹配
//        if (StringUtils.isNotBlank(condition.getPsname())) {
//            search.addFilterLike("psname", "%" + condition.getPsname() + "%");
//        }
//        // 联系人过滤
//        if (StringUtils.isNotBlank(condition.getLinkman())) {
//            search.addFilterLike("linkman", "%" + condition.getLinkman() + "%");
//        }
//         if (StringUtils.isNotBlank(areaCode) && !areaCode.equals("620000000") && !areaCode.equals("624000000")) {
//          search.addFilterEqual("regionCode",areaCode);
//          }
//         if (StringUtils.isNotBlank(areaCode) && areaCode.equals("624000000")) {
//        	 condition.setPsaddress("甘肃矿区");
//             search.addFilterEqual("psaddress",condition.getPsaddress());
//           }
//         if(StringUtils.isNotBlank(condition.getRegionCode()) && "624000000".equals(condition.getRegionCode())){
//        	 condition.setPsaddress("甘肃矿区");
//             search.addFilterEqual("psaddress",condition.getPsaddress());
//         } else if (StringUtils.isNotBlank(condition.getRegionCode())) {
//           search.addFilterEqual("regionCode", condition.getRegionCode());
//         }
//        if (StringUtils.isNotBlank(condition.getiType())) {
//            search.addFilterEqual("iType", condition.getiType());
//        }
//        //
//        if (StringUtils.isNotBlank(condition.getCommunicateAddr())) {
//            search.addFilterLike("communicateAddr", "%" + condition.getCommunicateAddr() + "%");
//        }
//        search.addFilterGreaterOrEqual("runDate", condition.getOperationTimeBegin());
//        if (condition.getOperationTimeEnd() != null) {
//            Date endTime = DateUtil.getNextDay(condition.getOperationTimeEnd());
//            search.addFilterLessThan("runDate", endTime);
//        }
//    }
//    @Override
//    public ModelAndView create() {
//        logger.debug("beging process add.do");
//        String viewName = pathPrefix + getEntityName() + viewNameMap.get("addView");
//        logger.debug("viewName=" + viewName);
//        ModelAndView mav = new ModelAndView(viewName);
//
//        List<AreaInfoVo> areas = areaInfoService.getAreaCodeByProvince(Constants.LEVER_TWO);
//        mav.addObject("areas", areas);
//
//        doCreate(mav);
//        logger.debug("end process add.do");
//        return mav;
//    }
//    @Override
//    public ModelAndView edit(String id) {
//        logger.debug("beging process edit.do");
//        String viewName = pathPrefix + getEntityName() + viewNameMap.get("editView");
//        logger.debug("viewName=" + viewName);
//        ModelAndView mav = new ModelAndView(viewName);
//        List<AreaInfoVo> areas = areaInfoService.getAreaCodeByProvince(Constants.LEVER_TWO);
//        mav.addObject("areas", areas);
//        doEdit(mav, id);
//        logger.debug("end process edit.do");
//        return mav;
//    }
//
//    @RequestMapping(value = "checkCaseInfo.do", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public PresentationVo checkCaseInfo(String id) {
//        PresentationVo presentationVo = new PresentationVo();
//        Messages messages = new Messages();
//        if (!caseInfoService.checkCaseInfo(id)) {
//            messages.add(new Message("查询不到相关的案件信息！"));
//            presentationVo.setErrorMessages(messages);
//            presentationVo.setSuccess(Boolean.FALSE);
//        } else {
//            presentationVo.setSuccess(Boolean.TRUE);
//        }
//        return presentationVo;
//    }
//
//    @RequestMapping(value = "jsonSave.do", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public PresentationVo jsonSave(HttpServletRequest request, @ModelAttribute("voModel")
//    PsBaseInfoVo vo, BindingResult bindingResult) {
//        logger.debug("beging process jsonSave.do");
//        PsBaseInfoService psInfoService = (PsBaseInfoService) super.entityService;
//        PresentationVo presentationVo = new PresentationVo();
//        if (!StringUtil.isValidString(vo.getId())) {
//            if (psInfoService.checkPsName(vo)) {
//                Messages messages = new Messages(vo.getPsname() + "的此企业名称已经被注册请重新注册！");
//                presentationVo.setErrorMessages(messages);
//                presentationVo.setSuccess(Boolean.FALSE);
//                return presentationVo;
//            }
//        }
//        save(vo, bindingResult);
//        if (bindingResult.hasErrors()) {
//            List<FieldError> errors = bindingResult.getFieldErrors();
//            Messages messages = new Messages();
//            WebApplicationContext webApplicationContext = RequestContextUtils.getWebApplicationContext(request, request.getSession().getServletContext());
//            for (FieldError error : errors) {
//                String message = webApplicationContext.getMessage(error, request.getLocale());
//                messages.add(message);
//            }
//            presentationVo.setObjectErrors(bindingResult.getAllErrors());
//            presentationVo.setErrorMessages(messages);
//            presentationVo.setSuccess(false);
//        } else {
//            Messages messages = new Messages("数据保存成功！");
//            presentationVo.setInfoMessages(messages);
//            presentationVo.setSuccess(true);
//        }
//        logger.debug("end process jsonSave.do");
//        return presentationVo;
//    }
//    
//	/**
//	 * 内部工具：修饰Vo：将各种代码、号码替换为页面将要显示的文字
//	 * 
//	 * @param historySendedMsgVo
//	 */
//	private PsBaseInfoVo dataEdit(PsBaseInfoVo psBaseInfoVo) {
//		// 改写短信类型的显示文字
//		DataDictionaryVo dictionaryVo = dataDictionaryService.fingDataItemsByTypeKey(Constants.I_TYPE, psBaseInfoVo.getiType());
//		// 对照数据字典显示类型名
//		psBaseInfoVo.setiTypeName(dictionaryVo.getValue());
//
//		return psBaseInfoVo;
//	}
//    /**
//     *  未受控企业信息导出
//     *  Author  岳梨梨
//     *  
//     * 导出日志记录
//     * 
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//	@RequestMapping(value = "exportPs.do", method = { RequestMethod.GET, RequestMethod.POST })
//    public void exportPs(PsBaseInfoSearchCondition searchCondition, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        logger.debug("beging process export.do");
//        ModelAndView mav = new ModelAndView();
//        searchValidator.validate(searchCondition, bindingResult);
//        if (bindingResult.hasErrors()) {
//            prepareListData(mav);
//        } else {
//            Search search = new Search();
//            search.setMaxResults(Integer.MAX_VALUE);
//            search.setPage(0);
//            if (StringUtil.isValidString(searchCondition.getSortName())) {
//                search.addSort(searchCondition.getSortName(), SearchCondition.ORDER_DESC.equals(searchCondition.getSortOrder()));
//            }
//            prepareSearchCondition(search, searchCondition);
//            SearchResult<PsBaseInfoVo> searchResult = (SearchResult<PsBaseInfoVo>) entityService.searchAndCount(search).getResultObject();
//            List<PsBaseInfoVo> HistorySendedMsgVos = new ArrayList<PsBaseInfoVo>();
//			for (PsBaseInfoVo psBaseInfoVo : searchResult.getResult()) {
//				dataEdit(psBaseInfoVo);
//				HistorySendedMsgVos.add(psBaseInfoVo);
//			}
//            mav.addObject("totalRecords", searchResult.getTotalCount());
//            mav.addObject("records", searchResult.getResult());
//        }
//        String fileName = "普通企业信息表.xls";
//        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//        response.setHeader("Content-Disposition", "attachment;filename=\"" + StringUtil.encodeFileName(fileName, request.getHeader("USER-AGENT")) + "\"");
//        response.setHeader("Content-Transfer-Encoding", "binary");
//        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
//        response.setHeader("Pragma", "public");
//        ServletOutputStream outputStream = response.getOutputStream();
//        SheetMappingParser parser = new SheetMappingParser();
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        URL url = classLoader.getResource("/excelMapper/PsBaseInfoExcelMap.xml");
//        SheetMappingConfig mappingConfig = parser.parse(url);
//        ExcelAccessor excelHelper = new ExcelAccessorImpl(mappingConfig);
//        excelHelper.wirte((List<?>) mav.getModel().get("records"), outputStream);
//        outputStream.flush();
//        logger.debug("end process export.do");
//    }

}
