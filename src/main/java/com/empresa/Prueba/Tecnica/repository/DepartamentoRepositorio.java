package com.empresa.Prueba.Tecnica.repository;

import java.util.Optional;

import com.empresa.Prueba.Tecnica.model.Departamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {

    Optional<Departamento> findByNombre(String nombre);

}