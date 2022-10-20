package org.example.lab_12.task_01;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class App {

    private static long startBuilding;
    private static long startSorting;
    private static MapsBuilder mapsBuilder;
    private static final MapsSorting mapsSorting = new MapsSorting();

    public static void main(String[] args) {
        workingWithHashMap();
        workingWithHashtable();
        workingWithLinkedHashMap();
        workingWithTreeMap();
    }

    public static void workingWithHashMap(){
        System.out.println("HashMap: ");
        startBuilding = System.currentTimeMillis();
        mapsBuilder = new MapsBuilder(new HashMap<String, Integer>());
        System.out.println("Random: " + (double)(System.currentTimeMillis() - startBuilding)/1000 + " sec");
        startSorting = System.currentTimeMillis();
        mapsSorting.sortMap(mapsBuilder.getMyMap());
        System.out.println("Sort: " + (double)(System.currentTimeMillis() - startSorting)/1000 + " sec");
        System.out.println("All time: " + (double)(System.currentTimeMillis() - startBuilding)/1000 + " sec \n");
    }

    public static void workingWithHashtable(){
        System.out.println("Hashtable: ");
        startBuilding = System.currentTimeMillis();
        mapsBuilder = new MapsBuilder(new Hashtable<String, Integer>());
        System.out.println("Random: " + (double)(System.currentTimeMillis() - startBuilding)/1000 + " sec");
        startSorting = System.currentTimeMillis();
        mapsSorting.sortMap(mapsBuilder.getMyMap());
        System.out.println("Sort: " + (double)(System.currentTimeMillis() - startSorting)/1000 + " sec");
        System.out.println("All time: " + (double)(System.currentTimeMillis() - startBuilding)/1000 + " sec \n");
    }

    public static void workingWithLinkedHashMap(){
        System.out.println("LinkedHashMap: ");
        startBuilding = System.currentTimeMillis();
        mapsBuilder = new MapsBuilder(new LinkedHashMap<String, Integer>());
        System.out.println("Random: " + (double)(System.currentTimeMillis() - startBuilding)/1000 + " sec");
        startSorting = System.currentTimeMillis();
        mapsSorting.sortMap(mapsBuilder.getMyMap());
        System.out.println("Sort: " + (double)(System.currentTimeMillis() - startSorting)/1000 + " sec");
        System.out.println("All time: " + (double)(System.currentTimeMillis() - startBuilding)/1000 + " sec \n");
    }

    public static void workingWithTreeMap() {
        System.out.println("TreeMap: ");
        startBuilding = System.currentTimeMillis();
        mapsBuilder = new MapsBuilder(new TreeMap<String, Integer>());
        System.out.println("Random: " + (double)(System.currentTimeMillis() - startBuilding)/1000 + " sec");
        startSorting = System.currentTimeMillis();
        mapsSorting.sortMap(mapsBuilder.getMyMap());
        System.out.println("Sort: " + (double)(System.currentTimeMillis() - startSorting)/1000 + " sec");
        System.out.println("All time: " + (double)(System.currentTimeMillis() - startBuilding)/1000 + " sec \n");
    }
}
