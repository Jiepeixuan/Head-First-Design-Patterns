package com.thread.ch12;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 11:16
 */

class Main {

    public static final Object producerController = new Object();
    public static final Object consumerController = new Object();

    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();

        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);

        Thread[] threads1 = new Thread[20];
        Thread[] threads2 = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads1[i] = new Thread(producer, "Producer-" + i);
            threads2[i] = new Thread(consumer, "Consumer-" + i);
        }

        for( int i = 0; i < 20; i++) {
            threads1[i].start();
            threads2[i].start();
        }
    }
}
