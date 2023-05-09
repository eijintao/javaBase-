package com.java.base.optional;

import java.util.Optional;

/**
 * mjt 梅锦涛
 * 2023/5/6
 *
 * @author mjt
 */
public class JudgmentNull {

    public static void main(String[] args) {

        String strNull = null;
        Optional<String> stringOptional = Optional.of(Optional.ofNullable(strNull).orElse("123"));
        if (stringOptional.isPresent()) {
            System.out.println("不为空");
        } else {
            System.out.println("为空");
        }

        String strNullOne = null;
        String stringOptionalOne = Optional.ofNullable(strNullOne).orElse("123");
        if (stringOptionalOne != null) {
            System.out.println("不为空");
        } else {
            System.out.println("为空");
        }





    }

}
