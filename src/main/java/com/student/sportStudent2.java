package com.student;

public class sportStudent2 extends Student{

    private double sportScore;

    sportStudent2(StudentBuilder studentBuilder) {
        super(studentBuilder);
    }

    @Override
    public double calculatePercentage() {
        return 0;
    }
    public static class sportStudentBuilder{
        private double sportScore;


    }
}
