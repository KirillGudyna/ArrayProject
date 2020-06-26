package com.gudyna.task42.service;

import com.gudyna.task42.exception.ProgramException;

import java.util.Comparator;

public class JaggedArrayService {

    public void sortArray(int[][] array, Comparator<int[]> comparator, boolean reverse) throws ProgramException {
        if (array == null || comparator == null) {
            throw new ProgramException("You enter bad parameters");
        }
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (comparator.compare(array[i], array[i + 1]) > 0) {
                    int[] tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                    sorted = false;
                }
            }
        }
        if (reverse) {
            reverse(array);
        }
    }

    private void reverse(int[][] array) throws ProgramException {
        if (array == null) {
            throw new ProgramException("incorrect parameter");
        }
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int[] temp = array[length - 1 - i];
            array[length - 1 - i] = array[i];
            array[i] = temp;
        }
    }
    public boolean jaggedArraysEquals(int[][] actual, int[][] expected) {
        if (actual == null || expected == null) {
            return false;
        }
        if (actual.length != expected.length) {
            return false;
        }
        for (int i = 0; i < actual.length; i++) {
            if (actual[i].length != expected[i].length) {
                return false;
            }
            for (int j = 0; j < actual[i].length; j++) {
                if (actual[i][j] != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}