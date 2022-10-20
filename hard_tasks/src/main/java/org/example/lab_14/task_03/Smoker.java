package org.example.lab_14.task_03;


public class Smoker {

    public static final long MIN_SMOKING_TIME = 5000;

    public static final long MAX_SMOKING_TIME = 5000;

    private String name;

    private Resource resource;

    private boolean isSmoke = false;

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized Resource getResource() {
        return resource;
    }

    public synchronized void setResource(Resource resource) {
        this.resource = resource;
    }

    public synchronized boolean isSmoke() {
        return isSmoke;
    }

    public synchronized void setSmoke(boolean smoke) {
        isSmoke = smoke;
    }

    public Smoker(String name, Resource resource) {
        this.name = name;
        this.resource = resource;
    }

    public void addResourceToTable(Table table) {
        table.addResource(resource);
    }

    public void smoke() throws InterruptedException {
        setSmoke(true);
        Thread.sleep(MIN_SMOKING_TIME + (int) (Math.random() * (MAX_SMOKING_TIME - MIN_SMOKING_TIME)));
        setSmoke(false);
    }

    public boolean checkTable(Table table) {
        return table.checkMissingResource(resource);
    }

    public void makeCigarette(Table table) throws Exception {
        table.takeResourcesBesides();
    }
}