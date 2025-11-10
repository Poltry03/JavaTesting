package org.example;

import java.util.ArrayList;

public class Calculator {
    public static int Add(String s) {

        if (s.isEmpty()) {
            return 0;
        } else if (s.toCharArray()[0] == '/' && s.toCharArray()[1] == '/') {
            String regex = "" + s.toCharArray()[2];

            String[] helper = s.substring(4).split(regex);

            int n = 0;
            ArrayList<Integer> negs = new ArrayList<>();

            for (int i = 0; i < helper.length; i++) {
                int numHelper = Integer.parseInt(helper[i]);

                if (numHelper < 0) {
                    negs.add(numHelper);
                } else {
                    n += numHelper;
                }
            }
            NegNotAllowed(negs);
            return n;

        } else if (s.contains(",") || s.contains("\n")) {
            String[] helper = s.split("[, \n]");

            int n = 0;
            ArrayList<Integer> negs = new ArrayList<>();

            for (int i = 0; i < helper.length; i++) {
                int numHelper = Integer.parseInt(helper[i]);
                if (numHelper < 0){
                    negs.add(numHelper);
                } else {
                n += numHelper;
                }
            }
            NegNotAllowed(negs);
            return n;
        }

        int n = Integer.parseInt(s);
        return n;
    }
    private static void NegNotAllowed(ArrayList<Integer> n){
        if (!n.isEmpty()){
            throw new RuntimeException("Negative number not allowed: "+ n );
        }
    }
}
