package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.MovimientoDinero;
import com.VProgreSS.demo.Repositorio.IEmpleado;
import com.VProgreSS.demo.Repositorio.IMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoDineroService implements ServiceIMovimientoDinero {
    //Atribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad Transaction
    @Autowired
    IMovimientoDinero IMovimientoDinero;

    @Override
    public List<MovimientoDinero> getTransaction() {
        return IMovimientoDinero.findAll();
    }

    @Override
    public MovimientoDinero getOnlyOneTransaction(Long idTransaction) throws Exception {
        Optional<MovimientoDinero> TransactionBD = IMovimientoDinero.findById(idTransaction);
        if(TransactionBD.isPresent()){
            return TransactionBD.get();
        }
        throw new Exception("IdTransaction no asignado a ninguna Transaction de nuestra base de datos");
    }

    @Override
    public String setCreateTransaction(MovimientoDinero movimientoDineroIn) {
        //Preguntamos si ya hay alguna Transaction ya registrada con ese Id.
        Optional<MovimientoDinero> TransactionBD = IMovimientoDinero.findById(movimientoDineroIn.getIdTransaction());
        if(!TransactionBD.isPresent()){
            IMovimientoDinero.save(movimientoDineroIn);
            return "Transaction Creada con exito";

        }
        return ("Ese Id ya esta regitrado a una Transaction Existente");
    }

    @Override
    public MovimientoDinero getUpdateTransaction(MovimientoDinero movimientoDineroIn) throws Exception {
        //LLamamos a la Transaction a actualizar de la BD
        MovimientoDinero movimientoDineroBD = getOnlyOneTransaction(movimientoDineroIn.getIdTransaction());

        //Actualizamos atributos
        if(movimientoDineroIn.getConceptTransaction()!=null && !movimientoDineroIn.getConceptTransaction().equals("")){
            movimientoDineroBD.setConceptTransaction(movimientoDineroIn.getConceptTransaction());
        }

        String amountCast= String.valueOf(movimientoDineroIn.getAmountTransaction());
        if(amountCast!=null && !amountCast.equals("")){
            movimientoDineroBD.setAmountTransaction(movimientoDineroIn.getAmountTransaction());
        }

        movimientoDineroBD.setUpdatedAtTransaction(Today);

        return IMovimientoDinero.save(movimientoDineroBD);
    }

    @Override
    public String getDeleteTransaction(Long idTransaction) throws Exception {
        Optional<MovimientoDinero> TransactionBD = IMovimientoDinero.findById(idTransaction);
        if(TransactionBD.isPresent()){
            IMovimientoDinero.deleteById(idTransaction);
            return "Transaction Eliminada con exito";
        }
        throw new Exception("Transaction NOOOOO encontarda");
    }
}
