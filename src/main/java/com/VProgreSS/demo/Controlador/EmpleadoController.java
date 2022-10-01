package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.Empleado;
import com.VProgreSS.demo.Entidades.ObjetivoVpro;
import com.VProgreSS.demo.Servicios.ServiceIEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    //Hacemos la inyeccion del objeto de tipo ServiceInterfaceEmployee
    @Autowired
    ServiceIEmpleado serviceIEmpleado;

    //Creamos los Mapping

    //Mapping para listar Employee
    @GetMapping("/ListEmployee")
    public ResponseEntity<List<Empleado>> getEmployee(){
        return new ResponseEntity<>(serviceIEmpleado.getEmployee(), HttpStatus.ACCEPTED);
    }

    //Mapping para traer una sola Employee
    @GetMapping("/OneEmployee/{idEmployee}")
    public ResponseEntity<Object> getEmployeePath(@PathVariable Long idEmployee){
        try {
            Empleado empleadoX = serviceIEmpleado.getOnlyOneEmployee(idEmployee);
            return new ResponseEntity<>(empleadoX,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para crear una Employee
    @PostMapping("/CreateEmployee")
    public ResponseEntity<String> PostCreateEmployee(@RequestBody Empleado empleadoX){
        try {
            String message = serviceIEmpleado.setCreateEmployee(empleadoX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para actualizar una Employee
    @PutMapping("/UpdateEmployee")
    public ResponseEntity<ObjetivoVpro> putUpdateEmployee(@RequestBody Empleado empleadoX){
        try {
            Empleado empleadoBD = serviceIEmpleado.getUpdateEmployee(empleadoX);
            return new ResponseEntity<>(new ObjetivoVpro("Atualizacion de Employee Exitosa", empleadoBD),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjetivoVpro(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapping para eliminar una Employee
    @DeleteMapping("/DeleteEmployee/{idEmployee}")
    public ResponseEntity<String> DeleteEmployee(@PathVariable Long idEmployee){
        try {
            String message = serviceIEmpleado.getDeleteEmployee(idEmployee);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
