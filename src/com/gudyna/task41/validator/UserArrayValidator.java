package com.gudyna.task41.validator;

import com.gudyna.task41.entity.UserArray;

public class UserArrayValidator {
    public boolean isUserArrayValidate(UserArray userArray){
        return userArray != null && userArray.getArrayNumber() != null;
    }
    public boolean isArraySorted(UserArray userArray){
        for (int i = 0; i < userArray.length() - 1; i++) {
            if (userArray.get(i) > userArray.get(i + 1) ) {
                return false;
            }
        }
        return true;
    }
}
