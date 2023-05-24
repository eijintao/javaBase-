package com.java.base.stream.java8LamdaOrStream.number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
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
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));



        // flatMapping 结合 groupby的使用
        flapMappingTest(dishTags, specialMenu);

        // summarizingInt的使用
        //CollectSummarizingIntTest(specialMenu);

        // joining的使用
        //CollectJoining(specialMenu);

        // reduce集合sum使用
        //extractedReduceAndSum(specialMenu);

        // reduce结合joining的使用
        //reduceJoiningTest(specialMenu);

        // 两种groupingBy 结合 filtering的使用
        //twoGroupByFilter(specialMenu);

        // groupingBy 结合 mapping的使用
        //groupByMappingTest(specialMenu);

        // 双层groupingBy的使用
        //groupByGroupBy(specialMenu);

        //groupByCounting(specialMenu);


        //groupByMaxByTest(specialMenu);

        groupByCollectingAndThenMaxByTest(specialMenu);

        //groupBySummingIntTest(specialMenu);


    }

    private static void groupByCollectingAndThenMaxByTest(List<Dish> specialMenu) {
        //     查找每个子组中热量最高的Dish
        //     把收集器返回的结果转换为另一种类型，你可以使用Collectors.collectingAndThen工厂方法返回的收集器
        Map<Dish.Type, Dish> collect = specialMenu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                        Optional::get)));
        System.out.println(collect);
        //    collectingAndThen() 这个工厂方法接受两个参数——要转换的收集器以及转换函数，并返回另一个收集器。这个收集器相当于旧收集器的一个包装，
        //    collect操作的最后一步就是将返回值用转换函数做一个映射。
        //    在这里，被包起来的收集器就是用maxBy建立的那个，
        //    而转换函数Optional::get则把返回的Optional中的值提取出来。前面已经说过，这个操作放在这里是安全的，因为reducing收集器永远都不会返回Optional.empty()。
    }

    private static void groupByMaxByTest(List<Dish> specialMenu) {
        // 这个分组的结果显然是一个Map，以Dish的类型作为键，以包装了该类型中热量最高的Dish的Optional<Dish>作为值：
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                specialMenu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCalories))));
    }

    private static void groupBySummingIntTest(List<Dish> specialMenu) {
        // 求出所有菜肴热量总和的收集器，不过这次是对每一组Dish求和：
        Map<Dish.Type, Integer> totalCaloriesByType =
                specialMenu.stream().collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);
    }

    private static void groupByCounting(List<Dish> specialMenu) {
        // 普通的单参数groupingBy(f)（其中f是分类函数）实际上是groupingBy(f, toList())的简便写法
        Map<Dish.Type, Long> typesCount = specialMenu.stream().collect(
                groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);
    }

    private static void groupByGroupBy(List<Dish> specialMenu) {
        // 那么要进行二级分组的话，可以把一个内层groupingBy传递给外层groupingBy，并定义一个为流中项目分类的二级标准
        /**
         * 这里的外层Map的键就是第一级分类函数生成的值：“fish, meat, other”，而这个Map的值又是一个Map，键是二级分类函数生成的值：“normal, diet, fat”。
         * 最后，第二级Map的值是流中元素构成的List，
         * 是分别应用第一级和第二级分类函数所得到的对应第一级和第二级键的值：“salmon, pizza…”这种多级分组操作可以扩展至任意层级，
         * n级分组就会得到一个代表n级树形结构的n级Map。
         *
         *
         * 普通的单参数groupingBy(f)（其中f是分类函数）实际上是groupingBy(f, toList())的简便写法
         */
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect = specialMenu.stream().collect(groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if (dish.getCalories() <= 350) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 600) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })));
        System.out.println(collect);
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
