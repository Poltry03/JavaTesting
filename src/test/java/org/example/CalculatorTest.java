package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void test(){
        int n;

        n = Calculator.calculator("0");
        assertEquals(0, n);

        n = Calculator.calculator("");
        assertEquals(0, n);

        n = Calculator.calculator("2");
        assertEquals(2, n);
    }

    @Test
    void testSum(){

        int n;

        n = Calculator.calculator("1,2");
        assertEquals(3, n);

    }

}