package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.Empleado;

import java.util.List;

public interface ServiceIEmpleado {
    //Metodo para ver lista de Employee
    public List<Empleado> getEmployee();


    //Metodo que nos trae un Employee
    public Empleado getOnlyOneEmployee(Long idEmployee) throws Exception;


    //Metodo que nos cree una Employee
    public String setCreateEmployee(Empleado empleadoIn);


    //Metodo que nos permita actualizar una Employee
    public Empleado getUpdateEmployee(Empleado empleadoIn) throws Exception;

    //Metodo que elimina una Employee
    public String getDeleteEmployee(Long idEmployee) throws Exception;

}
