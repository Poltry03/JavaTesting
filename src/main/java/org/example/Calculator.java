package org.example;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator {
    public static int Add(String s) {

        if (s.isEmpty()) {
            return 0;
        } else if (s.toCharArray()[0] == '/' &&
                s.toCharArray()[1] == '/' &&
                s.contains("][")) {

            int end = s.indexOf('\n');

            String metaRegex = "]\\[";

            String[] regex = s.substring(3, end - 1).split(metaRegex);

            String pattern = "";

            for (int i = 0; i < regex.length; i++){
                pattern += Pattern.quote(regex[i]);
                if (i != regex.length - 1) {
                    pattern += "|";
                }
            }

            String[] helper = s.substring(end + 1).split(pattern);

            return UsefulSum(helper);

        } else if (s.toCharArray()[0] == '/' &&
                s.toCharArray()[1] == '/' &&
                s.toCharArray()[2] == '[') {

            int end = s.indexOf("]");

            String regex;

            regex = Pattern.quote(s.substring(3, end));
            String[] helper = s.substring(end + 2).split(regex);

            return UsefulSum(helper);

        } else if (s.toCharArray()[0] == '/' && s.toCharArray()[1] == '/') {
            String regex = "" + s.toCharArray()[2];

            String[] helper = s.substring(4).split(regex);

            return UsefulSum(helper);

        } else if (s.contains(",") || s.contains("\n")) {
            String[] helper = s.split("[, \n]");

            return UsefulSum(helper);
        }

        int n = Integer.parseInt(s);
        return n;
    }

    private static int UsefulSum(String[] helper) {
        int n = 0;
        ArrayList<Integer> negs = new ArrayList<>();

        for (int i = 0; i < helper.length; i++) {
            int numHelper = Integer.parseInt(helper[i]);

            if (numHelper < 0) {
                negs.add(numHelper);
            } else if (numHelper > 1000) {
                ;
            } else {
                n += numHelper;
            }
        }
        NegNotAllowed(negs);
        return n;
    }

    private static void NegNotAllowed(ArrayList<Integer> n) {
        if (!n.isEmpty()) {
            throw new RuntimeException("Negative number not allowed: " + n);
        }
    }
}
