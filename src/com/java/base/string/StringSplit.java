package com.java.base.string;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * mjt 梅锦涛
 * 2023/5/11
 *
 * @author mjt
 */
public class StringSplit {

    public static void main(String[] args) {


        //String[] str = {"Hello", "World"};
        //for (String s : str) {
        //    String[] split = s.split("");
        //    for (String s1 : split) {
        //        System.out.println(s1);
        //    }
        //}

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

        //streamOfwords.map(word -> word.split(""))
        //        .flatMap(Arrays::stream)
        //        .distinct()
        //        .forEach(System.out::println);

        Stream.of(arrayOfWords).map(word -> word.split(""))
                // 让每个数组变成一个单独的流
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);


    }

}
