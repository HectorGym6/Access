package org.example.app;

import org.example.service.FileService;

import java.io.IOException;

public class Actividad1 {

    private final static String PATH = "src/main/resources/invoice_202009.csv";
    public static void main(String[] args) throws IOException {

        FileService fileService = new FileService();
        fileService.fileSplit(PATH);

    }
}
