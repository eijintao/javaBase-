package com.java.base.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * mjt 梅锦涛
 * 2024/2/2
 *
 * @author mjt
 */
public class ExcutorServiceTest {
    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(100);

    RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();








    public static void main(String[] args) {

        /**
         *
         * runnableTaskQueue(任务队列)：
         *      ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序。
         *      LinkedBlockingQueue：一个基于链表结构得到阻塞队列，此队列按FIFO排序元素。
         *      SynchronousQueue：一个不存储元素的阻塞队列
         *      PriorityBlockingQueue：一个具有优先级的额无线阻塞队列
         *
         * RejectedExecutionHandler(饱和策略):
         *      AbortPolicy：直接抛出异常
         *      CallerRunsPolicy：只用调用者所在线程来运行任务
         *      DiscardOldestPolicy：丢弃队列里最近的一个任务，并执行当前任务
         *      DiscardPolicy: 不处理，丢弃掉
         *
         *
         *
         *
         * keepAliveTime: 线程活动保持时间
         * TimeUnit: 线程活动保持时间的单位
         */
        ExecutorService executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() * 2, 4L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());

        /**
         * 无返回值
         */
        executorService.execute(() ->{

        });

        /**
         * 有返回值
         */
        Future<?> submit = executorService.submit(() -> {
                }
        );

        /**
         * 将当前线程池状态设置成SHUTDOWN状态，中断所有没有正在执行任务的线程
         */
        executorService.shutdown();

        /**
         * 将正在运行的线程进行关闭处理。是全部的，包括了正在运行的。
         */
        executorService.shutdownNow();


    }

}
