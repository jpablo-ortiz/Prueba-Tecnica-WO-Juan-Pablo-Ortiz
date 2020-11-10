package com.empresa.Prueba.Tecnica.controller;

import java.util.List;
import java.util.Optional;

import com.empresa.Prueba.Tecnica.auxiliar.LoggerLog4j;
import com.empresa.Prueba.Tecnica.auxiliar.MetodosCSV;
import com.empresa.Prueba.Tecnica.exceptions.InternalServerErrorException;
import com.empresa.Prueba.Tecnica.exceptions.NotFoundException;
import com.empresa.Prueba.Tecnica.model.Departamento;
import com.empresa.Prueba.Tecnica.model.Empleado;
import com.empresa.Prueba.Tecnica.repository.SumSalarioPorDepartamento;
import com.empresa.Prueba.Tecnica.services.DepartamentoService;
import com.empresa.Prueba.Tecnica.services.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase contiene el controlador de los empleados con sus requests.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmpleadoController {

    /**
     * Inyección del servicio de los empleados
     */
    @Autowired
    private EmpleadoService empleadoService;

    /**
     * Inyección del servicio de los departamentos
     */
    @Autowired
    private DepartamentoService departamentoService;

    /**
     * Servicio web que permite consultar de manera paginada los empleados de un
     * departamento.
     * <p>
     * Para usar parámetros que no sean por defecto en la paginación agregar "?"
     * seguido por uno o varios de los parámetros de paginación (en caso se poner
     * dos o más agregar "&" entre ellos), los principales parámetros son:
     * <ul>
     * <li>"page = número de la página".</li>
     * <li>"size = cantidad de datos por página".</li>
     * </ul>
     * Ejemplo: http://localhost:8080/api/departamento/2/empleados?page=0&size=5
     * </p>
     * 
     * @param departamentoId id (clave primaria) del departamento.
     * @param pageable Paginable para habilitar la paginación de los empleados del departamento indicado.
     * @return JSON con los datos paginados de los empleados obtenidos.
     * @throws NotFoundException Se levanta este error en el caso que no se
     *                           encuentre ningún empleado, en el departamento
     *                           indicado, en la base de datos.
     */
    @RequestMapping(value = "/departamento/{idDepartamento}/empleados", method = RequestMethod.GET, produces = "application/json")
    public Page<Empleado> findAllEmpleadosByDepartamentoId(@PathVariable(value = "idDepartamento") Long departamentoId, Pageable pageable) {
        Page<Empleado> resultado = empleadoService.getAllByDepartamentoId(departamentoId, pageable);
        try {
            if (!resultado.isEmpty()) {
                LoggerLog4j.info("| GET | Empleados por departamento (id:" + departamentoId + ") | Realizado correctamente | Datos paginados |"); 
                LoggerLog4j.info("| Elementos encontrados: " + resultado.getTotalElements() + " | Total páginas: " + resultado.getTotalPages() + " | Elementos por página: " + resultado.getSize() + " |");
                return resultado;
            } else {
                throw new NotFoundException("No se encontraron Empleados en este departamento");
            }
        } catch (Exception e) {
            LoggerLog4j.error("| GET | Empleados por departamento (id:" + departamentoId + ") | Error solicitud |");
            LoggerLog4j.error("| No se encontraron empleados en este departamento |");
            throw new NotFoundException("No se encontraron Empleados en este departamento");
        }
    }

    /**
     * Servicio web que permite obtener los 5 empleados con el salario más alto.
     * 
     * @return JSON con los datos de los 5 empleados con el salario más alto.
     * @throws NotFoundException Se levanta este error en el caso que no se
     *                           encuentre ningún empleado en la base de datos.
     */
    @RequestMapping(value = "/empleados/salarios-top5", method = RequestMethod.GET, produces = "application/json")
    public List<Empleado> findTop5EmpleadosSalario() {
        List<Empleado> resultado = empleadoService.getTopEmpleadosSalario(5);
        try {
            if (!resultado.isEmpty()) {
                LoggerLog4j.info("| GET | Top 5 empleados con el salario más alto | Realizado correctamente |"); 
                LoggerLog4j.info("| Elementos encontrados: " + resultado.size() + " |");
                return resultado;
            } else {
                throw new NotFoundException("No se encontraron Empleados");
            }
        } catch (Exception e) {
            LoggerLog4j.error("| GET | Top 5 empleados con el salario más alto | Error solicitud |");
            LoggerLog4j.error("| No se encontraron Empleados |");
            throw new NotFoundException("No se encontraron Empleados");
        }
    }

    /**
     * Servicio web que permite obtener la sumatoria de los salarios agrupados por
     * departamentos.
     * 
     * @return JSON con los datos de la sumatoria de los salarios agrupados por
     *         departamentos.
     * @throws NotFoundException Se levanta este error en el caso que no se
     *                           encuentre ningún resultado en la suma de salarios
     *                           por departamento.
     */
    @RequestMapping(value = "/empleados/sum-salarios-por-departamentos", method = RequestMethod.GET, produces = "application/json")
    public List<SumSalarioPorDepartamento> getSumSalariosGroupByDepartamento() {
        List<SumSalarioPorDepartamento> resultado = empleadoService.getSumSalariosGroupByDepartamento();
        try {
            if (!resultado.isEmpty()) {
                LoggerLog4j.info("| GET | Sumatoria de salarios agrupados por departamentos | Realizado correctamente |"); 
                LoggerLog4j.info("| Elementos encontrados: " + resultado.size() + " |");
                return resultado;
            } else {
                throw new InternalServerErrorException("No se encontraron resultados en la suma de salarios por departamento");
            }
        } catch (Exception e) {
            LoggerLog4j.error("| GET | Sumatoria de salarios agrupados por departamentos | Error solicitud |");
            LoggerLog4j.error("| No se encontraron resultados en la suma de salarios por departamento |");
            throw new InternalServerErrorException("No se encontraron resultados en la suma de salarios por departamento");
        }
    }

    /**
     * Servicio web que realiza la carga del archivo empleados.csv a la base de
     * datos.
     * 
     * @return Mensaje indicando que se cargaron los datos de los empleados a la
     *         base de datos.
     * @throws InternalServerErrorException Se levanta este error en el caso que no
     *                                      se ingresen correctamente los datos de
     *                                      los empleados en la base de datos.
     */
    @RequestMapping(value = "/leerCSV", produces = "application/json")
    public String cargaDatosEmpleadosCSV() {
        try {
            List<String[]> datos = MetodosCSV.leerEmpleadosCSV();

            String[] lineaActual;
            String nombre;
            String cargo;
            double salario;
            boolean tiempoCompleto;

            String nombreDepartamento;

            Optional<Departamento> consultaDepartamento;
            Departamento nuevoDepartamento;
            Empleado nuevoEmpleado;

            int contadorEmpleados = 0;
            int contadorDepartamentos = 0;

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
                    contadorDepartamentos++;

                    nuevoEmpleado.setDepartamentoAlQuePertenece(nuevoDepartamento);
                }

                nuevoEmpleado.setNombre(nombre);
                nuevoEmpleado.setCargo(cargo);
                nuevoEmpleado.setSalario(salario);
                nuevoEmpleado.setTiempoCompleto(tiempoCompleto);

                empleadoService.save(nuevoEmpleado);
                contadorEmpleados++;
            }
            LoggerLog4j.info("| GET | Carga del archivo empleados.csv a la base de datos | Realizado correctamente |"); 
            LoggerLog4j.info("| Empleados agregados: " + contadorEmpleados + " | Departamentos agregados: " + contadorDepartamentos + " |");
            return "{\"value\": \"Datos cargados correctamente\"}";
        } catch (Exception e) {
            LoggerLog4j.error("| GET | Carga del archivo empleados.csv a la base de datos | Error solicitud |"); 
            LoggerLog4j.error("| Error en la lectura de los archivos CSV |");
            throw new InternalServerErrorException("Error en la lectura de los archivos CSV");
        }
    }

}
