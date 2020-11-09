package com.empresa.Prueba.Tecnica.services;

import java.util.Optional;

import com.empresa.Prueba.Tecnica.model.Departamento;
import com.empresa.Prueba.Tecnica.repository.DepartamentoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase contiene el servicio de los departamentos.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 */
@Service
public class DepartamentoService {

    /**
     * Inyección del repositorio de los departamentos
     */
    @Autowired
    DepartamentoRepositorio departamentoRepositorio;

    /**
     * Busca un departamento por nombre.
     * @param nombre Nombre del departamento.
     * @return El departamento buscado.
     */
    public Optional<Departamento> findByNombre(String nombre) {
        return departamentoRepositorio.findByNombre(nombre);
    }

    /**
     * Guarda el departamento en la base de datos.
     * @param nuevoDepartamento Nuevo departamento a guardar.
     * @return El departamento guardado.
     */
    public Departamento save(Departamento nuevoDepartamento) {
        return departamentoRepositorio.save(nuevoDepartamento);
    }
}
