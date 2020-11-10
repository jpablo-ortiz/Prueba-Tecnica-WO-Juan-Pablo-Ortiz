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

/**
 * Esta clase contiene los atributos y métodos  de una entidad departamento.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 */
@Entity
public class Departamento {

    /**
     * Id (clave primaria) del departamento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del departamento.
     */
    @NonNull
    private String nombre;

    /**
     * lista de empleados del departamento.
     */
    @OneToMany(mappedBy = "departamentoAlQuePertenece", orphanRemoval = true)
    @JsonIgnore
    private List<Empleado> empleados;

    /**
     * Método constructor vacio.
     */
    public Departamento() {
    }

    /**
     * Método constructor parametrizado.
     * @param id Id del departamento.
     * @param nombre Nombre del departamento.
     * @param empleados Empleados del departamento.
     */
    public Departamento(Long id, String nombre, List<Empleado> empleados) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = empleados;
    }

    /**
     * Método constructor parametrizado.
     * @param nombre Nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<Empleado>();
    }

    /** 
     * Método que retorna el id del departamento.
     * @return Id del departamento.
     */
    public Long getId() {
        return this.id;
    }

    /** 
     * Método que establece el id del departamento.
     * @param id id del departamento.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * Método que retorna el nombre del departamento.
     * @return Nombre del departamento.
     */
    public String getNombre() {
        return this.nombre;
    }

    /** 
     * Método que establece el nombre del departamento.
     * @param nombre nombre del departamento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** 
     * Método que retorna los empleados del departamento.
     * @return Empleados del departamento.
     */
    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    /** 
     * Método que establece los empleados del departamento.
     * @param empleados empleados del departamento.
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /** 
     * Método que establece el id del departamento y retorna el departamento.
     * @param id id del departamento.
     * @return Departamento.
     */
    public Departamento id(Long id) {
        this.id = id;
        return this;
    }

    /** 
     * Método que establece el nombre del departamento y retorna el departamento.
     * @param nombre nombre del departamento.
     * @return Departamento.
     */
    public Departamento nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /** 
     * Método que establece los empleados del departamento y retorna el departamento.
     * @param empleados empleados del departamento.
     * @return Departamento.
     */
    public Departamento empleados(List<Empleado> empleados) {
        this.empleados = empleados;
        return this;
    }

    /** 
     * Override del equals.
     * @param o departamento a comparar.
     * @return <ul>
     *           <li>true: los departamentos son iguales.</li>
     *           <li>false: los departamentos son distintos.</li>
     *         </ul>
     * @see override
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Departamento)) {
            return false;
        }
        Departamento departamento = (Departamento) o;
        return Objects.equals(id, departamento.id) && Objects.equals(nombre, departamento.nombre)
                && Objects.equals(empleados, departamento.empleados);
    }

    /** 
     * Override del hashCode.
     * @return Hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, empleados);
    }

    /** 
     * Override del toString.
     * @return Departamento representado en texto.
     */
    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", nombre='" + getNombre() + "'" + ", empleados='" + getEmpleados() + "'"
                + "}";
    }

}
