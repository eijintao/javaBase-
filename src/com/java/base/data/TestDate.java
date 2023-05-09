package com.java.base.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * mjt 梅锦涛
 * 2023/2/23
 *
 * @author mjt
 */
public class TestDate {
    // 2021/9/8 星期三 11:30:25，java该如何转换这个时间格式

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy/MM/dd E HH:mm:ss");
            Date date = sdf.parse("2021/9/8 星期一 11:30:25");
            System.out.println(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);

        }

    }

}
