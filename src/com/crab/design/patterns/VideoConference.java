package com.crab.design.patterns;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/27 下午5:34
 */

class VideoConference implements Runnable {

    private final CountDownLatch countDownLatch;

    public VideoConference(int number) {
        countDownLatch = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        countDownLatch.countDown();
        System.out.printf("%s remove VideoConference: Waiting for %d participants.\n", name, countDownLatch.getCount());
    }

    @Override
    public void run() {
        long now = System.currentTimeMillis();
        System.out.printf("VidwoConference: Initialization: %d participants.\n", countDownLatch.getCount());
        try {
            countDownLatch.await();
            System.out.printf("VidwoConference: All the participants have come.\n");
            System.out.printf("VidwoConference: Let's start...");
            System.out.println("over，回家 cost:" + (System.currentTimeMillis() - now));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
