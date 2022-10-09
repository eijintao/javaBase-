package com.java.base.string;

/**
 * asus 梅锦涛
 * 2022/7/20
 *
 * @author mjt
 */
public class StringPaserSql {

    public static void main(String[] args) {
        String sql = "INSERT INTO ADP_USR.TEMP_T_STAT_KHZC_Y\n" +
                "        (YF, KHH, YYB, GRJG, YCZZC, YCZZC_RMB, YCZZC_HKD, YCZZC_USD)\n" +
                "        SELECT ${VAR:VN_YF} AS YF,\n" +
                "               KHH,\n" +
                "               YYB,\n" +
                "               GRJG,\n" +
                "               ZZC AS YCZZC,\n" +
                "               ZZC_RMB AS YCZZC_RMB,\n" +
                "               ZZC_HKD AS YCZZC_HKD,\n" +
                "               ZZC_USD AS YCZZC_USD\n" +
                "          FROM ADP_STAT.T_STAT_KHZC_R A\n" +
                "         WHERE RQ = ${VAR:VN_QC_RQ}\n" +
                "           AND NOT EXISTS (SELECT 1\n" +
                "                  FROM ADP_BAS.T_KHXX_JJYW B\n" +
                "                 WHERE A.KHH = B.KHH\n" +
                "                   AND B.KHZT = '3'\n" +
                "                   AND B.XHRQ = ${VAR:VN_QC_RQ})";
        String into = sql.replaceAll("(overwrite(\\s)+TABLE)|(OVERWRITE(\\s)+TABLE)", "into")
                .replaceAll("table","")
                .replaceAll("(cast|CAST)(\\s)*\\([^()]*\\)","456")
                .replaceAll("ROW_NUMBER\\(\\)","")
                .replaceAll("OVER(\\s)*\\([A-Z\\s\\.\\,]*\\)","OVER()")
                .replaceAll("PARTITION\\s*\\([A-Za-z_\\s]* = [A-Za-z0-9_${:}\\s]*\\)","")
                //;
                .replaceAll("\\$\\{[^}]+\\}", "123");


        //String s = RegExUtils.replaceAll(sql, "\\$\\{[^}]+\\}", "123");

        //System.out.println(JSONObject.toJSONString(null));
        System.out.println(into);
    }

}


class Test01 {
    public static void main(String[] args) {


    }
}