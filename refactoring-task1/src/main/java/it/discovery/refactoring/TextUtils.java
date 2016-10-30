package it.discovery.refactoring;

public class TextUtils {

	static String convert(int data, String schis) {
		int defaultScale = 10;
		try {
			defaultScale = Integer.parseInt(schis);
		} catch (NumberFormatException iskl) {
	
		}
	
		return Integer.toString(data, defaultScale);
	}

	static boolean isConsole(String console) {
		boolean isConsole = false;
		if (console != null && console.equals("true")) {
			isConsole = true;
		}
		return isConsole;
	}

	static int toInt(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException ex) {
			System.out.println("Oshibka");
			throw new RuntimeException(ex);
		}
	
	}

}
