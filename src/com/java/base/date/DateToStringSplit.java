package com.java.base.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * mjt 梅锦涛
 * 2023/12/25
 *
 * @author mjt
 */
public class DateToStringSplit {

    public static void main(String[] args) {
        String str = "2023-12-25 09:30:30.0";
       str = str.split("\\.")[0];
        // 2023-12-25 09:30:30
        System.out.println(str);


        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 获取当前日期是星期几
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        // 输出星期几
        System.out.println("Today is "+ dayOfWeek.toString() );
    }

}
