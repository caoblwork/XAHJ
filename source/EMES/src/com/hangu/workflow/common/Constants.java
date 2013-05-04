package com.hangu.workflow.common;

public class Constants {

	/**
	 * 流程定义文件
	 */
	public final static String BPMN_PATH = "BPMN_PATH";

	/**
	 * <ul>
	 * 任务状态
	 * <li>0：没有assignee用户，待签收</li>
	 * <li>1：已经assignee用户，待处理</li>
	 * <li>2：已处理</li>
	 * </ul>
	 */
	public final static String[] TASK_STATUS = { "0", "1", "2" };

	/**
	 * 系统统一标识符
	 */
	public static final String SPLIT_FLAG = ",";

}