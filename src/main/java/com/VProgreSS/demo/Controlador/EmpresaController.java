package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.Empresa;
import com.VProgreSS.demo.Entidades.ObjetivoVpro;
import com.VProgreSS.demo.Servicios.ServicioIEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEnterprise
    @Autowired
    ServicioIEmpresa servicioIEmpresa;

    //Creamos los Mapping

    //Mapping para listar Enterprise
    @GetMapping("/Empresas")
    public ResponseEntity <List<Empresa>> getEnterprise(){
        return new ResponseEntity<>(servicioIEmpresa.getEnterprise(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola Enterprise
    @GetMapping("/Empresa/{idEnterprise}")
    public ResponseEntity<Object> getEnterprisePath(@PathVariable Long idEnterprise){
        try {
            Empresa empresaX = servicioIEmpresa.getOnlyOneEnterprise(idEnterprise);
            return new ResponseEntity<>(empresaX,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una Enterprise
    @PostMapping("/CrearEmpresa")
    public ResponseEntity<String> PostCreateEnterprise(@RequestBody Empresa empresaX){
        try {
            String message = servicioIEmpresa.getCreateEnterprise(empresaX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Enterprise
    @PutMapping("/ActualizarEmpresa")
    public ResponseEntity<ObjetivoVpro> putUpdateEnterprise(@RequestBody Empresa empresaX){
        try {
            Empresa empresaBD = servicioIEmpresa.getUpdateEnterprise(empresaX);
            return new ResponseEntity<>(new ObjetivoVpro("Atualizacion de Enterprise Exitosa", empresaBD),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetivoVpro(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para eliminar una enterprise
    @DeleteMapping("/EliminarEmpresa/{idEnterprise}")
    public ResponseEntity<String> DeleteEnterprise(@PathVariable Long idEnterprise){
        try {
            String message = servicioIEmpresa.getDeleteEnterprise(idEnterprise);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
