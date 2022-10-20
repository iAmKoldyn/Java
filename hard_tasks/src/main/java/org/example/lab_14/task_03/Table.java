package org.example.lab_14.task_03;



import java.util.HashMap;
import java.util.Map;


public class Table {
    public HashMap<Resource, Boolean> resourceBooleanHashMap = new HashMap<>();

    public Table() {
        Resource[] resources = Resource.values();
        for (Resource resource : resources) {
            resourceBooleanHashMap.put(resource, false);
        }
    }

    public synchronized void addResource(Resource resource) {
        resourceBooleanHashMap.put(resource, true);
    }

    public synchronized void takeResourcesBesides() throws Exception {
        resourceBooleanHashMap.replaceAll((key, oldValue) -> false);
    }

    public synchronized boolean checkMissingResource(Resource resource) {
        for (Map.Entry<Resource, Boolean> item : resourceBooleanHashMap.entrySet()) {
            if (item.getKey() != resource && !item.getValue()) return false;
        }
        return true;
    }

    public synchronized boolean hasResource(Resource resource) {
        return resourceBooleanHashMap.get(resource);
    }
}