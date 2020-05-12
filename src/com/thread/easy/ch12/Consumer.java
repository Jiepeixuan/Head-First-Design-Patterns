package com.thread.easy.ch12;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 11:22
 */

class Consumer implements Runnable {

    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        eventStorage.get();
    }
}
