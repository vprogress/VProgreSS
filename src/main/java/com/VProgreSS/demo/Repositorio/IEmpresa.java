package com.VProgreSS.demo.Repositorio;

import com.VProgreSS.demo.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface IEmpresa extends JpaRepository<Empresa,Long> {
}
