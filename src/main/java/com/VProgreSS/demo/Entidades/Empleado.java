package com.VProgreSS.demo.Entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Employees")
public class Empleado {
    //Atributes1
    @Id
    private Long idEmployee;

    @Column
    private String nameEmployee;
    @Column
    private String phoneEmployee;
    @Column
    private String emailEmployee;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Perfil.class,fetch = FetchType.EAGER)
    private List<Perfil> perfilEmployee;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Empresa empresaEmployee;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    private List<MovimientoDinero> movimientoDineros;
    @Column
    private Date updatedAtEmployee;
    @Column
    private java.sql.Date createdAtEmployee;

    //Contructor


    public Empleado(Long idEmployee, String nameEmployee, String phoneEmployee, String emailEmployee, Date updatedAtEmployee, java.sql.Date createdAtEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.phoneEmployee = phoneEmployee;
        this.emailEmployee = emailEmployee;
        this.updatedAtEmployee = updatedAtEmployee;
        this.createdAtEmployee = createdAtEmployee;
    }

    //Constructor Empty
    public Empleado() {
    }

    //Setters and Getters

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public List<Perfil> getRolesEmployee() {
        return perfilEmployee;
    }

    public void setRolesEmployee(List<Perfil> perfilEmployee) {
        this.perfilEmployee = perfilEmployee;
    }

    public Empresa getEnterpriseEmployee() {
        return empresaEmployee;
    }

    public void setEnterpriseEmployee(Empresa empresaEmployee) {
        this.empresaEmployee = empresaEmployee;
    }

    public List<MovimientoDinero> getTransactions() {
        return movimientoDineros;
    }

    public void setTransactions(List<MovimientoDinero> movimientoDineros) {
        this.movimientoDineros = movimientoDineros;
    }

    public Date getUpdatedAtEmployee() {
        return updatedAtEmployee;
    }

    public void setUpdatedAtEmployee(Date updatedAtEmployee) {
        this.updatedAtEmployee = updatedAtEmployee;
    }

    public java.sql.Date getCreatedAtEmployee() {
        return createdAtEmployee;
    }

    public void setCreatedAtEmployee(java.sql.Date createdAtEmployee) {
        this.createdAtEmployee = createdAtEmployee;
    }
}
