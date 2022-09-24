package com.VProgreSS.demo.Repositorio;

import com.VProgreSS.demo.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresa extends JpaRepository<Empresa,Long> {
}
