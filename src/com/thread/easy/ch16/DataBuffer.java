package com.thread.easy.ch16;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:18
 */
public class DataBuffer {

    private int maxSize;
    private LinkedList<Date> buffer;

    private Lock lock;
    private Condition producer;
    private Condition consumer;

    public DataBuffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        producer = lock.newCondition();
        consumer = lock.newCondition();
    }

    public void put() {
        try {
            lock.lock();
            while (buffer.size() == this.maxSize) {
                producer.await();
            }
            buffer.add(new Date());
            System.out.printf("%s: Add one %s. Buffer size is %d.\n",
                    Thread.currentThread().getName(),
                    buffer.peekLast(),
                    buffer.size());
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (buffer.size() == 0) {
                consumer.await();
            }
            System.out.printf("%s: Get one %s. Buffer size is %d.\n",
                    Thread.currentThread().getName(),
                    buffer.pollFirst(),
                    buffer.size());
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
