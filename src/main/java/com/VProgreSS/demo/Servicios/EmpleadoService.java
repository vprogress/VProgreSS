package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.Empleado;
import com.VProgreSS.demo.Repositorio.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements ServicioIEmpleado {
    //Atribute
    Date Today = new Date();

    //Inyectar un objeto del repositorio de la entidad Employee
    @Autowired
    IEmpleado IEmpleado;

    @Override
    public List<Empleado> getEmployee() {
        return IEmpleado.findAll();
    }

    @Override
    public Empleado getOnlyOneEmployee(Long idEmployee) throws Exception {
        Optional<Empleado> EmployeeBD = IEmpleado.findById(idEmployee);
        if(EmployeeBD.isPresent()){
            return EmployeeBD.get();
        }
        throw new Exception("IdEmployee no asignado a ninguna Employee de nuestra base de datos");
    }

    @Override
    public String getCreateEmployee(Empleado empleadoIn) {
        //Preguntamos si ya hay alguna Employee ya registrada con ese Id.
        Optional<Empleado> EmployeeBD = IEmpleado.findById(empleadoIn.getIdEmployee());
        if(!EmployeeBD.isPresent()){
            IEmpleado.save(empleadoIn);
            return "Employee Creada con exito";

        }
        return ("Ese Id ya esta regitrado a un Employee Existente");
    }

    @Override
    public Empleado getUpdateEmployee(Empleado empleadoIn) throws Exception {
        //LLamamos a la Employee a actualizar de la BD
        Empleado empleadoBD = getOnlyOneEmployee(empleadoIn.getIdEmployee());

        //Actualizamos atributos
        if(empleadoIn.getNameEmployee()!=null && !empleadoIn.getNameEmployee().equals("")){
            empleadoBD.setNameEmployee(empleadoIn.getNameEmployee());
        }

        if(empleadoIn.getEmailEmployee()!=null && !empleadoIn.getEmailEmployee().equals("")){
            empleadoBD.setEmailEmployee(empleadoIn.getEmailEmployee());
        }

        if(empleadoIn.getRolesEmployee()!=null && !empleadoIn.getRolesEmployee().equals("")){
            empleadoBD.setRolesEmployee(empleadoIn.getRolesEmployee());
        }

        if(empleadoIn.getPhoneEmployee()!=null && !empleadoIn.getPhoneEmployee().equals("")){
            empleadoBD.setPhoneEmployee(empleadoIn.getPhoneEmployee());
        }

        empleadoBD.setUpdatedAtEmployee(Today);

        return IEmpleado.save(empleadoBD);
    }

    @Override
    public String getDeleteEmployee(Long idEmployee) throws Exception {
        Optional<Empleado> EmployeeBD = IEmpleado.findById(idEmployee);
        if(EmployeeBD.isPresent()){
            IEmpleado.deleteById(idEmployee);
            return "Employee Eliminada con exito";
        }
        throw new Exception("Employee NOOOOO encontarda");
    }
}
