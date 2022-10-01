package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.MovimientoDinero;

import com.VProgreSS.demo.Entidades.ObjetivoVpro;
import com.VProgreSS.demo.Servicios.ServiceIMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoDineroController {
    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceTransaction
    @Autowired
    ServiceIMovimientoDinero serviceIMovimientoDinero;

    //Creamos los Mapping

    //Mapping para listar Transaction
    @GetMapping("/ListTransaction")
    public ResponseEntity<List<MovimientoDinero>> getTransaction(){
        return new ResponseEntity<>(serviceIMovimientoDinero.getTransaction(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola Transaction
    @GetMapping("/OneTransaction/{idTransaction}")
    public ResponseEntity<Object> getTransactionPath(@PathVariable Long idTransaction){
        try {
            MovimientoDinero movimientoDineroX = serviceIMovimientoDinero.getOnlyOneTransaction(idTransaction);
            return new ResponseEntity<>(movimientoDineroX,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una Transaction
    @PostMapping("/CreateTransaction")
    public ResponseEntity<String> PostCreateTransaction(@RequestBody MovimientoDinero movimientoDineroX){
        try {
            String message = serviceIMovimientoDinero.setCreateTransaction(movimientoDineroX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Transaction
    @PutMapping("/UpdateTransaction")
    public ResponseEntity<ObjetivoVpro> putUpdateTransaction(@RequestBody MovimientoDinero movimientoDineroX){
        try {
            MovimientoDinero movimientoDineroBD = serviceIMovimientoDinero.getUpdateTransaction(movimientoDineroX);
            return new ResponseEntity<>(new ObjetivoVpro("Atualizacion de Transaction Exitosa", movimientoDineroBD),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetivoVpro(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para eliminar una Transaction
    @DeleteMapping("/DeleteTransaction/{idTransaction}")
    public ResponseEntity<String> DeleteTransaction(@PathVariable Long idTransaction){
        try {
            String message = serviceIMovimientoDinero.getDeleteTransaction(idTransaction);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
