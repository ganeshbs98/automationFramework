package FileHandling;

import java.io.*;

public class bufferWriterEx {
    public static void main(String[] args) throws IOException {
//        File myFile = new File(System.getProperty("user.dir") + "/src/main/java/FileHandling/demo.txt");
//        FileReader file = new FileReader(myFile);
//        BufferedReader br=new BufferedReader(file);
//        String data=null;
//        int count=0;
//        int totallengthof_character=0;
//        while((data=br.readLine())!=null){
//            count++;
//            System.out.println(data);
//            totallengthof_character+=data.length();
//        };
//        System.out.println("Total number of lines in the file: " + count);
//        System.out.println("Total number of characters in the file: " + totallengthof_character);

        longestWordinFile("/src/main/java/FileHandling/demo.txt");
        copyAndPasteTehFile("/src/main/java/FileHandling/demo.txt");


    }

    public static void longestWordinFile(String FilePath) {
        File file = new File(System.getProperty("user.dir") + FilePath);
        FileReader fr;
        BufferedReader br;
        String data = null;
        int maxllengthOfWord = Integer.MIN_VALUE;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((data = br.readLine()) != null) {
                String[] words = data.split(" ");
                for (String word : words) {
                    if (word.length() > maxllengthOfWord) {
                        maxllengthOfWord = word.length();
                    }
                }
            }
            System.out.println("Longest word in the file is: " + maxllengthOfWord);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyAndPasteTehFile(String filepath) {
        FileReader fr;
        BufferedReader br;
        FileWriter Fr;
        BufferedWriter BR;
        String Data = null;
        try {
            File sourceFile = new File(System.getProperty("user.dir")+filepath);
            br = new BufferedReader(new FileReader(sourceFile));
            File Destination = new File(System.getProperty("user.dir") + "/src/main/java/FileHandling/copy.txt");
            BR = new BufferedWriter(new FileWriter(Destination));
            while ((Data = br.readLine()) != null) {
                BR.write(Data);
                BR.newLine(); // To maintain the line breaks
            }
            BR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
