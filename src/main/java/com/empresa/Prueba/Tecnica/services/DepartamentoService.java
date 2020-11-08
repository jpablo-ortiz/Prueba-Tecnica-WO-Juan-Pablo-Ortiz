package com.empresa.Prueba.Tecnica.services;

import java.util.List;
import java.util.Optional;

import com.empresa.Prueba.Tecnica.model.Departamento;
import com.empresa.Prueba.Tecnica.repository.DepartamentoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {
    @Autowired
    DepartamentoRepositorio departamentoRepositorio;

    public List<Departamento> getAll() {
        return departamentoRepositorio.findAll();
    }

    public Optional<Departamento> findByNombre(String nombre) {
        return departamentoRepositorio.findByNombre(nombre);
    }

    public Departamento save(Departamento nuevoDepartamento) {
        return departamentoRepositorio.save(nuevoDepartamento);
    }
}
