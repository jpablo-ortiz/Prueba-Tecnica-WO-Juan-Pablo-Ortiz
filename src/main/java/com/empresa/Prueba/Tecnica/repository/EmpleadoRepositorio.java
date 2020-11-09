package com.empresa.Prueba.Tecnica.repository;

import java.util.List;

import com.empresa.Prueba.Tecnica.model.Empleado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Esta interfaz implementa el repositorio de los empleados.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 * @see JpaRepository
 */
@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

    /**
     * Busca todos los empleados que pertenecen al departamento indicado, en la base de datos.
     * @param idDepartamento Id (clave primaria) del departamento.
     * @param pageable Paginable para habilitar la paginación de los empleados del departamento indicado.
     * @return Datos paginados de los empleados obtenidos.
     */
    public Page<Empleado> findAllByDepartamentoAlQuePerteneceId(long idDepartamento, Pageable pageable);

    /**
     * Busca el top de los primeros "numTop" empleados con el salario más alto en la base de datos.
     * @param numTop Cantidad de personas a mostrar en el top.
     * @return lista de empleados.
     */
    @Query( value = "SELECT * " +
                    "FROM empleado e " +
                    "ORDER BY e.salario " +
                    "DESC LIMIT ?1", 
            nativeQuery = true )
    public List<Empleado> findTopEmpleadosSalario(int numTop);

    /**
     * Obtiene la sumatoria de los salarios agrupados por departamentos en la base de datos.
     * @return lista de Sumatoria de salarios por departamento (SumSalarioPorDepartamento). 
     */
    @Query( value = "SELECT d.id as idDepartamento, d.nombre as nombreDepartamento, SUM(e.salario) as sumatoriaSalarios " +
                    "FROM empleado e INNER JOIN departamento d " +
                    "WHERE e.departamento_al_que_pertenece_id = d.id " +
                    "GROUP BY d.id", 
            nativeQuery = true )
    public List<SumSalarioPorDepartamento> getSumSalariosGroupByDepartamento(); 
}
