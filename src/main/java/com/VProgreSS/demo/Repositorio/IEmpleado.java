package com.VProgreSS.demo.Repositorio;

import com.VProgreSS.demo.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleado extends JpaRepository<Empleado,Long> {
}
