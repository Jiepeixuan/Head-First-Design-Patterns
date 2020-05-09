package com.thread.ch11;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 10:39
 */

//https://my.oschina.net/nenusoul/blog/793470

class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;
    private final Object controlCinema1, controlCinema2;

    public Cinema(long vacanciesCinema2, long vacanciesCinema1) {
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        this.vacanciesCinema2 = vacanciesCinema2;
        this.vacanciesCinema1 = vacanciesCinema1;
    }

    public boolean sellTickets1(int number) {
        synchronized (controlCinema1) {
            if (vacanciesCinema1 >= number) {
                vacanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTickets2(int number) {
        synchronized (controlCinema2) {
            if (vacanciesCinema2 >= number) {
                vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean returnTickets1(int number) {
        synchronized (controlCinema1) {
            vacanciesCinema1 += number;
            return true;
        }
    }

    public boolean returnTickets2(int number) {
        synchronized (controlCinema2) {
            vacanciesCinema2 += number;
            return true;
        }
    }

    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }
}
