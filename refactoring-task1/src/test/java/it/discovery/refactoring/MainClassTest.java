package it.discovery.refactoring;

import org.junit.Test;

import java.util.Scanner;

public class MainClassTest {

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
    public void executeWorkMethod() {
        operation = "+";
        firstArgument = "2";
        secondArgument = "3";
        scale = "10";
        isConsoleEnabled = "true";
        MainClass.calculateOperation(operation, firstArgument, secondArgument, scale, isConsoleEnabled, "");
    }

    @Test
    public void executeMainMethod() {
        operation = "+";
        firstArgument = "2";
        secondArgument = "3";
        MainClass.main(new String[]{operation, firstArgument, secondArgument});
    }

    @Test
    public void executeScanner() {

    }
}
