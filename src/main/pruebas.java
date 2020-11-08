package com.empresa.Prueba.Tecnica;

import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class pruebas {
    public static void main(String[] args) {
        String archCSV = "./resources/CSV/empleados.csv";
		CSVReader csvReader = new CSVReader(new FileReader(archCSV));
        List<String[]> datos = csvReader.readAll();
	}
}
