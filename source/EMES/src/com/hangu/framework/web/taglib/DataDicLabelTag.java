package com.hangu.framework.web.taglib;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.tags.form.AbstractHtmlElementTag;
import org.springframework.web.servlet.tags.form.TagWriter;

import com.hangu.framework.system.service.DataDictionaryService;
import com.hangu.framework.system.vo.DataDictionaryVo;

/**
 * 数据字典单数据显示标签
 * 
 * @author 曹保利
 * 
 */
public class DataDicLabelTag extends AbstractHtmlElementTag {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1955876417736870209L;

	/**
	 * The {@link javax.servlet.jsp.PageContext} attribute under which the bound
	 * value is exposed to inner {@link OptionTag OptionTags}.
	 */
	public static final String DATADICLABEL_VALUE_PAGE_ATTRIBUTE = "com.hangu.framework.web.taglib.DataDicLabelTag";

	/**
	 * TagWriter
	 */
	private TagWriter tagWriter = null;

	/**
	 * 数据种类
	 */
	private String dataType = null;

	private String dataKey = "";

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException {
		ServletContext servletContext = pageContext.getSession().getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		DataDictionaryService dataDictionaryService = (DataDictionaryService) ctx.getBean("dataDictionaryService");
		tagWriter.startTag("label");
		writeDefaultAttributes(tagWriter);
		DataDictionaryVo dataDictionary = dataDictionaryService.findDataItemsByTypeKey(dataType, dataKey);
		if (dataDictionary != null) {
			tagWriter.appendValue(dataDictionary.getValue());
		}
		tagWriter.endTag(true);
		return SKIP_BODY;

	}

	@Override
	protected String getName() throws JspException {
		return getPath();
	}

	@Override
	protected String resolveCssClass() {
		return getCssClass();
	}

	/**
	 * Closes any block tag that might have been opened when using nested
	 * {@link OptionTag options}.
	 */
	@Override
	public int doEndTag() throws JspException {
		if (this.tagWriter != null) {
			this.tagWriter.endTag();
		}
		return EVAL_PAGE;
	}

	/**
	 * Clears the {@link TagWriter} that might have been left over when using
	 * nested {@link OptionTag options}.
	 */
	@Override
	public void doFinally() {
		super.doFinally();
		this.tagWriter = null;
		this.pageContext.removeAttribute(DATADICLABEL_VALUE_PAGE_ATTRIBUTE);
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the dataKey
	 */
	public String getDataKey() {
		return dataKey;
	}

	/**
	 * @param dataKey
	 *            the dataKey to set
	 */
	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}
}
