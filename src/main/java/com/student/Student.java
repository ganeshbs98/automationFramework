package com.student;

public abstract class Student extends Person {
    private final int rollno;
    private final double marksObtainedInEnglish;
    private final double marksObtainedInScience;
    private final double marksObtainedInMaths;
    protected double TotalMarks;
    protected double Percentage;
    protected String Grade;
    private static int studentCount = 0;


    protected Student(StudentBuilder studentBuilder) {
        super(studentBuilder.name, studentBuilder.age, studentBuilder.contactNumber, studentBuilder.address);
        this.rollno = studentBuilder.rollno;
        this.marksObtainedInEnglish = studentBuilder.marksObtainedInEnglish;
        this.marksObtainedInMaths = studentBuilder.marksObtainedInMaths;
        this.marksObtainedInScience = studentBuilder.marksObtainedInScience;
        TotalMarks = calculateMarks();
        studentCount++;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 25 && age > 10) {
            this.age = age;
        } else {
            System.out.println("Inavlid Age");
        }
    }

    public int getRollno() {
        return rollno;
    }


    public double getTotalMarks() {
        return TotalMarks;
    }

    public double getPecentage() {
        return Percentage;
    }

    public double getMarksObtainedInEnglish() {
        return marksObtainedInEnglish;
    }


    public double getMarksObtainedInScience() {
        return marksObtainedInScience;
    }


    public double getMarksObtainedInMaths() {
        return marksObtainedInMaths;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (validateAddress(address)) {
            this.address = address;
        }
    }

    public String getcontactNumber() {
        return contactNumber;
    }

    public void setcontactNumber(String contactNumber) {
        if (validateContactNumber(contactNumber)) {
            this.contactNumber = contactNumber;
        }
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public boolean validateContactNumber(String contactNumber) {
        if (!contactNumber.isEmpty() && contactNumber.matches("\\d{10}")) {
            return true;
        }
        System.err.println("Invalid Phone Number");
        return false;
    }

    public boolean validateAddress(String address) {
        if (address.length() > 0 && !address.isBlank()) {
            return true;

        }
        System.err.println("Invalid Address");
        return false;
    }

    public final double calculateMarks() {
        double TotalMarks = marksObtainedInEnglish + marksObtainedInMaths + marksObtainedInScience;
        return TotalMarks;

    }

    public abstract double calculatePercentage();

    public final String calculateGrade() {
        String Grade;
        if (Percentage == 0) {
            Grade = "Cannot calculate the Grade";
        } else {
            Grade = gradePolicy.calculateGrade(Percentage);
        }
        return Grade;
    }

    public boolean validateAge(int age) {
        if (age <= 25 && age >= 10) {
            return true;
        }
        System.err.println("Invalid Age ");
        return false;
    }

    public boolean validateRollNumber(int rollno) {
        if (rollno >= 1 && rollno <= 100) {
            return true;
        }
        System.err.println("Invalid Rollno");
        return false;
    }

    public boolean validateMarks(double marks) {
        if (marks > 100 || marks < 0) {
            System.err.println("Invalid marks ");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "management_System2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rollno=" + rollno +
                ", marksObtainedInEnglish=" + marksObtainedInEnglish +
                ", marksObtainedInScience=" + marksObtainedInScience +
                ", marksObtainedInMaths=" + marksObtainedInMaths +
                ", TotalMarks=" + TotalMarks +
                ", Pecentage=" + Percentage +
                ", contactNumber=" + contactNumber +
                ", Address=" + address +
                ", Grade='" + Grade + '\'' +
                '}';
    }

    public boolean displayStudentInfo() {
        System.out.println("=======Student Details========");
        System.out.println("Name :" + name);
        System.out.println("Age :" + age);
        System.out.println("Roll No :" + rollno);
        System.out.println("Contact Number :" + contactNumber);
        System.out.println("Address :" + address);
        System.out.println("Marks Obtained in English :" + marksObtainedInEnglish);
        System.out.println("Marks Obtained in Science :" + marksObtainedInScience);
        System.out.println("Marks Obtained in Maths :" + marksObtainedInMaths);

        System.out.println("==============================");
        System.out.println("Total Marks :" + TotalMarks);
        System.out.println("Percentage :" + Percentage);
        System.out.println("Grade :" + Grade);
        System.out.println("===============================");


        return false;
    }

    public void updateInformation(String newAddress, String newContactNumber) {
        if (parentApproval()) {
            super.UpdateInformation(newAddress, newContactNumber);
        } else {
            System.err.println("Get the Approval from your parent");
        }
    }


    private boolean parentApproval() {
        return true;
    }

    public abstract static class StudentBuilder {
        //mandatory fields
        protected String name;
        protected int age;
        protected String contactNumber;
        protected String address;
        //Option fields
        private int rollno;
        private double marksObtainedInEnglish;
        private double marksObtainedInScience;
        private double marksObtainedInMaths;

        protected StudentBuilder(String name, int age, String contactNumber, String address) {
            if (validateAge(age) && validateContactNumber(contactNumber) && validateAddress(address)) {
                this.name = name;
                this.age = age;
                this.contactNumber = contactNumber;
                this.address = address;
            }
        }

        public StudentBuilder withRollno(int rollno) {
            this.rollno = rollno;
            return this;
        }

        public StudentBuilder withMarksObtainedInEnglish(int marksObtainedInEnglish) {
            this.marksObtainedInEnglish = marksObtainedInEnglish;
            return this;
        }

        public StudentBuilder withMarksObtainedInScience(int marksObtainedInScience) {
            this.marksObtainedInScience = marksObtainedInScience;
            return this;
        }

        public StudentBuilder withMarksObtainedInMaths(int marksObtainedInMaths) {
            this.marksObtainedInMaths = marksObtainedInMaths;
            return this;
        }

        private boolean validateContactNumber(String contactNumber) {
            if (!contactNumber.isEmpty() && contactNumber.matches("\\d{10}")) {
                return true;
            }
            System.err.println("Invalid Phone Number");
            return false;
        }

        private boolean validateAddress(String address) {
            if (address.length() > 0 && !address.isBlank()) {
                return true;
            }
            System.err.println("Invalid Address");
            return false;
        }

        private boolean validateAge(int age) {
            if (age <= 25 && age >= 10) {
                return true;
            }
            System.err.println("Invalid Age ");
            return false;
        }

        private boolean validateName(String name) {
            if (name != null && !name.trim().isEmpty()) {
                return true;
            }
            System.err.println("Invalid Name");
            return false;
        }

        public abstract Student build();

    }


}
