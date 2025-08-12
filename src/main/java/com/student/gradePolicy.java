package com.student;

public final class gradePolicy {
    private final static int A_Plus;
    private final static int A_Grade;
    private final static int B_Plus;
    private final static int B_Grade;
    private final static int C_Plus;
    private final static int C_Grade;
    private final static int D_Grade;
    private final static int PASSING_MARKS;

    private gradePolicy(){
        // Private constructor to prevent instantiation
    }

    static{
        System.out.println("Grade Policy Loaded in the System");
        A_Plus=95;
        A_Grade=90;
        B_Plus=85;
        B_Grade=80;
        C_Plus=75;
        C_Grade=70;
        D_Grade=60;
        PASSING_MARKS=33;
    }

    public static String calculateGrade(double Percentage){
        if(Percentage>=A_Plus){
            return "A+";
        } else if(Percentage>=A_Grade){
            return "A";
        } else if(Percentage>=B_Plus){
            return "B+";
        } else if(Percentage>=B_Grade){
            return "B";
        } else if(Percentage>=C_Plus){
            return "C+";
        } else if(Percentage>=C_Grade){
            return "C";
        } else if(Percentage>=D_Grade){
            return "D";
        }
        return "F";

    }



}
