package FileHandling;

import java.io.File;
import java.io.IOException;

public class file1 {
    public static void main(String[] args) {

        File myFile = new File(System.getProperty("user.dir") + "/src/main/java/demo1.txt");
        if (myFile.exists()) {
            System.out.println(myFile.getName());
            System.out.println(myFile.getAbsolutePath());
            System.out.println("File exists: " + myFile.getAbsolutePath());
            myFile.delete();

        } else {
            try {
                if (myFile.createNewFile()) {
                    System.out.println(myFile.getName() + " created successfully.");
                }
//                myFile.deleteOnExit();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
