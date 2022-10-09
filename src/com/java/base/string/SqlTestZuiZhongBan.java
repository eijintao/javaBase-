package com.java.base.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * asus 梅锦涛
 * 2022/8/29
 *
 * @author mjt
 */
public class SqlTestZuiZhongBan {

    public static void main(String[] args) {

        String sql = readSql("D:\\test\\test1" +
                ".txt");
        String sql1 = handleSql(sql);
        writetoTxt("D:\\test\\test11" +
                        ".txt"
                , sql1);

        System.out.println("================================================end");
    }


    private static String handleSql(String sql) {
        Pattern castPattern = Pattern.compile("(?i)cast\\s*\\((((?!cast)[\\s\\S])+?)\\s+as\\s+((tinyint|bigint|smallint|int|string)\\s*\\)|decimal\\s*([\\s\\S]*?)\\)\\s*\\))");
        sql = castPattern.matcher(sql).replaceAll("$1");
        while (castPattern.matcher(sql).find()) {
            sql = castPattern.matcher(sql).replaceAll("$1");
        }
        sql = sql.replaceAll("\\$\\{[^}]+\\}", "123")
                .replaceAll("(?i)overwrite(\\s+table)?\\s", "into ")
                .replaceAll("(\\sTABLE\\s|\\stable\\s)  ", " ")
                .replaceAll("ROW_NUMBER\\(\\)", "")
                .replaceAll("OVER(\\s)*\\([A-Z\\s\\.\\,]*\\)", "OVER()")
                .replaceAll("DECODE(\\s)*\\([A-Za-z0-9\\,\\s\\{\\}\\'\\_\\$\\:]*\\)*", "");
        // 123 between aaa and bbb 无法解析
        sql = sql.replaceAll("(?i)123\\s+between\\s+\\w+\\s+and\\s+\\w+", "1=2 ");
        sql = sql.replaceAll("(?i)partition\\s*\\(\\s*\\w+\\s*=\\s*\\w+\\s*\\)", "");

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
