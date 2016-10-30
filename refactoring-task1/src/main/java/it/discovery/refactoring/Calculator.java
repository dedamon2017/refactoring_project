package it.discovery.refactoring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Calculation unit that implements arithmetic operations
 */
public class Calculator {
    private static final String ERROR_MESSAGE = "Oshibka";
    public static String report = null;

    // Primer ispolzovaniya: zapustit is IDE s argumentami
    // 1) znak operacii
    // 2) argument #1,
    // 3) argument #2
    // 4) sistema schisleniya - 2, 8, 10 ili 16 (opcionalno, default 10)
    // 5) vyvod v konsol(false) ili file(true) (opcionalno)
    // naprimer, + 2 2 true
    public static void main(String[] argumenty) {
        String operation = argumenty[0];
        String firstOp = argumenty[1];
        String secondOp = argumenty[2];
        String scale = null;
        try {
            scale = argumenty[3];
        } catch (ArrayIndexOutOfBoundsException e) {
            scale = "10";
        }

        String toConsole = null;
        try {
            toConsole = argumenty[4];
        } catch (ArrayIndexOutOfBoundsException iskl) {
            toConsole = "false";
        }

        calculate(operation, firstOp, secondOp, scale, toConsole);
    }

    /**
     * Glavnaya function
     *
     * @param argumenty
     */
    public static int calculate(String operation, String firstOp, String secondOp, String scale, String console) {
        report = "";
        report = "";
        report += "Nachali rabotu\n";
//		String operaciya = argumenty[10];
//		boolean probel = operaciya.equals("");
//		if (probel) {
//			operaciya = "+";
//		}		

        boolean isConsole = console != null && console.equals("true");
       /* if (console != null && console.equals("true")) {
            isConsole = true;
        }*/

        /*boolean isConsole = false;
        if (console != null && console.equals("true")) {
            isConsole = true;
        }*/

        switch (operation) {
            case "+": {
                report += "Operaciya slojit\n";
                int firstNumber = 0;
                try {
                    firstNumber = Integer.parseInt(firstOp);
                } catch (Exception ex) {
                    System.out.println("Oshibka");
                    return -1;
                }
                int secondNumber = 0;
                try {
                    secondNumber = Integer.parseInt(secondOp);
                } catch (Exception ex) {
                    System.out.println("Oshibka");
                    return -1;
                }

                report += "Argument 1 " + convertToScale(firstNumber, scale) + "\n";
                report += "Argument 2 " + convertToScale(secondNumber, scale) + "\n";
                int result = firstNumber + secondNumber;
                report += "Rezultat " + convertToScale(result, scale) + "\n";
                System.out.println(result);
                try {
                    report += "Zakonchili rabotu\n";
                    if (isConsole) {
                        System.out.println(report);
                    } else {
                        saveToFile();
                    }

                } catch (Exception e) {
                    System.out.println("Oshibka");
                    return -1;
                }
            }

            break;

            case "-": {
                report += "Operaciya vychitanie\n";
                int firstNumber = 0;
                try {
                    firstNumber = Integer.parseInt(firstOp);
                } catch (Exception ex) {
                    System.out.println("Oshibka");
                    return -1;
                }
                int secondNumber = 0;
                try {
                    secondNumber = Integer.parseInt(secondOp);
                } catch (Exception ex) {
                    System.out.println(ERROR_MESSAGE);
                }

                report += "Argument 1 " + convertToScale(firstNumber, scale) + "\n";
                report += "Argument 2 " + convertToScale(secondNumber, scale) + "\n";
                firstNumber -= secondNumber;
                report += "Rezultat " + convertToScale(firstNumber, scale) + "\n";
                System.out.println(firstNumber);
                try {
                    report += "Zakonchili rabotu\n";
                    if (isConsole) {
                        System.out.println(report);
                    } else {
                        saveToFile();
                    }

                } catch (Exception e) {
                    System.out.println(ERROR_MESSAGE);
                    return -1;
                }
            }

            break;
            case "*": {
                report += "Operaciya umnojeniya\n";
                int firstNumber = 0;
                try {
                    firstNumber = Integer.parseInt(firstOp);
                } catch (Exception ex) {
                    System.out.println(ERROR_MESSAGE);
                }
                int secondNumber = 0;
                try {
                    secondNumber = Integer.parseInt(secondOp);
                } catch (Exception ex) {
                    System.out.println(ERROR_MESSAGE);
                }
                report += "Argument 1 " + convert(firstNumber, scale) + "\n";
                report += "Argument 2 " + convert(secondNumber, scale) + "\n";
                int result = firstNumber * secondNumber;
                report += "Rezultat " + convert(result, scale) + "\n";
                System.out.println(result);
                try {
                    report += "Zakonchili rabotu\n";
                    if (isConsole) {
                        System.out.println(report);
                    } else {
                        saveToFile();
                    }
                } catch (Exception e) {
                    System.out.println(ERROR_MESSAGE);
                    return -1;
                }

            }

            break;
        }
        return 0;

    }

    private static void saveToFile() throws IOException {
        FileWriter writer = new FileWriter("d:\\test.txt");
        BufferedWriter out = new BufferedWriter(writer);
        out.write(report);
        out.close();
    }

    private static String convertToScale(int value, String scale) {
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
    }

    private static String convert(int data, String schis) {
        int defaultScale = 10;
        try {
            defaultScale = Integer.parseInt(schis);
        } catch (NumberFormatException iskl) {

        }


        return Integer.toString(data, defaultScale);
    }

}

//class OtchetTools {
//	public static void zapusk() {
//		String report = Calculator.report;
//		System.out.println(report);
//	}
//
//	public static void main(String[] argumenty) {
//		OtchetTools report = new OtchetTools();
//		report.zapusk();
//	}
//}
