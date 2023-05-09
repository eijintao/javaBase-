package com.java.base.date;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * mjt 梅锦涛
 * 2023/3/18
 *
 * @author mjt
 */
public class PeriodDateTest {
    public static void main(String[] args) {

        long longday = 0L;
        Date dateUpdate_time = new Date("2021/9/8 11:30:25");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateUpdate_time);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // 月份从0开始，所以要加1
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate from = LocalDate.of(year, month, day);
        longday = LocalDate.now().toEpochDay() - from.toEpochDay();// 556
        //    比较 两个日期相差的天数
        //longday = LocalDate.now().toEpochDay() - from.toEpochDay();
        //    Period 这个类有个bug, 是拿日期去比较的。我想比较的是  两个日期相差的天数
         longday = ChronoUnit.DAYS.between(from, LocalDate.now()); // 556

        System.out.println(longday);

    }

}
