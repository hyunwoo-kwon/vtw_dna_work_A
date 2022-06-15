package com.vtw.dna;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FuntionTest {

    public static void main(String[] args){

        String totalScreenSeat = "E";

//        System.out.println(totalScreenSeat.charAt(0)+1);

        char c = totalScreenSeat.charAt(0);

        for(char i = c; i >='A' ; i--){
            for(char j = 'A'; j <= i ; j++)
                System.out.println((char)j);
            System.out.println();
        }


//        String[] intArray = { "hello world", "yellow", "green", "hello", "red", "blue"};
//        Set<String> set = Arrays.asList(intArray)
//                .stream()
//                .filter(e -> e.startsWith("hello"))
//                .collect(Collectors.toSet());
//        set.forEach(e-> System.out.println(e));

    }
}
