package Entidades;

import java.sql.Time;
import java.util.Date;

public class MovimientoDinero {

    private int monto;
    private double egresos;
    private double ingresos;
    private int identificacion;
    private Date registroD;
    private Time registroH;

    public MovimientoDinero(int monto, double egresos, double ingresos, int identificacion, Date registroD, Time registroH) {
        this.monto = monto;
        this.egresos = egresos;
        this.ingresos = ingresos;
        this.identificacion = identificacion;
        this.registroD = registroD;
        this.registroH = registroH;
    }

    public MovimientoDinero() {
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

    public Date getRegistroD() {
        return registroD;
    }

    public void setRegistroD(Date registroD) {
        this.registroD = registroD;
    }

    public Time getRegistroH() {
        return registroH;
    }

    public void setRegistroH(Time registroH) {
        this.registroH = registroH;
    }
}