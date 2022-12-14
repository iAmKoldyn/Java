package org.example.lab_12.task_02;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import java.util.*;

public class Maps{
    Map<String, Integer> map;
    final int SEC = 1000;
    final int LIMIT = 2000000;

    final int GEN = 100000;

    final int MASS = 30000;

    Maps(Map<String, Integer> map){
        this.map = map;
        generateValues();
    }
    public String generateKey(){
        double start = System.currentTimeMillis();
        Random random = new Random();
        String str = "";
        for (int i = 0; i < 10; i++){
            int key = random.nextInt(26);
            str = Integer.toString(key);
        }
        return str;
    }
    public void generateValues(){
        for (int i = 0; i < LIMIT; i++){
            int value = (int)(Math.random() * GEN);
            this.map.put(generateKey(), value);
        }
    }

    public void time(){
        double start = System.currentTimeMillis();
        generateValues();
        double time = System.currentTimeMillis() - start;
        System.out.println("Time generatedValues: " + time/SEC + " sec");
    }
    public String[] mass(){
        String[] mass = new String[MASS];
        for(int i = 0; i < MASS; i++){
            mass[i] = generateKey();
        }
        return mass;
    }
    public void sum(String[] mass){
        double start = System.currentTimeMillis();
        int sum = 0;

        for (int i = 0; i < MASS; i++){
            Integer values = this.map.get(mass[i]);
            if (values != null) {
                sum += values;
            }
        }

        double time = System.currentTimeMillis() - start;
        System.out.println("Amount values time: " + time/SEC + " sec");
        System.out.println("Amount: " + sum);
    }
}
