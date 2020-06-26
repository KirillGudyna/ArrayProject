package com.gudyna.task41.service;

import com.gudyna.task41.entity.UserArray;
import com.gudyna.task41.exception.ProgramException;
import com.gudyna.task41.validator.UserArrayValidator;

public class ArraySearchService {
    private static final int FIBONACCI_MAX_ELEMENT_IN_INT = 1836311903;
    private static final int MAX_THREE_DIGIT_NUMBER = 999;
    private static final int MIN_THREE_DIGIT_NUMBER = 100;
    private static final int TEN = 10;
    private static final int ONE_HUNDRED = 100;

    public int binarySearch(UserArray userArray, int number) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            throw new ProgramException("Your array is empty!");
        }
        if (!validator.isArraySorted(userArray)) {
            throw new ProgramException("Your array is not sorted!");
        }
        int firstIndex = 0;
        int lastIndex = userArray.length() - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            int middleValue = userArray.get(middleIndex);
            if (middleValue == number) {
                return middleIndex;
            }
            if (middleValue < number) {
                firstIndex = middleIndex + 1;
            } else {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public int findMaxElement(UserArray userArray) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            throw new ProgramException("We can't find max element in empty array!");
        }
        int size = userArray.length();
        int maxElement = userArray.get(0);
        for (int i = 1; i < size; i++) {
            int tmp = userArray.get(i);
            if (tmp > maxElement) {
                maxElement = tmp;
            }
        }
        return maxElement;
    }

    public int findMinElement(UserArray userArray) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            throw new ProgramException("We can't find max element in empty array!");
        }
        int size = userArray.length();
        int minElement = userArray.get(0);
        for (int i = 1; i < size; i++) {
            int tmp = userArray.get(i);
            if (tmp < minElement) {
                minElement = tmp;
            }
        }
        return minElement;
    }

    private boolean isNumberFibonacci(int number) {
        boolean answer = false;
        int firstFibonacci = 0;
        int secondFibonacci = 1;
        if (firstFibonacci == number || secondFibonacci == number) {
            answer = true;
        }
        int nextFibonacci = firstFibonacci + secondFibonacci;
        int sum;
        while (number >= nextFibonacci && nextFibonacci <= FIBONACCI_MAX_ELEMENT_IN_INT) {
            if (number == nextFibonacci) {
                answer = true;
            }
            sum = secondFibonacci;
            secondFibonacci = nextFibonacci;
            nextFibonacci += sum;
        }
        return answer;
    }

    private boolean isNumberPrime(int number) {
        if (number < 1) {
            return false;
        }
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return count == 2;
    }

    private boolean isNumberThreeDigit(int number) {
        return number > MIN_THREE_DIGIT_NUMBER && number <= MAX_THREE_DIGIT_NUMBER;
    }

    private boolean isNumberHaveUniqueDigit(int number) {
        int units = number % TEN;
        int tens = (number / TEN) % TEN;
        int hundreds = number / ONE_HUNDRED;
        return units != tens && units != hundreds && tens != hundreds;
    }

    public UserArray findUniqueThreeDigitNumbers(UserArray userArray) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            throw new ProgramException("Your array is empty!");
        }
        UserArray newArray = new UserArray();
        int size = userArray.length();
        for (int i = 0; i < size; i++) {
            if(isNumberThreeDigit(userArray.get(i))&&isNumberHaveUniqueDigit(userArray.get(i))){
                newArray.add(userArray.get(i));
            }
        }
        return newArray;
    }

    public UserArray findPrimeNumbers(UserArray userArray) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            throw new ProgramException("Your is empty!");
        }
        UserArray array = new UserArray();
        int size = userArray.length();
        for (int i = 0; i < size; i++) {
            if (isNumberPrime(userArray.get(i))) {
                array.add(userArray.get(i));
            }
        }
        return array;
    }

    public UserArray findFibonacciNumbers(UserArray userArray) throws ProgramException {
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            throw new ProgramException("Your is empty!");
        }
        UserArray newArray = new UserArray();
        int size = userArray.length();
        for (int i = 0; i < size; i++) {
            if (isNumberFibonacci(userArray.get(i))) {
                newArray.add(userArray.get(i));
            }
        }
        return newArray;
    }
}
