package com.VProgreSS.demo.Entidades;

public class ObjetivoVpro {
    //Atributes
    private Object objetc;
    private String message;

    //Constructor
    public ObjetivoVpro(String message, Object objetc ) {
        this.objetc = objetc;
        this.message = message;
    }

    //Constructor Empty
    public ObjetivoVpro() {
    }

    //Setters and Getters

    public Object getObjetc() {
        return objetc;
    }

    public void setObjetc(Object objetc) {
        this.objetc = objetc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
