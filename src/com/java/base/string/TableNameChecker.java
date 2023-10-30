package com.java.base.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableNameChecker {
    public static void main(String[] args) {
        //String query = "SELECT KHH,YYB,JYL_GGQQ ... FROM ALIOTH_YDZQ_TESTING_ENVIRONMENT.T_STAT_KH_GGQQ_R_202310 WHERE some_condition";
        String query = "SELECT KHH,YYB,JYL_GGQQ ... FROM ALIOTH_YDZQ_TESTING_ENVIRONMENT.T_STAT_KH_GGQQ_R_2023-10-20";



        boolean isNumber = isLastPartDate(query);

        if (isNumber) {
            System.out.println("FROM 后面的表名中，最后一个下划线后面的数据是riqi。");
        } else {
            System.out.println("FROM 后面的表名中，最后一个下划线后面的数据不qiri。");
        }
    }

    public static boolean isLastPartNumber(String query) {
        // 使用正则表达式匹配 FROM 或 from 后面的内容，直到 WHERE 或 where 或字符串末尾
        Pattern pattern = Pattern.compile("(?i)\\bFROM\\b\\s+([^\\s]+)(?:\\s+\\bWHERE\\b|$)");
        Matcher matcher = pattern.matcher(query);

        String tableName= "";
        if (matcher.find()) {
            tableName =   matcher.group(1);
        }

        // 获取最后一个下划线后的部分
        String lastPart = tableName.substring(tableName.lastIndexOf("_") + 1);

        // 检查是否为纯数字
        return lastPart.chars().allMatch(Character::isDigit);

    }

    public static boolean isLastPartDate(String query) {
        // 使用正则表达式匹配 FROM 或 from 后面的内容，直到 WHERE 或 where 或字符串末尾
        Pattern pattern = Pattern.compile("(?i)\\bFROM\\b\\s+([^\\s]+)(?:\\s+\\bWHERE\\b|$)");
        Matcher matcher = pattern.matcher(query);

        String tableName= "";
        if (matcher.find()) {
            tableName =   matcher.group(1);
        }

        // 获取最后一个下划线后的部分
        String lastPart = tableName.substring(tableName.lastIndexOf("_") + 1);

        // 匹配 YYYY-MM 和 YYYY-MM-DD 日期格式
        return lastPart.matches("\\d{4}-\\d{1,2}(-\\d{1,2})?");

    }




}



class DateSuffixChecker {

    public static void main(String[] args) {
        String input = "TESTEVRIOMENT.ALIOTH_YDZQ_TESTING_ENVIRONMENT.T_STAT_KH_GGQQ_R";

        if (hasDateSuffix(input)) {
            System.out.println("字符串的结尾有指定的日期格式。");
        } else {
            System.out.println("字符串的结尾没有指定的日期格式。");
        }
    }

    public static boolean hasDateSuffix(String str) {
        // 正则表达式匹配以下日期格式：_yyyy _yyyymm _yyyymmdd _yyyy-mm _yyyy-mm-dd
        String regex = "_(\\d{4}|\\d{6}|\\d{8}|\\d{4}-\\d{2}|\\d{4}-\\d{2}-\\d{2})$";
        return str.matches(".*" + regex);
    }
}