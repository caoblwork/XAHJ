package com.hangu.emes.web.controller.workflow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.hangu.common.config.Configuration;
import com.hangu.common.util.StringUtil;
import com.hangu.emes.common.Constants;
import com.hangu.emes.common.ProcedureDeployStatus;
import com.hangu.emes.service.DeployManagerService;
import com.hangu.emes.vo.DeployManagerSearchCondition;
import com.hangu.emes.vo.DeployManagerVo;
import com.hangu.framework.vo.BaseVo;
import com.hangu.framework.web.controller.EntityController;

@Controller
@RequestMapping("/workflow/deployManager/*")
public class DeployManagerController extends EntityController<DeployManagerVo, DeployManagerSearchCondition> {

	@Autowired
	private RepositoryService repositoryService;

	@SuppressWarnings("unused")
	@Autowired
	private void setDeployManagerService(DeployManagerService deployManagerService) {
		this.setEntityService(deployManagerService);
	}

	public DeployManagerController() {
		super();
		pathPrefix = "workflow/";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(value = "saveDeployInfo.do", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("voModel") DeployManagerVo vo, BindingResult bindingResult, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		logger.debug("beging process saveDeployInfo.do");
		ModelAndView mav = new ModelAndView();
		mav.setView(new RedirectView("list.do"));
		if (null != addValidator) {
			addValidator.validate(vo, bindingResult);
		}
		if (bindingResult.hasErrors()) {
			String viewName = pathPrefix + getEntityName() + viewNameMap.get("addView");
			logger.debug("viewName=" + viewName);
			mav.setViewName(viewName);
			return mav;
		}
		String filePath = UUID.randomUUID().toString().replace("-", "");
		vo.setFilePath(filePath);
		vo.setStatus(ProcedureDeployStatus.disable.value() + "");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("actFile");
		if (!"application/x-zip-compressed".equals(file.getContentType())) {
			bindingResult.rejectValue("filePath", "errors.file.pattern", "文件格式不正确！");
			String viewName = pathPrefix + getEntityName() + viewNameMap.get("addView");
			logger.debug("viewName=" + viewName);
			mav.setViewName(viewName);
			return mav;
		}
		if (!bindingResult.hasErrors()) {
			doSave(mav, vo, bindingResult);
			filePath = Configuration.getInstance().getValue(Constants.BPMN_PATH) + filePath + ".zip";

			logger.debug("#ContentType#:" + file.getContentType());
			OutputStream outputStream = null;
			InputStream inputStream = null;
			try {
				File outFile = new File(filePath);
				if (!outFile.getParentFile().exists()) {
					outFile.getParentFile().mkdirs();
				}
				outputStream = new FileOutputStream(filePath);
				inputStream = file.getInputStream();
				int bytesRead = 0;
				byte[] buffer = new byte[8192];
				while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				outputStream.close();
				inputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.debug("end process saveDeployInfo.do");
		return mav;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "deploy/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deploy(@ModelAttribute("id") String id, RedirectAttributes redirectAttributes) {
		logger.debug("beging process deploy.do");
		DeployManagerService deployManagerService = (DeployManagerService) entityService;
		DeployManagerVo deployManagerVo = (DeployManagerVo) deployManagerService.get(id).getResultObject();

		try {
			String path = Configuration.getInstance().getValue(Constants.BPMN_PATH) + deployManagerVo.getFilePath() + ".zip";
			ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(path));

			Deployment deployment = repositoryService.createDeployment().name(deployManagerVo.getEnName()).addZipInputStream(zipInputStream).deploy();
			deployManagerVo.setDeployId(deployment.getId());
			deployManagerVo.setStatus(ProcedureDeployStatus.enable.value() + "");

			deployManagerService.save(deployManagerVo);
			redirectAttributes.addFlashAttribute("message", "流程部署成功！");

			zipInputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "流程部署失败！");
		} finally {
			String path = getRequest().getContextPath() + "/" + pathPrefix + "/" + getEntityName();
			ModelAndView mav = new ModelAndView(new RedirectView(path + "/list.do"));
			logger.debug("end process deploy.do");
			return mav;
		}
	}

	@Override
	protected void doRemove(ModelAndView mav, DeployManagerVo vo) {
		if (StringUtil.isValidString(vo.getDeployId())) {
			repositoryService.deleteDeployment(vo.getDeployId(), Boolean.TRUE);
		}
		super.doRemove(mav, vo);
	}

	protected void doRemove(ModelAndView mav, String id, BaseVo vo) {
		DeployManagerService deployManagerService = (DeployManagerService) entityService;
		DeployManagerVo deployManagerVo = (DeployManagerVo) deployManagerService.get(id).getResultObject();
		if (StringUtil.isValidString(deployManagerVo.getDeployId())) {
			repositoryService.deleteDeployment(deployManagerVo.getDeployId(), Boolean.TRUE);
		}
		super.doRemove(mav, id, deployManagerVo);
	}
}
