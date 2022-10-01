package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.UsersApplication;
import com.VProgreSS.demo.Repositorio.RepositoryUsersApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsersApplication implements ServiceInterfaceUser{

    //Inyectar un objeto del repositorio de la entidad UsersApplication
    @Autowired
    RepositoryUsersApplication repositoryUsersApplication;

    @Override
    public List<UsersApplication> getUsersApplication() {
        return repositoryUsersApplication.findAll();
    }

    @Override
    public UsersApplication getOnlyOneUsersApplication(String userApplication) throws Exception {
        Optional<UsersApplication> UsersApplicationBD = repositoryUsersApplication.findById(userApplication);
        if(UsersApplicationBD.isPresent()){
            return UsersApplicationBD.get();
        }
        throw new Exception("Unregistered user");
    }

    @Override
    public String setCreateUsersApplication(UsersApplication UsersApplicationIn) {
        //Preguntamos si ya hay alguna UsersApplication ya registrada con ese Id.
        Optional<UsersApplication> UsersApplicationBD = repositoryUsersApplication.findById(UsersApplicationIn.getUserApplication());
        if(!UsersApplicationBD.isPresent()){
            repositoryUsersApplication.save(UsersApplicationIn);
            return "Successfully created user";

        }
        return ("Username not available");
    }

    @Override
    public UsersApplication getUpdateUsersApplication(UsersApplication UsersApplicationIn) throws Exception {
        //LLamamos a la UsersApplication a actualizar de la BD
        UsersApplication UsersApplicationBD = getOnlyOneUsersApplication(UsersApplicationIn.getUserApplication());

        //Actualizamos atributos
        if(UsersApplicationIn.getPasswordUser()!=null && !UsersApplicationIn.getPasswordUser().equals("")){
            UsersApplicationBD.setPasswordUser(UsersApplicationIn.getPasswordUser());
        }
        if(UsersApplicationIn.getMailUser()!=null && !UsersApplicationIn.getMailUser().equals("")){
            UsersApplicationBD.setMailUser(UsersApplicationIn.getMailUser());
        }
        if(UsersApplicationIn.getRolUser()!=null && !UsersApplicationIn.getRolUser().equals("")){
            UsersApplicationBD.setRolUser(UsersApplicationIn.getRolUser());
        }

        return repositoryUsersApplication.save(UsersApplicationBD);
    }

    @Override
    public String getDeleteUsersApplication(String userApplication)  {
        repositoryUsersApplication.deleteById(userApplication);
        return "Usuario Eliminado con exito";
    }
}