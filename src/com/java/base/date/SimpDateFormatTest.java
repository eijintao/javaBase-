package com.java.base.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * mjt 梅锦涛
 * 2024/2/1
 *
 * @author mjt
 */
public class SimpDateFormatTest {

    public static void main(String[] args) {

        System.out.println(isPattern( "2023-10-26 12:34:56",  "yyyy-MM-dd"));


    }


    public static boolean isPattern (String datestr,String pattern) {
        try {
            //SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            //sdf.setLenient(false);
            //sdf.parse(datestr);

            DateTimeFormatter.ofPattern(pattern).parse(datestr);

            Calendar.getInstance().setLenient(false);
            Calendar.getAvailableLocales();
            LocalDate.parse(datestr, DateTimeFormatter.ofPattern(pattern));
            LocalDateTime.parse(datestr, DateTimeFormatter.ofPattern(pattern));
            LocalTime.parse(datestr, DateTimeFormatter.ofPattern(pattern));


            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
