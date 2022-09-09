package com.VProgreSS.demo.Repositorio;

import com.VProgreSS.demo.Entidades.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMensaje extends JpaRepository<Perfil,Long> {
}
