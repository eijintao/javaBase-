package com.java.base.basenum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mjt 梅锦涛
 * 2023/6/5
 *
 * @author mjt
 */
public class 特殊符号Test {

    public static void main(String[] args) {

        char a = '`'; // 96
        char c = '\''; // 39
        System.out.println((int)a);
        System.out.println((int)c);

    //    正则表达式验证中文字符

        String sql = "( \n" +
                "    `数字` string, \n" +
                "    TXMM string, \n" +
                "    USETIME timestamp, \n" +
                "    `详情` string \n" +
                ")";
        String[] split = sql.split("\\s*;\\s*(?=([^']*'[^']*')*[^']*$)");
        for (String s : split) {
            System.out.println("====");
            System.out.println(s);
        }



        //
        //String str = "ALIOTH_YDZQ_UAT.ALIOTH_YDZQ_UAT.TN_RULE_SET_REL_202304";
        //
        //
        //String    subTableName = str.substring(str.lastIndexOf(".") + 1);
        //System.out.println(subTableName);


        //String str1 = "TN_RULE_SET_REL";
        //
        //String    subTableName1 = str1.substring(str1.lastIndexOf("_") + 1);
        //System.out.println(subTableName1);

        String dmodenname = "TN_RULE_SET_REL_202304";
        if (dmodenname.lastIndexOf("_") > 0 ) {
            String subLastIndexOfdmodenname = dmodenname.substring(dmodenname.lastIndexOf("_") + 1);
            if (isNumericString(subLastIndexOfdmodenname) ) {
                String substring = dmodenname.substring(0, dmodenname.lastIndexOf("_"));
                System.out.println("------" + substring);
            }
        }



    }
    /**
     * 判断是否是数字字符串
     * @param inputString
     * @return
     */
    public static boolean isNumericString(String inputString) {
        String pattern = "^\\d+$"; // 匹配一个或多个数字
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(inputString);
        return matcher.matches();
    }

}
