package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SortingTest {

    @Test
    public void bubbleSortingArrayTest() {
        double[] array = {12, 34, 24, 55, 11, 5, 9};

        double[] target = {5, 9, 11, 12, 24, 34, 55};

        assertArrayEquals(target, BubbleSort.createSortedArray(array));
    }
}
