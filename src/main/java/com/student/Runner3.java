package com.student;

public class Runner3 {
    public static void main(String[] args) {
        Student s1=new regularStudent.regularStudentBuilder("ganesh",20,"1234567890","pune").withRollno(897)
                .withMarksObtainedInEnglish(98).withMarksObtainedInMaths(70).withMarksObtainedInScience(89)
                .build();
        System.out.println(s1);

        Student s2=new sportStudent.sportStudentBuilder("name",23,"2315712879","hydrabad").WithSportScore(80).withRollno(897)
                .withMarksObtainedInEnglish(98).withMarksObtainedInMaths(70).withMarksObtainedInScience(89)
                .build();
        System.out.println(s2);
    }
}
