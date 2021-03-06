package it.discovery.refactoring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

public class CalculationScanner {
	public static String report;

	public static ScanResult scanResult;

	public static Object scan() throws Exception {
		ScanResult scanResult = null;
		String defaultPath = constants.DEFAULT_SCAN_FOLDER;

		try {
			List<String> lines = Files.readAllLines(Paths.get(defaultPath));
			report = lines.toString();
			scanResult = new ScanResult(new Vector(lines), report);

		} catch (FileNotFoundException e) {
			System.out.println("Oshibka!");
		} catch (IOException e) {
			System.out.println("Oshibka!");
			throw new Exception("!");
		}
		return scanResult;

	}

	public static void main(String[] args) throws Exception {
		
		Object result = CalculationScanner.scan();
		try {
			ScanResult data = (ScanResult) result;
			data.printLineCount();
			data.printLines();
			data.printReport();
		} catch (Exception e) {
			System.out.println("!");
		}
	}
}



class LineContainer {
	private int lineCount;
	public LineContainer(int lineCount) {
		this.lineCount = lineCount;
	}
	public int getLineCount() {
		return lineCount;
	}
}

class ScanResult {
	private int lineCount;

	private Vector lines;

	private String report;

	public ScanResult(Vector lines, String report) {

		this.lineCount = lines.size();
		this.lines = lines;
		this.report = report;
	}

	private void printInfo(String content) {
		System.out.println(content);
	}

	public void printLineCount() {
		printInfo("Data::Chislo linij " + getLineCount());
	}

	public void printLines() {

		printInfo(constants.HEADER_LINES + getLines());
	}

	public void printReport() {

		printInfo("Data::Tekst " + getReport());
	}

	public int getLineCount() {
		return lineCount;
	}

	public Vector getLines() {
		return new Vector(lines);
	}

	public String getReport() {
		return report;
	}

}



interface constants {
	public static final String HEADER_LINES = "Data::Stroki";

	public static final String POINT = ".";

	public static final String ONE = "1";

	public static final String DEFAULT_SCAN_FOLDER = "d:\\test.txt";
}