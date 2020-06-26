package com.gudyna.task42.comparator;

import java.util.Comparator;

public class MinComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] array1, int[] array2) {
        if (min(array1) > min(array2)) {
            return 1;
        } else if (min(array1) < min(array2)) {
            return -1;
        }
        return 0;
    }

    public int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}
