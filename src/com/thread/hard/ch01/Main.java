package com.thread.hard.ch01;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 16:48
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        for (int i = 0; i < 10; i++) {
            Task task = new Task("Task" + i);
            server.execute(task);
            Thread.sleep(1000);
        }
        server.endServer();
    }
}
