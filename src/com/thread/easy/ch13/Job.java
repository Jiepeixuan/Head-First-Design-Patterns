package com.thread.easy.ch13;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:12
 */
public class Job implements Runnable{
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document.\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed.\n", Thread.currentThread().getName());
    }
}
