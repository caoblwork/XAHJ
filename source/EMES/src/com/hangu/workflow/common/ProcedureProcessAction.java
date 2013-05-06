package com.hangu.workflow.common;

/**
 * <h1>流程处理方式</h1>
 * 
 * <ol>
 * <li><b>create</b>:流程创建操作</li>
 * <li><b>approval</b>:流程审核操作</li>
 * <li><b>modify</b>:流程中涉及到信息修改的操作</li>
 * <li><b>fork</b>:流程分支操作</li>
 * <li><b>join</b>:流程合并操作</li>
 * <li><b>end</b>:流程终结操作</li>
 * </ol>
 * 
 * @author 曹保利
 * 
 */
public enum ProcedureProcessAction {

	create(0), approval(1), modify(2), complete(3), users(4), groups(5), fork(8), join(9), end(10);

	private final int value;

	ProcedureProcessAction(int value) {
		this.value = value;
	}

	public String toString() {
		return Integer.toString(this.value);
	}

	public int value() {
		return value;
	}
}
