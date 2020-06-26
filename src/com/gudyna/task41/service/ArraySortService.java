package com.gudyna.task41.service;

import com.gudyna.task41.entity.UserArray;
import com.gudyna.task41.exception.ProgramException;
import com.gudyna.task41.validator.UserArrayValidator;

public class ArraySortService {
    private static final String MESSAGE = "We can't sort empty array!";
    private void swap(UserArray array, int index1, int index2) {
        int value1 = array.get(index1);
        int value2 = array.get(index2);
        array.set(index1, value2);
        array.set(index2, value1);
    }

    public void bubbleSort(UserArray array) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(array)) {
            throw new ProgramException(MESSAGE);
        }
        int size = array.length();
        for (int i = 0; i < array.length() - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array.get(j + 1) < array.get(j)) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public void bubbleSortDown(UserArray userArray) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            throw new ProgramException(MESSAGE);
        }
        bubbleSort(userArray);
        reversedArray(userArray);
    }

    public void sortSelection(UserArray array) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(array)) {
            throw new ProgramException(MESSAGE);
        }
        for (int i = 0; i < array.length(); i++) {
            int min = array.get(i);
            int minI = i;
            for (int j = i + 1; j < array.length(); j++) {
                if (array.get(j) < min) {
                    min = array.get(j);
                    minI = j;
                }
            }
            if (i != minI) {
                swap(array, i, minI);
            }
        }
    }

    public void sortSelectionDown(UserArray userArray) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            throw new ProgramException(MESSAGE);
        }
        sortSelection(userArray);
        reversedArray(userArray);
    }

    public void sortShell(UserArray userArray) throws ProgramException{
        UserArrayValidator validator = new UserArrayValidator();
        if(!validator.isUserArrayValidate(userArray)){
            throw new ProgramException(MESSAGE);
        }
        int size = userArray.length();
        int tmp;
        int j;
        for (int step = size / 2; step > 0; step /= 2) {
            for (int i = step; i < size; i++) {
                tmp = userArray.get(i);
                for (j = i; j >= step; j -= step) {
                    if (tmp < userArray.get(j - step)) {
                        userArray.set(j, userArray.get(j - step));
                    } else {
                        break;
                    }
                }
                userArray.set(j,tmp);
            }
        }
    }
    public void sortShellDown(UserArray userArray) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            throw new ProgramException(MESSAGE);
        }
        sortShell(userArray);
        reversedArray(userArray);
    }
    private void reversedArray(UserArray userArray){
        int size = userArray.length();
        for (int i = 0; i < size/2; i++) {
            swap(userArray,size-i-1,i);
        }
    }
}
