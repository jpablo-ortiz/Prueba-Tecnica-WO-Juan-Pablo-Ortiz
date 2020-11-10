package com.empresa.Prueba.Tecnica.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

/**
 * Esta clase contiene los atributos y métodos de una entidad empleado.
 *
 * @author Juan Pablo Ortiz
 * @version 1.0
 */
@Entity
public class Empleado {

    /**
     * Id (clave primaria) del empleado.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del empleado.
     */
    @NonNull
    private String nombre;

    /**
     * Cargo del empleado.
     */
    @NonNull
    private String cargo;

    /**
     * Salario del empleado.
     */
    @NonNull
    private double salario;

    /**
     * El empleado es tiempo completo o no.
     */
    @NonNull
    private boolean tiempoCompleto;

    /**
     * Departamento al que pertenece el empleado.
     */
    @ManyToOne
    private Departamento departamentoAlQuePertenece;

    /**
     * Método constructor parametrizado.
     * @param nombre Nombre del empleado.
     * @param cargo Cargo del empleado.
     * @param salario Salario del empleado.
     * @param tiempoCompleto Si el empleado es o no de tiempo completo.
     * @param departamentoAlQuePertenece Departamento al que pertenece el empleado.
     */
    public Empleado(String nombre, String cargo, double salario, boolean tiempoCompleto, Departamento departamentoAlQuePertenece) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.tiempoCompleto = tiempoCompleto;
        this.departamentoAlQuePertenece = departamentoAlQuePertenece;
    }

    /**
     * Método constructor parametrizado.
     * @param id Id del empleado.
     * @param nombre Nombre del empleado.
     * @param cargo Cargo del empleado.
     * @param salario Salario del empleado.
     * @param tiempoCompleto Si el empleado es o no de tiempo completo.
     */
    public Empleado(Long id, String nombre, String cargo, double salario, boolean tiempoCompleto) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.tiempoCompleto = tiempoCompleto;
    }

    /**
     * Método constructor vacio.
     */
    public Empleado() {
    }

    /** 
     * Método que retorna el id del empleado.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /** 
     * Método que establece el id del empleado.
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * Método que retorna el nombre del empleado.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /** 
     * Método que establece el nombre del empleado.
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** 
     * Método que retorna el cargo del empleado.
     * @return String
     */
    public String getCargo() {
        return this.cargo;
    }

    /** 
     * Método que establece el cargo del empleado.
     * @param cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /** 
     * Método que establece el salario del empleado.
     * @return double
     */
    public double getSalario() {
        return this.salario;
    }

    /** 
     * Método que retorna el salario del empleado.
     * @param salario
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /** 
     * Método que dice si el empleado es o no de tiempo completo.
     * @return <ul>
     *           <li>true: El empleado es tiempo completo.</li>
     *           <li>false: El empleado no es tiempo completo.</li>
     *         </ul>
     */
    public boolean isTiempoCompleto() {
        return this.tiempoCompleto;
    }

    /** 
     * Método que dice si el empleado es o no de tiempo completo.
     * @return <ul>
     *           <li>true: El empleado es tiempo completo.</li>
     *           <li>false: El empleado no es tiempo completo.</li>
     *         </ul>
     */
    public boolean getTiempoCompleto() {
        return this.tiempoCompleto;
    }

    /** 
     * Método que establece si el empleado es o no tiempoCompleto.
     * @param tiempoCompleto Si el empleado es o no de tiempo completo.
     */
    public void setTiempoCompleto(boolean tiempoCompleto) {
        this.tiempoCompleto = tiempoCompleto;
    }

    /** 
     * Método que retorna el departamento al que pertenece el empleado.
     * @return Departamento al que pertenece el empleado.
     */
    public Departamento getDepartamentoAlQuePertenece() {
        return this.departamentoAlQuePertenece;
    }

    /** 
     * Método que establece el departamento al que pertenece el empleado.
     * @param departamentoAlQuePertenece Departamento al que pertenece el empleado.
     */
    public void setDepartamentoAlQuePertenece(Departamento departamentoAlQuePertenece) {
        this.departamentoAlQuePertenece = departamentoAlQuePertenece;
    }

    /** 
     * Método que establece el id del empleado y retorna el empleado.
     * @param id Id del empleado.
     * @return Empleado.
     */
    public Empleado id(Long id) {
        this.id = id;
        return this;
    }

    /** 
     * Método que establece el nombre del empleado y retorna el empleado.
     * @param nombre Nombre del empleado.
     * @return Empleado.
     */
    public Empleado nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /** 
     * Método que establece el cargo del empleado y retorna el empleado.
     * @param cargo Cargo del empleado.
     * @return Empleado.
     */
    public Empleado cargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    /** 
     * Método que establece el salario del empleado y retorna el empleado.
     * @param salario Salario del empleado.
     * @return Empleado.
     */
    public Empleado salario(double salario) {
        this.salario = salario;
        return this;
    }

    /** 
     * Método que establece si el empleado es o no tiempoCompleto y retorna el empleado.
     * @param tiempoCompleto Si el empleado es o no de tiempo completo.
     * @return Empleado.
     */
    public Empleado tiempoCompleto(boolean tiempoCompleto) {
        this.tiempoCompleto = tiempoCompleto;
        return this;
    }

    /** 
     * Método que establece el departamento al que pertenece el empleado y retorna el empleado.
     * @param departamentoAlQuePertenece Departamento al que pertenece el empleado.
     * @return Empleado.
     */
    public Empleado departamentoAlQuePertenece(Departamento departamentoAlQuePertenece) {
        this.departamentoAlQuePertenece = departamentoAlQuePertenece;
        return this;
    }

    
    /** 
     * Override del equals.
     * @param o empleado a comparar.
     * @return <ul>
     *           <li>true: los empleados son iguales.</li>
     *           <li>false: los empleados son distintos.</li>
     *         </ul>
     * @see override
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empleado)) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        return Objects.equals(id, empleado.id) && Objects.equals(nombre, empleado.nombre)
                && Objects.equals(cargo, empleado.cargo) && salario == empleado.salario
                && tiempoCompleto == empleado.tiempoCompleto
                && Objects.equals(departamentoAlQuePertenece, empleado.departamentoAlQuePertenece);
    }

    
    /** 
     * Override del hashCode.
     * @return Hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, cargo, salario, tiempoCompleto, departamentoAlQuePertenece);
    }

    
    /** 
     * Override del toString.
     * @return Empleado representado en texto.
     */
    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", nombre='" + getNombre() + "'" + ", cargo='" + getCargo() + "'"
                + ", salario='" + getSalario() + "'" + ", tiempoCompleto='" + isTiempoCompleto() + "'"
                + ", departamentoAlQuePertenece='" + getDepartamentoAlQuePertenece() + "'" + "}";
    }

}
