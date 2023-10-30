package com.java.base.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mjt 梅锦涛
 * 2023/5/14
 *
 * @author mjt
 */
public class ArraysLIstTest {

    public static void main(String[] args) {

        // 你创建了一个固定大小的列表，列表的元素可以更新，但不能增加或者删除
        //List<String> stringList =  new java.util.ArrayList<>(Arrays.asList("a", "b", "c"));
        //for (String s : stringList) {
        //    if ("c".equals(s)) {
        //        stringList.remove(s);
        //    }
        //
        //}
        //System.out.println(stringList);


    //    ArrayList下标越界异常的demo  数字会越界，但对象不会。所以，在使用ArrayList时，remove时尽量使用对象，而不是数字。
        //    因为数字remove会当成下标，而对象remove会当成对象。
        // 创建一个包含元素 1、2、3、4 和 5 的 ArrayList 对象
                List<String> myList = new ArrayList<>();
                myList.add("1");
                myList.add("2");
                myList.add("3");
                myList.add("4");
                myList.add("5");

                // 删除索引为 5 的元素，会抛出下标越界异常
        for (int i = 0; i < myList.size(); i++) {
            if ("2".equals(myList.get(i))) {
                //boolean remove = myList.remove(myList.get(i));
                //System.out.println(remove);

                String remove = myList.remove(i);
                System.out.println(remove);

            }
        }
        System.out.println(myList);






        //    创建一个可变的ArrayList集合
    //    List<String> str = new java.util.ArrayList<>(Arrays.asList("a", "b", "c"));
        //for (String s : str) {
        //    if ("a".equals(s)) {
        //        str.removeIf(x -> x.equals("a"));   // 会报错
        //    }
        //}

        //str.removeIf(x -> x.equals("a"));
        //System.out.println(str);

    }

}



class dataxCloumnOrderTest {

    public static void main(String[] args) {

        List<String> rdbmsColumns = new ArrayList<>();
        rdbmsColumns.add("date");
        rdbmsColumns.add("user");
        rdbmsColumns.add("day");

        String source_db_partitions = "date,day";
        String[] split = source_db_partitions.split(",");
        for (int i = 0; i < rdbmsColumns.size(); i++) {
            for (String source_db_partition : split) {
            //    如果rdbmsColumns中包含source_db_partition，就把source_db_partition放到rdbmsColumns的最后
                if (rdbmsColumns.get(i).equals(source_db_partition)) {
                    rdbmsColumns.remove(i);
                    rdbmsColumns.add(source_db_partition);
                }
            }
        }

        System.out.println(rdbmsColumns);

        getMap();

    }



    private static void getMap() {
        /**
         *   [
         *         {
         *             "type": "string",
         *                 "name": "`DATE`"
         *         },
         *         {
         *             "type": "string",
         *                 "name": "USER_NAME"
         *         },
         *         {
         *             "type": "string",
         *                 "name": "MENU_CODE"
         *         }
         * ]
         *
         *
         */
    //   将 [
        //    {
        //        "type": "string",
        //        "name": "`DATE`"
        //    },
        //    {
        //        "type": "string",
        //        "name": "USER_NAME"
        //    },
        //    {
        //        "type": "string",
        //        "name": "MENU_CODE"
        //    }
        //] 转换成  List<Map<String, Object>>的形式
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("type", "string");
        map.put("name", "`DATE`");
        list.add(map);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("type", "string");
        map1.put("name", "USER_NAME");
        list.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("type", "string");
        map2.put("name", "MENU_CODE");
        list.add(map2);
        System.out.println(list);

    //    获取到 name的值为date。然后删除它，并将它放在末尾
        for (int i = 0; i < list.size(); i++) {
            if ("`DATE`".equals(list.get(i).get("name"))) {
                Map<String, Object> remove = list.remove(i);
                list.add(remove);
            }
        }
        System.out.println(list);







    }


}



