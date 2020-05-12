package com.thread.easy.ch16;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:26
 */
public class Main {

    public static void main(String[] args) {
        DataBuffer buffer = new DataBuffer(5);

        new Thread(new ProducerTask(buffer), "ProducerTask").start();
        new Thread(new ConsumerTask(buffer), "ConsumerTask").start();
    }
}
