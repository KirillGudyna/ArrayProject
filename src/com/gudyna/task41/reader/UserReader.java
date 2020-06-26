package com.gudyna.task41.reader;

import com.gudyna.task41.parser.ParserArrayString;
import com.gudyna.task41.entity.UserArray;
import com.gudyna.task41.exception.ProgramException;
import com.gudyna.task41.validator.FileValidator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserReader {
    public UserArray fillArrayFile(String fileName) throws ProgramException {
        FileValidator validator = new FileValidator();
        if (!validator.validateFileName(fileName)) {
            throw new ProgramException("You enter empty file name!");
        }
        Path path = Paths.get(fileName);
        Scanner scanner;
        try {
            scanner = new Scanner(path);
        } catch (IOException e) {
            throw new ProgramException("Wrong file name!");
        }
        ParserArrayString parser = new ParserArrayString();
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
            sb.append(" ");
        }
        String[] numbers = sb.toString().split("\\s");
        return parser.parseArray(numbers);
    }
}
