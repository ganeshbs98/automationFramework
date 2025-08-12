package FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class file3 {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/src/main/java/demo.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            fw.write("This is a demo file for writing content using FileWriter.");
            fw.close();
        } catch (IOException e) {
           e.printStackTrace();
        }

    }
}
