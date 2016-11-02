package it.discovery.refactoring;

import java.io.IOException;

/**
 * Calculation unit that implements arithmetic operations
 */
public class Calculator {
	private static final String ERROR_MESSAGE = "Oshibka";
	private static String report = null;

	// Primer ispolzovaniya: zapustit is IDE s argumentami
	// 1) znak operacii
	// 2) argument #1,
	// 3) argument #2
	// 4) sistema schisleniya - 2, 8, 10 ili 16 (opcionalno, default 10)
	// 5) vyvod v konsol(false) ili file(true) (opcionalno)
	// naprimer, + 2 2 true
	public static void main(String[] args) {
		String operation = args[0];
		String firstOp = args[1];
		String secondOp = args[2];
		String scale = "10";
		if (args.length > 3) {
			scale = args[3];
		}
		String toConsole = "false";
		if (args.length > 4) {
			toConsole = args[4];
		}
		calculate(new Operation(operation, firstOp, secondOp, scale, toConsole));
	}

	/**
	 * Glavnaya function
	 * 
	 * @param operation
	 *            TODO
	 * @param argumenty
	 */
	public static void calculate(Operation operation) {
		String report = "";
		try {
			report = calculateReport(operation);
		} catch (Exception e) {
			System.out.println(ERROR_MESSAGE);
			throw new RuntimeException();
		}
		Calculator.setReport(report);

	}

	public static String calculateReport(Operation calcOperation) throws IOException {
		String operation = calcOperation.getOperation();
		String firstOp = calcOperation.getFirstOp();
		String secondOp = calcOperation.getSecondOp();
		String scale = calcOperation.getScale();
		String console = calcOperation.getConsole();
		String report = "Nachali rabotu\n";

		boolean isConsole = TextUtils.isConsole(console);

		int firstNumber = TextUtils.toInt(firstOp);
		int secondNumber = TextUtils.toInt(secondOp);
		int result = 0;
		switch (operation) {
		case "+": {
			report += "Operaciya slojit\n";
			result = firstNumber + secondNumber;
		}
			break;
		case "-": {
			report += "Operaciya vychitanie\n";
			result = firstNumber - secondNumber;
		}
			break;
		case "*": {
			report += "Operaciya umnojeniya\n";
			result = firstNumber * secondNumber;
		}
			break;
		}
		report += "Argument 1 " + TextUtils.convert(firstNumber, scale) + "\n";
		report += "Argument 2 " + TextUtils.convert(secondNumber, scale) + "\n";

		report += "Rezultat " + TextUtils.convert(result, scale) + "\n";
		System.out.println(result);

		report += "Zakonchili rabotu\n";
		if (isConsole) {
			System.out.println(report);
		} else {
			CalculationReport.saveToFile(report);
		}

		return report;
	}

	public static String getReport() {
		return report;
	}

	public static void setReport(String report) {
		Calculator.report = report;
	}

}
