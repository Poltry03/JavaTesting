package org.example;

public class Calculator {
    public static int calculator(String s){

        if (s.isEmpty()){
            return 0;
        } else if (s.contains(",")) {
            String[] helper = s.split(",");
            int n = Integer.parseInt(helper[0]) + Integer.parseInt(helper[1]);
            return n;
        }

        int n = Integer.parseInt(s);
        return n;
    }

}
