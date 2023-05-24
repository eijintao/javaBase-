package com.java.base.rexExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mjt 梅锦涛
 * 2023/5/23
 *
 * @author mjt
 */
public class numberTest {

    public static void main(String[] args) {
        String str = "month_DT4_table202105";

        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String numberStr = matcher.group();
            int number = Integer.parseInt(numberStr);
            System.out.println("Extracted number: " + number);
        }


        String tr = "jdbc:sqlserver://10.10.50.34:1433;databaseName=DzhJYLlogBak850";
        String numberStr = tr.substring(tr.lastIndexOf("DzhJYLlogBak") + 12);
        int number = Integer.parseInt(numberStr);
        System.out.println("DzhJYLlogBak: " + number);



        String str1 = "32";
        String str2 = "32.0";
        if (str1.equals("321")) {
            System.out.println("str1.equals(str2)");
        } else if (str2.equals("32.0")) {
            System.out.println("str1.equals(str21111111)");
        } else if (str1.equals("32")) {
            System.out.println("str1.equals(222222222222)");
        }
    }

}
