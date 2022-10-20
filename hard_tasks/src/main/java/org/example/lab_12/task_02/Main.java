package org.example.lab_12.task_02;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Metods met = new Metods();
        Maps map = new Maps(new HashMap<String, Integer>());
        met.hashMap(map);

        Maps map1 = new Maps(new TreeMap<String, Integer>());
        met.treeMap(map1);

        Maps map2 = new Maps(new LinkedHashMap<String, Integer>());
        met.linkedHashMap(map2);

        Maps map3 = new Maps(new Hashtable<String, Integer>());
        met.hashtable(map3);
    }
}
