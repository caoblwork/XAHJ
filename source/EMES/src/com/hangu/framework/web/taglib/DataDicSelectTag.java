package com.hangu.framework.web.taglib;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.BindStatus;
import org.springframework.web.servlet.tags.form.AbstractHtmlInputElementTag;
import org.springframework.web.servlet.tags.form.TagWriter;

import com.hangu.framework.system.service.DataDictionaryService;
import com.hangu.framework.system.vo.DataDictionaryVo;

/**
 * 数据字典下拉选择标签
 * 
 * @author 曹保利
 * 
 */
public class DataDicSelectTag extends AbstractHtmlInputElementTag {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1955876417736870209L;

	/**
	 * The {@link javax.servlet.jsp.PageContext} attribute under which the bound
	 * value is exposed to inner {@link OptionTag OptionTags}.
	 */
	public static final String DATADIC_VALUE_PAGE_ATTRIBUTE = "com.hangu.framework.web.taglib.DataDicSelectTag";

	/**
	 * 是否运行多选
	 */
	private Object multiple = Boolean.FALSE;

	/**
	 * TagWriter
	 */
	private TagWriter tagWriter = null;

	/**
	 * 数据种类
	 */
	private String type = null;

	/**
	 * 是否为必须项目
	 */
	private boolean required = Boolean.FALSE;

	/**
	 * Set the value of the HTML '<code>multiple</code>' attribute rendered on
	 * the final '<code>select</code>' element.
	 * <p>
	 * May be a runtime expression.
	 */
	public void setMultiple(Object multiple) {
		this.multiple = multiple;
	}

	/**
	 * Get the value of the HTML '<code>multiple</code>' attribute rendered on
	 * the final '<code>select</code>' element.
	 * <p>
	 * May be a runtime expression.
	 */
	protected Object getMultiple() {
		return this.multiple;
	}

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException {
		ServletContext servletContext = pageContext.getSession().getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		DataDictionaryService dataDictionaryService = (DataDictionaryService) ctx.getBean("dataDictionaryService");
		tagWriter.startTag("select");
		writeDefaultAttributes(tagWriter);
		if (isMultiple()) {
			tagWriter.writeAttribute("multiple", "multiple");
		}
		List<DataDictionaryVo> items = dataDictionaryService.findDataItemsByType(type);
		if (!required) {
			tagWriter.startTag("option");
			tagWriter.writeAttribute("value", "");
			tagWriter.appendValue("请选择");
			tagWriter.endTag();
		}
		String value = "";
		try {
			value = (String) getBoundValue();
		} catch (Exception e) {
			// do nothing!
		}
		if (items != null) {
			for (DataDictionaryVo item : items) {
				tagWriter.startTag("option");
				tagWriter.writeAttribute("value", item.getKey());
				if (item.getKey().equals(value)) {
					tagWriter.writeAttribute("selected", "selected");
				}
				tagWriter.appendValue(item.getValue());
				tagWriter.endTag();
			}
			tagWriter.endTag(true);
			writeHiddenTagIfNecessary(tagWriter);
			return SKIP_BODY;
		} else {
			tagWriter.forceBlock();
			this.tagWriter = tagWriter;
			this.pageContext.setAttribute(DATADIC_VALUE_PAGE_ATTRIBUTE, getBindStatus());
			return EVAL_BODY_INCLUDE;
		}
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
	 * If using a multi-select, a hidden element is needed to make sure all
	 * items are correctly unselected on the server-side in response to a
	 * <code>null</code> post.
	 */
	private void writeHiddenTagIfNecessary(TagWriter tagWriter) throws JspException {
		if (isMultiple()) {
			tagWriter.startTag("input");
			tagWriter.writeAttribute("type", "hidden");
			tagWriter.writeAttribute("name", WebDataBinder.DEFAULT_FIELD_MARKER_PREFIX + getName());
			tagWriter.writeAttribute("value", "1");
			tagWriter.endTag();
		}
	}

	private boolean isMultiple() throws JspException {
		Object multiple = getMultiple();
		if (Boolean.TRUE.equals(multiple) || "multiple".equals(multiple)) {
			return true;
		} else if (this.multiple instanceof String) {
			return evaluateBoolean("multiple", (String) multiple);
		}
		return forceMultiple();
	}

	/**
	 * Returns '<code>true</code>' if the bound value requires the resultant '
	 * <code>select</code>' tag to be multi-select.
	 */
	private boolean forceMultiple() throws JspException {
		BindStatus bindStatus = null;
		try {
			bindStatus = getBindStatus();
		} catch (Exception e) {
			return false;
		}
		Class<?> valueType = bindStatus.getValueType();
		if (valueType != null && typeRequiresMultiple(valueType)) {
			return true;
		} else if (bindStatus.getEditor() != null) {
			Object editorValue = bindStatus.getEditor().getValue();
			if (editorValue != null && typeRequiresMultiple(editorValue.getClass())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns '<code>true</code>' for arrays, {@link Collection Collections}
	 * and {@link Map Maps}.
	 */
	private static boolean typeRequiresMultiple(Class<?> type) {
		return (type.isArray() || Collection.class.isAssignableFrom(type) || Map.class.isAssignableFrom(type));
	}

	/**
	 * Closes any block tag that might have been opened when using nested
	 * {@link OptionTag options}.
	 */
	@Override
	public int doEndTag() throws JspException {
		if (this.tagWriter != null) {
			this.tagWriter.endTag();
			writeHiddenTagIfNecessary(tagWriter);
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
		this.pageContext.removeAttribute(DATADIC_VALUE_PAGE_ATTRIBUTE);
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the required
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * @param required
	 *            the required to set
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}
}