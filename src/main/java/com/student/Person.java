package com.student;

public class Person {
    protected String name;
    protected int age;
    protected String contactNumber;
    protected String address;
    private static int personCount = 0;

    public Person(String name, int age, String contactNumber, String address) {
        if (validateName(name)  && validateContactNumber(contactNumber) && validateAddress(address)) {
            this.name = name;
            this.age = age;
            this.contactNumber = contactNumber;
            this.address = address;
            personCount++;
        } else {
            throw new IllegalArgumentException("Invalid input data");
        }
    }

    public static int getPersonCount(){
        return personCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (validateName(name)) {
            this.name = name;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (validateAddress(address)) {
            this.address = address;
        }
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

            this.age = age;

    }
    public boolean validateName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            return true;
        }
        System.err.println("Invaliid name");
        return false;
    }


    public boolean validateContactNumber(String contactNumber) {
        if (contactNumber != null && contactNumber.matches("\\d{10}")) {
            return true;
        }
        System.err.println("Invalid Contact number");
        return false;
    }

    public boolean validateAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            return true;
        }
        System.err.println("Invalid Address");
        return false;
    }
    protected void UpdateInformation(String newAddress,String contactNumber){
        if (validateAddress(newAddress) &&validateContactNumber(contactNumber)) {
            this.address = newAddress;
            this.contactNumber = contactNumber;
            System.out.println("Updated Information Successfully");
        }
    }
    protected  void UpdateInformation(String newAddress){
        if (validateAddress(newAddress)) {
            this.address = newAddress;
            System.out.println("Updated Information Successfully");
        }
    }
    protected  void UpdateInformation(String newContactNumber,boolean update){
        if (validateContactNumber(newContactNumber)) {
            this.contactNumber = newContactNumber;
            System.out.println("Updated Information Successfully");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
