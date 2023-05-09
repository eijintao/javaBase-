package com.java.base.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mjt 梅锦涛
 * 2022/12/23
 *
 * @author mjt
 */
public class sqlJRCP {

    public static void main(String[] args) {
        //String sql = readSql("D:\\testydzqSQL\\jrcp" +
        //        ".txt");
        //String sql1 = handleSql(sql);
        //writetoTxt("D:\\testydzqSQL\\jrcp11" +
        //                ".txt"
        //        , sql1);
        //
        //System.out.println("================================================end");
        // 至少8位，包含大写字母、小写字母、数字、特殊字符中至少2种组合的正则
        //String s = "^(?=.[A-Z])(?=.[a-z])(?=.[e-9])(?=.[#@$*_]).{8,}$";
        Pattern withTempPattern = Pattern.compile("^(?=.[A-Z])(?=.[a-z])(?=.[0-9])(?=.[#@$*_]).{8,}$");
        Matcher m = withTempPattern.matcher("5346ert546^*&AS");
        if (m.find()) {
            System.out.println("可以匹配到");
        } else {
            System.out.println("not match");
        }
    }



    private static String handleSql(String sql) {
         // 新版
         sql = sql.replaceAll("(?i)partition\\s*\\(\\s*\\w+\\s*=\\s*\\$\\s*\\{\\s*[^}]+\\}\\)", "");
        // 老版
        //sql = sql.replaceAll("(?i)partition\\s*\\(\\s*\\w+\\s*=\\s*\\w+\\s*\\)","")
        //        .replaceAll("\\$\\{[^}]+\\}", "123");
        ////String var = sql.replaceAll("VAR", "");
        System.out.println(sql);

        Pattern withTempPattern = Pattern.compile("(?i)(with\\s+(temp\\w+)\\s+as)\\s*[\\s\\S]*\\(");
        Matcher m = withTempPattern.matcher(sql);
        if (m.find()) {
            String withAS = m.group(1);
            String tmpTab = m.group(2);
            String tmpSql = readTempTable(sql, withAS);
            sql = sql.replace(withAS, "").replace(tmpSql, "");
            sql = sql.replace(tmpTab, tmpSql);
        }

        return sql;
    }

    public static String readTempTable(String sql, String withAs) {
        int counts = 0;
        String rtnSql = "";
        boolean isStart = false;
        for (int i = sql.indexOf(withAs); i < sql.length(); i++) {
            String c = String.valueOf(sql.charAt(i));
            if (isStart) {
                if (c.equals("(")) counts++;
                if (c.equals(")")) counts--;
                rtnSql += c;
                if (counts == 0) {
                    return rtnSql;
                }
            } else if (c.equals("(")) {
                rtnSql += c;
                counts++;
                isStart = true;
            }
        }
        return rtnSql;
    }

    public static String readSql(String file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int i = 0;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                if (i != 0) result.append(System.lineSeparator());
                i++;
                result.append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void writetoTxt(String filename, String message) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(new File(filename)));
            out.write(message);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
