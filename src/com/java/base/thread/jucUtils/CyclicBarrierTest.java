package com.java.base.thread.jucUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * mjt 梅锦涛
 * 2024/2/2
 *
 * @author mjt
 *
 *
 * 代码详情见于：Java并发编程的艺术
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(3);

    public static void main(String[] args) throws InterruptedException {
        int numberWaiting = c.getNumberWaiting();
        System.out.println("numberWaiting1 : " + numberWaiting);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(1);
                int numberWaiting12 = c.getNumberWaiting();
                System.out.println("numberWaiting12 : " + numberWaiting12);
            }
        }).start();

        Thread.sleep(100); // 添加小的延时以帮助线程调度

        int numberWaiting2 = c.getNumberWaiting();
        System.out.println("numberWaiting2 : " + numberWaiting2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(3);
                int numberWaiting13 = c.getNumberWaiting();
                System.out.println("numberWaiting13 : " + numberWaiting13);
            }
        }).start();

        Thread.sleep(100); // 添加小的延时以帮助线程调度

        int numberWaiting3 = c.getNumberWaiting();
        System.out.println("numberWaiting3 : " + numberWaiting3);

        try {
            c.await();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(2);

        int numberWaiting4 = c.getNumberWaiting();
        System.out.println("numberWaiting4 : " + numberWaiting4);
    }

}


class CyclicBarrierTest01 {

    /**
     * 用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景。
     */
    static CyclicBarrier c = new CyclicBarrier(2,new A());

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(2);

    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}