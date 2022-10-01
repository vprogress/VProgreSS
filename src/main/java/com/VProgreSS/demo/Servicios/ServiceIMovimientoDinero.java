package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.MovimientoDinero;

import java.util.List;

public interface ServiceIMovimientoDinero {
    //Metodo para ver lista de Transaction
    public List<MovimientoDinero> getTransaction();


    //Metodo que nos trae un Transaction
    public MovimientoDinero getOnlyOneTransaction(Long idTransaction) throws Exception;


    //Metodo que nos cree una Transaction
    public String setCreateTransaction(MovimientoDinero movimientoDineroIn);


    //Metodo que nos permita actualizar una Transaction
    public MovimientoDinero getUpdateTransaction(MovimientoDinero movimientoDineroIn) throws Exception;

    //Metodo que elimina una Transaction
    public String getDeleteTransaction(Long idTransaction) throws Exception;
}
