package com.ui.test;

public class test {
    public static void main(String[] args) {
        String input = "HellOwoLD";
        int currentCount =0;
        int Start = -1;
        int maxCount = 0;
        int End = -1;
        int currentStart=0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                if (currentCount == 0) {
                    currentStart = i;
                }
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    Start = currentStart;
                    End = i;
                }
            } else {
                currentCount = 0;
            }
        }
        String part1 = new StringBuilder(input.substring(0, Start).toLowerCase()).reverse().toString();
        String part2 = new StringBuilder(input.substring(End + 1, input.length()).toLowerCase()).reverse().toString();
        String part3 = new StringBuilder(input.substring(Start, End + 1)).toString();
        String outPut = part1 + part3 + part2;

        System.out.println("longest subset for Uppercase is :-->" + maxCount + " start word is -->" + input.charAt(Start) + "\n and end word is -->" + input.charAt(End) + "the final output-->" + outPut);
    }

}
