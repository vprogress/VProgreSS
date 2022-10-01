package com.VProgreSS.demo.Repositorio;

import com.VProgreSS.demo.Entidades.UsersApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsersApplication extends JpaRepository<UsersApplication,String> {
}

