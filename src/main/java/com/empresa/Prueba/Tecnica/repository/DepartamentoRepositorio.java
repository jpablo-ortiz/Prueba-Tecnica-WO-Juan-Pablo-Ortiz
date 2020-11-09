package com.empresa.Prueba.Tecnica.repository;

import java.util.Optional;

import com.empresa.Prueba.Tecnica.model.Departamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interfaz implementa el repositorio de los departamentos.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 * @see JpaRepository
 */
@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {

    /**
     * Busca un departamento por nombre en la base de datos.
     * @param nombre Nombre del departamento.
     * @return El departamento buscado.
     */
    public Optional<Departamento> findByNombre(String nombre);

}