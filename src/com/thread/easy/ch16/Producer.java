package com.thread.easy.ch16;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:23
 */
public class Producer implements Runnable{

    private  DataBuffer buffer;

    public Producer(DataBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.put();
    }
}
