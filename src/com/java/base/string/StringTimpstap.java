package com.java.base.string;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * asus 梅锦涛
 * 2022/5/24
 *
 * @author mjt
 */
public class StringTimpstap {

    public static void main(String[] args) {
        LocalDateTime ld= LocalDateTime.now();
        // 转成 Timestamp
        Timestamp timestamp = Timestamp.valueOf(ld);
        System.out.println(timestamp);// 2022-05-24 11:19:25.779
        System.out.println(timestamp.toString());// 2022-05-24 11:19:25.779
        
        
        System.out.println("这个是副分支JavabaseBranchTest01");
        
         System.out.println("这个是副分支JavabaseBranchTest01 git pull origin");
        
         System.out.println("这个是副分支JavabaseBranchTest01 git pull origin javabaseBranchTest01");



        System.out.println("这个是副分支JavabaseBranchTest01 git push origin");


        System.out.println("这个是副分支JavabaseBranchTest01 git push origin javabaseBranchTest01");

        System.out.println(" git push 修改");
    }
}


