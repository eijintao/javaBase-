package com.java.base.utils;

/**
 * mjt 梅锦涛
 * 2023/3/13
 *  todo: 一个群友分享的面试题
 *
 * @author mjt
 */
public class Test {

    public volatile int inc = 0;

    public static void main(String[] args) {
        final Test test = new Test();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run(){
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                }
            }.start();
            while (Thread.activeCount() > 1) //保证前面的线程都执行完
                Thread.yield();
            System.out.println(test.inc);
        }
    }

    public void increase() {
        inc++;
    }
}
//这段代码的执行结果


