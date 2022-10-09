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
 * 2022/8/22
 *
 * @author mjt
 */
public class SqlTest {

    public static void main(String[] args) {
        String sql = readSql("D:\\test\\error.txt");
        String sql1 = handleSql(sql);
        System.out.println(sql1);
        writetoTxt("D:\\test\\test1.txt", sql1);
        System.out.println("================================================end");


    }

    private static String handleSql(String sql) {


//        Matcher m = castPattern.matcher(sql);
//        while (m.find()) {
//            for (int i = 0; i < m.groupCount(); i++) {
//                System.out.println("group" + i + "====" + m.group(i));
//            }
//        }

        Pattern castPattern = Pattern.compile("(?i)cast\\s*\\(([\\s\\S]*?)\\s+as\\s+((smallint|int|string)\\s*\\)|decimal\\s*([\\s\\S]*?)\\)\\s*\\))");
        sql = castPattern.matcher(sql).replaceAll("$1");
        sql = sql.replaceAll("(overwrite(\\s)+TABLE)|(OVERWRITE(\\s)+TABLE)", "into")
                .replaceAll("TABLE|table", "")
                // 这种可以把所有的 cast（...）都匹配出来 ,除了cast(...换行或者多个换行....)
//                .replaceAll("(cast|CAST)(\\s)*\\([^()]*\\)", "castreplace")
                // 这种可以精准匹配到 AS 后面的 INT 和 STRING
//                .replaceAll("(cast|CAST)(\\s)*\\(.*(as+|AS+)\\s(INT?|int?|STRING?)\\)", "castreplace2")
                .replaceAll("ROW_NUMBER\\(\\)", "")
                .replaceAll("OVER(\\s)*\\([A-Z\\s\\.\\,]*\\)", "OVER()")
                .replaceAll("PARTITION\\s*\\([A-Za-z_\\s]* = [A-Za-z0-9_${:}\\s]*\\)", "")
                .replaceAll("DECODE(\\s)*\\([A-Za-z0-9\\,\\s\\{\\}\\'\\_\\$\\:]*\\)*", "789")
                .replaceAll("\\$\\{[^}]+\\}", "123");
        // 以后如果 ${VAR:XXX} 这种方式需要改的话，那么，就应该用下面的正则表达式
        // (?i)\$\{VAR[:](\w+)\}
        return sql;
    }

    public static String readSql(String file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void writetoTxt(String filename, String message) {
        try {
//            File file = new File(filename);
//            file.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(new File(filename)));
            out.write(message);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class SqlTest01 {

    public static void main(String[] args) {
        String str = "INSERT INTO ADP_USR.TEMP_T_STAT_KH_RZRQ_R\n" +
                "\t\t(YYB, KHH, CRJE_RZRQ, QCJE_RZRQ, FWYJ_RZRQ)\n" +
                "\t\tSELECT YYB,\n" +
                "\t\t\t   KHH,\n" +
                "\t\t\t   CAST(ROUND(SUM(CASE\n" +
                "\t\t\t\t\t\t\t\t  WHEN SJKM = '101' THEN\n" +
                "                               FSJE * NVL(HL.GSBL, 1)\n" +
                "\t\t\t\t\t\t\t\t   DECODE(BZ, '2', ${VAR:VN_HL_HKD}, '3', ${VAR:VN_HL_USD}, 1)\n" +
                "\t\t\t\t\t\t\t\t  ELSE\n" +
                "\t\t\t\t\t\t\t\t   0\n" +
                "\t\t\t\t\t\t\t  END),\n" +
                "\t\t\t\t\t\t  2) AS DECIMAL(16, 2)) AS CRJE_RZRQ,\n";

        //Pattern castPattern = Pattern.compile("(?i)cast\\s*\\((((?!cast)[\\s\\S])+?)\\s+as\\s+((tinyint|bigint|smallint|int|string)\\s*\\)|decimal\\s*([\\s\\S]*?)\\)\\s*\\))");
        //Matcher matcher = castPattern.matcher(str);
        //if (matcher.find()) {
        //    System.out.println(matcher.group(0));
        //    System.out.println("group(1)是：" + matcher.group(1));
        //}


        String str2 = "DECODE(BZ, '2', ${VAR:VN_HL_HKD}, '3', ${VAR:VN_HL_USD}, 1)";
        //String regexp2 = "\\$\\{[^}]+\\}";
        String regexp2 = "(?i)\\$\\{VAR[:](\\w+)\\}";
        Pattern castPattern2 = Pattern.compile(regexp2);
        Matcher matcher2 = castPattern2.matcher(str2);
        //if (matcher2.find()) {
        //    System.out.println("str2匹配的是:" + matcher2.group(0));
        //
        //}
        str2 = matcher2.replaceAll("$1");
        while (matcher2.find()) {
            System.out.println("str2匹配的是:" + matcher2.group(0));
        }
        System.out.println("str2替换后的语句是：" + str2); // DECODE(BZ, '2', VN_HL_HKD, '3', VN_HL_USD, 1)

    }



}


class SqlTest02 {

    public static void main(String[] args) {
        String str = "INSERT INTO ADP_USR.TEMP_KH_XHKH_HSRQ(PYTYPE,PYZ)\n" +
                "\tVALUES (${VAR:VN_N_DATE_PYTYPE},CAST(${VAR:VN_N_DATE_PYZ} AS INT))";

        String s = handleSql(str);
        System.out.println(s);

    }

    private static String handleSql(String sql) {


//        Matcher m = castPattern.matcher(sql);
//        while (m.find()) {
//            for (int i = 0; i < m.groupCount(); i++) {
//                System.out.println("group" + i + "====" + m.group(i));
//            }
//        }

        Pattern castPattern = Pattern.compile("(?i)cast\\s*\\(([\\s\\S]*?)\\s+as\\s+((smallint|int|string)\\s*\\)|decimal\\s*([\\s\\S]*?)\\)\\s*\\))");
        sql = castPattern.matcher(sql).replaceAll("$1");
        sql = sql.replaceAll("(overwrite(\\s)+TABLE)|(OVERWRITE(\\s)+TABLE)", "into")
                .replaceAll("TABLE|table", "")
                // 这种可以把所有的 cast（...）都匹配出来 ,除了cast(...换行或者多个换行....)
//                .replaceAll("(cast|CAST)(\\s)*\\([^()]*\\)", "castreplace")
                // 这种可以精准匹配到 AS 后面的 INT 和 STRING
//                .replaceAll("(cast|CAST)(\\s)*\\(.*(as+|AS+)\\s(INT?|int?|STRING?)\\)", "castreplace2")
                .replaceAll("ROW_NUMBER\\(\\)", "")
                .replaceAll("OVER(\\s)*\\([A-Z\\s\\.\\,]*\\)", "OVER()")
                .replaceAll("PARTITION\\s*\\([A-Za-z_\\s]* = [A-Za-z0-9_${:}\\s]*\\)", "")
                .replaceAll("DECODE(\\s)*\\([A-Za-z0-9\\,\\s\\{\\}\\'\\_\\$\\:]*\\)*", "789")
                .replaceAll("\\$\\{[^}]+\\}", "123");
        // 以后如果 ${VAR:XXX} 这种方式需要改的话，那么，就应该用下面的正则表达式
        // (?i)\$\{VAR[:](\w+)\}
        return sql;
    }
}
