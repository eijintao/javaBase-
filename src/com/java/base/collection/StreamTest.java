package com.java.base.collection;

import java.io.InputStream;
import java.util.stream.IntStream;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class StreamTest {

    public static void main(String[] args) {

        // 判断条件里的元素，所有的都是，返回true
        IntStream stream = IntStream.of(1,2,3,4,5,6);
        boolean answer = stream.allMatch(num -> (num -5)>0);
        System.out.println(answer);// false

        // 判断的条件里，任意一个元素成功，返回true
        IntStream stream2 = IntStream.of(1,2,3,4,5,6);
        boolean answer2 = stream2.anyMatch(num -> (num -5)>0);
        System.out.println(answer2);// true

        // 与allMatch相反，判断条件里的元素，所有的都不是，返回true
        IntStream stream3 = IntStream.of(1,2,3,4,5,6);
        boolean answer3 = stream3.noneMatch(num -> (num -5)>0);
        System.out.println(answer3);// false


    }

}
