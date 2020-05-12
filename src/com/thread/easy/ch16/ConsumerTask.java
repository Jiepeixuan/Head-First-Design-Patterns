package com.thread.easy.ch16;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:26
 */
public class ConsumerTask implements Runnable {
    private DataBuffer buffer;

    public ConsumerTask(DataBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Consumer(buffer), "Consumer-" + i).start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
