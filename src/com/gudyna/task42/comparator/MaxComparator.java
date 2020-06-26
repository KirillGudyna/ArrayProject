package com.gudyna.task42.comparator;

import java.util.Comparator;

public class MaxComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] array1, int[] array2) {
        if (max(array1) > max(array2)) {
            return 1;
        } else if (max(array1) < max(array2)) {
            return -1;
        }
        return 0;
    }

    public int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
