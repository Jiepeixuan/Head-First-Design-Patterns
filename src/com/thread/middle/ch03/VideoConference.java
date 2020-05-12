package com.thread.middle.ch03;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 16:37
 */
public class VideoConference implements Runnable{

    private final CountDownLatch controller;

    public VideoConference(int number) {
        controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VidwoConference: Initialization: %d participants.\n", controller.getCount());
        try {
            controller.await();
            System.out.printf("VidwoConference: All the participants have come.\n");
            System.out.printf("VidwoConference: Let's start...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
