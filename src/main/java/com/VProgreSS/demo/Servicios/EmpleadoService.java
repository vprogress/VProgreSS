package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.Empleado;
import com.VProgreSS.demo.Repositorio.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private IEmpleado iEmpleado;

    @Autowired
    public void setRepositories (IEmpleado  iEmpleado){
        this.iEmpleado = iEmpleado;
    }
    //Guardar empleado
    public Empleado guardarEmpleado(Empleado empleado) {
        //if(empleado.getId() != null){
        return iEmpleado.save(empleado);
        //}
        //return null;

    }

    // Buscar dentro de una lista al empleado
    public List<Empleado> buscarEmpleados(){
        return iEmpleado.findAll();

    }
    // Identificacion del empleado por numero cedula
    public boolean existsByIdEmpleado(Long cedula){
        return iEmpleado.existsById(cedula);
    }
    //Encontrar empleado si esta por numero cedula.
    public Optional<Empleado> getEmpleado(Long cedula){
        return  iEmpleado.findById(cedula);
    }

}