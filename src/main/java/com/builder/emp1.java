package com.builder;

public class emp1 {

    private final String name;
    private  final int empId;
    private  final double salary;

    emp1(String name, int empId, double salary) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }

    public int getEmpId(){
        return empId;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", salary=" + salary +
                '}';
    }
    public static class Builder{
        private  String name;
        private int empId;
        private double salary;

        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder empId(int empId){
            this.empId=empId;
            return this;
        } public Builder salary(double salary){
            this.salary=salary;
            return this;
        }
        public emp1 build(){
            emp1 emp=new emp1(name,empId,salary);
            return emp;
        }
    }
}
