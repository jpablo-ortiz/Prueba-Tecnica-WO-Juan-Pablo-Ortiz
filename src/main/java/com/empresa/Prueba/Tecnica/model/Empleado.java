package com.empresa.Prueba.Tecnica.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nombre;

    @NonNull
    private String cargo;

    @NonNull
    private double salario;

    @NonNull
    private boolean tiempoCompleto;

    @ManyToOne
    private Departamento departamentoAlQuePertenece;


    public Empleado() {
    }

    public Empleado(Long id, String nombre, String cargo, double salario, boolean tiempoCompleto,
            Departamento departamentoAlQuePertenece) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.tiempoCompleto = tiempoCompleto;
        this.departamentoAlQuePertenece = departamentoAlQuePertenece;
    }
    
    public Empleado(Long id, String nombre, String cargo, double salario, boolean tiempoCompleto) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.tiempoCompleto = tiempoCompleto;
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

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isTiempoCompleto() {
        return this.tiempoCompleto;
    }

    public boolean getTiempoCompleto() {
        return this.tiempoCompleto;
    }

    public void setTiempoCompleto(boolean tiempoCompleto) {
        this.tiempoCompleto = tiempoCompleto;
    }

    public Departamento getDepartamentoAlQuePertenece() {
        return this.departamentoAlQuePertenece;
    }

    public void setDepartamentoAlQuePertenece(Departamento departamentoAlQuePertenece) {
        this.departamentoAlQuePertenece = departamentoAlQuePertenece;
    }

    public Empleado id(Long id) {
        this.id = id;
        return this;
    }

    public Empleado nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Empleado cargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public Empleado salario(double salario) {
        this.salario = salario;
        return this;
    }

    public Empleado tiempoCompleto(boolean tiempoCompleto) {
        this.tiempoCompleto = tiempoCompleto;
        return this;
    }

    public Empleado departamentoAlQuePertenece(Departamento departamentoAlQuePertenece) {
        this.departamentoAlQuePertenece = departamentoAlQuePertenece;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empleado)) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        return Objects.equals(id, empleado.id) && Objects.equals(nombre, empleado.nombre) && Objects.equals(cargo, empleado.cargo) && salario == empleado.salario && tiempoCompleto == empleado.tiempoCompleto && Objects.equals(departamentoAlQuePertenece, empleado.departamentoAlQuePertenece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, cargo, salario, tiempoCompleto, departamentoAlQuePertenece);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", cargo='" + getCargo() + "'" +
            ", salario='" + getSalario() + "'" +
            ", tiempoCompleto='" + isTiempoCompleto() + "'" +
            ", departamentoAlQuePertenece='" + getDepartamentoAlQuePertenece() + "'" +
            "}";
    }

}
