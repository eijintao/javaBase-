package com.java.base.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * mjt 梅锦涛
 * 2023/5/5
 *
 * @author mjt
 */
public class FlatMapTest {

    public static void main(String[] args) {
        List<Integer> together= Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers-> numbers.stream())
                .collect(Collectors.toList());
        System.out.println(together);


    }

}
