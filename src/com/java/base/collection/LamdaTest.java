package com.java.base.collection;

import com.java.base.basenum.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class LamdaTest {

    public static void main(String[] args) {

//        List<Person> list = Arrays.asList(new Person(1,"李四","qN"),
//                new Person(2,"张三","sN"),
//                new Person(3,"王五","lN"),
//                new Person(4,"周六","zlN"),
//                new Person(5,"钱七","zN"),
//                new Person(6,"赵八","qsN")
//        );

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person(7,"mingzi","qsN"));
        list2.add(new Person(8,"bamng","zN"));
        list2.add(new Person(9,"jiushuzi","sN"));
        for (Person person : list2) {
            System.out.println(person);
        }

//        list.stream().map(Person::getStatus).filter(x->x.equals("qN")).forEach(System.out::println);

//        Runnable s = () -> {System.out.println("hello world");};

        System.out.println("这个是测试是否真的推上去了。");
         System.out.println("这个是测试是否真的能够拉下去，这个是直接在github上直接写的。");
        System.out.println("这个是测试返回的版本");

    }


    public static void test1 () {

        List<Person> listResult = Arrays.asList(new Person(1,"李四",13,"0"),
                    new Person(2,"王五",16,"0"),
                    new Person(3,"李六",18,"0"));

        //对listResult进行排序,根据伴随度进行降序F
        List<Person> collect = listResult.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed()
                .thenComparing(Person::getAge).reversed())
                .collect(Collectors.toList());

    }

}
