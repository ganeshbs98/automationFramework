package com.student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class contactRunner {
    public static void main(String[] args) {
        contactClass contact=new contactClass("Arun","8722174221");
        try{
            File f=new File("Contact.ser");
            FileOutputStream fos=new FileOutputStream(f);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(contact);
            System.out.println("Object has been serialized to " + f.getAbsolutePath());
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
