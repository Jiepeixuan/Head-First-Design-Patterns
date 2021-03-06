package com.thread.middle.ch03;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 16:39
 */
public class Main {
    public static void main(String[] args) {
        VideoConference videoConference = new VideoConference(10);
        Thread threadConference = new Thread(videoConference);
        threadConference.start();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Participant("P-" + i, videoConference));
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
