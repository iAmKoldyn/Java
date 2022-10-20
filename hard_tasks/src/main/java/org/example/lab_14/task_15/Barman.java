package org.example.lab_14.task_15;

import java.util.ArrayList;

public class Barman implements Runnable {

    private static final int MIN_TIME_FOR_WAITING = 1000;

    private static final int TIME_FOR_WAITING_INTERVAL = 2000;

    private Table table;

    private Smoker[] smokers;

    private BarmanStat status = BarmanStat.WAITING;

    private ArrayList<Smoker> waitingSmokers = new ArrayList<>();

    Barman(Table table, Smoker[] smokers) {
        this.table = table;
        this.smokers = smokers;
    }

    private void updateWaitingSmokers() {
        waitingSmokers.clear();
        for (Smoker smoker : smokers) {
            if (smoker.getStatus() == SmokerStat.WAITING) {
                waitingSmokers.add(smoker);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                ArrayList<Resourse> takenResources = new ArrayList<>();
                Thread.sleep(MIN_TIME_FOR_WAITING + (int) (Math.random() * TIME_FOR_WAITING_INTERVAL));
                updateWaitingSmokers();
                if (waitingSmokers.size() >= 2) {
                    System.out.println("Бармен кладет ресурсы");
                    for (int i = 0; i < 2; i++) {
                        takenResources.add(waitingSmokers.get((int) (Math.random() * waitingSmokers.size())).getResource());
                    }
                    table.addResources(takenResources);
                    takenResources.clear();
                } else {
                    System.out.println("Бармен не может взять ресурсы");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}