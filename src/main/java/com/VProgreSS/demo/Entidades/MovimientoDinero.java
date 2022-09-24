package com.VProgreSS.demo.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Transactions")
public class MovimientoDinero {
    //Atributes
    @Id
    private Long idTransaction;
    @Column
    private String conceptTransaction;
    @Column
    private float amountTransaction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Empleado empleadoTransaction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Empresa empresaTransaction;
    @Column
    private Date createdAtTransaction;
    @Column
    private Date updatedAtTransaction;

    //Constructor
    public MovimientoDinero(Long idTransaction, String conceptTransaction, float amountTransaction, Date createdAtTransaction, Date updatedAtTransaction) {
        this.idTransaction = idTransaction;
        this.conceptTransaction = conceptTransaction;
        this.amountTransaction = amountTransaction;
        this.createdAtTransaction = createdAtTransaction;
        this.updatedAtTransaction = updatedAtTransaction;
    }

    //Constructor Empty
    public MovimientoDinero() {
    }

    //Setters and Getters

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getConceptTransaction() {
        return conceptTransaction;
    }

    public void setConceptTransaction(String conceptTransaction) {
        this.conceptTransaction = conceptTransaction;
    }

    public float getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(float amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public Empleado getEmployeeTransaction() {
        return empleadoTransaction;
    }

    public void setEmployeeTransaction(Empleado empleadoTransaction) {
        this.empleadoTransaction = empleadoTransaction;
    }

    public Empresa getEnterpriseTransaction() {
        return empresaTransaction;
    }

    public void setEnterpriseTransaction(Empresa empresaTransaction) {
        this.empresaTransaction = empresaTransaction;
    }

    public Date getCreatedAtTransaction() {
        return createdAtTransaction;
    }

    public void setCreatedAtTransaction(Date createdAtTransaction) {
        this.createdAtTransaction = createdAtTransaction;
    }

    public Date getUpdatedAtTransaction() {
        return updatedAtTransaction;
    }

    public void setUpdatedAtTransaction(Date updatedAtTransaction) {
        this.updatedAtTransaction = updatedAtTransaction;
    }
}
