package com.thread.easy.ch12;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 11:21
 */

class Producer implements Runnable{

    private EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        eventStorage.set();
    }
}
