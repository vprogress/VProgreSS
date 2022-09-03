package com.VProgreSS.demo.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Empresa")
public class Empresa {

    @Id
    private String Nit;
    @Column(nullable = false, length = 30)
    private String Nombre;
    @Column(nullable = false, length = 30)
    private String Direccion;
    @Column(nullable = false)
    private int Telefono;


    public Empresa(String nit, String nombre, String direccion, int telefono) {
        Nit = nit;
        Nombre = nombre;
        Direccion = direccion;
        Telefono = telefono;

    }

    public Empresa() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        this.Telefono = telefono;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String nit) {
        this.Nit = nit;
    }
}

