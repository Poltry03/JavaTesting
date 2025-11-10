package org.example;

public class Calculator {
    public static int Add(String s) {

        if (s.isEmpty()) {
            return 0;
        } else if (s.toCharArray()[0] == '/' && s.toCharArray()[1] == '/') {
            String regex = "" + s.toCharArray()[2];

            String[] helper = s.substring(4).split(regex);

            int n = 0;

            for (int i = 0; i < helper.length; i++) {
                int numHelper = Integer.parseInt(helper[i]);
                NegNotAllowed(numHelper);
                n += numHelper;
            }
            return n;

        } else if (s.contains(",") || s.contains("\n")) {
            String[] helper = s.split("[, \n]");

            int n = 0;

            for (int i = 0; i < helper.length; i++) {
                int numHelper = Integer.parseInt(helper[i]);
                NegNotAllowed(numHelper);
                n += numHelper;
            }
            return n;
        }

        int n = Integer.parseInt(s);
        return n;
    }
    private static void NegNotAllowed(int n){
        if (n < 0){
            throw new RuntimeException("Negative number not allowed: "+ n );
        }
    }
}
