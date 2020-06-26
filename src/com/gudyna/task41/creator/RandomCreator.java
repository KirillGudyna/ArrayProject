package com.gudyna.task41.creator;

import com.gudyna.task41.entity.UserArray;
import com.gudyna.task41.validator.UserArrayValidator;

import static java.lang.Math.random;

public class RandomCreator {
    public static final int DEFAULT_SIZE = 13;

    public void randomCreate(UserArray userArray, int size) {
        if (size < 0) {
            size = DEFAULT_SIZE;
        }
        UserArrayValidator validator = new UserArrayValidator();
        if (!validator.isUserArrayValidate(userArray)) {
            userArray = new UserArray(0);
        }
        for (int i = 0; i < size; i++) {
            userArray.add((int) (random() * 100));
        }
    }
}

