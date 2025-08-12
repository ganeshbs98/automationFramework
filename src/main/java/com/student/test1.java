package com.student;

import java.util.stream.IntStream;

public class test1 {
    public static void main(String[] args) {
        String x="this is a sample string";
        int indextoUppercase=0;
        StringBuilder s=new StringBuilder();
        for(int i=0;i<x.length();i++){
            if(x.charAt(i) !=' '){
                indextoUppercase++;
                if(indextoUppercase%3==0){
                   s.append(Character.toUpperCase(x.charAt(i)));
                }else{
                    s.append(x.charAt(i));
                }
            }else{
                s.append(x.charAt(i));
            }
        }
        System.out.println(s);
    }


}
