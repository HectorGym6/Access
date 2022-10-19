package org.example.app;

import org.example.service.Excel;
import org.example.service.FileService;


import java.io.IOException;

public class Actividad3 {
    private static final String PATH = "src/main/resources/ShopInfo.xlsx";
    private static final String PATH_DOS = "src/main/resources/result_invoice_202009.txt";
    public static void main(String[] args) throws IOException {
        Excel excel = new Excel();
        excel.createExcelFile(PATH, PATH_DOS);

    }
}