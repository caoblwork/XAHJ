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

import com.evalley.domain.Blog;
import com.evalley.service.SimpleService;

@Controller
@RequestMapping("/blog/*")
public class BlogController {

    private SimpleService simpleService;
	
    @Autowired
	public void setSimpleService(SimpleService simpleService) {
		this.simpleService = simpleService;
	}

	@RequestMapping(value = "list.do", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Blog list(HttpServletResponse response) {
		response.setContentType("application/json;charset=UTF-8");
		return simpleService.selectBlog(100);
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
