package com.gudyna.task41.console;

import com.gudyna.task41.entity.UserArray;
import com.gudyna.task41.exception.ProgramException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
    public UserArray consoleFill() throws ProgramException {
        Scanner scanner = new Scanner(System.in);
        int length;
        try {
            length = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new ProgramException("All values must be integer!");
        }
        UserArray userArray = new UserArray(length);
        for (int i = 0; i < length; i++) {
            int value;
            try {
                value = scanner.nextInt();
                userArray.set(i,value);
            } catch (InputMismatchException e) {
                throw new ProgramException("All values must be integer!");
            }
        }
        return userArray;
    }
}
