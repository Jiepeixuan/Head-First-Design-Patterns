package com.thread.middle.ch02;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 16:32
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread[] threads = new Thread[10];
        for (int i = 1; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue));
        }

        for (int i = 1; i < 10; i++) {
            threads[i].start();
        }
    }
}
