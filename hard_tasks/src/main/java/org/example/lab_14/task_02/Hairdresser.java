package org.example.lab_14.task_02;

public class Hairdresser implements Runnable{
    Barbershop barbershop;
    Hairdresser(Barbershop s1) {
        barbershop = s1;
    }

    @Override
    public void run() {
        while (true) {
            barbershop.workBarber();
        }
    }
}
