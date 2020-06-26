package com.gudyna.task41.validator;

public class FileValidator {
    public boolean validateFileName(String fileName){
        return fileName != null && !fileName.isEmpty();
    }
}
