package com.thread.ch11;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2020-05-09 10:46
 */

class Main {

    public static void main(String[] args) {
        Cinema cinema = new Cinema(20, 20);

        TicketOffice1 office1 = new TicketOffice1(cinema);
        TicketOffice2 office2 = new TicketOffice2(cinema);

        Thread thread1 = new Thread(office1, "Ticket-Office-1");
        Thread thread2 = new Thread(office2, "TIcket-Office-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Room1 vacancies: %d\n", cinema.getVacanciesCinema1());
        System.out.printf("Room2 vacancies: %d\n", cinema.getVacanciesCinema2());
    }

}
