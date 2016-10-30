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
			assertEquals(result.report, "[Nachali rabotu, Operaciya slojit, Argument 1 2, Argument 2 3, Rezultat 5, Zakonchili rabotu]");
			assertEquals(result.lines.size(), 6);
			
			
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}



}



