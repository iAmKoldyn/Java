package org.example.lab_14.task_01;

import java.util.concurrent.Semaphore;
public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        MemoryArea memoryArea = new MemoryArea();

        ReaderWriter client_1 = new ReaderWriter(semaphore, memoryArea);
        ReaderWriter client_2 = new ReaderWriter(semaphore, memoryArea);
        ReaderWriter client_3 = new ReaderWriter(semaphore, memoryArea);
        ReaderWriter client_4 = new ReaderWriter(semaphore, memoryArea);
        ReaderWriter client_5 = new ReaderWriter(semaphore, memoryArea);

        Thread x1 = new Thread(client_1, "Поток_1");
        Thread x2 = new Thread(client_2, "Поток_2");
        Thread x3 = new Thread(client_3, "Поток_3");
        Thread x4 = new Thread(client_4, "Поток_4");
        Thread x5 = new Thread(client_5, "Поток_5");

        x1.start();
        x2.start();
        x3.start();
        x4.start();
        x5.start();
    }
}