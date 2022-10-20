package org.example.lab_14.task_03;

public class SmokerThread implements Runnable {

    public static final long MIN_TIME_BETWEEN_CHECK = 1000;

    public static final long MAX_TIME_BETWEEN_CHECK = 1000;

    public final Smoker smoker;

    public Table table;

    public SmokerThread(Smoker smoker, Table table) {
        this.smoker = smoker;
        this.table = table;
    }

    public void run() {
        try {
            while (true) {
                synchronized (smoker) {
                    if (smoker.checkTable(table)) {
                        System.out.println(smoker.getName() + " берет необходимое и делает сигарету");
                        smoker.makeCigarette(table);
                        System.out.println(smoker.getName() + " идет курить");
                        smoker.smoke();
                        System.out.println(smoker.getName() + " покурил");
                    }
                }
                Thread.sleep(MIN_TIME_BETWEEN_CHECK + (int) (Math.random() * (MAX_TIME_BETWEEN_CHECK - MIN_TIME_BETWEEN_CHECK)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}