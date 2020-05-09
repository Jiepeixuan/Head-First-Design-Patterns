package com.thread.ch12;

import java.util.Date;
import java.util.LinkedList;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 11:17
 */

class EventStorage {

    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public void set() {
        synchronized (Main.producerController) {
            while (storage.size() == maxSize) {
                try {
                    Main.producerController.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(new Date());
            System.out.printf("%s: Add one. storge size: %d.\n", Thread.currentThread().getName(), storage.size());
        }

        synchronized (Main.consumerController) {
            Main.consumerController.notifyAll();
        }
    }

    public void get() {
        synchronized (Main.consumerController) {
            while (storage.size() == 0) {
                try {
                    Main.consumerController.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: Get one %s. Storge size: %d.\n", Thread.currentThread().getName(), storage.poll(), storage.size());
        }

        synchronized (Main.producerController) {
            Main.producerController.notifyAll();
        }
    }

}
