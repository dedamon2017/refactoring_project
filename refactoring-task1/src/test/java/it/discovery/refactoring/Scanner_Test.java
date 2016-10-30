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
		
	}
	
	@Test
	public void scan_ReportFileNonEmpty_ScanResultGenerated() {
		
		try {
			Object obj = CalculationScanner.scan();
			assertNotNull(obj);
			assertTrue(obj instanceof ScanResult);
			ScanResult result = (ScanResult) obj;
			assertEquals(result.getLineCount().getLineCount(), 6);
			assertEquals(result.getReport(), "[Nachali rabotu, Operaciya slojit, Argument 1 2, Argument 2 3, Rezultat 5, Zakonchili rabotu]");
			assertEquals(result.getLines().size(), 6);
			
			
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}



}



