package com.java.base.thread;

import java.util.concurrent.TimeUnit;

/**
 *
 * synchronized (pserson) 和 synchronized (pserson.getId)是没有互斥关系的。即不会争抢锁。
 *
 *
 * asus 梅锦涛
 * 2022/3/1
 *
 * @author mjt
 */
public class ThreadTest {

    public static void main(String[] args) {
        Pserson pserson = new Pserson();
        pserson.setId("personId");

        Thread t1 = new Thread(() -> {
            synchronized (pserson) {
                System.out.println("t1进入");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1");
                System.out.println("t1结束");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (pserson.getId()) {
                System.out.println("t2进入");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
                System.out.println("t2结束");
            }
        });
        t1.start();
        t2.start();

    }

}

class Pserson {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
