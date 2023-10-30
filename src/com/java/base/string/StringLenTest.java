package com.java.base.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * mjt 梅锦涛
 * 2023/9/5
 *
 * @author mjt
 */
public class StringLenTest {

    public static void main(String[] args) {

        //String s = "999999999999999999999999999999999999999999999999999999999999";
        //System.out.println(s.length()); // 60
        //
        //
        //String s1= "99999999999999999999999999999999999"
        //        ;
        //System.out.println(s1.length());// 35

        List<Map<String, Object>> columns = new ArrayList<>();

        Map<String, Object> column1 = new HashMap<>();
        column1.put("type", "string");
        column1.put("name", "CHARACTER_VARYING_COLUMN");
        columns.add(column1);

        Map<String, Object> column2 = new HashMap<>();
        column2.put("type", "decimal(10,2)");
        column2.put("name", "NUMERIC_COLUMN");
        columns.add(column2);

        Map<String, Object> column3 = new HashMap<>();
        column3.put("type", "decimal(35,20)");
        column3.put("name", "REAL_COLUMN");
        columns.add(column3);

        List<Map<String, Object>> updatedColumns = columns.stream()
                .map(column -> {
                    String type = (String) column.get("type");
                    Pattern pattern = Pattern.compile("decimal\\(\\d+,\\d+\\)");
                    Matcher matcher = pattern.matcher(type);
                    if (matcher.find()) {
                        column.put("type", "decimal");
                    }
                    return column;
                })
                .collect(Collectors.toList());

        // 打印结果
        updatedColumns.forEach(column -> {
            System.out.println("Type: " + column.get("type") + ", Name: " + column.get("name"));
        });


    }

}
