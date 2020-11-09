package com.empresa.Prueba.Tecnica.auxiliar;

import java.util.List;

import com.empresa.Prueba.Tecnica.exceptions.InternalServerErrorException;

import java.io.FileReader;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Esta clase implementa los métodos para manejar los archivos CSV.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 */
public class MetodosCSV {

    /**
     * Ruta del archivo empleados.cvs
     */
    private static final String empleadosCSV = "src/main/resources/CSV/empleados.csv";

    /**
     * Lee el arcivho empleados.csv ubicado en resources.
     * 
     * @return List<String[]> Lista (lineas del csv) de arreglos de Strings (columnas de cada linea csv).
     * @throws InternalServerErrorException Se levanta este error en el caso que no se abra correctamente el archivo empleados.csv .
     */
    public static List<String[]> leerEmpleadosCSV() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(empleadosCSV));
            return csvReader.readAll();
        } catch (Exception e) {
            throw new InternalServerErrorException("Error al abrir archivos CSV");
        }
    }

}
