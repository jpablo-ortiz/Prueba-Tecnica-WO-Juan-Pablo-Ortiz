package com.empresa.Prueba.Tecnica.repository;

import com.empresa.Prueba.Tecnica.model.Empleado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

    Page<Empleado> findAllByDepartamentoAlQuePerteneceId(long idDepartamento, Pageable pageable);

}
