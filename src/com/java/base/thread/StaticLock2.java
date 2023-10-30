package com.java.base.thread;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * asus 梅锦涛
 * 2022/3/1
 *
 * @author mjt
 */
public class StaticLock2 {

    public static Object staticLock = new Object();

    public static void main(String[] args) {
        //String string = "TN_RULE_SET_REL_yyyymmdd";
        //String strDate = "20230528";
        //extracted( string,strDate);

        //Double naN = Double.valueOf("null");
        //System.out.println(naN);

        //String ste = "istedhare\u0007";
        //System.out.println(ste);


        String sql1 = "SELECT KHH, SRJE, FCJE, YWKM, YYB FROM alioth_ydzq_testing_environment.DATACENTER_TZJMXLS_yyyyMMdd";

        Pattern pattern = Pattern.compile("FROM.*(_yyyyMM|_yyyymmdd|_yyyy|_yyyyMMdd)");
        Matcher matcher = pattern.matcher(sql1);

        if (matcher.find()) {
            String matched = matcher.group(1);
            System.out.println("Matched substring: " + matched);
        } else {
            System.out.println("No match found.");
        }

        String sql = "SELECT KHH, SRJE, FCJE, YWKM, YYB FROM alioth_ydzq_testing_environment.DATACENTER_TZJMXLS_yyyyMMdd";

        // 优化正则表达式，按照长度从长到短的顺序排列日期格式
        String regex = "(FROM\\s+[a-zA-Z0-9_\\.]+?)((_yyyyMMdd)|(_yyyymmdd)|(_yyyyMM)|(_yyyy))";
        Pattern pattern1 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern.matcher(sql);

        String updatedSql = matcher.replaceAll("$1");

        System.out.println("Original SQL: " + sql);
        System.out.println("Updated SQL: " + updatedSql);

    }

    private static void extracted(String str,String strdate) {
    //     获取到str中的yyyyMM
        String  regex = str.substring(str.lastIndexOf("_") + 1);
        String substring = strdate.substring(0, regex.length());

    }




}
