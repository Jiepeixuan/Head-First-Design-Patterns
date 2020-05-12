package com.thread.easy.ch14;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:04
 */
public class Main {

    public static void main(String[] args) {
        PriceInfo priceInfo = new PriceInfo();

        for (int i = 0; i < 3; i++) {
            Thread threadWriter = new Thread(new Writer(priceInfo));
            threadWriter.start();
        }

        while (true) {
            new Thread(new Reader(priceInfo)).start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
