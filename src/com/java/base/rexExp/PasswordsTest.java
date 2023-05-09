package com.java.base.rexExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mjt 梅锦涛
 * 2023/2/23
 *
 * @author mjt
 */
public class PasswordsTest {

    public static void main(String[] args) {
        // 这个正则表达式要求密码必须包含至少一个小写字母、一个大写字母、一个数字和一个特殊字符，密码长度至少为8个字符。
        String passwords = "123456Aa@";
        String str = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{8,})[a-zA-Z0-9!@#\\$%\\^&\\*]+";
        Pattern pattern = Pattern.compile(str,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            System.out.println("符合密码强度");
        }

    }
}
