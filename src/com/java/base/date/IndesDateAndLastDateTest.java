package com.java.base.date;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * mjt 梅锦涛
 * 2023/5/23
 *
 * @author mjt
 */
public class IndesDateAndLastDateTest {

    public static void main(String[] args) {
        //LocalDate today = LocalDate.now(); // 当前日期

        LocalDate today = LocalDate.of(2024, 2, 23); // 当前日期

        // 获取每个月的第一天
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        String yyyyMMdd1 = firstDayOfMonth.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println("第一天：" + yyyyMMdd1);

        // 获取每个月的最后一天
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        String yyyyMMdd2 = lastDayOfMonth.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println("最后一天：" + yyyyMMdd2);
    }

}
