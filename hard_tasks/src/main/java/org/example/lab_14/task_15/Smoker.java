package org.example.lab_14.task_15;

public class Smoker implements Runnable {
    private static final int MIN_TIME_FOR_GET_RESOURCE = 1000;

    private static final int TIME_FOR_GET_RESOURCE_INTERVAL = 1000;

    private static final int MIN_TIME_FOR_SMOKING = 3000;

    private static final int TIME_FOR_SMOKING_INTERVAL = 6000;

    private String name;
    private Resourse resource;

    private Table table;

    private SmokerStat status = SmokerStat.WAITING;

    public SmokerStat getStatus() {
        return status;
    }

    Smoker(String name, Resourse resource, Table table) {
        this.name = name;
        this.resource = resource;
        this.table = table;
    }

    public synchronized Resourse getResource() {
        return resource;
    }

    public boolean AllResourcesOnTheTable() {
        if (this.resource.equals(Resourse.PAPER)) {
            return table.hasMatches() && table.hasTobacco();
        } else if (this.resource.equals(Resourse.MATCHES)) {
            return table.hasPaper() && table.hasTobacco();
        } else {
            return table.hasMatches() && table.hasPaper();
        }
    }

    public Resourse[] takeResourcesFromTable() {
        if (this.resource.equals(Resourse.PAPER)) {
            return new Resourse[]{table.getMatches(), table.getTobacco()};
        } else if (this.resource.equals(Resourse.MATCHES)) {
            return new Resourse[]{table.getPaper(), table.getTobacco()};
        } else {
            return new Resourse[]{table.getMatches(), table.getPaper()};
        }
    }

    public void run() {
        while (true) {
            try {
                status = SmokerStat.WAITING;
                Thread.sleep(MIN_TIME_FOR_GET_RESOURCE + (int) (Math.random() * TIME_FOR_GET_RESOURCE_INTERVAL));
                if (AllResourcesOnTheTable()) {
                    takeResourcesFromTable();
                    status = SmokerStat.SMOKING;
                    System.out.println(this.name + " ушел курить");
                    Thread.sleep(MIN_TIME_FOR_SMOKING + (int) (Math.random() * TIME_FOR_SMOKING_INTERVAL));
                    System.out.println(this.name + " вернулся");
                } else {
                    System.out.println(this.name + " не нашел нужных ресурсов");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}