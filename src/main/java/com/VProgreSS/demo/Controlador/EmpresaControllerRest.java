package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.Empresa;
import com.VProgreSS.demo.Entidades.ObjetivoVpro;
import com.VProgreSS.demo.Servicios.ServiceIEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaControllerRest {

    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEnterprise
    @Autowired
    ServiceIEmpresa serviceIEmpresa;

    //Creamos los Mapping

    //Mapping para listar Enterprise
    @GetMapping("/ListEnterprise")
    public ResponseEntity<List<Empresa>> getEnterprise(){
        return new ResponseEntity<>(serviceIEmpresa.getEnterprise(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola Enterprise
    @GetMapping("/OneEnterprise/{idEnterprise}")
    public ResponseEntity<Object> getEnterprisePath(@PathVariable Long idEnterprise){
        try {
            Empresa empresaX = serviceIEmpresa.getOnlyOneEnterprise(idEnterprise);
            return new ResponseEntity<>(empresaX,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una Enterprise
    @PostMapping("/CreateEnterprise")
    public ResponseEntity<String> PostCreateEnterprise(@RequestBody Empresa empresaX){
        try {
            String message = serviceIEmpresa.setCreateEnterprise(empresaX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Enterprise
    @PutMapping("/UpdateEnterprise")
    public ResponseEntity<ObjetivoVpro> putUpdateEnterprise(@RequestBody Empresa empresaX){
        try {
            Empresa empresaBD = serviceIEmpresa.getUpdateEnterprise(empresaX);
            return new ResponseEntity<>(new ObjetivoVpro("Atualizacion de Enterprise Exitosa", empresaBD),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetivoVpro(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para eliminar una enterprise
    @DeleteMapping("/DeleteEnterprise/{idEnterprise}")
    public ResponseEntity<String> DeleteEnterprise(@PathVariable Long idEnterprise){
        try {
            String message = serviceIEmpresa.getDeleteEnterprise(idEnterprise);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
