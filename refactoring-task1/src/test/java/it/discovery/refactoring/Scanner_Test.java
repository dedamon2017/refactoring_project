package it.discovery.refactoring;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Шарипов on 29.10.2016.
 */
public class Scanner_Test {
	
	
	//static Обязательно требование Junit
	@BeforeClass
	public static void setup() {
		CalculationScanner.init();
	}
	
	@Test
	public void scan_ReportFileNonEmpty_ScanResultGenerated() {
		
		try {
			Object obj = CalculationScanner.scan();
			assertNotNull(obj);
			assertTrue(obj instanceof ScanResult);
			ScanResult result = (ScanResult) obj;
			assertEquals(result.lineCount.lineCount, 6);
			assertEquals(result.report, "Nachali rabotu\n" +
	                "Operaciya slojit\n" +
	                "Argument 1 2\n" +
	                "Argument 2 3\n" +
	                "Rezultat 5\n" +
	                "Zakonchili rabotu\n");
			assertEquals(result.lines.size(), 6);
			
			
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}



}



