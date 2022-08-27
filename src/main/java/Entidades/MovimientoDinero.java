package Entidades;

import java.sql.Time;
import java.util.Date;

public class MovimientoDinero{

    private float monto;
    //private int movimientoDinero
    private float egresos;
    private String concepto;
    private Date registroD;
    private Time registroH;

    public MovimientoDinero(float monto, float egresos, String concepto, Date registroD, Time registroH) {
        this.monto = monto;
        this.egresos = egresos;
        this.concepto = concepto;
        this.registroD = registroD;
        this.registroH = registroH;
    }

    public float getMonto() {
        return monto;
    }

    public float getEgresos() {
        return egresos;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setEgresos(float egresos) {
        this.egresos = egresos;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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
    // Metodo Para Eliminar 1 a la variable Monto
    public int monto(){
        return -1;
    }
    public String usuario(){
        return "-1";
    }
}
