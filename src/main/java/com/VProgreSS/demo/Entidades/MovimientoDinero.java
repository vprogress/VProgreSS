package com.VProgreSS.demo.Entidades;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.time.*; // Este paquete contiene LocalDate, LocalTime y LocalDateTime.
import java.time.format.*;  // Este paquete contiene DateTimeFormatter.
@Entity
@Table(name="Movimientos_Dinero")

public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codMovDinero;
    @Column(nullable = false, length = 30)
    private int monto;
    @Column(nullable = false, length = 30)
    private double egresos;
    @Column(nullable = false, length = 30)
    private double ingresos;
    @Column(nullable = false, length = 30)
    private int identificacion;
    @Column(nullable = false, length = 50)
    private LocalDateTime registroDyH;

    public MovimientoDinero(String codMovDinero, int monto, double egresos, double ingresos, int identificacion, LocalDateTime registroDyH) {
        this.codMovDinero = codMovDinero;
        this.egresos = egresos;
        this.ingresos = ingresos;
        this.identificacion = identificacion;
        this.registroDyH = registroDyH;

    }

    //registroDyH = LocalTime.now();

    public MovimientoDinero() {
    }

    public String getCodMovDinero() {
        return codMovDinero;
    }

    public void setCodMovDinero(String codMovDinero) {
        this.codMovDinero = codMovDinero;
    }
    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public double getEgresos() {
        return egresos;
    }

    public void setEgresos(double egresos) {
        this.egresos = egresos;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

        public LocalDateTime getRegistroDyH() {
        return registroDyH;
    }

    public void setRegistroDyH(LocalDateTime registroDyH) {
        this.registroDyH = registroDyH;
    }

}
