package com.java.base.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
