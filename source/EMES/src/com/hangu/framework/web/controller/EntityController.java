package com.hangu.framework.web.controller;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.hangu.common.util.GenericsUtils;
import com.hangu.common.util.StringUtil;
import com.hangu.framework.vo.BaseVo;
import com.hangu.framework.vo.Message;
import com.hangu.framework.vo.Messages;
import com.hangu.framework.vo.Page;
import com.hangu.framework.vo.PresentationVo;
import com.hangu.framework.vo.SearchCondition;

/**
 * 业务实体类Controller
 * 
 * @author 曹保利
 * 
 * @param <VO>
 * @param <SC>
 */
public class EntityController<VO extends BaseVo, SC extends SearchCondition> extends AbstractEntityController<VO, SC> {

	public EntityController() {
		super();
	}

	protected void doIndex(ModelAndView mav) {
		// Search search = new Search();
		// search.setMaxResults(15);
		// search.setPage(0);
		// List<VO> voList = (List<VO>)
		// entityService.search(search).getResultObject();
		// mav.addObject("records", voList);
	}

	@Override
	protected void doCreate(ModelAndView mav) {
		VO vo = BeanUtils.instantiate(voClass);
		mav.addObject("voModel", vo);
	}

	@SuppressWarnings("unchecked")
	protected void doEdit(ModelAndView mav, String id) {
		PresentationVo presentationVo = new PresentationVo();
		VO vo = null;
		Object resultObject = entityService.get(id).getResultObject();
		if (resultObject == null) {
			logger.warn("can't find record by id=" + id);
			vo = (VO) GenericsUtils.getClassInstance(voClass);
			Messages messages = new Messages();
			messages.add(new Message("要编辑的数据记录不存在."));
			presentationVo.setErrorMessages(messages);
			presentationVo.setSuccess(false);
		} else {
			presentationVo.setSuccess(true);
			vo = (VO) resultObject;
		}
		presentationVo.setVoModel(vo);
		mav.addObject("presentationResult", presentationVo);
		mav.addObject("voModel", vo);
	}

	@Override
	protected void doList(ModelAndView mav, SC searchCondition) {
		prepareSearchCondition(searchCondition);
		Page page = null;
		if (doListEnable) {
			page = (Page) entityService.searchAndCount(searchCondition);
			decorateSearchResult(page);
			mav.addObject("pageObject", page);
		}
	}

	protected void decorateSearchResult(Page page) {
		// TODO 重写结果集
	}

	protected void prepareSearchCondition(SearchCondition searchCondition) {
		// DO NOTHING!
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doRemove(ModelAndView mav, VO vo) {
		entityService.remove(vo);
	}

	@Override
	protected void doRemove(ModelAndView mav, String id, BaseVo vo) {
		if (StringUtil.isValidString(id)) {
			entityService.remove(id);
		} else {
			entityService.remove((Serializable[]) vo.getIds());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doSave(ModelAndView mav, VO vo, BindingResult bindingResult) {
		entityService.save(vo);
	}

	@SuppressWarnings("unchecked")
	protected void doShow(ModelAndView mav, String id) {
		PresentationVo presentationVo = new PresentationVo();
		VO vo = null;
		Object resultObject = entityService.get(id).getResultObject();
		if (resultObject == null) {
			logger.warn("can't find record by id=" + id);
			vo = (VO) GenericsUtils.getClassInstance(voClass);
			Messages messages = new Messages();
			messages.add(new Message("要查看的数据记录不存在."));
			presentationVo.setErrorMessages(messages);
			presentationVo.setSuccess(false);
		} else {
			presentationVo.setSuccess(true);
			vo = (VO) resultObject;
		}
		decorateShowResult(vo);
		presentationVo.setVoModel(vo);
		mav.addObject("presentationResult", presentationVo);
		mav.addObject("voModel", vo);
	}

	protected void decorateShowResult(VO vo) {
		// DO NOTHING!
	}

	@Override
	protected void prepareAddData(ModelAndView mav) {

	}

	@Override
	protected void prepareEditData(ModelAndView mav, String id) {

	}

	@Override
	protected void prepareListData(ModelAndView mav) {

	}
}
