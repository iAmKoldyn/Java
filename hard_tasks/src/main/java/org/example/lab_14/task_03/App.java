package org.example.lab_14.task_03;

public class App {
    public static void main(String[] args) {
        Table table = new Table();
        Smoker smokerWithTobacco = new Smoker("smoker1", Resource.TOBACCO);
        Smoker smokerWithPaper = new Smoker("smoker2", Resource.PAPER);
        Smoker smokerWithMatches = new Smoker("smoker3", Resource.MATCHES);

        Thread sm1Thread = new Thread(new SmokerThread(smokerWithTobacco, table));
        Thread sm2Thread = new Thread(new SmokerThread(smokerWithPaper, table));
        Thread sm3Thread = new Thread(new SmokerThread(smokerWithMatches, table));
        Thread barman = new Thread(new BarmanThread(table, new Smoker[]{smokerWithTobacco, smokerWithPaper, smokerWithMatches}));

        sm1Thread.start();
        sm2Thread.start();
        sm3Thread.start();
        barman.start();
    }
}