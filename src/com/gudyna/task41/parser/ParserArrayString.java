package com.gudyna.task41.parser;

import com.gudyna.task41.entity.UserArray;
import com.gudyna.task41.exception.ProgramException;

public class ParserArrayString {
    public UserArray parseArray(String[] data) throws ProgramException {
        UserArray array=new UserArray();
        for (String datum : data) {
            int temp;
            try {
                temp = Integer.parseInt(datum);
            } catch (NumberFormatException e) {
                throw new ProgramException("Wrong parse parameters!");
            }
            array.add(temp);
        }
        return array;
    }
}
