package org.example.dao;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl implements FileDAO {

    @Override
    public List<String> getLinesInFiles(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        try (Reader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                lines.add(row);
            }
        }
        return lines;
    }
    @Override
    public void replaceCaracters(String[] splitLine) {
        splitLine[3] = splitLine[3].replace(",", ".");
        splitLine[4] = splitLine[4].replace(",", ".");
        splitLine[5] = splitLine[5].replace(",", ".");
        splitLine[6] = splitLine[6].replace(",", ".");
    }
    @Override
    public void showInfoFile(String[] splitLine, double totalCost, double benefit, String invoiceName) {

        System.out.println("Articulo: " + splitLine[0]);
        System.out.println("Tipo: " + splitLine[1]);
        System.out.println("Precio de venta: " + splitLine[3]);
        System.out.println("Coste: " + totalCost);
        System.out.println("Beneficio: " + benefit);
        System.out.println("--------------------------------------------------" + '\n');
    }
    @Override
    public void writeInFile(String nombreFactura, String[] splitLine, double totalCost, double benefit) {

        File saveFile = new File("src/main/resources/" + nombreFactura);
        try (Writer writer = new FileWriter(saveFile, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(
                    "Articulo: " + splitLine[0] + '\n' +
                            "Tipo: " + splitLine[1] + '\n' +
                            "Precio de venta: " + splitLine[3] + '\n' +
                            "Coste: " + totalCost + '\n' +
                            "Beneficio: " + benefit + '\n' +
                            "--------------------------------------------------" + '\n');
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void writeInResultFile(String invoiceName, int articleAmount, double totalBenefit, String[] splitLine) {

        File finalFile = new File("src/main/resources/result_" + invoiceName);
        File csvFile = new File("src/main/resources/invoice_202009.txt");
        String path = csvFile.getPath();
        String csvName = csvFile.getName();
        double csvSize = csvFile.length();
        try (Writer writer = new FileWriter(finalFile);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(
                    "Factura: " + invoiceName + '\n' +
                            "Numero de articulos: " + articleAmount + '\n' +
                            "Beneficio total: " + totalBenefit + '\n' +
                            "Ruta del fichero: " + path + '\n' +
                            "Nombre del fichero: " + csvName + '\n' +
                            "Tamaño del fichero: " + csvSize + " bytes" + '\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void createExcelInDisk(Workbook workbook, String path, String pathExerciseTwo) throws IOException {

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();) {
            workbook.write(byteArrayOutputStream);
            workbook.write(new FileOutputStream(path));
            System.out.println("Excel creado en: " + path);

            double excelSize = byteArrayOutputStream.size();

            File file = new File(pathExerciseTwo);
            List<String> lines = new ArrayList<>();
            try (Reader reader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                String row;
                while ((row = bufferedReader.readLine()) != null) {
                    lines.add(row);
                }
            }
            lines.add("Ruta del fichero: " + path);
            lines.add("Tamaño del fichero: " + excelSize + " bytes");
            try (Writer writer = new FileWriter(file);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Fichero " + pathExerciseTwo + " modificado correctamente");
        }
    }
}