package com.thread.easy.ch16;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:25
 */
public class ProducerTask implements Runnable{

    private DataBuffer buffer;

    public ProducerTask(DataBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Producer(buffer), "Producer-" + i).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
