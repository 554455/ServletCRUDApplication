package com.umaraliev.crud;

import com.umaraliev.crud.service.FileService;

public class Main {
    public static void main(String[] args) {

        FileService fileService = new FileService();

        fileService.delete(1);

    }
}
