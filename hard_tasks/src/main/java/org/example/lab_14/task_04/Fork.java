package org.example.lab_14.task_04;

import java.util.concurrent.Semaphore;
public class Fork {
    Semaphore semaphore;
    Fork(Semaphore semaphore) {
        this.semaphore =  semaphore;
    }
}
