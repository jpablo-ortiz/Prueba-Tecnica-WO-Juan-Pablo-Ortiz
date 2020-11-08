package com.empresa.Prueba.Tecnica.security;

import com.empresa.Prueba.Tecnica.controller.EmpleadoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class OnBoot implements ApplicationRunner {

    @Autowired
    private EmpleadoController empleadoController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        empleadoController.inicializadorDatosEmpleadosCSV();
    }
}