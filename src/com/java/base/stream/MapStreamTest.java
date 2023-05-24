package com.java.base.stream;

import java.util.Map;

/**
 * mjt 梅锦涛
 * 2023/5/14
 *
 * @author mjt
 */
public class MapStreamTest {

    public static void main(String[] args) {

        Map<String, Integer> stringIntegerMap = Map.ofEntries(Map.entry("a", 1), Map.entry("b", 2), Map.entry("c", 3));
        System.out.println(stringIntegerMap);

    }

}
