package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.Empleado;
import com.VProgreSS.demo.Entidades.ObjetivoVpro;
import com.VProgreSS.demo.Servicios.ServicioIEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEmployee
    @Autowired
    ServicioIEmpleado servicioIEmpleado;

    //Creamos los Mapping

    //Mapping para listar Employee
    @GetMapping("/Empleados")
    public ResponseEntity<List<Empleado>> getEmployee(){
        return new ResponseEntity<>(servicioIEmpleado.getEmployee(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola Employee
    @GetMapping("/Empleado/{idEmployee}")
    public ResponseEntity<Object> getEmployeePath(@PathVariable Long idEmployee){
        try {
            Empleado empleadoX = servicioIEmpleado.getOnlyOneEmployee(idEmployee);
            return new ResponseEntity<>(empleadoX,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una Employee
    @PostMapping("/CrearEmpleado")
    public ResponseEntity<String> PostCreateEmployee(@RequestBody Empleado empleadoX){
        try {
            String message = servicioIEmpleado.getCreateEmployee(empleadoX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Employee
    @PutMapping("/ActualizarEmpleado")
    public ResponseEntity<ObjetivoVpro> putUpdateEmployee(@RequestBody Empleado empleadoX){
        try {
            Empleado empleadoBD = servicioIEmpleado.getUpdateEmployee(empleadoX);
            return new ResponseEntity<>(new ObjetivoVpro("Atualizacion de Employee Exitosa", empleadoBD),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetivoVpro(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para eliminar una Employee
    @DeleteMapping("/EliminarEmpleado/{idEmployee}")
    public ResponseEntity<String> DeleteEmployee(@PathVariable Long idEmployee){
        try {
            String message = servicioIEmpleado.getDeleteEmployee(idEmployee);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
