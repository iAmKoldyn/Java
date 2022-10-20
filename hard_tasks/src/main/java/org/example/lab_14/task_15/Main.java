package org.example.lab_14.task_15;

public class Main {
    public static void main(String[] args) {

        Table table = new Table();
        Smoker smoker1 = new Smoker("Курильщик с бумагой ", Resourse.PAPER, table);
        Smoker smoker2 = new Smoker("Курильщик со спичками ", Resourse.MATCHES, table);
        Smoker smoker3 = new Smoker("Курильщик с табаком ", Resourse.TOBACCO, table);
        Barman barman = new Barman(table, new Smoker[]{smoker1, smoker2, smoker3});

        new Thread(smoker1).start();
        new Thread(smoker2).start();
        new Thread(smoker3).start();
        new Thread(barman).start();
    }
}