package com.java.base.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * mjt 梅锦涛
 * 2023/2/27
 *
 * @author mjt
 */
public class YearMonthDayTest {

    public static void main(String[] args) {
        String str1 = "2022-12-05 17:38:36.0";
        //String str2 = "2023-02-27 15:40:41.0";
        extracted(str1);
        //extracted(str2);


    }

    private static void extracted(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long time = date.getTime();
        System.out.println(time);

        Timestamp update_time = new Timestamp(time);
        Date dateUpdate_time = new Date(update_time.getTime());
        System.out.println(dateUpdate_time);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateUpdate_time);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // 月份从0开始，所以要加1
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("年：" + year + "，月：" + month + "，日：" + day);
        LocalDate from = LocalDate.of(year, month, day);

        long longday = LocalDate.now().toEpochDay() - from.toEpochDay();
        System.out.println("距离当前多少日：" + longday);

    }

}
