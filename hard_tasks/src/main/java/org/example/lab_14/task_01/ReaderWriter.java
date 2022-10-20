package org.example.lab_14.task_01;

import java.util.concurrent.Semaphore;
public class ReaderWriter implements Runnable{
    Semaphore semaphore;
    MemoryArea memoryArea;
    ReaderWriter(Semaphore semaphore, MemoryArea memoryArea) {
        this.semaphore =  semaphore;
        this.memoryArea = memoryArea;
    }

    @Override
    public void run() {
        while (true) {
            memoryArea.readingData();
            try {
                semaphore.acquire(); // Просим разрешение на чтение
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            memoryArea.dataRecording();
            semaphore.release();
        }
    }
}

