package com.java.base.stream.java8LamdaOrStream.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * mjt 梅锦涛
 * 2023/5/8
 *
 * @author mjt
 */
public class FillteringApples {

    public static void main(String[] args) {
        List<Apples> inventory = Arrays.asList(new Apples(80, "green"),
                new Apples(155, "green"), new Apples(120, "red"));
        // 策略模式的写法
        //filterApples(inventory,new ApplesGreenColorPridicate()).forEach(System.out::println);
        //filterApples(inventory,new ApplesHeavyWeightPridicate()).forEach(System.out::println);

    //     使用lambda表达式  没有想到以公用接口为准的写法，可以产生这样的效果。
    //    filterApples(inventory,(Apples apples) -> "green".equals(apples.getColor())).forEach(System.out::println);

    //    将list类型抽象化  这个是使用到了泛型
    //    filter(inventory,(Apples apples) -> "red".equals(apples.getColor())).forEach(System.out::println);

        Function<String, Integer> stringIntegerFunction = (String s) -> s.length();
        System.out.println(stringIntegerFunction.apply("123456789"));

    }

    public static List<Apples> filterApples( List<Apples> inventory , ApplePredicate p){
        List<Apples> result = new ArrayList<>();
        for (Apples apples : inventory) {
            if (p.test(apples)) {
                result.add(apples);
            }
        }
        return result;

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
            for (T e : list) {
                if (p.test(e)) {
                    result.add(e);
                }
            }
            return result;
    }


}
