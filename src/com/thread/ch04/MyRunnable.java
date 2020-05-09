package com.thread.ch04;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 10:06
 */

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.printf("%s: I am start working.\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep((long) (Math.random() * 10 + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: I am end working.\n", Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        System.out.printf("%s: start two threads.\n", Thread.currentThread().getName());
        thread1.start();
        thread2.start();

        try {
//            在主方法中调用子线程的join()方法，即可让主线程进入WAITING状态并等待子线程终止后继续执行。
            thread2.join();
            thread1.join();
            System.out.printf("%s: child runnable both ends.\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s: end.\n", Thread.currentThread().getName());
    }
}
