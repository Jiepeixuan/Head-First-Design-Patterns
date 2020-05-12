package com.thread.easy.ch16;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:24
 */
public class Consumer implements Runnable{
    private DataBuffer buffer;

    public Consumer(DataBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.get();
    }
}
