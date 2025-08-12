package com.student;

public class sportStudent extends Student{
    private double sportScore;

    protected sportStudent(StudentBuilder studentBuilder) {
        super(studentBuilder);
        this.sportScore=((sportStudentBuilder)studentBuilder).sportScore;
        Percentage = calculatePercentage();
        Grade = calculateGrade();

    }

    @Override
    public double calculatePercentage() {
        double acdemicPercenatge = getTotalMarks()/3.0;
        double finalPercentage = (acdemicPercenatge*0.8) + (sportScore*0.2);
        return finalPercentage;
    }

    public static class sportStudentBuilder extends StudentBuilder {
        private double sportScore;

        public sportStudentBuilder(String name, int age, String contactNumber, String address) {
            super(name, age, contactNumber, address);
        }
        public sportStudentBuilder WithSportScore(double sportScore) {
            if(sportScore>=0 && sportScore<=100) {
                this.sportScore = sportScore;
            } else {
                System.out.println("Invalid Sport Score");
            }
            return this;
        }

        @Override
        public Student build() {
            Student s1 = new sportStudent(this);
            return s1;
        }
    }
}
