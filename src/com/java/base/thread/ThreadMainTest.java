package com.java.base.thread;

/**
 * mjt 梅锦涛
 * 2024/1/7
 *
 * @author mjt
 */
public class ThreadMainTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println("t1");
        });
        t1.start();

        Thread.sleep(1000);
        System.out.println("main");

        /*
        * 在多线程环境中，哪个线程先执行（在您的例子中是t1线程和主线程main）是不确定的，
        * \这取决于操作系统和JVM的线程调度器。在您的代码中，t1线程有可能在某些情况下比main线程先执行，但这通常是随机且不可预测的。
        *
        *
        * */

    }

}
