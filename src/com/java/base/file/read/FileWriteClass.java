package com.java.base.file.read;

/**
 * mjt 梅锦涛
 * 2022/11/30
 *
 * @author mjt
 */
public class FileWriteClass {

    public static void main(String[] args) {
        //String str = "sdfsdsfsfdsdfsfd_S";
        //String str1 = "sdfsdsfsfd_Ssdfs_S";
        //
        //System.out.println(str.lastIndexOf("_S"));//  >0
        //System.out.println(str.length());
        //System.out.println(str1.lastIndexOf("_S")); //

        String zhrx = "ydsc";
        String str3 = "/home/index/single/{zhrx}";
        String replace = str3.replace("{zhrx}", zhrx);
        System.out.println(replace);


    }
}
