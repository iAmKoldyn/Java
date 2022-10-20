package org.example.lab_14.task_02;

public class Main {
    public static void main(String[] args) {
        Barbershop s1 = new Barbershop();
        Client visitor1 = new Client(s1, "Олег");
        Client visitor2 = new Client(s1, "Олиг");
        Client visitor3 = new Client(s1, "Олежа");
        Client visitor4 = new Client(s1, "Алек");
        Client visitor5 = new Client(s1, "Алек");

        Thread w1 = new Thread(visitor1);
        Thread w2 = new Thread(visitor2);
        Thread w3 = new Thread(visitor3);
        Thread w4 = new Thread(visitor4);
        Thread w5 = new Thread(visitor5);
        Thread bardershop = new Thread(s1.barber);

        w1.start();
        w2.start();
        w3.start();
        w4.start();
        w5.start();
        bardershop.start();
    }
}
