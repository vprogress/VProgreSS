package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.Empleado;
import com.VProgreSS.demo.Entidades.Mensaje;
import com.VProgreSS.demo.Servicios.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    //Guardar empleado
    @PostMapping("/id")
    //Request para almacenar el tipo de dato al servicio
    private ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.guardarEmpleado(empleado));
    }
    @GetMapping("/empleado")
    private List<Empleado> buscarEmpleados(){
        return empleadoService.buscarEmpleados();
    }


    @GetMapping ("/empleado/{cedula}")
    public ResponseEntity<Empleado> buscarEmpleado(@PathVariable("cedula") Long cedula) {
        if (!empleadoService.existsByIdEmpleado(cedula)) {
            return new ResponseEntity(new Mensaje("No existe el  empleado"), HttpStatus.NOT_FOUND);
        } else {
            Empleado empleado = empleadoService.getEmpleado(cedula).get();
            return new ResponseEntity(empleado, HttpStatus.OK);
        }

    }
}