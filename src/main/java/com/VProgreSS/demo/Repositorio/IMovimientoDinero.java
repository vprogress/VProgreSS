package com.VProgreSS.demo.Repositorio;

import com.VProgreSS.demo.Entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovimientoDinero extends JpaRepository<MovimientoDinero, Long> {
}
