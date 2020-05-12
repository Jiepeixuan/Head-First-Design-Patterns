package com.thread.hard.ch01;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 16:47
 */
public class Server {
    ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    /**
     * 执行任务并打印当前线程池状态
     * @param task 任务
     */
    public void execute(Task task) {
        System.out.println("Server: A new task has arrived.\n");
        executor.execute(task);
        //返回线程池中的线程数
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        //返回线程池中正在运行的线程数
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        //返回线程池中已经完成的任务数
        System.out.printf("Server: Completed Task: %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}
