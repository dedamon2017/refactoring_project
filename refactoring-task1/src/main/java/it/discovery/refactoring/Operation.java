package it.discovery.refactoring;

public class Operation {
	public String operation;
	public String firstOp;
	public String secondOp;
	public String scale;
	public String console;

	public Operation(String operation, String firstOp, String secondOp, String scale, String console) {
		this.operation = operation;
		this.firstOp = firstOp;
		this.secondOp = secondOp;
		this.scale = scale;
		this.console = console;
	}
	
}