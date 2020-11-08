package com.empresa.Prueba.Tecnica.services;

import java.util.List;

import com.empresa.Prueba.Tecnica.model.Empleado;
import com.empresa.Prueba.Tecnica.repository.EmpleadoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado> getAll() {
        return empleadoRepositorio.findAll();
    }

    public Page<Empleado> getAllByDepartamentoId(long idDepartamento, Pageable pageable) {
        return empleadoRepositorio.findAllByDepartamentoAlQuePerteneceId(idDepartamento, pageable);
    }

    public Empleado save(Empleado nuevoEmpleado) {
        return empleadoRepositorio.save(nuevoEmpleado);
    }
}