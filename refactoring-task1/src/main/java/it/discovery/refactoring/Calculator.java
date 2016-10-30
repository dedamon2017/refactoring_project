package it.discovery.refactoring;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
	 * @param operation TODO
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
		String operation = calcOperation.operation;
		String firstOp = calcOperation.firstOp;
		String secondOp = calcOperation.secondOp;
		String scale = calcOperation.scale;
		String console = calcOperation.console;
		String report = calcOperation.console;
		
		report += "Nachali rabotu\n";
		// String operaciya = argumenty[10];
		// boolean probel = operaciya.equals("");
		// if (probel) {
		// operaciya = "+";
		// }

		boolean isConsole = isConsole(console);
		
			switch (operation) {
			case "+": {
				report += "Operaciya slojit\n";
				int firstNumber = toInt(firstOp);
				int secondNumber = toInt(secondOp);

				report += "Argument 1 " + convert(firstNumber, scale) + "\n";
				report += "Argument 2 " + convert(secondNumber, scale) + "\n";
				int result = firstNumber + secondNumber;
				report += "Rezultat " + convert(result, scale) + "\n";
				System.out.println(result);

				report += "Zakonchili rabotu\n";
				if (isConsole) {
					System.out.println(report);
				} else {
					saveToFile(report);
				}

			}

				break;

			case "-": {
				report += "Operaciya vychitanie\n";
				int firstNumber = toInt(firstOp);
				int secondNumber = toInt(secondOp);

				report += "Argument 1 " + convert(firstNumber, scale) + "\n";
				report += "Argument 2 " + convert(secondNumber, scale) + "\n";
				int result = firstNumber - secondNumber;
				report += "Rezultat " + convert(result, scale) + "\n";
				System.out.println(result);

				report += "Zakonchili rabotu\n";
				if (isConsole) {
					System.out.println(report);
				} else {
					saveToFile(report);
				}

			}

				break;
			case "*": {
				report += "Operaciya umnojeniya\n";
				int firstNumber = toInt(firstOp);
				int secondNumber = toInt(secondOp);
				report += "Argument 1 " + convert(firstNumber, scale) + "\n";
				report += "Argument 2 " + convert(secondNumber, scale) + "\n";
				int result = firstNumber * secondNumber;
				report += "Rezultat " + convert(result, scale) + "\n";
				System.out.println(result);

				report += "Zakonchili rabotu\n";
				if (isConsole) {
					System.out.println(report);
				} else {
					saveToFile(report);
				}

			}

				break;
			}
		return report;
	}

	private static int toInt(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException ex) {
			System.out.println("Oshibka");
			throw new RuntimeException(ex);
		}

	}

	private static boolean isConsole(String console) {
		boolean isConsole = false;
		if (console != null && console.equals("true")) {
			isConsole = true;
		}
		return isConsole;
	}

	private static void saveToFile(String content) throws IOException {
		FileWriter writer = new FileWriter("d:\\test.txt");
		BufferedWriter out = new BufferedWriter(writer);
		out.write(content);
		out.close();
	}

/*	private static String convertToScale(int value, String scale) {
		switch (scale) {
		case "2":
			return Integer.toBinaryString(value);
		case "8":
			return Integer.toOctalString(value);
		case "16":
			return Integer.toHexString(value);
		default:
			return "" + value;
		}
	}*/

	private static String convert(int data, String schis) {
		int defaultScale = 10;
		try {
			defaultScale = Integer.parseInt(schis);
		} catch (NumberFormatException iskl) {

		}

		return Integer.toString(data, defaultScale);
	}

	public static String getReport() {
		return report;
	}

	public static void setReport(String report) {
		Calculator.report = report;
	}

}

// class OtchetTools {
// public static void zapusk() {
// String report = Calculator.report;
// System.out.println(report);
// }
//
// public static void main(String[] argumenty) {
// OtchetTools report = new OtchetTools();
// report.zapusk();
// }
// }
