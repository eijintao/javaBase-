package com.java.base.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class MapTest {

    static final int TREEIFY_THRESHOLD = 8;

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        Object put = map.put("123", 1);

        map.get("123");


        int i = 7;
        if (i >= TREEIFY_THRESHOLD -1) {
            System.out.println(i + ">= 8 -1是true");
        } else {
            System.out.println(i + ">= 8 -1是false");
        }


    }

}
