package com.hangu.framework.vo;

public class SearchCondition extends BaseVo {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -7764073067458411323L;

	/**
	 * 排序标识
	 */
	public static final String ORDER_DESC = "DESC";

	/**
	 * 页号(从0开始)
	 */
	private Integer pageNumber = Integer.valueOf(0);

	/**
	 * 记录开发位置(从0开始)
	 */
	private Integer startIndex = Integer.valueOf(0);

	/**
	 * 页显示记录数量
	 */
	private Integer pageSize = Integer.valueOf(20);

	/**
	 * 排序项目
	 */
	private String sortName = null;

	/**
	 * 排序方向
	 */
	private String sortOrder = "DESC";

	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the sortName
	 */
	public String getSortName() {
		return sortName;
	}

	/**
	 * @param sortName
	 *            the sortName to set
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	/**
	 * @return the sortOrder
	 */
	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder
	 *            the sortOrder to set
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @param startIndex
	 *            the startIndex to set
	 */
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * @return the startIndex
	 */
	public Integer getStartIndex() {
		return startIndex;
	}

}
