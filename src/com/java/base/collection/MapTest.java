package com.java.base.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
//        Object put = map.put("123", 1);
//        map.put("234",45);
//        map.put("lisi","李四");
//        System.out.println(map.get("wang_kai")); // null
//        map.put("saner","三儿");
//        map.put("wangwu","王五");
        map.put("234",49);

//        map.get("123");
//        System.out.println(map.size());

        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(map);
//        Map<String, Object> stringObjectMap = Optional.ofNullable(mapList).map(x -> x.get(0)).orElseGet(() -> {
//            return null;
//        } );
        Map<String, Object> stringObjectMap = mapList.get(0);
        System.out.println(stringObjectMap);
        System.out.println(stringObjectMap.get("lisi"));

//        int i = 7;
//        if (i >= TREEIFY_THRESHOLD -1) {
//            System.out.println(i + ">= 8 -1是true");
//        } else {
//            System.out.println(i + ">= 8 -1是false");
//        }


    }

}
