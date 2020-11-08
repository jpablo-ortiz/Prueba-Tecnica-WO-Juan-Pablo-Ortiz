package com.empresa.Prueba.Tecnica.auxiliar;

import java.util.List;

import com.empresa.Prueba.Tecnica.exceptions.InternalServerErrorException;

import java.io.FileReader;

import au.com.bytecode.opencsv.CSVReader;

public class MetodosCSV {

    public static List<String[]> leerCSV() {
        try {
            String archCSV = "src/main/resources/CSV/empleados.csv";
            CSVReader csvReader = new CSVReader(new FileReader(archCSV));
            return csvReader.readAll();
        } catch (Exception e) {
            throw new InternalServerErrorException("Error al abrir archivos CSV");
        }
    }

}
