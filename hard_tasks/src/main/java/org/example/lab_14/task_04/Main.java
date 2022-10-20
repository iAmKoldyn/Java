package org.example.lab_14.task_04;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        /*
         * Создаём вилки с помощу которых философы будут есть
         */
        Fork fork_1 = new Fork(new Semaphore(1));
        Fork fork_2 = new Fork(new Semaphore(1));
        Fork fork_3 = new Fork(new Semaphore(1));
        Fork fork_4 = new Fork(new Semaphore(1));
        Fork fork_5 = new Fork(new Semaphore(1));
        /*
         * Создаём офицанта который будет разрешать есть философам
         */
        Waiter waiter = new Waiter(new Semaphore(2));
        /*
         * Создаём философов которые будут думать или размышлять
         */
        Philosopher philosopher_1 = new Philosopher(fork_1, fork_2, waiter);
        Philosopher philosopher_2 = new Philosopher(fork_2, fork_3, waiter);
        Philosopher philosopher_3 = new Philosopher(fork_3, fork_4, waiter);
        Philosopher philosopher_4 = new Philosopher(fork_4, fork_5, waiter);
        Philosopher philosopher_5 = new Philosopher(fork_5, fork_1, waiter);
        /*
         * Создаём и запускаем потоки философов
         */
        Thread x1 = new Thread(philosopher_1);
        Thread x2 = new Thread(philosopher_2);
        Thread x3 = new Thread(philosopher_3);
        Thread x4 = new Thread(philosopher_4);
        Thread x5 = new Thread(philosopher_5);

        x1.start();
        x2.start();
        x3.start();
        x4.start();
        x5.start();
    }
}
