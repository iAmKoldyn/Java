package org.example.lab_14.task_02;

import java.util.LinkedList;
import java.util.Queue;
public class Barbershop {
    final int CHAIR = 3; // Количество мест в рчереди
    int NumberOfOccupiedChairs; // Количество занятых стульев
    static boolean haircut; // Идёт стрижка или нет
    Hairdresser barber;
    Client client;
    Queue<Client> barbershopQueue = new LinkedList<>(); // Очередь в которой хранятся клиенты
    Barbershop() {
        NumberOfOccupiedChairs = 0;
        haircut = false;
        barber = new Hairdresser(this);
    }
    /*
     * Метод(workClient) описывающий принцип работы клиента
     * @param client - клиент который приходит в парекмахерскую
     */
    public synchronized void workClient(Client client) { // Описание логики клиента
        System.out.println("Клиет " + client.name + " пришёл в парикмахерскую.");
        if (haircut == false) { // Если парикмахер спит
            haircut = true;
            this.client = client;
            System.out.println("Клиет " + client.name + ": под троечку.");
        } else {
            workClientTrue(client);
        }
        try {
            notify(); // Запускает другой поток
            wait(); // Ожидание
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * Метод(workClientTrue) описывающий принцип работы клиента
     * @param client - клиент который приходит в парекмахерскую
     */
    public void workClientTrue(Client client) {
        if (NumberOfOccupiedChairs < CHAIR) { // Если в очереди есть место то клиент занимает в ней место
            barbershopQueue.add(client); // Клиет сел в очередь
            NumberOfOccupiedChairs++;
            System.out.println("Клиент " + client.name + ": парикмахер занят, займу очередь.");
        } else {
            System.out.println("Клиент " + client.name + ": очереди нет места, придется уйти.");
        }
    }

    /*
     * Принцип работы парекмахера
     * Метод(workBarber) описывающий принцип работы парикмахера
     */
    public synchronized void workBarber() { // Описание логики парикмахера
        if (this.client == null) { // Парекмахер спит
            haircut = false;
            System.out.println("спит");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.client != null) { // Парекмахер занят стрижкой
            haircut = true;
            System.out.println("Парекмахер: Начал стрич клиента " + this.client.name);
            try {
                wait(1000);
                System.out.println("Парекмахер: Закончил стрич клиента " + this.client.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.client = null;
            if (NumberOfOccupiedChairs != 0) {
                System.out.println("Парекмахер: Позвал следующего клиента");
            }
            nextClient();
        }
    }
    /*
     * Метод(nextClient) вызывает следующего клиента на стрижку
     */
    public synchronized void nextClient() {
        if (NumberOfOccupiedChairs != 0) {
            this.client = barbershopQueue.poll();
            NumberOfOccupiedChairs--;
            System.out.println("Парекмахер: Пригласил клиента " + this.client.name);
        } else {
            haircut = false;
            System.out.println("спит");
        }
    }
}
