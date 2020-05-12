package com.thread.middle.ch02;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:46
 */
public class PrintQueue {
    private boolean freePrinters[];
    private Lock lockPrinters;
    private Semaphore semaphore;

    public PrintQueue() {
        this.freePrinters = new boolean[3];
        this.lockPrinters = new ReentrantLock();
        this.semaphore = new Semaphore(3);
        for (int i = 0; i < 3; i++) {
            this.freePrinters[i] = true;
        }
    }

    public void printJob(Object object) {
        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();

            long duration = (long)(Math.random() * 10);
            System.out.printf("%s: Print a Job in printer %d duration %d seconds.\n",
                    Thread.currentThread().getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);

            freePrinter(assignedPrinter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void freePrinter(int printNo) {
        lockPrinters.lock();

        try {
            freePrinters[printNo] = true;
        } finally {
            lockPrinters.unlock();
        }
    }

    private int getPrinter() {
        lockPrinters.lock();
        int printNo = -1;
        try {
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    printNo = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } finally {
            lockPrinters.unlock();
        }
        return printNo;
    }
}
