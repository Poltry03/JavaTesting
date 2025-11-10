package org.example;

public class Converter {
    public static int convert(String s){
        while (s.startsWith(" "))
            s = s.substring(1);

        int n = Integer.parseInt(s);

        if(n < -32768 || n > 32767){
            throw new NumberFormatException();
        }
        return n;
    }
}
