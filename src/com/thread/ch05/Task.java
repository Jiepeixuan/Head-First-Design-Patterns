package com.thread.ch05;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 10:09
 */

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.printf("%s: I am starting work.\n", Thread.currentThread().getName());
        try {
            while (true) {
                if (Thread.interrupted()) throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            System.out.printf("%s: I am interrupted.\n", Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s: Setting interrupt flag.\n", Thread.currentThread().getName());
        thread.interrupt();
    }
}
