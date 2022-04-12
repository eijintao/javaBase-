package com.java.base.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * asus 梅锦涛
 * 2022/3/1
 *
 * @author mjt
 */
public class ClassLock {

    public synchronized static void test1() {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin..");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " end..");
    }
    public synchronized static void test2() {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin..");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + " " + Thread.currentThread().getName() + "end..");
    }

}

class ClassLock2 {
    public synchronized static void test1( ) {
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin..");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " end..");
    }
    public static void test2 () {
        synchronized (ClassLock2.class) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin..");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end..");
        }
    }
}
