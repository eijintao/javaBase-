package com.java.base.thread.jucUtils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * mjt 梅锦涛
 * 2024/2/2
 *
 * @author mjt
 *
 *    Exchanger(交换者)是一个用于线程间协作的工具类。
 *    Exchanger用于进行线程间的数据交换。
 *    它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。
 *    todo: 这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()方法，它会一直等待第二个线程也执行exchange方法，
 *    todo: 当两个线程都达到同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。
 *
 *
 */
public class ExchangeerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);



    public static void main(String[] args) {

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";
                try {
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "银行流水B";
                try {
                    String A = exgr.exchange("B");
                    System.out.println("A和B数据是否一致：" + A.equals(B) + ", A录入的是：" + A + "，B录入是：" + B);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        threadPool.shutdown();


    }

}
