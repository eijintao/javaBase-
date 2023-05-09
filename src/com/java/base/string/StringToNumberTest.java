package com.java.base.string;

import java.util.Arrays;

/**
 * mjt 梅锦涛
 * 2023/3/20
 *
 * @author mjt
 */
public class StringToNumberTest {
    public static void main(String[] args) {
        //int str = '9';
        //System.out.println(str);


        //String s= "sdsfsfsdf反搜的方式";
        //String[] strr = s.split(",");
        //System.out.println(Arrays.toString(strr));
        //
        //String[] str1 = new String[0];
        //str1 = new String[]{"1", "2", "3"};
        //System.out.println(Arrays.toString(str1));


        String str4 = "采集方式：01库到库，02文件到库，03库到文件;（(）)";
        // 替换 采集方式：01库到库，02文件到库，03库到文件;（(）) 中的所有空格以及所有的逗号以及所有的分号所有的冒号所有的括号
        //
        String s = str4.replaceAll(" ", "")
                .replaceAll(",", "")
                .replaceAll(";", "")
                .replaceAll(":", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("（", "")
                .replaceAll("：", "")
                .replaceAll("，", "")
                .replaceAll("@", "")
        .replaceAll("）", "");

        System.out.println(s);




    }

}
