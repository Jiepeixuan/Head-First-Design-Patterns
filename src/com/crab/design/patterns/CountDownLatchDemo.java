package com.crab.design.patterns;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/11/27 下午5:18
 */

class CountDownLatchDemo {

    public static void main(String[] args) {
        VideoConference videoConference = new VideoConference(100);
        Thread threadConference = new Thread(videoConference);
        threadConference.start();

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(new Participant("P-" + i, videoConference));
        }

        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
    }
}
