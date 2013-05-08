package com.evalley.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evalley.domain.Corporation;
import com.evalley.service.CorporationService;

@Controller
@RequestMapping("/corp/*")
public class CorporationController {

    private CorporationService corporationService;
	
    @Autowired
	public void setSimpleService(CorporationService corporationService) {
		this.corporationService = corporationService;
	}

	@RequestMapping(value = "list.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Corporation list(HttpServletResponse response) {
		response.setContentType("application/json;charset=UTF-8");
		return corporationService.selectCorporation("");
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
