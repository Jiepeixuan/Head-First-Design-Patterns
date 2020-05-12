package com.thread.easy.ch14;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description:
 * Author:          crab
 * Time:            2020/5/12 14:57
 */
public class PriceInfo {

    private double price1;
    private double price2;

    private ReadWriteLock lock;

    public PriceInfo() {
        price1 = 1.0;
        price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        lock.readLock().lock();
        double value = price1;
        lock.readLock().unlock();
        return  price1;
    }

    public double getPrice2() {
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return price2;
    }

    public void setPrice(double price1, double price2){
        lock.writeLock().lock();
        System.out.printf("Writer: Attemp to modify the price! Price1:%f Price2:%f\n", price1, price2);
        this.price1 = price1;
        this.price2 = price2;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Writer: Price has been modified: Price1:%f Price2:%f\n", price1, price2);
        lock.writeLock().unlock();
    }
}
