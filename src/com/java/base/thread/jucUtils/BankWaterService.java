package com.java.base.thread.jucUtils;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * mjt 梅锦涛
 * 2024/2/2
 *
 * @author mjt
 */

/**
 * 在这个例子中，CyclicBarrier
 * 确保所有的银流数据计算线程都完成其工作后，再进行结果的汇总。
 * 这是一个典型的分工合作的并行计算模式，
 * 常用于将一个大的计算任务分割成若干个小的任务并行执行，最后再将结果合并
 *
 *
 */
public class BankWaterService implements Runnable{

    /**
     * 创建4个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4,this);

    /**
     * 假设只有4个sheet，所以只启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算出的银流结果
     */
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    /**
     * 为每个sheet启动一个线程（总共4个线程），每个线程负责计算一个sheet的银流数据。
     * 每个线程在完成计算后，将其结果放入 sheetBankWaterCount 中。
     * 每个线程完成工作后，调用 c.await() 来等待其他线程。当所有4个线程都到达这个屏障点时，CyclicBarrier 触发 BankWaterService 的 run 方法。
     */
    private void count() {
        System.out.println("进入count方法");
        for (int i = 0; i < 4; i++) {
             executor.execute(new Runnable() {
                 @Override
                 public void run() {
                     // 计算当前sheet的银流数据，计算代码省略
                     sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                     try {
                         // 银流计算完成，插入一个屏障
                         c.await();
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     } catch (BrokenBarrierException e) {
                         throw new RuntimeException(e);
                     }
                 }
             });


        }
        System.out.println("count方法结束");
    }

    /**
     * 当所有线程都到达屏障时，执行 run 方法。
     * run 方法遍历 sheetBankWaterCount，累加所有sheet的结果，并将最终结果放入 sheetBankWaterCount 中。
     * 打印出最终累加的结果。
     */
    @Override
    public void run() {
        System.out.println("进入run  方法");
        int result = 0;
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }

        sheetBankWaterCount.put("result",result);
        System.out.println(result);
        System.out.println("进入run  方法结束");


    }

    public static void main(String[] args) {

        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();

    }
}
