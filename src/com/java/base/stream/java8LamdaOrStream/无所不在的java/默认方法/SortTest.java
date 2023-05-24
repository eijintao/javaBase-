package com.java.base.stream.java8LamdaOrStream.无所不在的java.默认方法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * mjt 梅锦涛
 * 2023/5/15
 *
 * @author mjt
 */
public class SortTest {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(3, 5, 1, 2, 4);
        integers.sort(Comparator.naturalOrder());
        System.out.println(integers);// [1, 2, 3, 4, 5]
    }

}
