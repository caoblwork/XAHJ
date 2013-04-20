package com.hangu.framework.web.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import com.hangu.framework.vo.Page;


/**
 * 分页导航信息显示标签
 * 
 * @author 徐浩
 * 
 */
public class PageTag extends TagSupport{

    /**
     * 序列化ID
     */
	private static final long serialVersionUID = 4902903427014161397L;

    /**
     * 样式名
     */
    private String cssClass;
    
    /**
     * 页号元素的ID
     */
    private String pageNumberElementId;
    
    /**
     * 查询form的ID
     */
    private String searchFormId;
    
    /**
     * 分页对象名
     */
    private String pageObject;  
    
    /**
     * 分页对象上下文
     */
    private String contextType;
    
    /**
     * 上下文类型-request
     */
    private static final String CONTEXT_TYPE_REQUEST = "0";
    
    /**
     * 上下文类型session
     */
    private static final String CONTEXT_TYPE_SESSION = "1";

	/**
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}

	/**
	 * @param cssClass the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	/**
	 * @return the pageObject
	 */
	public String getPageObject() {
		return pageObject;
	}

	/**
	 * @param pageObject the pageObject to set
	 */
	public void setPageObject(String pageObject) {
		this.pageObject = pageObject;
	}

	/**
	 * @return the contextType
	 */
	public String getContextType() {
		return contextType;
	}

	/**
	 * @param contextType the contextType to set
	 */
	public void setContextType(String contextType) {
		this.contextType = contextType;
	}
	
	public int doStartTag() throws JspException {  
        JspWriter out = pageContext.getOut();  
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        // 初始化基本参数
        if(StringUtils.isEmpty(searchFormId)) {
        	searchFormId = "searchForm";
        }        
        if(StringUtils.isEmpty(pageNumberElementId)) {
        	pageNumberElementId = "pageNumber";
        }        
        if(StringUtils.isEmpty(cssClass)) {
        	cssClass = "pagingStyle";
        }        
        if(StringUtils.isEmpty(contextType)) {
        	contextType = CONTEXT_TYPE_REQUEST;
        }        
        // 取得page对象存储的属性名
        if(StringUtils.isEmpty(pageObject)) {
        	pageObject = "pageObject";
        }
        // 取得page对象
        Page page = null;
        if(CONTEXT_TYPE_REQUEST.equals(contextType)) {
        	page = (Page) request.getAttribute(pageObject);
        } else if(CONTEXT_TYPE_SESSION.equals(contextType)){
        	page = (Page) request.getSession().getAttribute(pageObject);
        } else {
        	return super.doStartTag();
        }
        try{  
        	// 构造script
        	String scriptHtml = buildPageChangeScriptHtml();
        	if(page.getLastPageNumber() < 1) {
                return super.doStartTag();   
        	}
    		// 构造分页导航信息
            String pagingHtml = buildPagingHtml(page);
            out.write(scriptHtml);
            out.write(pagingHtml);
            
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return super.doStartTag();  
    }

	/**
	 * 构造分页用脚本代码
	 * 
	 * @return
	 */
	private String buildPageChangeScriptHtml() {
		StringBuilder scriptHtml = new StringBuilder();
		// 单击链接时调用的函数
		scriptHtml.append("<script language='javascript'>");
		scriptHtml.append("	function submitPageSearch_" + searchFormId + "(targetPageNumber) {");
		scriptHtml.append("$('#" + pageNumberElementId + "').val(targetPageNumber);");
		scriptHtml.append("$('#" + searchFormId + "').submit();");
		scriptHtml.append("}");
		// 直接输入选择页号时调用的函数
		scriptHtml.append("	function selectPageSubmit_" + searchFormId + "() {");
		scriptHtml.append("var selectedPage = $('#selectedPage_" + searchFormId +"').val();");
		scriptHtml.append("if('' != $.trim(selectedPage)) {");
		scriptHtml.append("$('#" + pageNumberElementId + "').val(selectedPage-1);}");
		scriptHtml.append("$('#" + searchFormId + "').submit();");
		scriptHtml.append("}");
		scriptHtml.append("</script>");
		return scriptHtml.toString();
	}

	/**
	 * 构造分页导航信息
	 * 
	 * @param page 分页对象
	 * @return
	 */
	private String buildPagingHtml(Page page) {
		StringBuilder pagingHtml = new StringBuilder();
		int targetPageNumber;
		// 构造分页信息
		  pagingHtml.append("<div class='" + cssClass +"'>");
		  if (page.isFirstPage()) {
			  pagingHtml.append("<span class='firstWithNotLink'>首页</span>");
		  } else {
			  targetPageNumber = 0;
			  pagingHtml.append("<span class='firstWithLink'><a href='javascript:void(0)' onclick='submitPageSearch_" + searchFormId + "(" + targetPageNumber + ")'>首页 </a></span>");
		  }  
		  if (page.isHasPreviousPage()) {
			  targetPageNumber = page.getThisPageNumber() - 1;
			  pagingHtml.append("<span class='previouWithLink'><a href='javascript:void(0)' onclick='submitPageSearch_" + searchFormId + "(" + targetPageNumber + ")'>上一页</a></span>");
		  } else {
			  pagingHtml.append("<span class='previouWithNotLink'>上一页</span>");
		  }  
		  if (page.isHasNextPage()) {
			  targetPageNumber = page.getThisPageNumber() + 1;
			  pagingHtml.append("<span class='nextWithLink'><a href='javascript:void(0)' onclick='submitPageSearch_" + searchFormId + "(" + targetPageNumber + ")'>下一页</a></span>");
		  } else {
			  pagingHtml.append("<span class='nextWithNotLink'>下一页</span>");
		  }  
		  if (page.isLastPage()) {
			  pagingHtml.append("<span class='lastWithNotLink'>尾页</span>");
		  } else {
			  targetPageNumber = page.getLastPageNumber();
			  pagingHtml.append("<span class='nextWithLink'><a href='javascript:void(0)' onclick='submitPageSearch_" + searchFormId + "(" + targetPageNumber + ")'>尾页</a></span>");
		  }
		  
		  // 如果页数大于3显示页选择
		  if(page.getLastPageNumber() > 2) {
			  String onKeyPress = "onkeypress='return event.keyCode&gt;=48&&event.keyCode&lt;=57' onpaste='return !clipboardData.getData('text').match(/\\D/)' ondragenter='return false'";
			  pagingHtml.append("<span class='selectedPage'> 第<input " + onKeyPress +" style='ime-mode:disabled' id='selectedPage_" + searchFormId + "' type='text' size='1'></input>页<a href='javascript:void(0)' onclick='selectPageSubmit_" + searchFormId + "()'>确定</a></span>");
		  }
		  // 页数信息
		  if(page.getLastPageNumber() > 0) {
			  int currentPage = page.getThisPageNumber()+1;
			  int totalPageCount = page.getLastPageNumber()+1;
			  pagingHtml.append("<span class='recordInfo'>" + " 共" + page.getTotalCount() + "条记录,当前第" + currentPage +"/" + totalPageCount + "页</span>");
		  }
		  pagingHtml.append("</div>");
		  return pagingHtml.toString();
	}  
}
