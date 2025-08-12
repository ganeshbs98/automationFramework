package com.builder;

public class employee {
    private  String name;
    private int EmpId;
    private double salary;

    employee(String name,int EmpId,double salary){
        this.name=name;
        this.EmpId=EmpId;
        this.salary=salary;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getEmpId(){
        return EmpId;
    }
    public void setEmpid(int EmpId){
        this.EmpId=EmpId;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", EmpId=" + EmpId +
                ", salary=" + salary +
                '}';
    }


    public static class Builder{
        private String name;
        private int EmpId;
        private double salary;

        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder empId(int empId){
            this.EmpId=empId;
            return this;
        }
        public Builder salary(double salary){
            this.salary=salary;
            return this;
        }
        public employee build(){
            employee emp1=new employee(name, EmpId, salary);
            return emp1;
        }

    }
}
