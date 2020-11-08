package com.empresa.Prueba.Tecnica.controller;

import java.util.List;
import java.util.Optional;

import com.empresa.Prueba.Tecnica.auxiliar.MetodosCSV;
import com.empresa.Prueba.Tecnica.exceptions.InternalServerErrorException;
import com.empresa.Prueba.Tecnica.exceptions.NotFoundException;
import com.empresa.Prueba.Tecnica.model.Departamento;
import com.empresa.Prueba.Tecnica.model.Empleado;
import com.empresa.Prueba.Tecnica.services.DepartamentoService;
import com.empresa.Prueba.Tecnica.services.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private DepartamentoService departamentoService;

    /*
     * Ejemplo uso con parametros de pageable:
     * /departamento/{idDepartamento}/empleados?page=0&size=3&sort=id,desc
     */
    @GetMapping("/departamento/{idDepartamento}/empleados")
    public Page<Empleado> findAllByDepartamentoId(@PathVariable(value = "idDepartamento") Long departamentoId,
            Pageable pageable) {
        Page<Empleado> resultado = empleadoService.getAllByDepartamentoId(departamentoId, pageable);
        if (!resultado.isEmpty()) {
            return resultado;
        } else {
            throw new NotFoundException("No se encontraron Empleados en este departamento");
        }
    }

    @GetMapping("/empleados/salarios-top5")
    public List<Empleado> findTop5EmpleadosSalario() {
        List<Empleado> resultado = empleadoService.getTopEmpleadosSalario(5);
        if (!resultado.isEmpty()) {
            return resultado;
        } else {
            throw new NotFoundException("No se encontraron Empleados");
        }
    }

    @RequestMapping(value = "/leerCSV", produces = "application/json")
    public String inicializadorDatosEmpleadosCSV() {
        try {
            List<String[]> datos = MetodosCSV.leerCSV();

            String[] lineaActual;
            String nombre;
            String cargo;
            double salario;
            boolean tiempoCompleto;

            String nombreDepartamento;

            Optional<Departamento> consultaDepartamento;
            Departamento nuevoDepartamento;
            Empleado nuevoEmpleado;

            for (int i = 1; i < datos.size(); i++) {
                lineaActual = datos.get(i);

                nombre = lineaActual[0];
                cargo = lineaActual[1];
                salario = Double.parseDouble(lineaActual[2]);
                tiempoCompleto = Boolean.parseBoolean(lineaActual[3]);
                nombreDepartamento = lineaActual[4];

                consultaDepartamento = departamentoService.findByNombre(nombreDepartamento);
                nuevoEmpleado = new Empleado();

                if (consultaDepartamento.isPresent()) {
                    nuevoEmpleado.setDepartamentoAlQuePertenece(consultaDepartamento.get());
                } else {
                    nuevoDepartamento = new Departamento();
                    nuevoDepartamento.setNombre(nombreDepartamento);
                    departamentoService.save(nuevoDepartamento);

                    nuevoEmpleado.setDepartamentoAlQuePertenece(nuevoDepartamento);
                }

                nuevoEmpleado.setNombre(nombre);
                nuevoEmpleado.setCargo(cargo);
                nuevoEmpleado.setSalario(salario);
                nuevoEmpleado.setTiempoCompleto(tiempoCompleto);

                empleadoService.save(nuevoEmpleado);
            }
            return "{\"value\": \"Datos inicializados correctamente\"}";
        } catch (Exception e) {
            throw new InternalServerErrorException("Error en la lectura de los archivos CSV");
        }
    }

}
