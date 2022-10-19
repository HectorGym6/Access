package org.example.app;

import org.example.service.FileService;

import java.io.IOException;


    public class Actividad2 {
        private final static String PATH = "src/main/resources/invoice_202009.txt";
        public static void main(String[] args) throws IOException {
            FileService fileService = new FileService();
            fileService.modifyFile(PATH);
        }
    }
