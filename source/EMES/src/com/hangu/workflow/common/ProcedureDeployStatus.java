package com.hangu.workflow.common;

/**
 * <h1>流程定义的部署状态</h1>
 * <ol>
 * <li>disable:当前流程不可用（流程定义未部署）</li>
 * <li>enable:当前流程可用（流程定义已成功部署）</li>
 * </ol>
 * 
 * @author 曹保利
 * @since 
 */
public enum ProcedureDeployStatus {

	disable(0), enable(1);

	private final int value;

	ProcedureDeployStatus(int value) {
		this.value = value;
	}

	public String toString() {
		return Integer.toString(this.value);
	}

	public int value() {
		return value;
	}
}
