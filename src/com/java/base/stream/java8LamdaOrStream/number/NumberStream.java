package com.java.base.stream.java8LamdaOrStream.number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * mjt 梅锦涛
 * 2023/5/11
 *
 * @author mjt
 */
public class NumberStream {

    public static void main(String[] args) {
        List<Integer> someNumbers = asList();
        Optional<Integer> max = someNumbers.stream().reduce(Integer::max);
        //System.out.println(max.isPresent()?max.get():0); 该行为报错
        //System.out.println(max.orElse(0)); 0


        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));



        List<Dish> specialMenu = asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 150, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 130, Dish.Type.OTHER));
        // flatMapping 结合 groupby的使用
        //flapMappingTest(dishTags, specialMenu);

        // summarizingInt的使用
        //CollectSummarizingIntTest(specialMenu);

        // joining的使用
        //CollectJoining(specialMenu);

        // reduce集合sum使用
        //extractedReduceAndSum(specialMenu);

        // reduce结合joining的使用
        //reduceJoiningTest(specialMenu);

        // 两种groupingBy 结合 filtering的使用
        twoGroupByFilter(specialMenu);

        // groupingBy 结合 mapping的使用
        //groupByMappingTest(specialMenu);

    }

    private static void groupByMappingTest(List<Dish> specialMenu) {
        Map<Dish.Type, List<String>> dishNamesByType1 =
                specialMenu.stream()
                        .collect(groupingBy(Dish::getType,
                                mapping(Dish::getName, toList())));
        System.out.println(dishNamesByType1);
    }

    private static void flapMappingTest(Map<String, List<String>> dishTags, List<Dish> specialMenu) {
        Map<Dish.Type, Set<String>> dishNamesByType =
                specialMenu.stream()
                        .collect(groupingBy(Dish::getType,
                                flatMapping(dish -> dishTags.get( dish.getName() ).stream(),toSet())));
        System.out.println(dishNamesByType);
    }

    private static void twoGroupByFilter(List<Dish> specialMenu) {
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                specialMenu.stream().filter(dish -> dish.getCalories() > 200)
                        .collect(groupingBy(Dish::getType));
        System.out.println(caloricDishesByType);

        System.out.println(" ------------------- ");

        Map<Dish.Type, List<Dish>> caloricDishesByType1 =
                specialMenu.stream()
                        .collect(groupingBy(Dish::getType,
                                    //该 filtering方法是在jdk9中引入的
                                filtering(dish -> dish.getCalories() > 200, toList())));
        System.out.println(caloricDishesByType1);
    }

    private static void reduceJoiningTest(List<Dish> specialMenu) {
        String shortMenu = specialMenu.stream().map(Dish::getName).collect(joining());
        String shortMenu1 = specialMenu.stream().map(Dish::getName)
               .collect( reducing      ( (s1, s2) -> s1 + s2 ) ).get();
        //String shortMenu = specialMenu.stream()
        //       .collect( reducing( (d1, d2) -> d1.getName() + d2.getName() ) ).get();
        String shortMenu2 = specialMenu.stream()
               .collect( reducing( "", Dish::getName, (s1, s2) -> s1 + s2 ) );
    }

    private static void CollectJoining(List<Dish> specialMenu) {
        String shortMenu = specialMenu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);
    }

    private static void CollectSummarizingIntTest(List<Dish> specialMenu) {
        IntSummaryStatistics menuStatistics =
                specialMenu.stream().collect(summarizingInt(Dish::getCalories));

        // IntSummaryStatistics{count=5, sum=1700, min=120, average=340.000000, max=530}
        System.out.println(menuStatistics);
    }

    private static void extractedReduceAndSum(List<Dish> specialMenu) {
        // 不同求和的归约变种
        int totalCalories = specialMenu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));

        int totalCalories1 = specialMenu.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j);

        int totalCalories2 =
                specialMenu.stream().map(Dish::getCalories).reduce(Integer::sum).get();

        int totalCalories3 = specialMenu.stream().mapToInt(Dish::getCalories).sum();

        System.out.println(totalCalories1);
    }

}
