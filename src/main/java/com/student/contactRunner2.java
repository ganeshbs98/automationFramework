package com.student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class contactRunner2 {
    public static void main(String[] args) {
        FileInputStream fis;
        try{
            fis=new FileInputStream("Contact.ser");
            ObjectInputStream ois=new ObjectInputStream(fis);
            contactClass c=(contactClass)ois.readObject();
            System.out.println(c);

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();

        }
    }
}
