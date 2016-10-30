package it.discovery.refactoring;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        int result = Calculator.calculate("+", "2", "3", "10", "true", "");
        assertEquals(result, 0);
    }

    @Test
    //Given_When_Then
    public void calculate_SumArgumentNonNumber_Error() {
        int result = Calculator.calculate("+", "aaa", "2", "10", "true", "");
        assertEquals(result, -1);
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
}
