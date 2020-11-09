package com.empresa.Prueba.Tecnica.repository;

/**
 * Esta interfaz representa la respuesta de la sumatoria de los salarios por departamento.
 * 
 * @author Juan Pablo Ortiz
 * @version 1.0
 */
public interface SumSalarioPorDepartamento {

    /**
     * Método que obtiene el id del departamento.
     * @return Id del departamento.
     */
    long getIdDepartamento();

    /**
     * Método que obtiene el nombre del departamento.
     * @return Nombre del departamento.
     */
    String getNombreDepartamento();

    /**
     * Método que obtiene la sumatoria de los salarios del departamento.
     * @return Sumatoria de los salarios del departamento
     */
    Double getSumatoriaSalarios();
}
