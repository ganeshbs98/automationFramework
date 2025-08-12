package com.student;

public class Teacher extends Person {

    private String empId;
    private  String subject;
    private int yearsOfExperience;
    private double salary;
    private static final double BASE_SALARY = 30000;
    private static final double EXPERIENCE_SALARY_BONUS = 2000;
    private static int teacherCount=0;


    public Teacher(String name, int age, String address, String contactNumber, String empId, String subject, int yearsOfExperience) {
        super(name, age, contactNumber, address);
        if (validate_age(age) && validateAddress(address) && validateContactNumber(contactNumber) && validateEmpId(empId) && validateYearofExperice(yearsOfExperience)) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.contactNumber = contactNumber;
            this.empId = empId;
            this.subject = subject;
            this.yearsOfExperience = yearsOfExperience;
            calculateSalary();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (validateYearofExperice(yearsOfExperience)) {
            this.yearsOfExperience = yearsOfExperience;
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subjectd) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (validateAddress(address)) {
            this.address = address;
        }
    }

    public String getEmpId() {
        return empId;
    }

    public double salary() {
        return salary;
    }


    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        if (validateContactNumber(contactNumber)) {
            this.contactNumber = contactNumber;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (validate_age(age)) {
            this.age = age;
        }
    }

    protected final void calculateSalary() {
        salary = BASE_SALARY + (yearsOfExperience * EXPERIENCE_SALARY_BONUS);
    }

    public static int getTeacherCount(){
        return teacherCount;
    }


    public boolean validate_age(int age) {
        if (age >= 25 && age <= 65) {
            return true;
        }
        System.err.println("Invalid age");
        return false;

    }

    public boolean validateContactNumber(String contactNumber) {
        if (!contactNumber.isEmpty() && contactNumber.matches("\\d{10}")) {
            return true;
        }
        System.err.println("Invalid Contact number");
        return false;
    }

    public boolean validateAddress(String address) {
        if (!address.isEmpty()) {
            return true;
        }
        System.err.println("Inavlid Address");
        return false;
    }

    public boolean validateYearofExperice(int yearsOfExperience) {
        if (yearsOfExperience >= 0 && yearsOfExperience <= 35) {
            return true;
        }
        System.err.println("Invalid YearsOfExperience");
        return false;
    }

    public boolean validateEmpId(String empId) {
        if (empId.matches("T\\d{3}") && empId.length() == 4) {
            return true;
        }
        System.err.println("Invalid EmployeeId");
        return false;
    }

    public void displayTeacherDetails() {
        System.out.println("=======Teacher Details========");
        System.out.println("Name :" + name);
        System.out.println("Age :" + age);
        System.out.println("Contact :" + contactNumber);
        System.out.println("address :" + address);
        System.out.println("Employee ID : " + empId);
        System.out.println("Subject :" + subject);
        System.out.println("YearsOfExperience :" + yearsOfExperience);
        System.out.println("Salary :" + "$ " + salary);
        System.out.println("===============================");

    }

    @Override
    public String toString() {
        return "TeacherManagement{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                ", EmpId='" + empId + '\'' +
                ", SubjectTeached='" + subject + '\'' +
                ", salary=" + salary +
                '}';
    }


    public void updateInformation(String newAddress, String newContactNumber) {
        if (hrApproval()) {
            super.UpdateInformation(newAddress, newContactNumber);
            System.out.println("Updated Information Successfully");
        } else {
            System.err.println("Failed to update information. Please check the provided details.");
        }
    }


    private boolean hrApproval() {
        return true; // Simulating HR approval
    }
}
