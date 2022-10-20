package org.example.lab_14.task_04;

public class Philosopher implements Runnable {
    Fork rightFork;
    Fork leftFork;
    Waiter waiter;
    Philosopher(Fork rightFork, Fork leftFork, Waiter waiter) {
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.waiter = waiter;
    }
    @Override
    public void run() {
        while (true) {
            theLogicOfThePhilosopher();
        }
    }
    /*
     * Метод описывающий логику философа
     */
    public void theLogicOfThePhilosopher() {
        if (waiter.semaphore.tryAcquire()) { // Если получаем разрешение на еду
            eat(); // Едим
            waiter.semaphore.release();
            think(); // Думаем
        } else { // Иначе думаем
            think();
        }
    }
    /*
     * Метод с помощу которого философ ест
     */
    public void eat() {
        // Пытаемся взять вилки
        takeTheRightFork();
        takeTheLeftFork();
        if (!rightFork.semaphore.tryAcquire() && !leftFork.semaphore.tryAcquire()) { // Начили приём пищи
            System.out.println("Начал приём пищи " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Закончил приём пищи " + Thread.currentThread().getName());
            putTheRightFork();
            putTheLeftFork();
        } else { // Начили размышлять
            think();
        }
    }
    /*
     * Метод с помощу которого философ бирёт правую вилку
     */
    public void takeTheRightFork() {
        if (rightFork.semaphore.tryAcquire()) {
            System.out.println("Взял правую вилку " + Thread.currentThread().getName());
        } else if (!leftFork.semaphore.tryAcquire()) {
            putTheLeftFork();
        }
    }
    /*
     * Метод с помощу которого философ ложит левую вилку
     */
    public void putTheLeftFork() {
        leftFork.semaphore.release();
        System.out.println("Положил левую вилку " + Thread.currentThread().getName());
    }
    /*
     * Метод с помощу которого философ бирёт левую вилку
     */
    public void takeTheLeftFork() {
        if (leftFork.semaphore.tryAcquire()) {
            System.out.println("Взял левую вилку " + Thread.currentThread().getName());
        } else if (!rightFork.semaphore.tryAcquire()) {
            putTheRightFork();
        }
    }
    /*
     * Метод с помощу которого философ ложит правую вилку
     */
    public void putTheRightFork() {
        leftFork.semaphore.release();
        System.out.println("Положил правую вилку " + Thread.currentThread().getName());
    }
    /*
     * Метод с помощу которого философ думет
     */
    public void think() {
        System.out.println("Начал филосовствовать " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Закончил филосовствовать " + Thread.currentThread().getName());
    }
}
