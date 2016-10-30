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
			scanResult = new ScanResult(new LineContainer(lines.size()), new Vector(lines), report);
			
			
			
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
	private int lineCount;
	
	
	public BaseLineContainer(int lineCount) {
		this.lineCount = lineCount;
	}

	public BaseLineContainer() {
		if(!(this instanceof LineContainer)) {
			System.out.println("Error!");
		}
	}

	public int getLineCount() {
		return lineCount;
	}

	
}

class LineContainer extends BaseLineContainer {

	public LineContainer(int lineCount) {
		super(lineCount);
		
	}
	
}

class FutureLineContainer extends LineContainer {

	public FutureLineContainer(int lineCount) {
		super(lineCount);
		
	}
	
}

class ScanResult {
	private BaseLineContainer lineCount;
	
	private Vector lines;
	
	private String report;
	
	
	
	public ScanResult(BaseLineContainer lineCount, Vector lines, String report) {
		
		this.lineCount = lineCount;
		this.lines = lines;
		this.report = report;
	}

	private void printInfo(String content) {
		System.out.println(content);
	}
	
	public void printLineCount() {
		printInfo("Data::Chislo linij " + getLineCount().getLineCount());
	}
	
	public void printLines() {
		
		printInfo(constants.HEADER_LINES + getLines());
	}

	public void printReport() {
	
		printInfo("Data::Tekst " + getReport());
	}

	public BaseLineContainer getLineCount() {
		return lineCount;
	}

	

	public Vector getLines() {
		return lines;
	}

	

	public String getReport() {
		return report;
	}

	
	
}

class ScannerWrapper {
	public CalculationScanner scanner;
	
	public Object scan() throws Exception {
		return scanner.scan();
	}
}

interface constants {
      public static final String HEADER_LINES = "Data::Stroki";
      
      public static final String POINT = ".";
      
      public static final String ONE = "1";
      
      public static final String DEFAULT_SCAN_FOLDER =  "d:\\test.txt";
}