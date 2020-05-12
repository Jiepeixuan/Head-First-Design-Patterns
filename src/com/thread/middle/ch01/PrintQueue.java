package com.thread.middle.ch01;

import java.util.concurrent.Semaphore;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:37
 */

/**
 * Semaphore是一个二进制信号量，只有0和1两个值。如果线程想要访问一个共享资源，它必须先获得信号量。如果信号量的内部计数器大于0，那么信号量减1，并允许访问这个资源。否则，如果信号量计数器等于0，线程会等待直至计数器大于0。

 所以说计数器大于0，说明有资源可用。计数器等于0，说明没有资源可用。

 同时Semaphore提供了一个带有boolean参数的构造方法，true代表公平锁，false代表非公平锁，默认实现是非公平锁。

 我们使用Semaphore信号量来重写PrintQueue的例子。

 首先实现一个PrintQueue打印队列，有一个Semaphore信号量用来并发访问控制。打印之前使用acquire()方法获取信号量，执行完毕后使用release()方法释放信号量。每次打印等待一个随机时间，模拟打印耗时。
 */
public class PrintQueue {

    private Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);   //非公平的
//        semaphore = new Semaphore(1, true); //公平的
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            long duration = (long)(Math.random() * 10000);
            System.out.printf("%s: Print a job duration %d seconds.\n",
                    Thread.currentThread().getName(), duration / 1000);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
