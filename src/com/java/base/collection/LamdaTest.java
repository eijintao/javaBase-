package com.java.base.collection;

import com.java.base.basenum.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class LamdaTest {

    public static void main(String[] args) {

        List<Person> list = Arrays.asList(new Person(1,"李四","qN"),
                new Person(2,"张三","sN"),
                new Person(3,"王五","lN"),
                new Person(4,"周六","zlN"),
                new Person(5,"钱七","zN"),
                new Person(6,"赵八","qsN")
        );

        list.stream().map(Person::getStatus).filter(x->x.equals("qN")).forEach(System.out::println);

        Runnable s = () -> {System.out.println("hello world");};

        System.out.println("这个是测试是否真的推上去了。");

    }

}
