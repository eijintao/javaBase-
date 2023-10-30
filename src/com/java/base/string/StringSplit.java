package com.java.base.string;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * mjt 梅锦涛
 * 2023/5/11
 *
 * @author mjt
 */
public class StringSplit {

    public static void main(String[] args) {


        //String[] str = {"Hello", "World"};
        //for (String s : str) {
        //    String[] split = s.split("");
        //    for (String s1 : split) {
        //        System.out.println(s1);
        //    }
        //}

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

        //streamOfwords.map(word -> word.split(""))
        //        .flatMap(Arrays::stream)
        //        .distinct()
        //        .forEach(System.out::println);

        Stream.of(arrayOfWords).map(word -> word.split(""))
                // 让每个数组变成一个单独的流
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);


    }

}

class StringSplitIndexRange {

    public static void main(String[] args) {
        //String table_name = "NUMLIST_yyyymm";
        //String substring = table_name.substring(table_name.lastIndexOf("_") + 1);
        //System.out.println(substring);
        //
        //String str = "ALIOTH_YDZQ_UAT.TN_RULE_SET_REL_yyyymm";
        //String substring1 = str.substring(0,str.lastIndexOf("_"));
        //System.out.println(substring1);


        String str2 = "SELECT  RULE_SET_ID,RULE_ID,NEXT_RULE_ID,PRE_RULE_ID,SEQUENCE,NEXT_LOGIC,ID  FROM ALIOTH_YDZQ_UAT.TN_RULE_SET_REL";

    //    写一个日期为yyyyMMdd的程序
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
        String format = localDate.format(yyyyMMdd);
        System.out.println(format);

        Map<String, Object> map = new HashMap<>();
        map.put("DB_TYPE", "sqlserver");
        map.put("TABLE_NAME", "TN_RULE_SET_REL");

        String lowerCaseTableName = map.get("TABLE_NAME").toString().toLowerCase();

        if (map.get("DB_TYPE").toString().toLowerCase().trim().equals("sqlserver") && lowerCaseTableName.contains("_yyyy")) {
            String substring = lowerCaseTableName.substring( lowerCaseTableName.lastIndexOf("_")+1);
            System.out.println(substring);
            String substringDate = format.substring(0, substring.length());
            str2 = str2 + "_" + substringDate;
            System.out.println(str2);

        }

    }
}
