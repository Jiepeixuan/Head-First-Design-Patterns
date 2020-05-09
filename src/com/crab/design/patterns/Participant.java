package com.crab.design.patterns;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/27 下午5:39
 */

class Participant implements Runnable {

    private String name;
    private VideoConference videoConference;

    public Participant(String name, VideoConference conference) {
        this.name = name;
        this.videoConference = conference;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        videoConference.arrive(name);
    }
}
