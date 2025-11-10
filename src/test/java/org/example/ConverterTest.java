package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    void test(){
        int n = Converter.convert("123");
        assertEquals(123, n);
    }

    @Test
    void testNotNumber(){
        try{
            int n = Converter.convert("ciao");
            fail("Not number converted");
        } catch (Exception e) {
        }
    }
    @Test
    void testTrailingSpaces(){
        try{
            int n = Converter.convert("    345");
        } catch (Exception e) {
            fail("Spazi non  rimossi");
        }
    }
    @Test
    void testMinus(){
        int n = Converter.convert("-123");
        assertEquals(-123, n);
    }

    @Test
    void testRange(){
        try{
            int n = Converter.convert("32768");
            fail("Out of range");
        } catch (Exception e) {
        }
    }

}