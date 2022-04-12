package com.java.base.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * synchronized 修饰同一个类的两个静态方式时互斥
 */

/**
 *  结论：两个线程分别同时执行同一个类产生的不同对象的两个不同synchronized static方法，类锁生效，
 *  虽然是不同对象，但是因为两个线程使用的是同一个类锁。
 *  反过来，假如test2()没有synchronized修饰的话，只有test1方法有被synchronized修饰，此时两个方法
 *  也不会互斥，一个有锁，一个没有锁，自然不会互斥。
 */
class SynchronizedAndClassLock {
    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            new ClassLock().test1();
        }).start();

        new Thread(() -> {
            new ClassLock().test2();
        }).start();
    }
}

/**
 * 如果是一静态，一实例，就不会互斥。
 * 结论: 两个线程同时分别执行一个被synchronized修饰static方法，一个有synchronized(该类)代码块
 * 的static方法，锁生效，虽然是不同对象，因为两个线程使用的同一个类锁。反过来，如果是修饰的不同类，因为
 * 类锁不同，肯定不会互斥。比如将test2()方法的synchronized(ClassLock2.class)这句代码改成
 * synchronized(SynchronizedAndClassLock.class)，此时不会互斥。
 *
 */
class SynchronizedAndClassLock2 {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            new ClassLock2().test1();
        }).start();

        new Thread(() -> {
            new ClassLock2().test2();
        }).start();
    }
}

/**
 * synchronized分别修饰同一个类的静态对象时互斥。
 * 如果是修饰不同的静态对象肯定不会互斥。
 */
class SynchronizedAndClassLock10 {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            new RunObject1().test1();
        }).start();

        new Thread(() -> {
            new RunObject2().test2();
        }).start();
    }
}

/**
 * 以下说的是 synchronized对象锁
 *
 * 这里说的synchronized对象锁的作用范围是对象级别的即仅仅作用于同一个对象，如果是
 * 同一个类的两个不同的对象是不会互斥的，即没有效果的。
 */

/**
 *
 *
 */
class SynchronizedAndClassLock3 {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            new ClassLock2().test1();
        }).start();

        new Thread(() -> {
            new ClassLock2().test2();
        }).start();
    }
}


