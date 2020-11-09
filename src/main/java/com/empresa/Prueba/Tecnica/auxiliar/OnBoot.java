package com.empresa.Prueba.Tecnica.auxiliar;

import com.empresa.Prueba.Tecnica.controller.EmpleadoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Esta clase ejecuta métodos al inciar Spring Boot.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 * @see ApplicationRunner
 */
@Configuration
@Component
public class OnBoot implements ApplicationRunner {

    /**
     * Inyección del controlador de los empleados
     */
    @Autowired
    private EmpleadoController empleadoController;
    
    
    /** 
     * Permite ejecutar el request inicializadorDatosEmpleadosCSV al iniciar Spring Boot.
     * @param args
     * @throws Exception Se levanta este error si hay algún problema entre el código ejecutado.
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Descomentar la linea de código siguiente en el caso de querer
        // habilitar la inicialización de los daatos CSV al iniciar Spring Boot.

        // empleadoController.inicializadorDatosEmpleadosCSV();
    }
}