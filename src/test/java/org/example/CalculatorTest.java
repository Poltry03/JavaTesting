package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void test(){
        int n;

        n = Calculator.Add("0");
        assertEquals(0, n);

        n = Calculator.Add("");
        assertEquals(0, n);

        n = Calculator.Add("2");
        assertEquals(2, n);
    }

    @Test
    void testSum(){

        int n;

        n = Calculator.Add("1,2");
        assertEquals(3, n);
    }

    @Test
    void testSumThreeOrMore(){

        int n = Calculator.Add("1,2,3");
        assertEquals(6, n);

        n = Calculator.Add("1\n2,3");
        assertEquals(6, n);
    }

    @Test
    void testWithRegex(){
        int n = Calculator.Add("//;\n1;2");
        assertEquals(3, n);
    }

    @Test
    void testWithNeg(){
        try {
            Calculator.Add("1,-2,-3");
            fail("Dovrebbe lanciare un'errore");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    void testHighNum(){
        int n = Calculator.Add("1,2,3000");
        assertEquals(3, n);
    }

}