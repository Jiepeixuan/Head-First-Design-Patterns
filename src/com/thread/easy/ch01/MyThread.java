package com.thread.easy.ch01;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 09:32
 */

class MyThread extends Thread{

    private int num = 5;

    @Override
    public void run() {
        while (num > 0) {
            System.out.println("Thread:" + Thread.currentThread().getName() + ", cosume " + num);
            num--;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
