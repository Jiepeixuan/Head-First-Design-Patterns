package com.thread.hard.ch01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 16:47
 */
public class Task implements Runnable {
    private String name;
    private Date initDate;

    public Task(String name) {
        this.name = name;
        this.initDate = new Date();
    }

    /**
     * 任务过程
     * 1. 打印任务创建时间
     * 2. 打印任务开始时间
     * 3. 任务随机休眠一段时间
     * 4. 打印任务结束时间
     */
    @Override
    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.printf("%s: Task %s: Created on: %s\n",
                Thread.currentThread().getName(), name, format.format(initDate));
        System.out.printf("%s: Task %s: Started on: %s\n",
                Thread.currentThread().getName(), name, format.format(new Date()));
        long duration = (long) (Math.random() * 10);
        System.out.printf("%s: Task %s: Do something duration %d Seconds\n",
                Thread.currentThread().getName(), name, duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Task %s: Finished on: %s\n",
                Thread.currentThread().getName(), name, format.format(new Date()));
    }
}
