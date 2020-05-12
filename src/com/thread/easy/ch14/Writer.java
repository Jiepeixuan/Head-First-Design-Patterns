package com.thread.easy.ch14;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:02
 */
public class Writer implements Runnable{
    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        double price1 = Math.random() * 10;
        double price2 = Math.random() * 8;
        try {
            Thread.sleep((long) (Math.random() * 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        priceInfo.setPrice(price1, price2);
    }
}
