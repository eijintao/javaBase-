package com.java.base.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * asus 梅锦涛
 * 2022/3/1
 *
 * @author mjt
 */
public class RunObject1 {

    public static void test1() {
        synchronized (StaticLock2.staticLock) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin..");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end..");
        }
    }

}

class RunObject2 {

    public static void test2() {
        synchronized (StaticLock2.staticLock) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin..");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end..");
        }
    }

}
