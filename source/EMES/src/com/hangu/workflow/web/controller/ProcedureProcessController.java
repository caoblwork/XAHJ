package com.hangu.workflow.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workflow/*")
public class ProcedureProcessController extends BaseProcedureController {
	
	public ProcedureProcessController() {
		super();
		pathPrefix = "workflow/";
	}
}
