package com.thread.middle.ch01;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:40
 */
public class Job implements Runnable{
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a Job.\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The Job has been printed.\n", Thread.currentThread().getName());
    }
}

