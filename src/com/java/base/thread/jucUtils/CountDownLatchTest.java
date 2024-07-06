package com.java.base.thread.jucUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * mjt 梅锦涛
 * 2024/2/2
 *
 * @author mjt
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException{

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(1);
                c.countDown();
                //for (int i = 6; i < 8 ; i++) {
                //    System.out.println(i);
                //}
                System.out.println(2);
                c.countDown();
                //long count2 = c.getCount();
                //System.out.println("thread1 count2 :" + count2);
            }
        },"t1");
        thread1.start();



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(4);
                c.countDown();


                System.out.println(5);
                c.countDown();
                //long count2 = c.getCount();
                //System.out.println("thread2 count2 :" + count2);
            }
        },"t2");
        thread2.start();



        System.out.println("count2 : " + c.getCount());

            System.out.println(3);


    }

}

class CyclicBarrierTest02 {

    public static void main(String[] args) {

        //CyclicBarrier c = new CyclicBarrier(2);
        CyclicBarrier c = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("done");
            }
        });
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));
        //CyclicBarrier c = new CyclicBarrier(2, () -> System.out.println("done"));

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
