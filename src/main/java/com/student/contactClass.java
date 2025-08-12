package com.student;

import java.io.Serializable;

public class contactClass implements Serializable {
    private String name;
    private String contactNumber;

    contactClass(String name,String contactNumber){
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "contactClass{" +
                "name='" + name + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
