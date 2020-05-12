package com.thread.easy.ch13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:11
 */
public class PrintQueue {

    private final Lock queueLock = new ReentrantLock(true);

    public void printJob(Object document) {
        try {
            queueLock.lock();
            long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() +
                    " PrintQueue: print a job during " + (duration / 1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
