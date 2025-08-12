package com.student;

public class regularStudent extends Student {

   protected regularStudent(StudentBuilder studentBuilder) {
        super(studentBuilder);
       Percentage = calculatePercentage();
       Grade = calculateGrade();

   }

    @Override
    public double calculatePercentage() {
       double Percentage=TotalMarks/3.0;
       return Percentage;
    }

    public static class regularStudentBuilder extends StudentBuilder {
        public regularStudentBuilder(String name, int age, String contactNumber, String address) {
            super(name, age, contactNumber, address);
        }

        @Override
        public Student build() {
           Student s1=new regularStudent(this);
           return s1;
        }
    }


}
