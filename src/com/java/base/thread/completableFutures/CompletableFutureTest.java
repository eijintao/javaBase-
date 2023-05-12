package com.java.base.thread.completableFutures;



import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * asus 梅锦涛
 * 2022/5/3
 *
 * @author mjt
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {
           //test();
           test2();
          // test4();
    }

    /**
     * 子线程是异步执行的，主线程休眠等待子线程执行完成，
     * 子线程执行完成后唤醒主线程，主线程获取任务执行结果后退出。
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void test () throws ExecutionException, InterruptedException {
        // newSingleThreadExecutor创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有
        // 任务按照指定顺序（FIFO,LIFO,优先级）执行。
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> submit = executorService.submit(() -> {
            Thread.currentThread().setName("线程1");
            System.out.println(Thread.currentThread().getName() + " start,time " + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (false) {
                throw new RuntimeException("test");
            } else {
                System.out.println(Thread.currentThread().getName() + " end,time " + System.currentTimeMillis());
                return 1.2;
            }
        });

        System.out.println("main thread start,time->"+ Thread.currentThread().getName() +" "+System.currentTimeMillis());
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        // get方法抛出异常导致主线程异常终止。
        System.out.println("run result->"+submit.get());
        System.out.println("main thread exit,time->"+ Thread.currentThread().getName() +" "+ System.currentTimeMillis());

    }

    public static void test2() throws Exception {
        // 创建异步执行任务，有返回值
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(false){
                throw new RuntimeException("test");
            }else{
                System.out.println(Thread.currentThread()+" exit,time->"+System.currentTimeMillis());
                return 1.2;
            }
        });
        System.out.println("main thread start,time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("run result->"+cf.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }


    public static void test4() throws Exception {
        // 创建异步执行任务，无返回值
        CompletableFuture cf = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread()+" start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(false){
                throw new RuntimeException("test");
            }else{
                System.out.println(Thread.currentThread()+" exit,time->"+System.currentTimeMillis());
            }
        });
        System.out.println("main thread start,time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("run result->"+cf.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }


}
