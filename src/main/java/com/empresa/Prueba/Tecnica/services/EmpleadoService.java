package com.empresa.Prueba.Tecnica.services;

import java.util.List;

import com.empresa.Prueba.Tecnica.model.Empleado;
import com.empresa.Prueba.Tecnica.repository.EmpleadoRepositorio;
import com.empresa.Prueba.Tecnica.repository.SumSalarioPorDepartamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Esta clase contiene el servicio de los empleados.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 */
@Service
public class EmpleadoService {

    /**
     * Inyección del repositorio de los empleados
     */
    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    /**
     * Busca todos los empleados que pertenecen al departamento indicado.
     * @param idDepartamento Id (clave primaria) del departamento.
     * @param pageable Paginable para habilitar la paginación de los empleados del departamento indicado.
     * @return Datos paginados de los empleados obtenidos.
     */
    public Page<Empleado> getAllByDepartamentoId(long idDepartamento, Pageable pageable) {
        return empleadoRepositorio.findAllByDepartamentoAlQuePerteneceId(idDepartamento, pageable);
    }

    /**
     * Busca el top de los primeros "numTop" empleados con el salario más alto.
     * @param numTop Cantidad de personas a mostrar en el top.
     * @return Lista de empleados.
     */
    public List<Empleado> getTopEmpleadosSalario(int numTop) {
        return empleadoRepositorio.findTopEmpleadosSalario(numTop);
    }

    /**
     * Obtiene la sumatoria de los salarios agrupados por departamentos.
     * @return lista de Sumatoria de salarios por departamento (SumSalarioPorDepartamento). 
     */
    public List<SumSalarioPorDepartamento> getSumSalariosGroupByDepartamento() {
        return empleadoRepositorio.getSumSalariosGroupByDepartamento();
    }

    /**
     * Guarda el empleado en la base de datos.
     * @param nuevoEmpleado Nuevo empleado a guardar.
     * @return El empleado guardado.
     */
    public Empleado save(Empleado nuevoEmpleado) {
        return empleadoRepositorio.save(nuevoEmpleado);
    }
}