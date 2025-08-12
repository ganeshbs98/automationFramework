package FileHandling;

import java.io.File;

public class file2 {
    public static void main(String[] args) {
        File myFile = new File(System.getProperty("user.dir") + "/src/main/java/demo.txt");
        System.out.println(myFile.getName());
        System.out.println(myFile.getAbsolutePath());
        System.out.println(myFile.getAbsoluteFile());
        System.out.println(myFile.isFile());
        System.out.println(myFile.canExecute());
        System.out.println(myFile.canRead());
        System.out.println(myFile.canWrite());
        System.out.println(myFile.isDirectory());
    }
}
