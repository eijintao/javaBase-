package com.java.base.collection;

import java.util.LinkedList;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class ListTest {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<String>();
        list.add("123");
        list.add("345");
        list.removeIf(x -> x.equals("123"));
        System.out.println(list);




    }

}
