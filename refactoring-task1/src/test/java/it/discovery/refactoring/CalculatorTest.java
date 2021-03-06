package it.discovery.refactoring;


import org.junit.Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalculatorTest {


    public String operation;
    public String firstArgument;
    public String secondArgument;
    public String scale;
    public String isConsoleEnabled;



    @Test
    public void test_() {
        System.out.println("OK!");
    }

    @Test
    //Given_When_Then
    public void calculate_SumWithDecimalScaleAndConsoleOutput_Success() {
        Calculator.calculate(new Operation("+", "2", "3", "10", "true"));
        assertEquals(Calculator.getReport(), "Nachali rabotu\n" +
                "Operaciya slojit\n" +
                "Argument 1 2\n" +
                "Argument 2 3\n" +
                "Rezultat 5\n" +
                "Zakonchili rabotu\n");
        
    }

    @Test
    //Given_When_Then
    public void calculate_SumWithDecimalScaleAndFileOutput_Success() {
        Calculator.calculate(new Operation("+", "2", "3", "10", "false"));
        assertEquals(Calculator.getReport(), "Nachali rabotu\n" +
                "Operaciya slojit\n" +
                "Argument 1 2\n" +
                "Argument 2 3\n" +
                "Rezultat 5\n" +
                "Zakonchili rabotu\n");
        
    }
    
    @Test
    //Given_When_Then
    public void calculateReport_SumWithDecimalScaleAndConsoleOutput_Success() {
        try {
			String report = Calculator.calculateReport(new Operation("+", "2", "3", "10", "true"));
			assertEquals(report, "Nachali rabotu\n" +
	                "Operaciya slojit\n" +
	                "Argument 1 2\n" +
	                "Argument 2 3\n" +
	                "Rezultat 5\n" +
	                "Zakonchili rabotu\n");
		} catch (IOException e) {
			fail(e.getMessage());
		}
        
       
    }
    
    @Test
    //Given_When_Then
    public void calculate_DecreaseWithDecimalScaleAndConsoleOutput_Success() {
        Calculator.calculate(new Operation("-", "5", "2", "10", "true"));
        assertEquals(Calculator.getReport(), "Nachali rabotu\n" +
                "Operaciya vychitanie\n" +
                "Argument 1 5\n" +
                "Argument 2 2\n" +
                "Rezultat 3\n" +
                "Zakonchili rabotu\n");
        
    }

    @Test
    public void calculate_SumWithBinaryScaleAndConsoleOutput_Success() {
        Calculator.calculate(new Operation("+", "1", "5", "2", "true"));
        assertEquals(Calculator.getReport(),
                "Nachali rabotu\n" +
                "Operaciya slojit\n" +
                "Argument 1 1\n" +
                "Argument 2 101\n" +
                "Rezultat 110\n" +
                "Zakonchili rabotu\n");
        
    }

    @Test
    public void calculate_SumWithOctalScaleAndConsoleOutput_Success() {
        Calculator.calculate(new Operation("+", "2", "8", "8", "true"));
        assertEquals(Calculator.getReport(),
                "Nachali rabotu\n" +
                        "Operaciya slojit\n" +
                        "Argument 1 2\n" +
                        "Argument 2 10\n" +
                        "Rezultat 12\n" +
                        "Zakonchili rabotu\n");
        
    }

    @Test
    public void calculate_SumWithHexScaleAndConsoleOutput_Success() {
        Calculator.calculate(new Operation("+", "5", "12", "16", "true"));
        assertEquals(Calculator.getReport(),
                "Nachali rabotu\n" +
                        "Operaciya slojit\n" +
                        "Argument 1 5\n" +
                        "Argument 2 c\n" +
                        "Rezultat 11\n" +
                        "Zakonchili rabotu\n");
        
    }

    @Test
    //Given_When_Then
    public void calculate_MultiplyWithDecimalScaleAndConsoleOutput_Success() {
        Calculator.calculate(new Operation("*", "2", "3", "10", "true"));
        assertEquals(Calculator.getReport(), "Nachali rabotu\n" + "Operaciya umnojeniya\n" +
                "Argument 1 2\n" + "Argument 2 3\n" + "Rezultat 6\n" + "Zakonchili rabotu\n");
        
    }

    @Test(expected = RuntimeException.class)
    //Given_When_Then
    public void calculate_SumFirstArgumentNonNumber_Error() {
        Calculator.calculate(new Operation("+", "aaa", "2", "10", "true"));
        
    }
    @Test(expected = RuntimeException.class)
    //Given_When_Then
    public void calculate_SumSecondArgumentNonNumber_Error() {
        Calculator.calculate(new Operation("+", "2", "bb", "10", "true"));
        
    }


    @Test
    public void executeMainMethod() {
        operation = "+";
        firstArgument = "2";
        secondArgument = "3";
        Calculator.main(new String[]{operation, firstArgument, secondArgument});

    }

    @Test
    public void executeScanner() {

    }

    @Test
    public void saveToFile_SumWithDecimalScaleAndConsoleOutput_Succes() {


    }
}
