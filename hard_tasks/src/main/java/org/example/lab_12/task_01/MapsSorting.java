package org.example.lab_12.task_01;

import java.util.Map;

public class MapsSorting {

    public void sortMap(Map<String, Integer> myMap){
        quickSort(myMap.values().toArray(new Integer[0]), 0, myMap.values().toArray(new Integer[0]).length - 1);
    }

    private static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(Integer[] mass, int begin, int end) {
        int pivot = mass[end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (mass[j] <= pivot) {
                i++;
                int swapTemp = mass[i];
                mass[i] = mass[j];
                mass[j] = swapTemp;
            }
        }
        int swapTemp = mass[i+1];
        mass[i+1] = mass[end];
        mass[end] = swapTemp;
        return i+1;
    }
}
