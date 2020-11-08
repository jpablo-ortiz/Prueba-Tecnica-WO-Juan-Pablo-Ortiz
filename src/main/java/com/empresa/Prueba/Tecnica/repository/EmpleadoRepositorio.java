package com.empresa.Prueba.Tecnica.repository;

import java.util.List;

import com.empresa.Prueba.Tecnica.model.Empleado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

    public Page<Empleado> findAllByDepartamentoAlQuePerteneceId(long idDepartamento, Pageable pageable);

    @Query(value = "SELECT * FROM empleado e ORDER BY e.salario DESC LIMIT ?1", nativeQuery = true)
    public List<Empleado> findTopEmpleadosSalario(int numTop);

}
