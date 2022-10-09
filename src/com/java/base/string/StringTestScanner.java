package com.java.base.string;

import java.util.Scanner;

/**
 * asus 梅锦涛
 * 2022/4/25
 *
 * @author mjt
 */
public class StringTestScanner {

    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner sc = new Scanner(System.in);
        String sa = sc.nextLine();
        if (sa.length() == 0) {
            System.out.println("输入的字符串长度不能为0，请重新输入");
        } else if (sa.length() >= 5000) {
            System.out.println("输入的字符串长度不能超过5000，请重新输入");
        } else {
            // 去掉两边空格
            String strTrim = sa.trim();
            // 找到最后一个空格的下标
            int i = strTrim.lastIndexOf(" ");
            // 截取最后一个单词
            String strSub = strTrim.substring(i+1);
            System.out.println("该字符串最后一个单词是：" + strSub + ", 长度是：" + strSub.length());

        }
    }

}
