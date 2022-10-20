package org.example.lab_14.task_03;

public class BarmanThread implements Runnable {

    public static final long MIN_TIME_BETWEEN_ADD_RESOURCE = 1000;

    public static final long MAX_TIME_BETWEEN_ADD_RESOURCE = 2000;

    public Table table;

    public Smoker[] smokers;

    public BarmanThread(Table table, Smoker[] smokers) {
        this.table = table;
        this.smokers = smokers;
    }

    public void run() {
        try {
            while (true) {
                int[] indexes = getArrayBesidesRandomNumber(2);

                for (int index : indexes) {
                    if (smokers[index].isSmoke()) continue;
                    if (table.hasResource(smokers[index].getResource())) continue;

                    smokers[index].addResourceToTable(table);
                    System.out.println("бармен добавил " + smokers[index].getResource());
                }

                Thread.sleep(MIN_TIME_BETWEEN_ADD_RESOURCE + (int) (Math.random() * (MAX_TIME_BETWEEN_ADD_RESOURCE - MIN_TIME_BETWEEN_ADD_RESOURCE)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] getArrayBesidesRandomNumber(int max) {
        int number = (int) (Math.random() * (max + 1));
        int[] result = new int[max];

        for (int i = 0; i < result.length; i++) {
            result[i] = (number + i + 1) % (max + 1);
        }

        return result;
    }
}