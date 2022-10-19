package org.example.service;

import org.example.dao.FileDAO;
import org.example.dao.FileDAOImpl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FileService {
    FileDAO fileDAO = new FileDAOImpl();
    public void fileSplit(String path) throws IOException {

        String pathResource = "src/main/resources/";
        File file = new File(path);
        String invoiceName = file.getName().replace(".csv", ".txt");

        List<String> lines = fileDAO.getLinesInFiles(file);

        for (int i = 1; i < lines.size(); i++) {
            String[] splitLine = lines.get(i).split(";");
            fileDAO.replaceCaracters(splitLine);
            double totalCost = Double.parseDouble(splitLine[4]) +
                    Double.parseDouble(splitLine[5]) +
                    Double.parseDouble(splitLine[6]);
            double benefit = Double.parseDouble(splitLine[3]) - totalCost;
            BigDecimal formatNumber = new BigDecimal(benefit);
            formatNumber = formatNumber.setScale(2, RoundingMode.DOWN);
            fileDAO.showInfoFile(splitLine, totalCost, formatNumber.doubleValue(), invoiceName);
            fileDAO.writeInFile(invoiceName, splitLine, totalCost, formatNumber.doubleValue());
        }
        System.out.println("Fichero " + invoiceName + " generado en " + pathResource);
    }
    public void modifyFile(String path) throws IOException {

        String pathResource = "src/main/resources/";
        File fileResult = new File(path);
        String invoiceName = fileResult.getName();

        List<String> lines = fileDAO.getLinesInFiles(fileResult);

        int articleAmount = 0;
        double totalBenefit = 0;
        for (int i = 0; i < lines.size(); i++) {
            String[] splitLine = lines.get(i).split(":");
            if (splitLine[0].equals("Articulo")) {

                articleAmount++;
            }
            if (splitLine[0].equals("Beneficio")) {
                totalBenefit += Double.parseDouble(splitLine[1]);


            }
            BigDecimal formatNumber = new BigDecimal(totalBenefit);
            formatNumber = formatNumber.setScale(2, RoundingMode.DOWN);
            fileDAO.writeInResultFile(invoiceName, articleAmount, formatNumber.doubleValue(), splitLine);
        }
        System.out.println("Fichero " + "result_" + invoiceName + " generado correctamente en " + pathResource);
    }
}