package com.thread.easy.ch01;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 09:36
 */

class MyRunnable implements Runnable{
    private int num = 5;

    @Override
    public void run() {
        while (num > 0) {
            System.out.println("Thread:" + Thread.currentThread().getName() + ", consume " + num);
            num--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();
        thread3.start();

        Runnable runnable = new MyRunnable();

        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);

        thread4.start();
        thread5.start();
        thread6.start();
    }
}
