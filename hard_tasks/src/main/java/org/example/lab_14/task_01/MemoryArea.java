package org.example.lab_14.task_01;

public class MemoryArea {
    private int x;
    MemoryArea() {
        x = 0;
    }
    // Чтение
    public void readingData() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("x = " + x);
    }
    // Перезапись
    public synchronized void dataRecording() {
        x++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("x + 1 = " + x);
    }
}