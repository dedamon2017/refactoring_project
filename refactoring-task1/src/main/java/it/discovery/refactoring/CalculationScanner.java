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
	
	public static void init() {
		scanResult = new ScanResult();
	}

	public static Object scan() throws Exception {
		String defaultPath = constants.DEFAULT_SCAN_FOLDER;
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(defaultPath));
			report = lines.toString();
			
			
			scanResult.lineCount = new LineContainer();
			scanResult.lineCount.lineCount = lines.size();
			scanResult.lines = new Vector(lines);
			scanResult.report = report;
			
		} catch (FileNotFoundException e) {
			System.out.println("Oshibka!");
		}
		catch (IOException e) {
			System.out.println("Oshibka!");
			throw new Exception("!");
		}
		return scanResult;

	}

	public static void main(String[] args) throws Exception {
		ScannerWrapper wrapper = new ScannerWrapper();
		wrapper.scanner = new CalculationScanner();
		Object result = wrapper.scan();
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

class BaseLineContainer {
	public int lineCount;
	
	public BaseLineContainer() {
		if(!(this instanceof LineContainer)) {
			System.out.println("Error!");
		}
	}
}

class LineContainer extends BaseLineContainer {
	
}

class FutureLineContainer extends LineContainer {
	
}

class ScanResult {
	public BaseLineContainer lineCount;
	
	public Vector lines;
	
	public String report;
	
	private void printInfo(String content) {
		System.out.println(content);
	}
	
	public void printLineCount() {
		printInfo("Data::Chislo linij " + lineCount.lineCount);
	}
	
	public void printLines() {
		
		printInfo(constants.HEADER_LINES + lines);
	}

	public void printReport() {
	
		printInfo("Data::Tekst " + report);
	}
	
}

class ScannerWrapper {
	public CalculationScanner scanner;
	
	public Object scan() throws Exception {
		scanner.init();
		return scanner.scan();
	}
}

interface constants {
      public static final String HEADER_LINES = "Data::Stroki";
      
      public static final String POINT = ".";
      
      public static final String ONE = "1";
      
      public static final String DEFAULT_SCAN_FOLDER =  "d:\\test.txt";
}