package com.empresa.Prueba.Tecnica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.lang.NonNull;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nombre;

    @OneToMany(mappedBy = "departamentoAlQuePertenece", orphanRemoval = true)
    @JsonIgnore
    private List<Empleado> empleados;


    public Departamento() {
    }

    public Departamento(Long id, String nombre, List<Empleado> empleados) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public Departamento(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<Empleado>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Departamento id(Long id) {
        this.id = id;
        return this;
    }

    public Departamento nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Departamento empleados(List<Empleado> empleados) {
        this.empleados = empleados;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Departamento)) {
            return false;
        }
        Departamento departamento = (Departamento) o;
        return Objects.equals(id, departamento.id) && Objects.equals(nombre, departamento.nombre) && Objects.equals(empleados, departamento.empleados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, empleados);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", empleados='" + getEmpleados() + "'" +
            "}";
    }
    
}
