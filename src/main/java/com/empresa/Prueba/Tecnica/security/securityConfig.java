package com.empresa.Prueba.Tecnica.security;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Esta clase contiene todas las configuraciones de seguridad del Java Spring.
 * 
 * @author Juan Pablo Ortiz
 * @version 1.0
 * @see WebSecurityConfigurerAdapter
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class securityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Configura el HttpSecurity.
     * @param http Parámetro HttpSecurity.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest()
                .permitAll();
                
        http.headers()
                .frameOptions()
                .disable();
    }
}
