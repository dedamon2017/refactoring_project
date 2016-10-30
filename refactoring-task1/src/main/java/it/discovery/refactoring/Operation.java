package it.discovery.refactoring;

public class Operation {
	private String operation;
	private String firstOp;
	private String secondOp;
	private String scale;
	private String console;

	public Operation(String operation, String firstOp, String secondOp, String scale, String console) {
		this.setOperation(operation);
		this.setFirstOp(firstOp);
		this.setSecondOp(secondOp);
		this.setScale(scale);
		this.setConsole(console);
	}

	public String getOperation() {
		return operation;
	}

	private void setOperation(String operation) {
		this.operation = operation;
	}

	public String getFirstOp() {
		return firstOp;
	}

	private void setFirstOp(String firstOp) {
		this.firstOp = firstOp;
	}

	public String getSecondOp() {
		return secondOp;
	}

	private void setSecondOp(String secondOp) {
		this.secondOp = secondOp;
	}

	public String getScale() {
		return scale;
	}

	private void setScale(String scale) {
		this.scale = scale;
	}

	public String getConsole() {
		return console;
	}

	private void setConsole(String console) {
		this.console = console;
	}
	
}