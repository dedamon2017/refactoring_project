package it.discovery.refactoring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Шарипов on 29.10.2016.
 */
public class Scanner_Test {



    @Before
    public void init() {
        CalculationScanner.init();
    }

    @Test
    public void executeScannerInitMethod() {

        CalculationScanner.init();
    }

    @Test
    public void executeMainMethod() {
        try {
            CalculationScanner.scan();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void executeMainClassMethod() {
        try {
            CalculationScanner.main(new String[]{""});
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}



