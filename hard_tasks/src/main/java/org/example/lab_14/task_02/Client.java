package org.example.lab_14.task_02;

public class Client implements Runnable {
    Barbershop barbershop;
    String name;
    Client(Barbershop s1, String name) {
        barbershop = s1;
        this.name = name;
    }

    @Override
    public void run() {
        barbershop.workClient(this);
    }
}
