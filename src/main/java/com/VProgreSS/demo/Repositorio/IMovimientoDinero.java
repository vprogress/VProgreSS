package com.VProgreSS.demo.Repositorio;


import com.VProgreSS.demo.Entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoDinero extends JpaRepository<MovimientoDinero,Long> {
}

