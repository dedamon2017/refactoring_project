package it.discovery.refactoring;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Calculation unit that implements arithmetic operations
 */
public class MainClass {
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

        calculate(operation, firstOp, secondOp, scale, toConsole, "");
    }

    /**
     * Glavnaya function
     *
     * @param argumenty
     */
    public static int calculate(String operation, String firstOp, String secondOp, String scale, String console, String temp) {
        report = "";
        report = "";
        report += "Nachali rabotu\n";
//		String operaciya = argumenty[10];
//		boolean probel = operaciya.equals("");
//		if (probel) {
//			operaciya = "+";
//		}		

        boolean isConsole = false;
        if (console != null && console.equals("true")) {
            isConsole = true;
        }

        switch (operation) {
            case "+": {
                report += "Operaciya slojit\n";
                int firstNumber = 0;
                try {
                    firstNumber = Integer.parseInt(firstOp);
                } catch (Exception ex) {
                    System.out.println("Oshibka");
                }
                int secondNumber = 0;
                try {
                    secondNumber = Integer.parseInt(secondOp);
                } catch (Exception ex) {
                    System.out.println("Oshibka");
                }

                report += "Argument 1 " + convertToScale(firstNumber, scale) + "\n";
                report += "Argument 2 " + convertToScale(secondNumber, scale) + "\n";
                int sum = firstNumber + secondNumber;
                report += "Rezultat " + convertToScale(sum, scale) + "\n";
                System.out.println(sum);
                try {
                    report += "Zakonchili rabotu\n";
                    if (isConsole) {
                        System.out.println(report);
                    } else {
                        FileWriter writer = new FileWriter("d:\\test.txt");
                        BufferedWriter out = new BufferedWriter(writer);
                        out.write(report);
                        out.close();
                    }

                } catch (Exception e) {
                    System.out.println("Oshibka");
                    return -1;
                }
            }
            ;
            break;

            case "-": {
                report += "Operaciya vychitanie\n";
                int firstNumber = 0;
                try {
                    firstNumber = Integer.parseInt(firstOp);
                } catch (Exception ex) {
                    System.out.println("Oshibka");
                }
                int secondNumber = 0;
                try {
                    secondNumber = Integer.parseInt(secondOp);
                } catch (Exception ex) {
                    System.out.println(getErrorMessage());
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
                        FileWriter writer = new FileWriter("d:\\test.txt");
                        BufferedWriter out = new BufferedWriter(writer);
                        out.write(report);
                        out.close();
                    }

                } catch (Exception e) {
                    System.out.println(getErrorMessage());
                    return -1;
                }
            }
            ;
            break;
            case "*": {
                report += "Operaciya umnojeniya\n";
                int firstNumber = 0;
                try {
                    firstNumber = Integer.parseInt(firstOp);
                } catch (Exception ex) {
                    System.out.println(getErrorMessage());
                }
                int secondNumber = 0;
                try {
                    secondNumber = Integer.parseInt(secondOp);
                } catch (Exception ex) {
                    System.out.println(getErrorMessage());
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
                        FileWriter writer = new FileWriter("d:\\test.txt");
                        BufferedWriter out = new BufferedWriter(writer);
                        out.write(report);
                        out.close();
                    }
                } catch (Exception e) {
                    System.out.println(getErrorMessage());
                    return -1;
                }

            }
            ;
            break;
        }
        return 0;

    }

    private static String convertToScale(int value, String scale) {
        switch (scale) {
            case "2":
                String result = Integer.toBinaryString(value);
                return result;
            case "8":
                String result2 = Integer.toOctalString(value);
                return result2;
            case "16":
                String result3 = Integer.toHexString(value);
                return result3;
            default:
                String result4 = "" + value;
                return result4;
        }
    }

    private static String convert(int data, String schis) {
        int defaultScale = 10;
        try {
            defaultScale = Integer.parseInt(schis);
        } catch (NumberFormatException iskl) {

        }

        String result = Integer.toString(data, defaultScale);
        return result;
    }

    private static String getErrorMessage() {
        return "Oshibka";
    }
}

//class OtchetTools {
//	public static void zapusk() {
//		String report = MainClass.report;
//		System.out.println(report);
//	}
//	
//	public static void main(String[] argumenty) {
//		OtchetTools report = new OtchetTools();
//		report.zapusk();
//	}
//}
