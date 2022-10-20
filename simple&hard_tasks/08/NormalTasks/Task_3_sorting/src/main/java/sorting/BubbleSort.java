package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static double[] createSortedArray(double[] array) { 
        double[] result = array.clone();
        sort(result);
        return result;
    }

    public static void sort(double[] array) {  
        for (int i = 0; i < array.length - 2; i++) { 
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
