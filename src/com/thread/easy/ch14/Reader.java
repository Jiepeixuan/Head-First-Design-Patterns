package com.thread.easy.ch14;

import java.util.Date;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 15:04
 */
public class Reader implements Runnable {
    private PriceInfo priceInfo;

    public Reader(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        Date date = new Date();
        System.out.printf("%s: Price1 %f .%s\n",
                Thread.currentThread().getName(), priceInfo.getPrice1(), date);
        System.out.printf("%s: Price2 %f .%s\n",
                Thread.currentThread().getName(), priceInfo.getPrice2(), date);
    }
}
