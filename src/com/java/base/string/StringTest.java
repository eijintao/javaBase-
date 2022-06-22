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

class AbcdTest {
    public static void main(String[] args) {
         System.out.println("这个是主分支master");
        System.out.println("这个是主分支master   删除");
    }
}
