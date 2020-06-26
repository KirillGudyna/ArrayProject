package com.gudyna.task41.entity;

import java.util.Arrays;

public class UserArray {

    private int[] arrayNumber;

    public UserArray() {
    }

    public UserArray(int[] arrayNumber) {
        this.arrayNumber = arrayNumber;
    }

    public UserArray(int size) {
        arrayNumber = new int[size];
    }

    public int[] getArrayNumber() {
        return arrayNumber;
    }

    public void setArrayNumber(int[] arrayNumber) {
        this.arrayNumber = arrayNumber;
    }

    public int get(int index) {
        int answer = -1;
        if (isIndexCorrect(index)) {
            answer = arrayNumber[index];
        }
        return answer;
    }

    public boolean set(int index, int number) {
        boolean answer = false;
        if (isIndexCorrect(index)) {
            arrayNumber[index] = number;
            answer = true;
        }
        return answer;
    }

    public int length() {
        return arrayNumber.length;
    }

    public void add(int number) {
        if (arrayNumber == null) {
            arrayNumber = new int[1];
            arrayNumber[0] = number;
        } else {
            int[] newArray = Arrays.copyOf(arrayNumber, length() + 1);
            newArray[length()] = number;
            arrayNumber = newArray;
        }
    }

    private boolean isIndexCorrect(int index) {
        return index >= 0 && index <= arrayNumber.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof UserArray)) {
            return false;
        }
        UserArray userArray = (UserArray) o;
        if (this.length() != userArray.length()) {
            return false;
        }
        int size = length();
        for (int i = 0; i < size; i++) {
            if (this.get(i) != userArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (arrayNumber == null) {
            return 0;
        }
        int result = 1;
        for (int element : arrayNumber) {
            result = 31 * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("numberArray=");
        if (arrayNumber == null) {
            return sb.append("null").toString();
        }
        int size = length() - 1;
        if (size == -1) {
            return sb.append("[]").toString();
        }
        sb.append('[');
        for (int i = 0; ; i++) {
            sb.append(arrayNumber[i]);
            if (i == size) {
                return sb.append(']').append('}').toString();
            }
            sb.append(", ");
        }
    }
}
