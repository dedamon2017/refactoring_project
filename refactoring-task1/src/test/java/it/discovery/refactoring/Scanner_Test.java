package it.discovery.refactoring;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Шарипов on 29.10.2016.
 */
public class Scanner_Test {


    @Test
    public void executeScannerInitMethod() {

        Skkaner_.init();
    }

    @Test
    public void executeMainMethod() {
        try {
            Skkaner_.readFromFile();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void executeMainClassMethod() {
        try {
            Skkaner_.main(new String[]{""});
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}



