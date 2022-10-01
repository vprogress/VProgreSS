package com.VProgreSS.demo.Repositorio;

import com.VProgreSS.demo.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface IEmpleado extends JpaRepository<Empleado,Long> {
}

