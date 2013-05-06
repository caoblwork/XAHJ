package com.hangu.workflow.common;

public enum ProcedureProcessDecision {

	disagree(0), agree(1), fork(2);

	private final int value;

	ProcedureProcessDecision(int value) {
		this.value = value;
	}

	public String toString() {
		return Integer.toString(this.value);
	}

	public int value() {
		return value;
	}
}
