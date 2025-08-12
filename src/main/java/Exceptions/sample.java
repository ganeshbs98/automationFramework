package Exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class sample {
    public static void main(String[] args) {
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            file = new File("/Users/ganeshbs/IdeaProjects/RegessionUI3/Assigment/src/main/java/demo.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String data = bufferedReader.readLine();
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
