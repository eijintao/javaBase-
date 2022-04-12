package com.java.base.basenum;

import java.util.*;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class SwitchTest {

    /**
     * 1：使用switch 配合 Enum 时，会报：Constant expression required：要求常量表达式。
     *  所以，两者配合时，case 需要用到 常量，而不是枚举中的某个值，
     *
     *
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        List<Person> list = Arrays.asList(new Person(1,"李四","qN"),
                new Person(2,"张三","sN"),
                new Person(3,"王五","lN"),
                new Person(4,"周六","zlN"),
                new Person(5,"钱七","zN"),
                new Person(6,"赵八","qsN")
        );

        for (Person person : list) {
            switch (person.getStatus()) {
                case EnumStatus.ln :
                    map.put(1,"老年");
                    break;
                case EnumStatus.qn :
                    map.put(2,"青年");
                    break;
                case EnumStatus.qsn :
                    map.put(3,"青少年");
                    break;
                case EnumStatus.sn :
                    map.put(4,"少年");
                    break;
                case EnumStatus.zln :
                    map.put(5,"中老年");
                    break;
                default:
                    break;

            }

        }
        map.forEach((x,y) -> System.out.println("key="+x+" value="+y));


    }

}
