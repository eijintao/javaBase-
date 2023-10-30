package com.java.base.data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * mjt 梅锦涛
 * 2023/6/16
 *
 * @author mjt
 */
public class DateFormtteComparatorTest {

    public static void main(String[] args) {

        //String s = formatDate(new Date(), "yyyy-MM-dd");
        //System.out.println(s);
        //String yyyyMMdd = formatDate(new Date(), "yyyyMMdd");
        //System.out.println(yyyyMMdd);
        //String s1 = s.replaceAll("-", "");
        //if (yyyyMMdd.compareTo(s1) > 0) {
        //    System.out.println("s > yyyyMMdd");
        //} else if (yyyyMMdd.compareTo(s1) < 0) {
        //    System.out.println("s < yyyyMMdd");
        //} else if (yyyyMMdd.compareTo(s1) == 0) {
        //    System.out.println("s = yyyyMMdd");
        //}



        String yyyyMMdd = formatDate(new Date(), "yyyyMMdd");

        String etl_cycle_Date = "";
        String busiDateEn = "20230616";
        String DateStr = "2023-06-16";
        String  optime = DateStr.replaceAll("-", "");
        String  subymd = "yyyy".replaceAll("-", "");
        if (busiDateEn != null && yyyyMMdd.compareTo(optime) == 0) {
            etl_cycle_Date = busiDateEn.substring(0, subymd.length());
        } else if ( busiDateEn != null  && yyyyMMdd.compareTo(optime) != 0) {
            etl_cycle_Date = optime.substring(0, subymd.length());
        } else {
            etl_cycle_Date = optime.substring(0, subymd.length());
        }

        System.out.println("66666    " + etl_cycle_Date);

        // 定义输入日期字符串的格式
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(subymd);

        // 解析输入日期字符串为 LocalDate 对象
        LocalDate date = null;
        if (subymd.length() == 8) {
            date = LocalDate.parse(etl_cycle_Date, inputFormatter);
        } else if (subymd.length() == 6) {
            date = YearMonth.parse(etl_cycle_Date , inputFormatter).atEndOfMonth();
        }

        // 定义目标日期字符串的格式
        DateTimeFormatter outputFormatter = null;
        if (subymd.length() == 8) {
            outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else if (subymd.length() == 6) {
            outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        }
        if (etl_cycle_Date.length() != 4) {
            // 格式化 LocalDate 对象为目标日期字符串
            String outputDate = date.format(outputFormatter);

            System.out.println("44444444    " + outputDate);
        } else {
            System.out.println("2222222    " + etl_cycle_Date);
        }

    }


    /**
     * 格式化日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {

        return new SimpleDateFormat(pattern).format(date);
    }




}




class yyyymmddQuestionsTest {

    public static void main(String[] args) {

        String yyyymmdd = getFormmaterStrDate("yyyyMMdd", "20230618");
        System.out.println( "yyyymmdd  " + yyyymmdd);

    }
    private static String getFormmaterStrDate(String subymd, String etl_cycle_Date) {

        // 定义输入日期字符串的格式
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(subymd);

        // 解析输入日期字符串为 LocalDate 对象
        LocalDate date = null;
        // 定义目标日期字符串的格式
        DateTimeFormatter outputFormatter = null;
        if (subymd.length() == 8) {
            date = LocalDate.parse(etl_cycle_Date, inputFormatter);
            outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else if (subymd.length() == 6) {
            date = YearMonth.parse(etl_cycle_Date , inputFormatter).atEndOfMonth();
            outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        }

        if (etl_cycle_Date.length() != 4) {
            // 格式化 LocalDate 对象为目标日期字符串
            String outputDate = date.format(outputFormatter);
            return outputDate;
        } else {
            return etl_cycle_Date;
        }
    }


}
