package com.java.base.string;

import com.sun.javafx.util.Logging;

/**
 * asus 梅锦涛
 * 2021/11/12
 *
 * @author mjt
 */
public class StringTest {

    public static void main(String[] args) {

//        StringBuilder str = new StringBuilder("123sag,");
//        str.delete(str.lastIndexOf("a"),str.lastIndexOf(","));
//        System.out.println(str);


            String s1="a";
            String s2=s1+"b";
            String s3="a"+"b";
            System.out.println(s2=="ab"); // false
            System.out.println(s3=="ab"); // true

        Logging.getCSSLogger();

        // substring
        String str = "100%%ss";
        String substring = str.substring(3, 6);
        System.out.println(substring);

        System.out.println(System.getProperty("java.version"));

        String str77 = "测试";
        String flag = "1";
        if ("1".equals(flag)) {
            System.out.println("1233");
        }else if (null != str77 && !"".equals(str77)) {
            System.out.println("------");
        }
    }
}

class Abcd {
    public static void main(String[] args) {
        final String h1 = "hello";
        String h2 = "hello";
        String s1 = h1 + "Hydra";
        String s2 = h2 + "Hydra";
        System.out.println(s1);
        System.out.println((s1 == "helloHydra")); // true
        System.out.println(s2);
        System.out.println((s2 == "helloHydra")); // false
        System.out.println();
        String s = "Hydra";
        String s4 = new String("Hydra");
        System.out.println(s == "Hydra");

        System.out.println("-----");
        String s6 = "d";
        String s5 = "a"+"b"+"c" + s6;
        System.out.println(s5 == "abcd");


    }
}

/**
 * 字符串拼接换行符, 尾随的空字符串不出现在新的数组中
 */
class StringEnter {
    public static void main(String[] args) {
        StringBuffer content = new StringBuffer();
        content.append( "发起审批需要您进行审批，请登录平台（");
        content.append("www.xxx.con）进行查看。");
        content.append("\n");
        content.append("流程ID：\n");
        content.append("流程名称：\n");
        content.append("发起人：\n");
        System.out.println(content.toString());

        String str = ",,,,,,,,a,,b,,,,,,,,";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println(s);
        }


    }
}

/**
 * string 的返回是否是原来的字符串
 */
class StringTest01 {
    public static void main(String[] args) {

        String sql = "12346543164abc";
        sql =  sql.replaceAll("abc","")
                .replaceAll("123","");
        System.out.println("第一个sql是：" + sql);// 46543164
        sql = sql.replaceAll("4","x");
        System.out.println("第二个sql是：" + sql);// x65x316x



    }
}


class AbcdTest {
    public static void main(String[] args) {
         System.out.println("这个是主分支master");
        System.out.println("这个是主分支master   删除");
    }
}
