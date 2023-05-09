package com.java.base.stream;

import com.java.base.entity.Employee;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * mjt 梅锦涛
 * 2023/5/6
 *
 * @author mjt
 */
public class StreamTest {

    public static void main(String[] args) {

        // 测试一
        //List<Object> collect = Stream.of(new Employee("里斯", 2222, 2023, 05, 06,true), new Employee("丈八", 4444, 2023, 05, 06,false) )
        //        //.flatMap(employee ->  Arrays.asList(employee.getName(), employee.getSalary(), employee.getHireDay()).stream())
        //        //.flatMap(employee -> Stream.of(employee.getName(), employee.getSalary(), employee.getHireDay()))
        //        .flatMap(employee -> Stream.of(employee.toString()))
        //        .collect(Collectors.toList());
        //System.out.println(collect);


         // 测试二
         //Stream.of(new Employee("里斯", 2222, 2023, 05, 06, true),
         //               new Employee("丈八", 4444, 2023, 05, 06, false),
         //               new Employee("千六", 2222, 2023, 05, 06, true),
         //               new Employee("王五", 4444, 2023, 05, 06, false))
         //       //.flatMap(employee ->  Arrays.asList(employee.getName(), employee.getSalary(), employee.getHireDay()).stream())
         //       //.flatMap(employee -> Stream.of(employee.getName(), employee.getSalary(), employee.getHireDay()))
         //       .flatMap(employee -> Stream.of(employee.toString()))
         //          .collect(Collectors.toList());

        // 分组测试
        //Map<Double, List<Employee>> collect = Stream.of(new Employee("里斯", 2222, 2023, 05, 06, true),
        //                new Employee("丈八", 4444, 2023, 05, 06, false),
        //                new Employee("千六", 2222, 2023, 05, 06, true),
        //                new Employee("王五", 4444, 2023, 05, 06, false))
        //        //.flatMap(employee -> Stream.of(employee.getName(), employee.getSalary(), employee.getHireDay()))
        //        //.collect(Collectors.partitioningBy(employee -> employee instanceof Employee && ((Employee) employee).isJudgment()));
        //        .collect(Collectors.groupingBy(employee -> employee.getSalary()));
        //System.out.println(collect);

        Stream<Employee> employeeStream = Stream.of(new Employee("里斯", 2222, 2023, 05, 06, true),
                new Employee("丈八", 4444, 2023, 05, 06, false),
                new Employee("千六", 2222, 2023, 05, 06, true),
                new Employee("王五", 4444, 2023, 05, 06, false));
        // 将多个流连接成一个流
        //Stream<Employee> concat = Stream.concat(employeeStream, Stream.empty());

        //Stream<? extends Serializable> stream = employeeStream.flatMap(employee -> Stream.of( employee.getSalary()));
        //Map<String, ? extends List<? extends Serializable>> collect = stream.collect(Collectors.groupingBy(employee -> employee.toString()));
        //System.out.println(collect);


    //    过滤并分组
        Map<Double, List<Employee>> collect1 = employeeStream.filter((Employee e) -> e.getSalary() == 2222).collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println("过滤并分组");
        System.out.println(collect1);




    }
}
