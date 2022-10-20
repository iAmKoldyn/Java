package org.example.lab_14.task_04;

import java.util.concurrent.Semaphore;
public class Waiter {
    Semaphore semaphore;
    Waiter(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
}
