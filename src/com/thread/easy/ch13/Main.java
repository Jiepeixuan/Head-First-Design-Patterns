package com.thread.easy.ch13;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:13
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        PrintQueue printQueue = new PrintQueue();
        Job job = new Job(printQueue);

        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(job);
            thread.start();
            Thread.sleep(100);
        }
    }
}
